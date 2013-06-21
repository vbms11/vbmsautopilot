package dev.vbms.autopilot.sim;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.util.SkyFactory;

public class Sky {
    
    public void init (Scene scene) {
        
        // sky
        Node rootNode = scene.getRootNode();
        AssetManager assetManager = scene.getAassetManager();
        rootNode.attachChild(SkyFactory.createSky(assetManager, "Textures/sky/sky.jpg", true));        
    }
}
