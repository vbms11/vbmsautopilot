/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.sim;

/**
 *
 * @author pcmobile
 */
public class Enviroment {
    
    Terrain terrain;
    Vehicle vehicle;
    Water water;
    Sky sky;
    
    public void update (int stepsMillis) {
        
    }
    
    public void render () {
        
        Scene.clear();
        
        sky.render();
        terrain.render();
        water.render();
        vehicle.render();
    }
}
