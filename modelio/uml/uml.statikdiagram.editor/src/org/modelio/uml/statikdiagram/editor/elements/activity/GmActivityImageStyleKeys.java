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
package org.modelio.uml.statikdiagram.editor.elements.activity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.metamodel.uml.behavior.activityModel.Activity;
import org.modelio.uml.statikdiagram.editor.style.StaticAbstractStyleKeyProvider;

/**
 * This class provides the StyleKey constants for a {@link Activity} when its representation mode is
 * RepresentationMode.IMAGE
 */
@objid ("33db26a2-55b7-11e2-877f-002564c97630")
public class GmActivityImageStyleKeys extends StaticAbstractStyleKeyProvider {
    @objid ("a5b9feab-55c2-11e2-9337-002564c97630")
    static final StyleKey REPMODE = GmActivityStructuredStyleKeys.REPMODE;

    @objid ("a5b9fead-55c2-11e2-9337-002564c97630")
    static final StyleKey FONT = GmActivityStructuredStyleKeys.FONT;

    @objid ("a5b9feaf-55c2-11e2-9337-002564c97630")
    static final StyleKey TEXTCOLOR = GmActivityStructuredStyleKeys.TEXTCOLOR;

    @objid ("a5b9feb1-55c2-11e2-9337-002564c97630")
    static final StyleKey SHOWSTEREOTYPES = GmActivityStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("a5b9feb3-55c2-11e2-9337-002564c97630")
    static final StyleKey SHOWTAGS = GmActivityStructuredStyleKeys.SHOWTAGS;

}
