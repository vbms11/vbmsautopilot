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
public class AirframeClassicPlain {
    
    final String plainConfigPath = "dev.vbms.autopilot.config.plainClassicConfig.properties";
    
    // the plain parts
    AbstractServo rudderServoHorizontal;
    AbstractServo rudderServoVertical;
    AbstractServo wingLeftServo;
    AbstractServo wingRightServo;
    AbstractMotor motor;
    
    public String getConfigPath () {
        return plainConfigPath;
    }
    
    public void setHorizontalValue (double value) {
        rudderServoHorizontal.setPosition(value);
    }
    
    public void setVerticalValue (double value) {
        rudderServoVertical.setPosition(value);
    }
    
    public void setRoleValue (double value) {
        wingLeftServo.setPosition(value);
        wingRightServo.setPosition(-value);
    }
    
    public double getHorizontalValue () {
        return rudderServoHorizontal.getPosition();
    }
    
    public double getVerticalValue () {
        return rudderServoVertical.getPosition();
    }
    
    public double getRoleValue () {
        double roleLeft = wingLeftServo.getPosition();
        double roleRight = wingRightServo.getPosition();
        if (roleLeft < 0) {
            roleLeft = -roleLeft;
        }
        if (roleRight < 0) {
            roleRight = -roleRight;
        }
        return (roleLeft + roleRight) / 2.0f;
    }
    
    public double getMotorThrott () {
        return motor.getThrottle();
    }
    
    public void setMotorThrottle (double throttle) {
        motor.setThrottle(throttle);
    }
}
