/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.sim;

import com.jme3.math.Vector3f;

/**
 *
 * @author pcmobile
 */
public class Camera {
    
    public void init (Enviroment enviroment) {
        
        enviroment.getFlyByCamera().setMoveSpeed(100f);
        enviroment.getCamera().setLocation(new Vector3f(0, 100, 0));
    }
    
}
