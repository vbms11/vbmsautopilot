/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.sim;

import dev.vbms.autopilot.core.PlainState;
import dev.vbms.autopilot.core.Position;

/**
 *
 * @author pcmobile
 */
public class Physics {
    
    public updateVehicles (int millis) {
        
        Vehicle vehicle;
        PlainState plain = vehicle.getPlainState();
        Position position = plain.getPosition();
        
        
        // horizontal angle
        Vector3d direction = plain.getHeading().getDirection();
        Vector3d heading = plain.getHeading();
        Vector3d component = direction;
        double turnEffect = Math.sin(direction.dot(heading)) / millis;
        
        // vertical angle
        
        
        
        // role angle
        
        
        
        component.mult(turnEffect);
        heading.add();
        //
        
        
        plain.getHeading().getVerticalAngle(plain);
        
        plain.getHeading().getHorizontalAngle(plain);
        
        
        
    }
}
