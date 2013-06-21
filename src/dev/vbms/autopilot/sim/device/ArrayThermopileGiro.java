package dev.vbms.autopilot.sim.device;

import com.jme3.math.Vector2f;
import java.util.List;

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
            
            int current_recrusions = 1;
            int[][] frame = null; //themopileArray.getFrame();
            float avarageX = 0, avarageY = 0;
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
            
            Vector2f avarageVector = new Vector2f(avarageX,avarageY);
            avarageVector.normalize();
            
            // search with recrusive boxes
            
        }
    }
    
    
    
    
}
