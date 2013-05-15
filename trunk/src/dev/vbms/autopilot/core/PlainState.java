/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

import dev.vbms.autopilot.pain.Plain;

/**
 *
 * @author pcmobile
 */
public class PlainState {
    
    Heading heading;
    Position position;
    double roleSpeed;
    double horizontalAngleSpeed;
    double verticalAngleSpeed;
    Vector3d velocity;
    double speed;
    long timestamp;
    
    private PlainState () {
        
    }
    
    public PlainState getCurrentState (Plain plain, PlainState lastState = null) {
        PlainState plainState = new PlainState();
        plainState.timestamp = System.currentTimeMillis();
        plainState.heading = plain.getCompass().getHeading();
        plainState.position = plain.getGps().getPosition();
        if (lastState == null) {
            plainState.velocity = new Vector3d(0,0,0);
            plainState.horizontalAngleSpeed = 0;
            plainState.verticalAngleSpeed = 0;
            plainState.roleSpeed = 0;
        } else {
            long timeStep = plainState.timestamp - lastState.timestamp;
            Vector3f distance = plainState.sub(lastState.position);
            plainState.speed = distance.length() * (1000 * 60 * 60 / timeStep);
            
        }
    }
    
    
}
