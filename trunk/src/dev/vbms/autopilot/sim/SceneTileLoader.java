package dev.vbms.autopilot.sim;

import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.math.Vector3f;
import com.jme3.terrain.geomipmap.LRUCache;
import com.jme3.terrain.geomipmap.TerrainGridTileLoader;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.HeightMap;
import com.jme3.terrain.noise.Basis;
import dev.vbms.autopilot.building.BuildingNode;
import dev.vbms.autopilot.road.RoadJunction;
import dev.vbms.autopilot.road.RoadPath;
import dev.vbms.autopilot.vehicle.CarVehicle;
import dev.vbms.autopilot.vehicle.VehicleNode;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.List;

public class SceneTileLoader implements TerrainGridTileLoader {
    
    private int patchSize;
    private int quadSize;
    private final Basis base;
    private final float heightScale;
    protected LRUCache<Vector3f, AbstractHeightMap> cache = new LRUCache<Vector3f, AbstractHeightMap>(30);
    
    public static class FloatBufferHeightMap extends AbstractHeightMap {

        private final FloatBuffer buffer;
        
        public FloatBufferHeightMap(FloatBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public boolean load() {
            this.heightData = this.buffer.array();
            return true;
        }
    }
    
    public SceneTileLoader(Basis base, float heightScale) {
        this.base = base;
        this.heightScale = heightScale;
    }
    
    public List<VehicleNode> getVehicleNodes (Vector3f location) {
        AbstractHeightMap heightmap = getHeightMapAt(location);
        List<VehicleNode> lst_vehicles = new LinkedList<VehicleNode>();
        VehicleNode vn_test = new CarVehicle();
        vn_test.init(Enviroment.getEnviroment());
        float height = heightmap.getInterpolatedHeight(location.x, location.z);
        vn_test.setPosition(new Vector3f(patchSize / 2, height + vn_test.getSpawnHeight(), patchSize / 2));
        lst_vehicles.add(vn_test);
        return lst_vehicles;
    }
    
    public List<BuildingNode> getBuildingNodes (Vector3f location) {
        Enviroment.getEnviroment().getScene().getTerrain();
        
        return null;
    }
    
    public List<RoadJunction> getRoadJunctions (Vector3f location) {
        Enviroment.getEnviroment().getScene().getTerrain();
        return null;
    }
    
    public List<RoadPath> getRoadPath (Vector3f location) {
        Enviroment.getEnviroment().getScene().getTerrain();
        return null;
    }
    
    public AbstractHeightMap getHeightMapAt(Vector3f location) {
        AbstractHeightMap heightmap = cache.get(location);
        if (heightmap == null) {
            FloatBuffer buffer = this.base.getBuffer(location.x * (this.quadSize - 1), location.z * (this.quadSize - 1), 0, this.quadSize);
            float[] arr = buffer.array();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * this.heightScale;
            }
            heightmap = new FloatBufferHeightMap(buffer);
            heightmap.load();
            cache.put(location, heightmap);
        }
        return heightmap;
    }
    
    @Override
    public TerrainQuad getTerrainQuadAt(Vector3f location) {
        HeightMap heightMapAt = getHeightMapAt(location);
        TerrainQuad q = new TerrainQuad("Quad" + location, patchSize, quadSize, heightMapAt == null ? null : heightMapAt.getHeightMap());
        return q;
    }
    
    @Override
    public void setPatchSize(int patchSize) {
        this.patchSize = patchSize;
    }
    
    @Override
    public void setQuadSize(int quadSize) {
        this.quadSize = quadSize;
    }
    
    @Override
    public void write(JmeExporter ex) throws IOException {
        //TODO: serialization
    }
    
    @Override
    public void read(JmeImporter im) throws IOException {
        //TODO: serialization
    }
    
}
