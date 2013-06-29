package dev.vbms.autopilot.vehicle;

import com.jme3.asset.AssetManager;
import com.jme3.bounding.BoundingBox;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.VehicleControl;
import com.jme3.bullet.objects.VehicleWheel;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.FastMath;
import com.jme3.math.Matrix3f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import dev.vbms.autopilot.sim.Enviroment;
import dev.vbms.autopilot.test.PhysicsHelper;

public class CarVehicle extends VehicleNode implements ActionListener {
    
    private VehicleControl player;
    private float wheelRadius;
    private float steeringValue = 0;
    private float accelerationValue = 0;
    private float spawnHeight = 1;
    
    public CarVehicle () {
    }
    
    public float getSpawnHeight () {
        return spawnHeight;
    }
    
    public void setPosition (Vector3f position) {
        player.setPhysicsLocation(position);
    }
    
    @Override
    public void init (Enviroment enviroment) {
        
        float stiffness = 120.0f; //200=f1 car
        float compValue = 0.2f;   //(lower than damp!)
        float dampValue = 0.3f;
        final float mass = 400;

        //Load model and get chassis Geometry
        AssetManager assetManager = enviroment.getAssetManager();
        Node carNode = (Node) assetManager.loadModel("Models/Ferrari/Car.scene");
        carNode.setShadowMode(ShadowMode.Cast);
        attachChild(carNode);
        Geometry chasis = PhysicsHelper.findGeom(carNode, "Car");
        
        BoundingBox box;

        //Create a hull collision shape for the chassis
        CollisionShape carHull = CollisionShapeFactory.createDynamicMeshShape(chasis);

        //Create a vehicle control
        player = new VehicleControl(carHull, mass);
        addControl(player);

        //Setting default values for wheels
        player.setSuspensionCompression(compValue * 2.0f * FastMath.sqrt(stiffness));
        player.setSuspensionDamping(dampValue * 2.0f * FastMath.sqrt(stiffness));
        player.setSuspensionStiffness(stiffness);
        player.setMaxSuspensionForce(10000);
        
        Vector3f wheelDirection = new Vector3f(0, -1, 0);
        Vector3f wheelAxle = new Vector3f(-1, 0, 0);

        Geometry wheel_fr = PhysicsHelper.findGeom(this, "WheelFrontRight");
        wheel_fr.center();
        box = (BoundingBox) wheel_fr.getModelBound();
        wheelRadius = box.getYExtent();
        float back_wheel_h = (wheelRadius * 1.7f) - 1f;
        float front_wheel_h = (wheelRadius * 1.9f) - 1f;
        player.addWheel(wheel_fr.getParent(), box.getCenter().add(0, -front_wheel_h, 0),
                wheelDirection, wheelAxle, 0.2f, wheelRadius, true);

        Geometry wheel_fl = PhysicsHelper.findGeom(this, "WheelFrontLeft");
        wheel_fl.center();
        box = (BoundingBox) wheel_fl.getModelBound();
        player.addWheel(wheel_fl.getParent(), box.getCenter().add(0, -front_wheel_h, 0),
                wheelDirection, wheelAxle, 0.2f, wheelRadius, true);

        Geometry wheel_br = PhysicsHelper.findGeom(this, "WheelBackRight");
        wheel_br.center();
        box = (BoundingBox) wheel_br.getModelBound();
        player.addWheel(wheel_br.getParent(), box.getCenter().add(0, -back_wheel_h, 0),
                wheelDirection, wheelAxle, 0.2f, wheelRadius, false);

        Geometry wheel_bl = PhysicsHelper.findGeom(this, "WheelBackLeft");
        wheel_bl.center();
        box = (BoundingBox) wheel_bl.getModelBound();
        player.addWheel(wheel_bl.getParent(), box.getCenter().add(0, -back_wheel_h, 0),
                wheelDirection, wheelAxle, 0.2f, wheelRadius, false);

        player.getWheel(2).setFrictionSlip(4);
        player.getWheel(3).setFrictionSlip(4);

        enviroment.getRootNode().attachChild(this);
        enviroment.getPhysicsSpace().add(player);
    }
    
    @Override
    public void onAction(String binding, boolean value, float tpf) {
        switch (binding) {
            case "left":
                if (value) {
                    steeringValue += 0.5f;
                } else {
                    steeringValue += -0.5f;
                }
                player.steer(steeringValue);
                break;
            case "right":
                if (value) {
                    steeringValue += -0.5f;
                } else {
                    steeringValue += 0.5f;
                }
                player.steer(steeringValue);
                break;
            case "up":
                if (value) {
                    accelerationValue -= 800;
                } else {
                    accelerationValue += 800;
                }
                player.accelerate(accelerationValue);
                player.setCollisionShape(CollisionShapeFactory.createDynamicMeshShape(PhysicsHelper.findGeom(this, "Car")));
                break;
            case "down":
                if (value) {
                    player.brake(40f);
                } else {
                    player.brake(0f);
                }
                break;
            case "reset":
                if (value) {
                    // player.setPhysicsLocation(Vector3f.ZERO);
                    player.setPhysicsRotation(new Matrix3f());
                    player.setLinearVelocity(Vector3f.ZERO);
                    player.setAngularVelocity(Vector3f.ZERO);
                    player.resetSuspension();
                    break;
                }
        }
    }
    
    public void update(float tpf) {
        // cam.lookAt(this.getWorldTranslation(), Vector3f.UNIT_Y);
    }
    
}