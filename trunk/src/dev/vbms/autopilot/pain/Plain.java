/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.pain;

import dev.vbms.autopilot.device.AbstractMotor;
import dev.vbms.autopilot.device.AbstractServo;

/**
 *
 * @author pcmobile
 */
public class Plain {
    
    // the plain parts
    AbstractServo rudderServoHorizontal;
    AbstractServo rudderServoVertical;
    AbstractServo wingLeftServo;
    AbstractServo wingRightServo;
    AbstractMotor motor;
    
    Giro giro;
    Gps gps;
    
    void setRudderVerticalPosition (double rudderPosition) {
    
    }
    
    void setRudderHorizontalPosition (double horizontalPosition) {
       
        
    }
    
    void setSetVerticalPosition (double horizontalPosition) {
        
    }
    
    double getMotorThrott () {
        return motor.getThrottle();
    }
    
    void setMotorThrottle (double throttle) {
        motor.setThrottle(throttle);
    }
    
}
