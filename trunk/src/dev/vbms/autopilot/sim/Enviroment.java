package dev.vbms.autopilot.sim;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;

public class Enviroment extends SimpleApplication {
    
    Scene scene;
    AssetManager assetManager;
    BulletAppState bulletAppState;
    
    public Enviroment () {
    }
    
    public PhysicsSpace getPhysicsSpace() {
        return bulletAppState.getPhysicsSpace();
    }
    
    public AssetManager getAassetManager () {
        return assetManager;
    }
    
    public Scene getScene () {
        return scene;
    }
    
    @Override
    public void simpleInitApp () {
        
        assetManager = getAssetManager();
        
        AppState state = new BulletAppState();
        getStateManager().attach(state);
        
        scene = new Scene();
        scene.init(this);
    }
    
    public void update (int stepsMillis) {
        scene.update(stepsMillis);
    }
    
    public void render () {
        scene.render();
    }
}
