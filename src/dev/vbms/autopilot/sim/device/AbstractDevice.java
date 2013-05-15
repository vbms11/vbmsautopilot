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
public abstract class AbstractDevice {
    String deviceName;
    public String getDeviceName () {
        return deviceName;
    }
    public void setDeviceName (String name) {
        this.deviceName = name;
    }
}
