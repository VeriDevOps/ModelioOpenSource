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
package org.modelio.uml.statikdiagram.editor.elements.bpmncollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeRequestConstants;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeStartCreationEditPolicy;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.RoundedBoxFigure;
import org.modelio.diagram.elements.core.link.DefaultCreateLinkEditPolicy;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.node.AbstractNodeEditPart;
import org.modelio.diagram.elements.core.tools.multipoint.CreateMultiPointRequest;
import org.modelio.diagram.elements.umlcommon.constraint.ConstraintLinkEditPolicy;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for an BpmnCollaboration Node.
 */
@objid ("90d50f3d-0768-45a6-8312-fd9e57231c15")
public class BpmnCollaborationEditPart extends AbstractNodeEditPart {
    @objid ("c960664a-d5ea-4e1c-9b82-439d49a8b0e0")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("26b93d03-c1d6-4ce1-8c99-8d2dc586b05b")
    @Override
    protected void addChildVisual(final EditPart childEditPart, final int index) {
        // Only two possible children: the header and the behavior label!
        // See Gm constructor for detail
        IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
        GmAbstractObject gmAbstractObject = (GmAbstractObject) childEditPart.getModel();
        if (index == 0 && gmAbstractObject.getLayoutData() == null) {
        
            gmAbstractObject.setLayoutData(BorderLayout.TOP);
        } else if (index == 1 && gmAbstractObject.getLayoutData() == null) {
            gmAbstractObject.setLayoutData(BorderLayout.CENTER);
        } else if (index >= 2) {
            throw new IllegalArgumentException("CallBehaviorEditPart#addChildVisual: unknown index " + index);
        }
        getFigure().add(child, gmAbstractObject.getLayoutData(), index);
        
    }

    @objid ("d6a3bba3-2f5d-417f-9e3d-e832ff2a8612")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(EditPolicy.NODE_ROLE, new DefaultCreateLinkEditPolicy());
        installEditPolicy(LinkedNodeRequestConstants.REQ_LINKEDNODE_START,
                          new LinkedNodeStartCreationEditPolicy());
        installEditPolicy(CreateMultiPointRequest.REQ_MULTIPOINT_FIRST, new ConstraintLinkEditPolicy(false));
        
    }

    @objid ("3ebe4bf3-fd46-4b26-98fd-e2d591984351")
    @Override
    protected IFigure createFigure() {
        // create the figure
        RoundedBoxFigure fig = new RoundedBoxFigure();
        fig.setLayoutManager(new BorderLayout());
        
        // set style independent properties
        fig.setSize(100, 50);
        fig.setRadius(5);
        MinimumSizeLayout.apply(fig, 100, 50);
        
        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());
        
        // return the figure
        return fig;
    }

    @objid ("9645cb30-ef7e-4a89-97e2-eeb675031a52")
    @Override
    protected void refreshFromStyle(final IFigure aFigure, final IStyle style) {
        if (aFigure instanceof RoundedBoxFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }
        }
        
    }

    @objid ("b13209ac-f636-4cfb-b312-1e661f8cf889")
    @Override
    protected void refreshVisuals() {
        GmBpmnCollaborationPrimaryNode callBehaviorModel = (GmBpmnCollaborationPrimaryNode) getModel();
        getFigure().getParent().setConstraint(getFigure(), callBehaviorModel.getLayoutData());
        
    }

}
