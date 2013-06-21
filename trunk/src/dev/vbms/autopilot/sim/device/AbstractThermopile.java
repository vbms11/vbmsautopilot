package dev.vbms.autopilot.sim.device;

import com.jme3.math.Vector3f;

public abstract class AbstractThermopile extends AbstractDevice {
    public abstract int[][] getData ();
    public abstract Vector3f getPosition ();
    public abstract Vector3f getDirection ();
}
