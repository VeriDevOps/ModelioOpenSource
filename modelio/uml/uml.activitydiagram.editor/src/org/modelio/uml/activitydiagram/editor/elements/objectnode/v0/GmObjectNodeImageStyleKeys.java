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
package org.modelio.uml.activitydiagram.editor.elements.objectnode.v0;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.uml.activitydiagram.editor.style.ActivityAbstractStyleKeyProvider;

/**
 * This class provides the StyleKey constants for a GmObjectNode when its representation mode is RepresentationMode.IMAGE
 */
@objid ("2ae0113a-55b6-11e2-877f-002564c97630")
class GmObjectNodeImageStyleKeys extends ActivityAbstractStyleKeyProvider {
    @objid ("d24d59a9-55c0-11e2-9337-002564c97630")
    static final StyleKey REPMODE = GmObjectNodeStructuredStyleKeys.REPMODE;

    @objid ("d24d59ab-55c0-11e2-9337-002564c97630")
    static final StyleKey FONT = GmObjectNodeStructuredStyleKeys.FONT;

    @objid ("d24d59ad-55c0-11e2-9337-002564c97630")
    static final StyleKey TEXTCOLOR = GmObjectNodeStructuredStyleKeys.TEXTCOLOR;

    @objid ("d24d59af-55c0-11e2-9337-002564c97630")
    static final StyleKey SHOWSTEREOTYPES = GmObjectNodeStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("d24d59b1-55c0-11e2-9337-002564c97630")
    static final StyleKey SHOWTAGS = GmObjectNodeStructuredStyleKeys.SHOWTAGS;

}
