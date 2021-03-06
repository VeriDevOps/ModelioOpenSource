/* 
 * Copyright 2013-2020 Modeliosoft
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: ModelerModule v9.3.00

 * This file was generated on 10/8/20 2:50 PM by Modelio Studio.
 */
package org.modelio.module.modelermodule.api.methodology.infrastructure.methodologicallink;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.model.scope.ElementScope;
import org.modelio.api.module.mda.IMdaExpert;
import org.modelio.metamodel.uml.infrastructure.MethodologicalLink;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * MDA expert to handle a {@link MethodologicalLink} with << Event >> stereotype.
 * <p>
 * This link can be created between:
 * </p>
 * <table summary="Creation rules" border="1">
 * <tr>
 *   <th>Possible source</th>
 *   <th>Possible target</th>
 * </tr>
 * <tr><td>BpmnEvent</td><td>ApplicationEvent</td></tr>
 * <tr><td>BpmnEvent</td><td>BusinessEvent</td></tr>
 * <tr><td>BpmnEvent</td><td>TechnologyEvent</td></tr>
 * <tr><td>BpmnEvent</td><td>Signal</td></tr>
 * 
 * </table>
 */
@objid ("d380f89f-9140-46b8-bf10-3bd06e004afa")
public class EventExpert implements IMdaExpert {
    @objid ("047e9674-e3a8-4040-b959-97c53bb84c3d")
    @Override
    public boolean canSource(Stereotype linkStereotype, MClass linkMetaclass, MClass fromMetaclass) {
        MMetamodel metamodel = linkMetaclass.getMetamodel();
        return (fromMetaclass.hasBase(metamodel.getMClass("Standard.BpmnEvent")));
    }

    @objid ("d74e1d46-7686-4c35-82c5-541bc0fb2b3a")
    @Override
    public boolean canSource(Stereotype linkStereotype, MObject linkElement, MObject fromElement) {
        MMetamodel metamodel = linkElement.getMClass().getMetamodel();
        return (fromElement.getMClass().hasBase(metamodel.getMClass("Standard.BpmnEvent")));
    }

    @objid ("aad90fe9-1437-4fc6-9d3e-7eab18da98a9")
    @Override
    public boolean canSource(ElementScope linkScope, MObject fromElement) {
        MMetamodel metamodel = linkScope.getMetaclass().getMetamodel();
        return (fromElement.getMClass().hasBase(metamodel.getMClass("Standard.BpmnEvent")));
    }

    @objid ("03bc0050-881c-407f-a896-7ca41dd4d3b9")
    @Override
    public boolean canTarget(Stereotype linkStereotype, MClass linkMetaclass, MClass toMetaclass) {
        MMetamodel metamodel = linkMetaclass.getMetamodel();
        return (toMetaclass.hasBase(metamodel.getMClass("Archimate.ApplicationEvent"))) || 
        (toMetaclass.hasBase(metamodel.getMClass("Archimate.BusinessEvent"))) || 
        (toMetaclass.hasBase(metamodel.getMClass("Archimate.TechnologyEvent"))) || 
        (toMetaclass.hasBase(metamodel.getMClass("Standard.Signal")));
    }

    @objid ("923f074a-74a1-4132-bc73-d7cad9c24720")
    @Override
    public boolean canTarget(Stereotype linkStereotype, MObject linkElement, MObject toElement) {
        MMetamodel metamodel = linkElement.getMClass().getMetamodel();
        return (toElement.getMClass().hasBase(metamodel.getMClass("Archimate.ApplicationEvent"))) || 
        (toElement.getMClass().hasBase(metamodel.getMClass("Archimate.BusinessEvent"))) || 
        (toElement.getMClass().hasBase(metamodel.getMClass("Archimate.TechnologyEvent"))) || 
        (toElement.getMClass().hasBase(metamodel.getMClass("Standard.Signal")));
    }

    @objid ("8497f2cc-7026-4506-bfd8-78e76e82d595")
    @Override
    public boolean canLink(Stereotype linkStereotype, MClass linkMetaclass, MClass fromMetaclass, MClass toMetaclass) {
        MMetamodel metamodel = linkMetaclass.getMetamodel();
        return ((fromMetaclass.hasBase(metamodel.getMClass("Standard.BpmnEvent"))) && (toMetaclass.hasBase(metamodel.getMClass("Archimate.ApplicationEvent")))) || 
        ((fromMetaclass.hasBase(metamodel.getMClass("Standard.BpmnEvent"))) && (toMetaclass.hasBase(metamodel.getMClass("Archimate.BusinessEvent")))) || 
        ((fromMetaclass.hasBase(metamodel.getMClass("Standard.BpmnEvent"))) && (toMetaclass.hasBase(metamodel.getMClass("Archimate.TechnologyEvent")))) || 
        ((fromMetaclass.hasBase(metamodel.getMClass("Standard.BpmnEvent"))) && (toMetaclass.hasBase(metamodel.getMClass("Standard.Signal"))));
    }

    @objid ("4ab3eff9-c5da-490e-8696-16693b43f059")
    @Override
    public boolean canLink(Stereotype linkStereotype, MClass linkMetaclass, MObject fromElement, MObject toElement) {
        MMetamodel metamodel = linkMetaclass.getMetamodel();
        return ((fromElement.getMClass().hasBase(metamodel.getMClass("Standard.BpmnEvent"))) && (toElement.getMClass().hasBase(metamodel.getMClass("Archimate.ApplicationEvent")))) || 
        ((fromElement.getMClass().hasBase(metamodel.getMClass("Standard.BpmnEvent"))) && (toElement.getMClass().hasBase(metamodel.getMClass("Archimate.BusinessEvent")))) || 
        ((fromElement.getMClass().hasBase(metamodel.getMClass("Standard.BpmnEvent"))) && (toElement.getMClass().hasBase(metamodel.getMClass("Archimate.TechnologyEvent")))) || 
        ((fromElement.getMClass().hasBase(metamodel.getMClass("Standard.BpmnEvent"))) && (toElement.getMClass().hasBase(metamodel.getMClass("Standard.Signal"))));
    }

    @objid ("3eb814a7-6368-4cf5-91a4-b6936b9b1d75")
    @Override
    public Collection<MClass> getPossibleSourceMetaclasses(Stereotype linkStereotype, MClass targetMetaclass) {
        MMetamodel metamodel = linkStereotype.getMClass().getMetamodel();
        Set<MClass> metaclasses = new HashSet<>();
        if ((targetMetaclass.hasBase(metamodel.getMClass("Archimate.ApplicationEvent")))) {
        	MClass mc = metamodel.getMClass("Standard.BpmnEvent");
        	metaclasses.add(mc);
        	metaclasses.addAll(mc.getSub(true));
        }
        if ((targetMetaclass.hasBase(metamodel.getMClass("Archimate.BusinessEvent")))) {
        	MClass mc = metamodel.getMClass("Standard.BpmnEvent");
        	metaclasses.add(mc);
        	metaclasses.addAll(mc.getSub(true));
        }
        if ((targetMetaclass.hasBase(metamodel.getMClass("Archimate.TechnologyEvent")))) {
        	MClass mc = metamodel.getMClass("Standard.BpmnEvent");
        	metaclasses.add(mc);
        	metaclasses.addAll(mc.getSub(true));
        }
        if ((targetMetaclass.hasBase(metamodel.getMClass("Standard.Signal")))) {
        	MClass mc = metamodel.getMClass("Standard.BpmnEvent");
        	metaclasses.add(mc);
        	metaclasses.addAll(mc.getSub(true));
        }
        return metaclasses;
    }

    @objid ("e11b8e7d-114a-49ec-bf4c-38b4d3e71702")
    @Override
    public Collection<MClass> getPossibleTargetMetaclasses(Stereotype linkStereotype, MClass sourceMetaclass) {
        MMetamodel metamodel = linkStereotype.getMClass().getMetamodel();
        Set<MClass> metaclasses = new HashSet<>();
        if ((sourceMetaclass.hasBase(metamodel.getMClass("Standard.BpmnEvent")))) {
        	MClass mc = metamodel.getMClass("Archimate.ApplicationEvent");
        	metaclasses.add(mc);
        	metaclasses.addAll(mc.getSub(true));
        }
        if ((sourceMetaclass.hasBase(metamodel.getMClass("Standard.BpmnEvent")))) {
        	MClass mc = metamodel.getMClass("Archimate.BusinessEvent");
        	metaclasses.add(mc);
        	metaclasses.addAll(mc.getSub(true));
        }
        if ((sourceMetaclass.hasBase(metamodel.getMClass("Standard.BpmnEvent")))) {
        	MClass mc = metamodel.getMClass("Archimate.TechnologyEvent");
        	metaclasses.add(mc);
        	metaclasses.addAll(mc.getSub(true));
        }
        if ((sourceMetaclass.hasBase(metamodel.getMClass("Standard.BpmnEvent")))) {
        	MClass mc = metamodel.getMClass("Standard.Signal");
        	metaclasses.add(mc);
        	metaclasses.addAll(mc.getSub(true));
        }
        return metaclasses;
    }

    @objid ("94734cf7-79b9-4f73-8e54-425df81cd5f6")
    @Override
    public boolean isMultiple(Stereotype linkStereotype) {
        return false;
    }

}
