/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.pain;

/**
 * 
 * @author pcmobile
 */
public class SteerWave {
    
    double maxSteer = 1.0f;
    double impacktWaveTime = 0.5f;
    double impacktWaveMax = 0.25f;
    double impacktWavePower = 0.8f;
    
    public SteerWave () {
    }
    
    public double getPosition (double angel, double impacktRpm) {
        
        // 
        double impacktWaveTimeRpm = (impacktRpm / 60.0f) * impacktWaveTime;
        double impacktWaveValue = 0.0f;
        if (impacktWaveTimeRpm > impacktWaveMax) {
            impacktWaveValue = 1.0f;
        } else {
            impacktWaveValue = Math.cos(impacktWaveTimeRpm * 360);
        }
        impacktWaveValue *= impacktWavePower;
        
        // 
        double position = Math.cos(angel);
        position += impacktWaveValue;
        
        // limmit maximum steer
        if (position >= maxSteer) {
            position = maxSteer;
        }
        
        // return as percentage
        return position * 100.0f;
    }
    
    
    
    
    
    
    
}
