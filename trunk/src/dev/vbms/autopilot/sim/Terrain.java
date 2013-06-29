package dev.vbms.autopilot.sim;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.terrain.geomipmap.TerrainGrid;
import com.jme3.terrain.geomipmap.TerrainGridLodControl;
import com.jme3.terrain.geomipmap.TerrainLodControl;
import com.jme3.terrain.geomipmap.grid.FractalTileLoader;
import com.jme3.terrain.geomipmap.lodcalc.DistanceLodCalculator;
import com.jme3.terrain.noise.ShaderUtils;
import com.jme3.terrain.noise.basis.FilteredBasis;
import com.jme3.terrain.noise.filter.IterativeFilter;
import com.jme3.terrain.noise.filter.OptimizedErode;
import com.jme3.terrain.noise.filter.PerturbFilter;
import com.jme3.terrain.noise.filter.SmoothFilter;
import com.jme3.terrain.noise.fractal.FractalSum;
import com.jme3.terrain.noise.modulator.NoiseModulator;
import com.jme3.texture.Texture;

public class Terrain {
    
    Material mat_terrain;
    float grassScale = 1;
    float dirtScale = 1;
    float rockScale = 1;
    FractalSum base;
    PerturbFilter perturb;
    OptimizedErode therm;
    SmoothFilter smooth;
    IterativeFilter iterate;
    TerrainGrid terrain;
    TerrainLodControl control;
    
    public void init (Enviroment env) {
        
        AssetManager assetManager = env.getAssetManager();
        
        // TERRAIN TEXTURE material
        mat_terrain = new Material(assetManager, "Common/MatDefs/Terrain/HeightBasedTerrain.j3md");
        Texture grass = assetManager.loadTexture("res/tex/terrain/grass.jpg");
        grass.setWrap(Texture.WrapMode.Repeat);
        mat_terrain.setTexture("region1ColorMap", grass);
        mat_terrain.setVector3("region1", new Vector3f(15, 200, grassScale));
        
        // DIRT texture
        Texture dirt = assetManager.loadTexture("res/tex/terrain/dirt.jpg");
        dirt.setWrap(Texture.WrapMode.Repeat);
        this.mat_terrain.setTexture("region2ColorMap", dirt);
        this.mat_terrain.setVector3("region2", new Vector3f(0, 20, dirtScale));
        
        // ROCK texture
        Texture rock = assetManager.loadTexture("res/tex/terrain/rock.jpg");
        rock.setWrap(Texture.WrapMode.Repeat);
        mat_terrain.setTexture("region3ColorMap", rock);
        mat_terrain.setVector3("region3", new Vector3f(198, 260, rockScale));
        mat_terrain.setTexture("region4ColorMap", rock);
        mat_terrain.setVector3("region4", new Vector3f(198, 260, rockScale));
        mat_terrain.setTexture("slopeColorMap", rock);
        mat_terrain.setFloat("slopeTileFactor", 32);
        mat_terrain.setFloat("terrainSize", 513);
        
        base = new FractalSum();
        base.setRoughness(0.7f);
        base.setFrequency(1.0f);
        base.setAmplitude(1.0f);
        base.setLacunarity(2.12f);
        base.setOctaves(8);
        base.setScale(0.1f);
        base.addModulator(new NoiseModulator() {
            @Override
            public float value(float... in) {
                return ShaderUtils.clamp(in[0] * 0.5f + 0.5f, 0, 1);
            }
        });
        
        FilteredBasis ground = new FilteredBasis(this.base);
        perturb = new PerturbFilter();
        perturb.setMagnitude(0.119f);
        
        therm = new OptimizedErode();
        therm.setRadius(5);
        therm.setTalus(0.011f);
        
        smooth = new SmoothFilter();
        smooth.setRadius(1);
        smooth.setEffect(0.7f);
        
        iterate = new IterativeFilter();
        iterate.addPreFilter(perturb);
        iterate.addPostFilter(smooth);
        iterate.setFilter(therm);
        iterate.setIterations(1);
        
        ground.addPreFilter(iterate);
        
        terrain = new TerrainGrid("terrain", 33, 1025, new FractalTileLoader(ground, 256f));
        terrain.setMaterial(mat_terrain);
        terrain.setLocalTranslation(0, 0, 0);
        terrain.setLocalScale(2f, 2f, 2f);
        
        RigidBodyControl terrainPhysicsNode = new RigidBodyControl(CollisionShapeFactory.createMeshShape(terrain), 0);
        terrain.addControl(terrainPhysicsNode);
        env.getPhysicsSpace().add(terrainPhysicsNode);
        
        control = new TerrainGridLodControl(terrain, env.getCamera());
        control.setLodCalculator(new DistanceLodCalculator(33, 2.7f));
        terrain.addControl(control);
        
        env.getScene().getRootNode().attachChild(terrain);
    }
}
