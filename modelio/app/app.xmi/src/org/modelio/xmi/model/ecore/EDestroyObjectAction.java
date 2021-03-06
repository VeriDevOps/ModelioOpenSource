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
import org.modelio.module.modelermodule.api.xmi.standard.opaqueaction.UML2DestroyObjectAction;

@objid ("7e132d0d-d743-4e58-8378-f5a4440fd8c9")
public class EDestroyObjectAction extends EActivityNode {
    @objid ("95df2be3-3082-423f-a98c-58783c7ac756")
    @Override
    public Element createObjingElt() {
        return UML2DestroyObjectAction.create().getElement();
    }

    @objid ("6c19c220-92ff-4a7f-976c-ab8c8cdb3e80")
    public  EDestroyObjectAction(org.eclipse.uml2.uml.DestroyObjectAction element) {
        super(element);
    }

}
