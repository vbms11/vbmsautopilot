/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

import dev.vbms.autopilot.math.Vector3d;
import dev.vbms.autopilot.pain.AbstractPlain;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author pcmobile
 */
public class PlainState {
    
    Heading heading;
    Position position;
    
    double roleSpeed;
    double climbSpeed;
    double horizontalAngleSpeed;
    double verticalAngleSpeed;
    
    Vector3d velocity;
    double speed;
    long timestamp;
    
    private static List<PlainState> plainStateLog = new LinkedList<PlainState>();
    
    private PlainState () {
        
    }
    
    public PlainState getCurrentState (AbstractPlain plain, PlainState lastState) {
        PlainState plainState = new PlainState();
        plainState.timestamp = System.currentTimeMillis();
        // plainState.heading = plain.getCompass().getReading();
        plainState.position = plain.getGps().getPosition();
        if (lastState == null) {
            plainState.velocity = new Vector3d(0.0f,0.0f,0.0f);
            plainState.horizontalAngleSpeed = 0;
            plainState.verticalAngleSpeed = 0;
            plainState.roleSpeed = 0;
        } else {
            long timeStep = plainState.timestamp - lastState.timestamp;
            // Vector3d distance = plainState.sub(lastState.position);
            // plainState.speed = distance.length() * (1000 * 60 * 60 / timeStep);
        }
        return plainState;
    }
    
    public static PlainState getAvarageState (Long pastTimeMilis) {
        if (pastTimeMilis == null) {
            pastTimeMilis = 100L;
        }
        PlainState plainState = new PlainState();
        Iterator<PlainState> itr_plainStateLog = plainStateLog.listIterator(plainStateLog.size()-1);
        do {
            
            
        } while (itr_plainStateLog.hasNext());
        return plainState;
    }
    
    public Heading getHeading() {
        return heading;
    }

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getRoleSpeed() {
        return roleSpeed;
    }

    public void setRoleSpeed(double roleSpeed) {
        this.roleSpeed = roleSpeed;
    }

    public double getClimbSpeed() {
        return climbSpeed;
    }

    public void setClimbSpeed(double climbSpeed) {
        this.climbSpeed = climbSpeed;
    }

    public double getHorizontalAngleSpeed() {
        return horizontalAngleSpeed;
    }

    public void setHorizontalAngleSpeed(double horizontalAngleSpeed) {
        this.horizontalAngleSpeed = horizontalAngleSpeed;
    }

    public double getVerticalAngleSpeed() {
        return verticalAngleSpeed;
    }

    public void setVerticalAngleSpeed(double verticalAngleSpeed) {
        this.verticalAngleSpeed = verticalAngleSpeed;
    }

    public Vector3d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3d velocity) {
        this.velocity = velocity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
