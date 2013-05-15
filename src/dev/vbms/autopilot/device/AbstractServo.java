/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.device;

/**
 *
 * @author pcmobile
 */
public abstract class AbstractServo extends AbstractDevice {
    double callibrate;
    abstract void setPosition (double position);
    abstract void getPosition ();
    abstract void calibrate ();
}
