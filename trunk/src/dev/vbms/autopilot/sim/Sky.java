/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.sim;

/**
 *
 * @author pcmobile
 */
public class Sky {
    
    public void init () {
        
        // sky
        rootNode.attachChild(SkyFactory.createSky(assetManager, "Textures/sky/sky.jpg", false));

    }
}
