/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.pain;

import java.awt.Point;
import java.util.Vector;

/**
 *
 * @author pcmobile
 */
 abstract public class Sensors {
     
    public class Position {
    }
    
    public class PositionFactory {
        
    }
    
    public int getHeightFromAirPressure () {
        return 0;
    }
    
    public Position getPositionFromGps () {
        return new Position();
    }
    
    public int getCompasAngle () {
        return 0;
    }
    
    public int getServoPosition (int servoId) {
        return 0;
    }
    
    
}
