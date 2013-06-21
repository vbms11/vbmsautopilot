/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

import dev.vbms.autopilot.pain.AbstractPlain;
import dev.vbms.autopilot.pain.SteerWave;

/**
 *
 * @author pcmobile
 */
public class FlightSimulator {
    
    Heading intendedHeading;
    Heading currentHeading;
    Position currentPosition;
    Position targetPosition;
    Position nextTargetPosition;
    
    double cruseAngle;
    double horizontalAngle;
    double verticalAngle;
    double roleAngle;    
    double horizontalPosition;
    double verticalPosition;
    double rolePosition;
    
    final int state_waiting = 0;
    final int state_ascending = 1;
    final int state_decending = 2;
    final int state_traveling = 3;
    int state = state_waiting;
    
    void updateIntended () {
        /*
        AbstractPlain plain = Context::getPlain();
        PlainState plainState = plain.getPlainState();
        
        switch (state) {
            
            case state_waiting:
                break;
            case state_ascending:
                // check speed
                // check angle
                currentHeadings = plainState.getHeadings();
                
                break;
            case state_decending:
                break;
            case state_turning:
                // turns are made here
                
                break;
            case state_traveling:
                // traveling to next objetive following the line
                
                // check height
                plainState.getPosition().getHeight();
                
                
                // use steer wave to correct flap position
                double currentAngel = plainState.getHeading().getVerticalAngel();
                double cruseOffset = currentAngel - cruseAngle;
                SteerWave steerWaveRole = new SteerWave();
                SteerWave steerWaveVertical = new SteerWave();
                
                verticalPosition = steerWaveVertical.getPosition(cruseAngle, plainState.getVerticalAngelSpeed());
                rolePosition = steerWaveRole.getPosition(0.0f, plainState.getRoleAngelSpeed());
                
                Vector3d heading = plainState.getHeading().getHorizontalAngle();
                
                if () {
                    
                }
                
                break;
        }
        
        // if loosing height
        // check travel angle
        // check speed
        */
    }
    
    public Heading getIntendedHeading() {
        return intendedHeading;
    }

    public void setIntendedHeading(Heading intendedHeading) {
        this.intendedHeading = intendedHeading;
    }

    public Heading getCurrentHeading() {
        return currentHeading;
    }

    public void setCurrentHeading(Heading currentHeading) {
        this.currentHeading = currentHeading;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Position targetPosition) {
        this.targetPosition = targetPosition;
    }

    public Position getNextTargetPosition() {
        return nextTargetPosition;
    }

    public void setNextTargetPosition(Position nextTargetPosition) {
        this.nextTargetPosition = nextTargetPosition;
    }

    public double getCruseAngle() {
        return cruseAngle;
    }

    public void setCruseAngle(double cruseAngle) {
        this.cruseAngle = cruseAngle;
    }

    public double getHorizontalAngle() {
        return horizontalAngle;
    }

    public void setHorizontalAngle(double horizontalAngle) {
        this.horizontalAngle = horizontalAngle;
    }

    public double getVerticalAngle() {
        return verticalAngle;
    }

    public void setVerticalAngle(double verticalAngle) {
        this.verticalAngle = verticalAngle;
    }

    public double getRoleAngle() {
        return roleAngle;
    }

    public void setRoleAngle(double roleAngle) {
        this.roleAngle = roleAngle;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getHorizontalPosition() {
        return horizontalPosition;
    }

    public void setHorizontalPosition(double horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    public double getVerticalPosition() {
        return verticalPosition;
    }

    public void setVerticalPosition(double verticalPosition) {
        this.verticalPosition = verticalPosition;
    }

    public double getRolePosition() {
        return rolePosition;
    }

    public void setRolePosition(double rolePosition) {
        this.rolePosition = rolePosition;
    }
    /*
    double getRoleAngel () {
        return currentHeading.getRoleAngle(intendedHeading);
    }
    
    double getHorizontalAngel () {
        return currentHeading.getHorizontalAngle(intendedHeading);
    }
    
    double getVerticalAngel () {
        return currentHeading.getHorizontalAngle(intendedHeading);
    }
    
    double getThrottel () {
        return throttel;
    }
    */
}
