/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.pain;

import dev.vbms.autopilot.device.AbstractGiro;
import dev.vbms.autopilot.core.Autopilot;
import dev.vbms.autopilot.core.PlainConfig;
import dev.vbms.autopilot.core.PlainState;
import dev.vbms.autopilot.device.AbstractAltitude;
import dev.vbms.autopilot.device.AbstractCompass;
import dev.vbms.autopilot.device.AbstractGps;
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
    
    public AbstractPlain (PlainConfig plainConfig, Autopilot autopilot) {
        this.autopilot = autopilot;
        this.plainConfig = plainConfig;
    }
    
    // control flap intensions
    public abstract void setHorizontalValue (double value);
    public abstract void setVerticalValue (double value);
    public abstract void setRoleValue (double value);
    
    // control motor
    public abstract double getMotorThrott ();
    public abstract void setMotorThrottle (double throttle);

    public AbstractAltitude getAltitude() {
        return altitude;
    }

    public void setAltitude(AbstractAltitude altitude) {
        this.altitude = altitude;
    }

    public AbstractCompass getCompass() {
        return compass;
    }

    public void setCompass(AbstractCompass compass) {
        this.compass = compass;
    }

    public AbstractGiro getGiro() {
        return giro;
    }

    public void setGiro(AbstractGiro giro) {
        this.giro = giro;
    }

    public AbstractGps getGps() {
        return gps;
    }

    public void setGps(AbstractGps gps) {
        this.gps = gps;
    }

    public PlainConfig getPlainConfig() {
        return plainConfig;
    }

    public void setPlainConfig(PlainConfig plainConfig) {
        this.plainConfig = plainConfig;
    }

    public PlainState getPlainState() {
        return plainState;
    }

    public void setPlainState(PlainState plainState) {
        this.plainState = plainState;
    }

    public Autopilot getAutopilot() {
        return autopilot;
    }

    public void setAutopilot(Autopilot autopilot) {
        this.autopilot = autopilot;
    }
    
    
}
