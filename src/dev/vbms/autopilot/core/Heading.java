package dev.vbms.autopilot.core;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

public class Heading {
    
    Vector3f direction;
    Vector2f role;
    
    public Vector3f getDirection () {
        return direction;
    }
    
    public double getHorizontalAngle (Vector3f relative) {
        double angle = 0;
        if (relative == null) {
            relative = new Vector3f(0,0,-1);
        }
        return direction.dot(relative);
    }
    
    public double getVerticalAngle (Vector3f relative) {
        double angle = 0;
        if (relative == null) {
            relative = new Vector3f(0,0,-1);
        }
        return direction.dot(relative);
    }
    
    public double getRoleAngle (Vector2f relative) {
        double angle = 0;
        if (relative == null) {
            relative = new Vector2f(0,1);
        }
        angle = role.dot(relative);
        if (role.x < 0) {
            angle = -angle;
        }
        return angle;
    }
    
}
