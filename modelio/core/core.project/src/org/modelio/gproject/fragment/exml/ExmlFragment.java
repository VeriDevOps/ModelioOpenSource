/* 
 * Copyright 2013-2020 Modeliosoft
 * 
 * This file is part of Modelio.
 * 
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package org.modelio.gproject.fragment.exml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Properties;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.gproject.data.project.DefinitionScope;
import org.modelio.gproject.data.project.FragmentDescriptor;
import org.modelio.gproject.data.project.FragmentInfos;
import org.modelio.gproject.data.project.FragmentType;
import org.modelio.gproject.data.project.GAuthConf;
import org.modelio.gproject.data.project.GProperties;
import org.modelio.gproject.data.project.IFragmentInfos;
import org.modelio.gproject.fragment.AbstractFragment;
import org.modelio.gproject.fragment.FragmentAuthenticationException;
import org.modelio.gproject.fragment.FragmentMigrationNeededException;
import org.modelio.gproject.fragment.VersionHelper;
import org.modelio.gproject.fragment.exml.migration.ChainedExmlFragmentMigrator;
import org.modelio.gproject.fragment.migration.FragmentMigratorWithBackup;
import org.modelio.gproject.fragment.migration.IFragmentMigrator;
import org.modelio.gproject.plugin.CoreProject;
import org.modelio.metamodel.uml.infrastructure.AbstractProject;
import org.modelio.vbasic.log.Log;
import org.modelio.vbasic.progress.IModelioProgress;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.session.api.IAccessManager;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.session.impl.permission.BasicAccessManager;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MetamodelVersionDescriptor;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.version.ModelioVersion;
import org.modelio.vstore.exml.common.RepositoryVersions;
import org.modelio.vstore.exml.local.ExmlBase;
import org.modelio.vstore.exml.resource.IExmlRepositoryGeometry;
import org.modelio.vstore.exml.resource.LocalExmlResourceProvider;

/**
 * Local EXML repository fragment.
 */
@objid ("dfa9d009-95c6-11e1-ac83-001ec947ccaf")
public class ExmlFragment extends AbstractFragment {
    /**
     * Fragment type identifier.
     */
    @objid ("f4d8467b-aa5a-11e1-8392-001ec947ccaf")
    public static final FragmentType TYPE = FragmentType.EXML;

    @objid ("c1778ccd-95da-11e1-ac83-001ec947ccaf")
    private ExmlBase repository;

    /**
     * Instantiate a local fragment.
     * @param id the fragment name
     * @param scope definition scope
     * @param properties the fragment properties.
     * @param authData authentication configuration
     */
    @objid ("6a69b8ca-d66d-11e1-9f03-001ec947ccaf")
    public  ExmlFragment(final String id, final DefinitionScope scope, final GProperties properties, final GAuthConf authData) {
        super(id, scope, properties, authData);
    }

    @objid ("7a4a46ef-cd07-11e1-8e98-001ec947ccaf")
    @Override
    public Collection<MObject> doGetRoots() {
        final SmMetamodel mm = getProjectMetamodel();
        final Collection<MObject> roots = this.repository.findByClass(mm.getMClass(AbstractProject.class), true);
        return roots;
    }

    @objid ("c1778cd6-95da-11e1-ac83-001ec947ccaf")
    @Override
    public IRepository doMountInitRepository(final IModelioProgress aMonitor) throws IOException {
        final Path location = getDataDirectory();
        
        final LocalExmlResourceProvider resProvider = createResourceProvider();
        
        this.repository = new ExmlBase(resProvider);
        
        // Create the project structure if new fragment
        if (! Files.isDirectory(location)) {
            this.repository.create(getProject().getSession().getMetamodel());
        
            // Add metamodel version file
            saveMmVersion(getCurrentMmDescriptor());
        
        }
        return this.repository;
    }

    @objid ("c1778ce1-95da-11e1-ac83-001ec947ccaf")
    @Override
    public IRepository getRepository() {
        return this.repository;
    }

    @objid ("e0552a92-2025-4720-a8d6-3340c4f1f58e")
    @Override
    public MetamodelVersionDescriptor getRequiredMetamodelDescriptor() throws IOException {
        final Path p = getMmVersionPath();
        
        try (BufferedReader in = Files.newBufferedReader(p, StandardCharsets.UTF_8);) {
            return VersionHelper.convert(new MetamodelVersionDescriptor(in));
        } catch (FileNotFoundException | NoSuchFileException e) {
            // Assume Modelio 3.1 MM version
            Log.warning("No '"+p+"' metamodel version file. Assume Modelio 3.1 (9020) metamodel version.");
            final MetamodelVersionDescriptor guessed = VersionHelper.getDescriptors(9020);
            return guessed;
        }
        
    }

    @objid ("13a7bf93-9a85-11e1-ac83-001ec947ccaf")
    @Override
    public FragmentType getType() {
        return TYPE;
    }

    @objid ("a301839a-abf1-11e1-8392-001ec947ccaf")
    @Override
    public URI getUri() {
        return getDataDirectory().toUri();
    }

    @objid ("890e6274-4965-4ec6-a165-ce324f1e5792")
    @Override
    public void reconfigure(final FragmentDescriptor fd, final IModelioProgress aMonitor) {
        // Nothing to do on a local fragment as its location does not change.
    }

    @objid ("adcb831b-ce30-42e4-b3ce-dc2745e7c263")
    @Override
    protected void checkVersions() throws FragmentMigrationNeededException, IOException {
        super.checkVersions();
        
        final RepositoryVersions repoVersion = this.repository.getResourceProvider().readRepositoryVersion();
        if (repoVersion.getRepositoryFormat() < 2) {
            throw new FragmentMigrationNeededException(
                    this,
                    getRequiredMetamodelDescriptor(),
                    CoreProject.I18N.getMessage("ExmlFragment.RepositoryFormatNeedMigration",
                            getId(),
                            repoVersion.getRepositoryFormat(),
                            RepositoryVersions.CURRENT_FORMAT));
        }
        
        // If we reach this line no exception is thrown and no migration is needed.
        if (!isReadOnly()) {
            final MetamodelVersionDescriptor neededMm = getRequiredMetamodelDescriptor();
            final MetamodelVersionDescriptor currentMm = getCurrentMmDescriptor();
        
            if (! neededMm.isSame(currentMm)) {
                // save the metamodel version
                saveMmVersion(currentMm);
            }
        }
        
    }

    @objid ("dd4c7da9-395a-11e2-a6db-001ec947ccaf")
    @Override
    protected IAccessManager doInitAccessManager() {
        final BasicAccessManager ret = new BasicAccessManager();
        if (isReadOnly()) {
            ret.setWriteable(false);
        }
        return ret;
    }

    @objid ("c1778cd9-95da-11e1-ac83-001ec947ccaf")
    @Override
    protected void doUnmountPostProcess() {
        this.repository = null;
    }

    @objid ("06014d19-8593-4060-a4d9-5c48778d837f")
    protected Path getMmVersionPath() {
        return getDataDirectory().resolve(IExmlRepositoryGeometry.ADMIN_DIRNAME).resolve(MMVERSION_FILE_NAME);
    }

    @objid ("d5c264f4-65a1-428c-a478-0c5951a36bcb")
    protected boolean isReadOnly() {
        return Boolean.parseBoolean(getProperties().getValue(PROP_READ_ONLY));
    }

    @objid ("41d246eb-6718-4703-9dd5-00a627f2b1b3")
    private void saveMmVersion(final MetamodelVersionDescriptor mmVersion) throws IOException {
        final Path mmVersionPath = getMmVersionPath();
        Files.createDirectories(mmVersionPath.getParent());
        
        try (Writer out = Files.newBufferedWriter(mmVersionPath, StandardCharsets.UTF_8)) {
            mmVersion.write(out);
        }
        
    }

    @objid ("35be4acf-910c-44e4-9216-85556fb8aca2")
    @SuppressWarnings ("resource")
    @Override
    public IFragmentMigrator getMigrator(final MetamodelVersionDescriptor targetMetamodel) throws IOException {
        final LocalExmlResourceProvider resProvider = createResourceProvider();
        
        final ChainedExmlFragmentMigrator chainedMigrator = new ChainedExmlFragmentMigrator(
                getProject(),
                this,
                getMmVersionPath(),
                targetMetamodel,
                resProvider);
        
        if (chainedMigrator.getMigrationChain().isSuccessful()) {
            return new FragmentMigratorWithBackup(this, chainedMigrator);
        } else {
            return null;
        }
        
    }

    /**
     * Instantiate a configured {@link IRepository}.
     * @param session unused
     * @return a ready repository.
     * @throws IOException on I/O failure
     * @throws FragmentAuthenticationException on authentication error.
     */
    @objid ("f9b97b4a-dfb7-4ec1-9452-e3535b2683c6")
    public IRepository instantiateRepository(final ICoreSession session) throws IOException, FragmentAuthenticationException {
        final LocalExmlResourceProvider resProvider = createResourceProvider();
        
        final ExmlBase ret = new ExmlBase(resProvider);
        
        final Path location = getDataDirectory();
        if (! Files.isDirectory(location)) {
            throw new NoSuchFileException(location.toString());
        }
        return ret;
    }

    /**
     * Instantiate an EXML resources provider for this fragment.
     * @return a new EXML resources provider for this fragment.
     */
    @objid ("b4245893-7dfb-4526-8b13-0618eae6bf9a")
    protected LocalExmlResourceProvider createResourceProvider() {
        return new LocalExmlResourceProvider(getDataDirectory(), getRuntimeDirectory(), getId());
    }

    @objid ("4d594515-8bc9-47c7-81f9-5947b12d94ff")
    @Override
    public IFragmentInfos getInformations() throws IOException {
        final Path infosuri = getDataDirectory().resolve("manifest.properties");
        try (InputStream is = Files.newInputStream(infosuri);
                InputStreamReader in = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            final Properties p = new Properties();
            p.load(in);
            return new FragmentInfos(p.getProperty("name"), p.getProperty("description"), new Version(p.getProperty("version")), new Version(p.getProperty("modelioversion")));
        } catch (FileNotFoundException | NoSuchFileException e) {
            Log.warning("No '"+infosuri+"' infos version file, use default values.");
            return new FragmentInfos(getId(), "", new Version("0.0.0"), ModelioVersion.VERSION);
        }
        
    }

}
