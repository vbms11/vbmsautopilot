/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.device;

import dev.vbms.autopilot.device.AbstractGiro;
import dev.vbms.autopilot.math.Vector3d;

/**
 *
 * @author pcmobile
 */
public class ArrayCompasGiro extends AbstractGiro {
    
    AbstractCompass xCompass;
    AbstractCompass yCompass;
    AbstractCompass ZCompass;
    
    public void init () {
    }
    
    public double getCompasHeadings () {
        return 0;
    }
    
    public Vector3d getDownVector () {
        return new Vector3d();
    }
    
}
