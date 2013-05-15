/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.sim.device;

import dev.vbms.autopilot.device.*;
import dev.vbms.autopilot.core.Position;

/**
 *
 * @author pcmobile
 */
public abstract class AbstractGps extends AbstractDevice {
    public abstract Position getPosition ();
}
