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
public abstract class AbstractThermopile extends AbstractDevice {
    public abstract int[][] getData ();
    public abstract Vector3d getPosition ();
    public abstract Vector3d getDirection ();
}
