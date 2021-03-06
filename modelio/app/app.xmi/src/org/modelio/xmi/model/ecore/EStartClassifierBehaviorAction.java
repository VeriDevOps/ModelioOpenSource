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
import org.modelio.module.modelermodule.api.xmi.standard.opaqueaction.UML2StartClassifierBehaviorAction;

@objid ("cfa90e3f-ff0c-4645-bc0f-4259b450d910")
public class EStartClassifierBehaviorAction extends EActivityNode {
    @objid ("19eb4e48-85c8-4705-a2d9-593567493ccb")
    @Override
    public Element createObjingElt() {
        return UML2StartClassifierBehaviorAction.create().getElement();
    }

    @objid ("76cb27cf-1652-425d-a3f0-0cecdc543eb4")
    public  EStartClassifierBehaviorAction(org.eclipse.uml2.uml.StartClassifierBehaviorAction element) {
        super(element);
    }

}
