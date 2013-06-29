package dev.vbms.autopilot.sim;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.util.SkyFactory;

public class Sky {
    
    public void init (Enviroment enviroment) {
        
        // sky
        Scene scene = enviroment.getScene();
        Node rootNode = scene.getRootNode();
        AssetManager assetManager = enviroment.getAassetManager();
        rootNode.attachChild(SkyFactory.createSky(assetManager, "res/tex/sky/Skysphere.jpg", true));        
    }
}
