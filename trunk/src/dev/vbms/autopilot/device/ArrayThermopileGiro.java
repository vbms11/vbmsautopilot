/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.device;

import dev.vbms.autopilot.math.Vector2d;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author pcmobile
 */
public class ArrayThermopileGiro {
    
    class RasterDivider {
        
    }
    
    List<AbstractThermopile> themopiles;
    
    void addThermopileArray () {
        
        // for each sensor try to find the down vector
        for (AbstractThermopile themopile : themopiles) {
            
            // find the vector of the avarage score
            
            int current_ecrusions = 1;
            int[][] frame = themopile.getData();
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
            /*
            Vector2d avarageVector = new Vector2d(avarageX,avarageY);
            avarageVector.normalize();
            */
            // search with recrusive boxes
            
        }
    }
    
    
    
    
}
