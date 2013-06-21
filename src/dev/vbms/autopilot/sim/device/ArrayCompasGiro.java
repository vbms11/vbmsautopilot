package dev.vbms.autopilot.sim.device;

import com.jme3.math.Vector3f;
import dev.vbms.autopilot.device.AbstractGiro;

public class ArrayCompasGiro extends AbstractGiro {
    
    AbstractCompass xCompass;
    AbstractCompass yCompass;
    AbstractCompass ZCompass;
    
    public void init () {
    }
    
    public double getCompasHeadings () {
        return 0;
    }
    
    public Vector3f getDownVector () {
        return null;
    }
    
}
