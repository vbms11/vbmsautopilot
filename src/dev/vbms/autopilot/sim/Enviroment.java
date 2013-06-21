package dev.vbms.autopilot.sim;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.ScreenshotAppState;

public class Enviroment extends SimpleApplication {
    
    Scene scene;
    
    public Enviroment () {
    }
    
    public Scene getScene () {
        return scene;
    }
    
    @Override
    public void simpleInitApp () {
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
