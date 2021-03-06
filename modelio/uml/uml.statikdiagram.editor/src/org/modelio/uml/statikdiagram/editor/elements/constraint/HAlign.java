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
package org.modelio.uml.statikdiagram.editor.elements.constraint;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.SWT;

/**
 * Horizontal alignment enumeration.
 */
@objid ("50e90e94-a7bc-4de5-8ef8-6b3c8403d626")
public enum HAlign {
    /**
     * Left
     */
    @objid ("9d1e4810-88af-4a4e-a274-5619bb98406c")
    Left(SWT.BEGINNING),
    /**
     * Center
     */
    @objid ("2511833c-d478-4d1e-bfeb-9486c067a540")
    Center(SWT.CENTER),
    /**
     * Right
     */
    @objid ("9aecb241-9e52-43de-a35a-5e82ca9f9c3b")
    Right(SWT.END);

    @objid ("ad5654bb-5e16-4c54-9e39-cb70e00cf155")
    private final int swtConst;

    @objid ("399a7944-6a56-43a1-81df-34cc4a2afc83")
     HAlign(int swtConst) {
        this.swtConst = swtConst;
    }

    /**
     * @return the matching SWT constant
     */
    @objid ("a4595a16-b403-42c9-9942-e7c63cd29945")
    public int toSwt() {
        return this.swtConst;
    }

}
