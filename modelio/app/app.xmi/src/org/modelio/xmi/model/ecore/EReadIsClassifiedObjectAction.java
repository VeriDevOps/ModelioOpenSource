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
package org.modelio.xmi.model.ecore;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.module.modelermodule.api.xmi.standard.opaqueaction.UML2ReadIsClassifierObjectAction;

@objid ("14fa172e-bbed-480a-b646-85492afd591c")
public class EReadIsClassifiedObjectAction extends EActivityNode {
    @objid ("2e48ee42-b423-40e7-82fb-b463601cf32a")
    @Override
    public Element createObjingElt() {
        return UML2ReadIsClassifierObjectAction.create().getElement();
    }

    @objid ("4efa63db-c06f-4077-96cd-f9c3f5252231")
    public  EReadIsClassifiedObjectAction(org.eclipse.uml2.uml.ReadIsClassifiedObjectAction element) {
        super(element);
    }

}
