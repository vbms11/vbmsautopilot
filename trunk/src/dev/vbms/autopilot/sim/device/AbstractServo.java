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
public abstract class AbstractServo extends AbstractDevice {
    double callibrate;
    public abstract void setPosition (double position);
    public abstract double getPosition ();
    public abstract void calibrate ();
}
