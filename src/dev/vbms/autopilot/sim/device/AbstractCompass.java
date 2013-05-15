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
public abstract class AbstractCompass extends AbstractDevice {
    public double getResolutionMilis () {
        return 1;
    }
    public double getReading () {
        return 0;
    }
}
