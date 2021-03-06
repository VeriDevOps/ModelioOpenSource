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
package org.modelio.uml.statikdiagram.editor.elements.requiredinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.modelio.diagram.elements.common.linktovoid.LinkToVoidFinishCreationEditPolicy;
import org.modelio.diagram.elements.core.commands.ModelioCreationContext;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.uml.statikdiagram.editor.elements.providedinterface.ProvidedInterfaceLinkEditPart;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Edit Policy to put on {@link RequiredInterfaceLinkEditPart} to allow connecting a provided interface links to the
 * host required interface.
 * 
 * @author cmarin
 */
@objid ("366e548b-55b7-11e2-877f-002564c97630")
public class ConnectProvToReqEditPolicy extends LinkToVoidFinishCreationEditPolicy {
    @objid ("366e548f-55b7-11e2-877f-002564c97630")
    @Override
    protected Command getReconnectTargetCommand(final ReconnectRequest request) {
        if (!isHandled(request)) {
            return null;
        }
        
        final ProvidedInterfaceLinkEditPart provEditPart = (ProvidedInterfaceLinkEditPart) request.getConnectionEditPart();
        final RequiredInterfaceLinkEditPart reqEditPart = (RequiredInterfaceLinkEditPart) request.getTarget();
        
        ConnectLollipopsCommand cmd = new ConnectLollipopsCommand(reqEditPart,
                provEditPart,
                request.getLocation());
        return cmd;
    }

    @objid ("366e5496-55b7-11e2-877f-002564c97630")
    @Override
    protected Command getConnectionCompleteCommand(final CreateConnectionRequest request) {
        if (isHandled(request)) {
            return new CreateConnectedConnectionCommand(request, getHost(), request.getLocation());
        } else {
            return null;
        }
        
    }

    @objid ("366e549c-55b7-11e2-877f-002564c97630")
    @Override
    public EditPart getTargetEditPart(final Request request) {
        if (REQ_LINKTOVOID_END.equals(request.getType())) {
            CreateConnectionRequest r = (CreateConnectionRequest) request;
            if (isHandled(r)) {
                return getLinkMoveTargetEditPart();
            }
        
        } else if (REQ_LINKTOVOID_RECONNECT_TARGET.equals(request.getType())) {
            ReconnectRequest r = (ReconnectRequest) request;
            if (isHandled(r)) {
                return getLinkMoveTargetEditPart();
            }
        
        }
        return null;
    }

    /**
     * Return the lollipop edit part if the link is connected to one or the host.
     * @return the lollipop edit part or the host edit part.
     */
    @objid ("366e54a3-55b7-11e2-877f-002564c97630")
    private EditPart getLinkMoveTargetEditPart() {
        final ConnectionEditPart host = (ConnectionEditPart) getHost();
        if (host.getTarget() instanceof LollipopConnectionEditPart) {
            return host.getTarget();
        } else {
            return getHost();
        }
        
    }

    @objid ("366e54a7-55b7-11e2-877f-002564c97630")
    private boolean isHandled(final CreateConnectionRequest r) {
        ModelioCreationContext ctx = ModelioCreationContext.lookRequest(r);
        if (ctx != null) {
            Class<? extends MObject> c = ctx.getMetaclass().getJavaInterface();
            return (ProvidedInterface.class.isAssignableFrom(c));
        } else {
            return false;
        }
        
    }

    @objid ("366e54ad-55b7-11e2-877f-002564c97630")
    private boolean isHandled(final ReconnectRequest r) {
        EditPart editPart = r.getConnectionEditPart();
        GmModel gm = (GmModel) editPart.getModel();
        MObject el = gm.getRelatedElement();
        return (el instanceof ProvidedInterface);
    }

}
