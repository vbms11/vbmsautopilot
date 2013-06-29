package dev.vbms.autopilot.sim.cad;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.util.SkyFactory;
import dev.vbms.autopilot.vehicle.Aeroplain;

public class DesignView extends SimpleApplication {
    
    Material mat;
    Aeroplain aeroplain;
    
    public DesignView (Aeroplain aeroplain) {
        this.aeroplain = aeroplain;
    }
    
    @Override
    public void simpleInitApp () {
        
        // setup camera looking at center
        this.flyCam.setMoveSpeed(100f);
        this.getCamera().setLocation(new Vector3f(10, 10, 10));
        this.getCamera().lookAt(Vector3f.ZERO, Vector3f.UNIT_XYZ);
        
        // sky 
        this.viewPort.setBackgroundColor(ColorRGBA.Black);
        rootNode.attachChild(SkyFactory.createSky(assetManager, "Textures/sky/Skysphere.jpg", true));
        
        // floor
        /*
        Material floorMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Texture floorTexture = this.assetManager.loadTexture("res/designFloor.jpg");
        floorTexture.setWrap(Texture.WrapMode.Repeat);
        floorMaterial.setTexture("floor", floorTexture);
        */
        Quad floorQuad = new Quad(2000,2000);
        Geometry floor = new Geometry("floor", floorQuad);
        floor.setLocalTranslation(-1000, 0, 1000);
        floor.setShadowMode(RenderQueue.ShadowMode.Receive);
        floor.setMaterial(new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md"));
        rootNode.attachChild(floor);
        
        // plain
        mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Gray);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
        Box b = new Box(Vector3f.ZERO, 1, 1, 1);
        Geometry geom = new Geometry("Box", b);
        geom.setMaterial(mat);
        rootNode.attachChild(geom);
    }
}