package dev.vbms.autopilot.vehicle;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer;
import com.jme3.scene.shape.Box;
import dev.vbms.autopilot.sim.Enviroment;
import dev.vbms.autopilot.sim.Scene;

public class AeroplainVehicle extends VehicleNode {
    
    float wingHeight = 0.01f, 
           wingLength = 2.0f, 
           wingWidth = 0.2f, 
           tailLength = 1.0f, 
           tailWidth = 0.2f, 
           rudderLength = 1.0f,
           rudderWidth = 0.1f, 
           wingOffset = 1.0f,
           hullWidth = 0.1f,
           hullHeight = 0.1f,
           hullLength = 2.0f;
    
    Box wingBox, tailBox, rudderBox, hullBox;
    
    public Mesh getMesh () {
        Mesh mesh = new Mesh();
        VertexBuffer vb = new VertexBuffer();
        
        wingBox = new Box(wingWidth / 2.0f, wingHeight / 2.0f, wingLength / 2.0f);
        tailBox = new Box(tailWidth / 2.0f, wingHeight / 2.0f, tailLength / 2.0f);
        rudderBox = new Box(rudderWidth / 2.0f, wingHeight / 2.0f, rudderLength / 2.0f);
        hullBox = new Box(hullWidth / 2.0f, hullHeight / 2.0f, hullLength / 2.0f);
        
        
        /*
        mesh.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices));
        mesh.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        mesh.setBuffer(VertexBuffer.Type.Index,    3, BufferUtils.createIntBuffer(indexes));
        mesh.updateBound();
        */
        return mesh;
    }
    
    public void init (Enviroment enviroment) {
        Scene scene = enviroment.getScene();
        Mesh mesh = getMesh();
        Geometry geo = new Geometry("OurMesh", mesh);
        Material mat = new Material(enviroment.getAssetManager(),"Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geo.setMaterial(mat);
        scene.getRootNode().attachChild(geo);
    }
    
    public void render () {
        
    }
    
    public void onAction (String name, float tfp) {
        
    }
}
