package dev.vbms.autopilot.vehicle;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import dev.vbms.autopilot.sim.Enviroment;

abstract public class VehicleNode extends Node {
    
    public void init (Enviroment enviroment) {
    }
    
    public void onAction (String binding, boolean value, float tpf) {
    }
    
    public void onRender () {
    }
    
    public void onUpdate (float tpf) {
    }
    
    public void startUsing () {
    }
    
    public void stopUsing () {
    }
    
    public void setPosition (Vector3f position) {
    }
    
    public float getSpawnHeight () {
        return 0.0f;
    }
}
