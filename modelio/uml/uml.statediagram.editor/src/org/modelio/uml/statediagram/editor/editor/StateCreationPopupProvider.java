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
package org.modelio.uml.statediagram.editor.editor;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.editor.context.AbstractCreationPopupProvider;
import org.modelio.platform.utils.i18n.BundledMessages;
import org.modelio.uml.statediagram.editor.plugin.DiagramEditorState;
import org.osgi.framework.Bundle;

/**
 * Implementation of {@link AbstractCreationPopupProvider} for State diagram.
 */
@objid ("a21c5947-47cc-4b0d-8de0-1069440c22b0")
public class StateCreationPopupProvider extends AbstractCreationPopupProvider {
    @objid ("171588b4-8320-48cc-9732-90d079320643")
    @Override
    protected Bundle getBundle() {
        return DiagramEditorState.getContext().getBundle();
    }

    @objid ("fbd71901-a931-4d83-9f59-89474ded37e0")
    @Override
    protected BundledMessages getI18nBundle() {
        return DiagramEditorState.I18N;
    }

}
