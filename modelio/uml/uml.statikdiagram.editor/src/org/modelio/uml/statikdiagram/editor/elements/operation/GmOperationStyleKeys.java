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
package org.modelio.uml.statikdiagram.editor.elements.operation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.uml.statikdiagram.editor.style.StaticAbstractStyleKeyProvider;

/**
 * This class provides the StyleKey constants for a GmAttribute
 */
@objid ("425c562c-b3aa-4451-b4d2-f4bdb3acede0")
public class GmOperationStyleKeys extends StaticAbstractStyleKeyProvider {
    /**
     * Text font.
     */
    @objid ("90502dd0-16cf-44ac-9feb-d76830e5ea77")
    static final StyleKey FONT = createStyleKey("OPERATION_FONT", MetaKey.FONT);

    /**
     * Text color.
     */
    @objid ("d70d7d98-64fc-485b-9714-78e87e4919fd")
    static final StyleKey TEXTCOLOR = createStyleKey("OPERATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

}
