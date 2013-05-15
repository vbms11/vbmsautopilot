/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

/**
 *
 * @author pcmobile
 */
public class Heading {
    
    Vector3d direction;
    Vector2d role;
    
    public double getHorizontalAngle (Vector3d relative = null) {
        double angle = 0;
        if (relative == null) {
            relative = new Vector3d(0,0,-1);
        }
        return direction.dot(relative);
    }
    
    public double getVerticalAngle (Vector3d relative = null) {
        double angle = 0;
        if (relative == null) {
            relative = new Vector3d(0,0,-1);
        }
        return direction.dot(relative);
    }
    
    public double getRoleAngle (Vector2d relative = null) {
        double angle = 0;
        if (relative == null) {
            relative = new Vector2d(0,1);
        }
        angle = role.dot(relative);
        if (role.x < 0) {
            angle = -angle;
        }
        return angle;
        
    }
}
