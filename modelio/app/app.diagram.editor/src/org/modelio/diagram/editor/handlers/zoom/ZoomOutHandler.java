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
/**
 * 
 */
package org.modelio.diagram.editor.handlers.zoom;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import javax.inject.Named;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.editparts.ZoomManager;
import org.modelio.diagram.editor.AbstractDiagramEditor;

/**
 * Handler that will decrease zoom level by one if available in the active diagram if it can provide a zoom manager
 * (diagram editor should be able to do that).
 * 
 * @author fpoyer
 */
@objid ("6664e881-33f7-11e2-95fe-001ec947c8cc")
public class ZoomOutHandler {
    @objid ("6664e886-33f7-11e2-95fe-001ec947c8cc")
    @Execute
    public Object execute(@Named(IServiceConstants.ACTIVE_PART) final MPart part) {
        if (! (part.getObject() instanceof AbstractDiagramEditor)) {
            return null;
        }
        
        AbstractDiagramEditor editor = (AbstractDiagramEditor) part.getObject();
        
        ZoomManager zoomManager = editor.getAdapter(ZoomManager.class);
        
        if (zoomManager != null && zoomManager.canZoomOut()) {
            zoomManager.zoomOut();
        }
        return null;
    }

}
