package dev.vbms.autopilot.sim;

import com.jme3.scene.Node;
import dev.vbms.autopilot.vehicle.VehicleNode;

public class Scene {
    
    Node rootNode;
    Enviroment enviroment;
    Terrain terrain;
    Camera camera;
    Water water;
    Sky sky;
    
    VehicleNode character;
    VehicleNode currentVehicle;
    // RoadsManager
    // VehicleManager
    // BuildingsManager
    
    public VehicleNode getCharacter () {
        return character;
    }
    
    public Terrain getTerrain () {
        return terrain;
    }
    
    public Node getRootNode () {
        return rootNode;
    }
    
    public Enviroment getEnviroment () {
        return enviroment;
    }
    
    public void init (Enviroment enviroment) {
        
        this.enviroment = enviroment;
        rootNode = enviroment.getRootNode();
        
        camera = new Camera();
        camera.init(enviroment);
        
        terrain = new Terrain();
        terrain.init(enviroment);
        
        sky = new Sky();
        sky.init(enviroment);
        
        water = new Water();
        water.init(enviroment);
        
    }
    
    public void update (int stepsMillis) {
        
    }
    
    public void render () {
        
    }
}
