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
package org.modelio.uml.statikdiagram.editor.elements.packaze;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.uml.statikdiagram.editor.style.StaticAbstractStyleKeyProvider;

/**
 * Style key provider for {@link GmPackage}.
 * 
 * @author cmarin
 */
@objid ("36251692-55b7-11e2-877f-002564c97630")
public class GmPackageSimpleStyleKeys extends StaticAbstractStyleKeyProvider {
    @objid ("a5b3e42f-55c2-11e2-9337-002564c97630")
    static final StyleKey REPMODE = GmPackageStructuredStyleKeys.REPMODE;

    @objid ("a5b3e431-55c2-11e2-9337-002564c97630")
    static final StyleKey FILLCOLOR = GmPackageStructuredStyleKeys.FILLCOLOR;

    @objid ("a5b3e433-55c2-11e2-9337-002564c97630")
    static final StyleKey FILLMODE = GmPackageStructuredStyleKeys.FILLMODE;

    @objid ("a5b3e435-55c2-11e2-9337-002564c97630")
    static final StyleKey LINECOLOR = GmPackageStructuredStyleKeys.LINECOLOR;

    @objid ("a5b3e437-55c2-11e2-9337-002564c97630")
    static final StyleKey LINEWIDTH = GmPackageStructuredStyleKeys.LINEWIDTH;

    @objid ("a5b3e439-55c2-11e2-9337-002564c97630")
    static final StyleKey FONT = GmPackageStructuredStyleKeys.FONT;

    @objid ("a5b3e43b-55c2-11e2-9337-002564c97630")
    static final StyleKey TEXTCOLOR = GmPackageStructuredStyleKeys.TEXTCOLOR;

    @objid ("a5b3e43d-55c2-11e2-9337-002564c97630")
    static final StyleKey SHOWNAME = GmPackageStructuredStyleKeys.SHOWNAME;

    @objid ("a5b3e43f-55c2-11e2-9337-002564c97630")
    static final StyleKey SHOWSTEREOTYPES = GmPackageStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("a5b3e441-55c2-11e2-9337-002564c97630")
    static final StyleKey SHOWTAGS = GmPackageStructuredStyleKeys.SHOWTAGS;

}
