/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

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
    
    final int state_waiting = 0;
    final int state_ascending = 1;
    final int state_decending = 2;
    final int state_traveling = 3;
    int state = state_waiting;
    
    
    void updateIntended () {
        
        plain = Context::getPlain();
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
            case state_traveling:
                
                
                break;
        }
        
        // if loosing height
        // check travel angle
        // check speed
        
        
        if () {
            
        }
    }
    
    void getAdjustRole () {
        return currentHeading.getRoleAngle(intendedHeading);
    }
    
    double getAdjustHeading () {
        return currentHeading.getHorizontalAngle(intendedHeading);
    }
    
    double getAdjustThrottel () {
        
    }
}
