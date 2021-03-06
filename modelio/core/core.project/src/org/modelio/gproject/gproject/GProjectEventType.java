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
package org.modelio.gproject.gproject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Project event type.
 */
@objid ("954b3423-08b2-11e2-b193-001ec947ccaf")
public enum GProjectEventType {
    /**
     * A fragment has gone down.
     * The event message and/or exception will be filled.
     */
    @objid ("6181ee50-08b6-11e2-b193-001ec947ccaf")
    FRAGMENT_DOWN,
    /**
     * A warning event.
     * The event message and/or exception will be filled.
     * The fragment may be filled.
     */
    @objid ("6181ee52-08b6-11e2-b193-001ec947ccaf")
    WARNING,
    /**
     * A new fragment was added.
     * <p>
     * The fragment may be mounted or not (mount may fail).
     */
    @objid ("55dbdb80-de64-43c3-b28e-eda158fa75aa")
    FRAGMENT_ADDED,
    /**
     * A fragment was removed from the project.
     */
    @objid ("1ed81992-02c6-4c46-93e1-1b1537630e8c")
    FRAGMENT_REMOVED,
    /**
     * A fragment state has changed.
     * <p>
     * Ifthe fragment went DOWN, a FRAGMENT_DOWN event is fired instead.
     */
    @objid ("2e538ade-3fee-48b1-8192-0f42dd51be28")
    FRAGMENT_STATE_CHANGED;

}
