/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.building;

import com.jme3.scene.Node;

/**
 *
 * @author pcmobile
 */
public class BuildingDoorNode extends Node {
    
    boolean state_closed;
    
    public BuildingDoorNode (boolean closed) {
        state_closed = closed;
    }
    
    public void toggleState () {
        
    }
}
