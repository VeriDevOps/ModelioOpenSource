/* 
 * Copyright 2013-2020 Modeliosoft
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.modelio.api.module.propertiesPage;

import java.nio.file.Path;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.module.IModule;

/**
 * Abstract class of a module property page generated by the MDA Designer tool.
 * <p>
 * This class is used as a base class of the property page that is associated to a specific module.
 */
@objid ("00d00158-0001-5d84-0000-000000000000")
public abstract class AbstractModulePropertyPage implements IModulePropertyPage {
    @objid ("00d00158-0001-a51a-0000-000000000000")
    private String name = null;

    @objid ("00d00158-0001-a51c-0000-000000000000")
    private String label = null;

    /**
     * Module that is associated to the property page.
     */
    @objid ("00d00158-0001-5da3-0000-000000000000")
    protected IModule module;

    @objid ("b582609a-e3a1-4794-b913-29c98f421b43")
    private Path icon;

    @objid ("00d00158-0001-5da0-0000-000000000000")
    @Override
    public final IModule getModule() {
        return this.module;
    }

    /**
     * Constructors of this abstract property page.
     * @param module module that is associated to the property page
     * @param name the name of the property page.
     * @param label the label of the property page.
     * @param icon a relative path to the image to display for the property page.
     */
    @objid ("00d00158-0001-a520-0000-000000000000")
    public  AbstractModulePropertyPage(IModule module, String name, String label, String icon) {
        this.module = module;
        this.name = name;
        this.label = label;
        this.icon = icon.isEmpty() ? null : module.getModuleContext().getConfiguration().getModuleResourcesPath().resolve(icon);
        
    }

    @objid ("00d00158-0001-a528-0000-000000000000")
    @Override
    public String getName() {
        return this.name;
    }

    @objid ("00d00158-0001-a52b-0000-000000000000")
    @Override
    public String getLabel() {
        return this.label;
    }

    @objid ("2c4818c4-e5f5-11e0-9cef-bc305ba4815c")
    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @objid ("2c483fd7-e5f5-11e0-9cef-bc305ba4815c")
    @Override
    public void setLabel(final String label) {
        this.label = label;
    }

    @objid ("2c4866e7-e5f5-11e0-9cef-bc305ba4815c")
    @Override
    public void setModule(final IModule module) {
        this.module = module;
    }

    @objid ("77bb982a-87f4-489c-a19b-593843ec5202")
    @Override
    public Path getIcon() {
        return this.icon;
    }

}
