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
package org.modelio.bpmn.diagram.editor.elements.bpmnendevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.swt.graphics.Color;
import org.modelio.bpmn.diagram.editor.elements.common.editpart.AbstractCircleNodeEditPart;
import org.modelio.bpmn.diagram.editor.elements.common.policies.BpmnCreateLinkEditPolicy;
import org.modelio.bpmn.diagram.editor.elements.common.policies.KeepNodeRatioResizableEditPolicy;
import org.modelio.bpmn.diagram.editor.elements.common.policies.MethodologicalLinkUpdateDropEditPolicy;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeRequestConstants;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeStartCreationEditPolicy;
import org.modelio.diagram.elements.core.figures.ColorizableImageFigure;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.requests.ModelElementDropRequest;
import org.modelio.diagram.elements.core.tools.multipoint.CreateMultiPointRequest;
import org.modelio.diagram.elements.umlcommon.constraint.ConstraintLinkEditPolicy;
import org.modelio.diagram.styles.core.IStyle;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.module.modelermodule.api.methodology.infrastructure.methodologicallink.Event;

/**
 * EditPart for an {@link GmBpmnEndEventPrimaryNode}.
 */
@objid ("60dbf3da-55b6-11e2-877f-002564c97630")
public final class BpmnEndEventPrimaryNodeEditPart extends AbstractCircleNodeEditPart {
    @objid ("60dbf3de-55b6-11e2-877f-002564c97630")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("60dbf3e3-55b6-11e2-877f-002564c97630")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(EditPolicy.NODE_ROLE, new BpmnCreateLinkEditPolicy());
        installEditPolicy(LinkedNodeRequestConstants.REQ_LINKEDNODE_START, new LinkedNodeStartCreationEditPolicy());
        installEditPolicy(CreateMultiPointRequest.REQ_MULTIPOINT_FIRST, new ConstraintLinkEditPolicy(false));
        installEditPolicy(ModelElementDropRequest.TYPE, new MethodologicalLinkUpdateDropEditPolicy(Event.MdaTypes.STEREOTYPE_ELT, true));
        
    }

    @objid ("60dbf3e6-55b6-11e2-877f-002564c97630")
    @Override
    protected IFigure createFigure() {
        ColorizableImageFigure imageFigure = new ColorizableImageFigure(getModel().getEventImage());
        imageFigure.setPreferredSize(33, 33);
        imageFigure.setMinimumSize(new Dimension(33, 33));
        
        // set style dependent properties
        refreshFromStyle(imageFigure, getModelStyle());
        
        // return the figure
        return imageFigure;
    }

    @objid ("60dd7a7d-55b6-11e2-877f-002564c97630")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (!switchRepresentationMode()) {
            super.refreshFromStyle(aFigure, style);
        
            if (aFigure instanceof ColorizableImageFigure) {
                ColorizableImageFigure cFigure = (ColorizableImageFigure) aFigure;
                final GmModel gmModel = getModel();
                Color color = style.getColor(gmModel.getStyleKey(MetaKey.FILLCOLOR));
                cFigure.setColor(color);
                super.refreshFromStyle(aFigure, style);
            }
        }
        
    }

    @objid ("60dd7a84-55b6-11e2-877f-002564c97630")
    @Override
    protected void refreshVisuals() {
        GmBpmnEndEventPrimaryNode initialNodeModel = getModel();
        getFigure().getParent().setConstraint(getFigure(), initialNodeModel.getLayoutData());
        
    }

    @objid ("60dd7a87-55b6-11e2-877f-002564c97630")
    @Override
    public SelectionEditPolicy getPreferredDragRolePolicy(final String requestType) {
        return new KeepNodeRatioResizableEditPolicy();
    }

    @objid ("d2c8ce61-18f3-4413-a996-1c649651a704")
    @Override
    public GmBpmnEndEventPrimaryNode getModel() {
        return (GmBpmnEndEventPrimaryNode) super.getModel();
    }

}
