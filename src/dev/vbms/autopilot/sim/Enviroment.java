package dev.vbms.autopilot.sim;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AppState;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Ray;
import com.jme3.scene.Node;
import dev.vbms.autopilot.building.BuildingDoorNode;
import dev.vbms.autopilot.item.ItemNode;
import dev.vbms.autopilot.vehicle.CharacterVehicle;
import dev.vbms.autopilot.vehicle.VehicleNode;

public class Enviroment extends SimpleApplication implements ActionListener {
    
    Scene scene;
    BulletAppState bulletAppState;
    VehicleNode currentVehicle;
    
    protected static Enviroment enviroment = null;
    
    protected Enviroment () {    
    }
    
    public static Enviroment getEnviroment () {
        if (enviroment == null) {
            enviroment = new Enviroment();
        }
        return enviroment;
    }
    
    public PhysicsSpace getPhysicsSpace() {
        return bulletAppState.getPhysicsSpace();
    }
    
    public Scene getScene () {
        return scene;
    }
    
    @Override
    public void simpleInitApp () {
        
        assetManager = getAssetManager();
        
        AppState state = new BulletAppState();
        getStateManager().attach(state);
        
        setupKeys();
        
        scene = new Scene();
        scene.init(this);
    }
    
    public void update (int stepsMillis) {
        scene.update(stepsMillis);
    }
    
    public void render () {
        scene.render();
    }
    
    private void setupKeys() {
        inputManager.addMapping("use", new KeyTrigger(KeyInput.KEY_E));
        inputManager.addMapping("left", new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("right", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("up", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("down", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("space", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("reset", new KeyTrigger(KeyInput.KEY_RETURN));
        inputManager.addListener(this, "use");
        inputManager.addListener(this, "left");
        inputManager.addListener(this, "right");
        inputManager.addListener(this, "up");
        inputManager.addListener(this, "down");
        inputManager.addListener(this, "space");
        inputManager.addListener(this, "reset");
    }
    
    @Override
    public void onAction (String binding, boolean value, float tpf) {
        switch (binding) {
            case "use":
                if (currentVehicle instanceof CharacterVehicle) {
                    CollisionResults results = new CollisionResults();
                    Ray ray = new Ray(cam.getLocation(), cam.getDirection());
                    rootNode.collideWith(ray, results);
                    if (results.size() > 0) {
                        CollisionResult closest = results.getClosestCollision();
                        Node selectedNode = getUsableNode(closest.getGeometry().getParent());
                        if (selectedNode != null) {
                            if (selectedNode instanceof VehicleNode) {
                                currentVehicle = (VehicleNode) selectedNode;
                                currentVehicle.startUsing();
                            } else if (selectedNode instanceof BuildingDoorNode) {
                                BuildingDoorNode bdn_door = (BuildingDoorNode) selectedNode;
                                bdn_door.toggleState();
                            } else if (selectedNode instanceof ItemNode) {
                                
                            }
                        }
                    }
                } else {
                    VehicleNode character = scene.getCharacter();
                    character.setLocalTranslation(currentVehicle.getLocalTranslation());
                    currentVehicle.stopUsing();
                    currentVehicle = character;
                }
                break;
            default:
                currentVehicle.onAction(binding, value, tpf);
        }
    }
    
    private Node getUsableNode (Node node) {
        if (node instanceof VehicleNode) {
            return node;
        } else if (node instanceof BuildingDoorNode) {
            return node;
        } else if (node instanceof ItemNode) {
            return node;
        }
        Node parent = node.getParent();
        if (parent != null) {
            return getUsableNode(parent);
        }
        return null;
    }
    
}
