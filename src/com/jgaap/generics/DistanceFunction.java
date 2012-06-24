/*
 * JGAAP -- a graphical program for stylometric authorship attribution
 * Copyright (C) 2009,2011 by Patrick Juola
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 **/
package com.jgaap.generics;

import java.util.List;

/**
 * This is an abstract class for distance functions. It is used, for example, in
 * variations of nearest-neighbor algorihms.
 * 
 */
abstract public class DistanceFunction extends Parameterizable implements Comparable<DistanceFunction>, Displayable{

	public abstract String displayName();

	public abstract String tooltipText();

    public String longDescription() { return tooltipText(); }

	public abstract boolean showInGUI();

    /**
     * Returns (as double) the distance between two EventSets.
     * 
     * @param es1
     *            The first EventSet
     * @param es2
     *            The first EventSet
     * @return a double precision number (ideally a distance) btw es1 and es2
     */
    abstract public double distance(EventSet es1, EventSet es2) throws DistanceCalculationException;

    public double distance(List<Double> v1, List<Double> v2) throws DistanceCalculationException {
        EventSet es1 = new EventSet();
        EventSet es2 = new EventSet();
        int max = 0;

        if(v1.size() > v2.size()) {
            max = v1.size();
        }
        else {
            max = v2.size();
        }

        for(Integer i = 0; i < max; i++) {
            Event e = new Event(i.toString());
            for(int j = 0; j < Math.round(1000 * v1.get(i)); j++) {
                es1.addEvent(e);
            }
        }

        for(Integer i = 0; i < max; i++) {
            Event e = new Event(i.toString());
            for(int j = 0; j < Math.round(1000 * v2.get(i)); j++) {
                es2.addEvent(e);
            }
        }

        return distance(es1, es2);

    }

    public int compareTo(DistanceFunction o){
    	return displayName().compareTo(o.displayName());
    }

}
