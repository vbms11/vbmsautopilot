/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.device;

import dev.vbms.autopilot.math.Vector3d;

/**
 *
 * @author pcmobile
 */
public abstract class AbstractThermopile {
    public abstract int[][] getData ();
    public abstract Vector3d getPosition ();
    public abstract Vector3d getDirection ();
}
