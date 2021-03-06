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

@objid ("215c7499-9820-482d-8709-5a87ff254f55")
public class EVariable extends ENamedElement {
    @objid ("371c59cd-4219-4510-983e-016adc2eb639")
    @Override
    public Element createObjingElt() {
        return null;
    }

    @objid ("5fde1776-5594-459f-8075-edf332f7ba17")
    public  EVariable(org.eclipse.uml2.uml.Variable element) {
        super(element);
    }

}
