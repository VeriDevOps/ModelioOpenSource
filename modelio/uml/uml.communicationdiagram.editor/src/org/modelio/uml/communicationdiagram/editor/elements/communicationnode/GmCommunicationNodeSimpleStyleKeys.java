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
package org.modelio.uml.communicationdiagram.editor.elements.communicationnode;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.uml.communicationdiagram.editor.style.CommunicationAbstractStyleKeyProvider;

/**
 * This class provides the StyleKey constants for a GmCommunicationNode when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("7a5d7e88-55b6-11e2-877f-002564c97630")
public class GmCommunicationNodeSimpleStyleKeys extends CommunicationAbstractStyleKeyProvider {
    /**
     * Representation mode.
     */
    @objid ("9cd99d5b-55c1-11e2-9337-002564c97630")
    public static final StyleKey REPMODE = createStyleKey("COMMUNICATIONNODE_REPMODE", MetaKey.REPMODE);

    /**
     * Fill color.
     */
    @objid ("9cd99d5e-55c1-11e2-9337-002564c97630")
    public static final StyleKey FILLCOLOR = createStyleKey("COMMUNICATIONNODE_FILLCOLOR", MetaKey.FILLCOLOR);

    /**
     * Fill mode.
     */
    @objid ("9cd9c46b-55c1-11e2-9337-002564c97630")
    public static final StyleKey FILLMODE = createStyleKey("COMMUNICATIONNODE_FILLMODE", MetaKey.FILLMODE);

    /**
     * Line color.
     */
    @objid ("9cd9c46e-55c1-11e2-9337-002564c97630")
    public static final StyleKey LINECOLOR = createStyleKey("COMMUNICATIONNODE_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width.
     */
    @objid ("9cd9eb7b-55c1-11e2-9337-002564c97630")
    public static final StyleKey LINEWIDTH = createStyleKey("COMMUNICATIONNODE_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font.
     */
    @objid ("9cd9eb7e-55c1-11e2-9337-002564c97630")
    public static final StyleKey FONT = createStyleKey("COMMUNICATIONNODE_FONT", MetaKey.FONT);

    /**
     * Text color.
     */
    @objid ("9cda128b-55c1-11e2-9337-002564c97630")
    public static final StyleKey TEXTCOLOR = createStyleKey("COMMUNICATIONNODE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Display stereotype.
     */
    @objid ("9cda3999-55c1-11e2-9337-002564c97630")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("COMMUNICATIONNODE_SHOWSTEREOTYPES",
                MetaKey.SHOWSTEREOTYPES);

    /**
     * Display tagged values.
     */
    @objid ("9cda399c-55c1-11e2-9337-002564c97630")
    public static final StyleKey SHOWTAGS = createStyleKey("COMMUNICATIONNODE_SHOWTAGS", MetaKey.SHOWTAGS);

}
