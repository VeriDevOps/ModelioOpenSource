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
package org.modelio.bpmn.diagram.editor.elements.bpmnsripttask;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.modelio.bpmn.diagram.editor.elements.common.editpart.AbstractBpmnNodeEditPart;
import org.modelio.bpmn.diagram.editor.elements.common.policies.BpmnCreateLinkEditPolicy;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeRequestConstants;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeStartCreationEditPolicy;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.RoundedBoxFigure;
import org.modelio.diagram.elements.core.tools.multipoint.CreateMultiPointRequest;
import org.modelio.diagram.elements.umlcommon.constraint.ConstraintLinkEditPolicy;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for an BpmnScriptTask Node.
 */
@objid ("61ae861a-55b6-11e2-877f-002564c97630")
public class BpmnScriptTaskEditPart extends AbstractBpmnNodeEditPart {
    @objid ("61ae861e-55b6-11e2-877f-002564c97630")
    @Override
    protected IFigure createFigure() {
        // create the figure
        RoundedBoxFigure fig = new RoundedBoxFigure();
        fig.setLayoutManager(new BorderLayout());
        
        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 46);
        fig.setRadius(5);
        
        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());
        
        // return the figure
        return fig;
    }

    @objid ("61ae8623-55b6-11e2-877f-002564c97630")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(EditPolicy.NODE_ROLE, new BpmnCreateLinkEditPolicy());
        installEditPolicy(LinkedNodeRequestConstants.REQ_LINKEDNODE_START, new LinkedNodeStartCreationEditPolicy());
        installEditPolicy(CreateMultiPointRequest.REQ_MULTIPOINT_FIRST, new ConstraintLinkEditPolicy(false));
        
    }

    @objid ("61ae8626-55b6-11e2-877f-002564c97630")
    @Override
    protected void refreshVisuals() {
        GmBpmnScriptTaskPrimaryNode calloperationModel = (GmBpmnScriptTaskPrimaryNode) getModel();
        getFigure().getParent().setConstraint(getFigure(), calloperationModel.getLayoutData());
        
    }

    @objid ("61ae8629-55b6-11e2-877f-002564c97630")
    @Override
    protected void addChildVisual(EditPart childEditPart, int index) {
        IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
        if (index == 0) {
            getFigure().add(child, BorderLayout.CENTER, index);
        }
        if (index == 1) {
            getFigure().add(child, BorderLayout.BOTTOM, index);
        }
        
    }

    @objid ("61ae862e-55b6-11e2-877f-002564c97630")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("61ae8633-55b6-11e2-877f-002564c97630")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof RoundedBoxFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }
        }
        
    }

}
