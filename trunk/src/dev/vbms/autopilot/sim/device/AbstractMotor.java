/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.sim.device;

import dev.vbms.autopilot.device.*;

/**
 *
 * @author pcmobile
 */
public abstract class AbstractMotor extends AbstractDevice {
    protected double calibrate;
    public abstract void setThrottle (double throttle);
    public abstract double getThrottle ();
    
    /**
     * 
     * @param toValue 
     */
    public void easeThrottle (int toValue) {
        
    }
    
    /**
     * 
     */
    public void zero () {
        
    }
}
