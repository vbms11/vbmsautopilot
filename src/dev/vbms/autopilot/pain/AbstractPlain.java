/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.pain;

import dev.vbms.autopilot.device.AbstractGiro;
import dev.vbms.autopilot.core.Autopilot;
import dev.vbms.autopilot.core.PlainConfig;
import dev.vbms.autopilot.core.PlainState;
import dev.vbms.autopilot.device.AbstractMotor;
import dev.vbms.autopilot.device.AbstractServo;

/**
 *
 * @author pcmobile
 */
public abstract class AbstractPlain {
    
    // sensors
    AbstractAltitude altitude;
    AbstractCompass compass;
    AbstractGiro giro;
    AbstractGps gps;
    
    PlainConfig plainConfig;
    PlainState plainState;
    Autopilot autopilot;
    
    public AbstractPain (PlainConfig plainConfig) {
        
    }
    
    // control flap intensions
    public abstract void setHorizontalValue (double value);
    public abstract void setVerticalValue (double value);
    public abstract void setRoleValue (double value);
    
    // control motor
    public abstract double getMotorThrott ();
    public abstract void setMotorThrottle (double throttle);
    
}
