package dev.vbms.autopilot.sim;

import com.jme3.app.state.ScreenshotAppState;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;

public class Scene {
    
    Node rootNode;
    AssetManager assetManager;
    Enviroment enviroment;
    Terrain terrain;
    Water water;
    Sky sky;
    Camera camera;
    
    public AssetManager getAassetManager () {
        return assetManager;
    }
    
    public Node getRootNode () {
        return rootNode;
    }
    
    public Enviroment getEnviroment () {
        return enviroment;
    }
    
    public void init (Enviroment enviroment) {
        
        this.enviroment = enviroment;
        
        assetManager = enviroment.getAssetManager();
        rootNode = enviroment.getRootNode();
        
        ScreenshotAppState state = new ScreenshotAppState();
        enviroment.getStateManager().attach(state);
        
        camera = new Camera();
        camera.init(enviroment);
        
        terrain = new Terrain();
        terrain.init(enviroment);
        
        sky = new Sky();
        sky.init(this);
        
        water = new Water();
        water.init(this);
    }
    
    public void update (int stepsMillis) {
        
    }
    
    public void render () {
        
    }
    
}
