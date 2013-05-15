/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

/**
 *
 * @author pcmobile
 */
public class Position {
    
    int longditude = 0;
    int latitude = 0;
    int accuracy = 0;
    int height = 0;
    
    public int getLongditude() {
        return longditude;
    }

    public void setLongditude(int longditude) {
        this.longditude = longditude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }    
}
