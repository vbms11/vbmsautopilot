/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.device;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author pcmobile
 */
public class ArrayThermopileGiro {
    
    class ThermopileArray {

    }
    
    class RasterDivider {
        
    }
    
    List<ThermopileArray> themopileArrays;
    
    void addThermopileArray () {
        
        // for each sensor try to find the down vector
        for (ThermopileArray themopileArray : themopileArrays) {
            
            // find the vector of the avarage score
            
            int current recrusions = 1;
            int[][] frame = themopileArray.getFrame();
            double avarageX = 0, avarageY = 0;
            int frameWidth = frame.length;
            int frameHeight = frame[0].length;
            double halfFrameHeight = frameHeight / 2.0f;
            double halfFrameWidth = frameWidth / 2.0f;
            double avarageScore = 0;
            for (int y=0; y<frame.length; y++) {
                
                for (int x=0; x<frameHeight; x++) {
                    avarageX += (x - halfFrameWidth) * frame[y][x];
                    avarageY += (y - halfFrameWidth) * frame[y][x];
                    avarageScore += frame[y][x];
                }
            }
            avarageScore /= frameWidth * frameHeight;
            
            Vector2d avarageVector = new Vector2d(avarageX,avarageY);
            avarageVector.normalize();
            
            // search with recrusive boxes
            
        }
    }
    
    
    
    
}
