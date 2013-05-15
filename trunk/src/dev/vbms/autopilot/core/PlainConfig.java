/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author pcmobile
 */
public class PlainConfig {
    
    final String configPath = "dev.vbms.autopilot.plainDefaultConfig.properties";
    
    //  
    String plain_name = "default plain";
    
    // takeoff
    Integer takeoff_accelerate_speed = null;
    Integer takeoff_accelerate_throttel = 100;
    Integer takeoff_accelerate_throttel_rate = 40;
    Integer takeoff_liftoff_speed = 30;
    Integer takeoff_ascend_throttel = 100;
    Integer takeoff_ascend_throttle_rate = 100;
    Integer max_ascend_angle = 10;

    // cruse
    Integer cruse_throttel = 100;
    Integer cruse_throttel_rate = 100;
    Integer cruse_land_height = 200;
    Integer cruse_water_height = 200;

    // landing
    Integer landing_decend_throttel = 20;
    Integer landing_decend_throttle_rate = 20;
    Integer max_descend_angle = 10;
    Integer landing_wheels_retract_time = 10;
    Integer landing_wheels_buffer_time = 10;
    
    // communication
    String plain_key;
    String plain_key_public;
    String plain_key_private;
    
    public boolean loadConfig () {
        
        boolean success = false;
        
        // load the default config file
        Properties config = null;
        try {
            config = new Properties();
            config.load(this.getClass().getResourceAsStream(configPath));
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }
        
        // import values from the config file
        Field[] fields = this.getClass().getDeclaredFields();
        Map<String,Field> map_fields = new HashMap<String,Field>();
        for (Field field : fields) {
            map_fields.put(field.getName(), field);
        }
        
        for (Object key : config.keySet()) {
            Object obj_value = config.get(key);
            String str_value = ((String)obj_value).trim();
            if (str_value.isEmpty()) {
                str_value = null;
            }
            if (map_fields.containsKey(key)) {

                Field field = map_fields.get(key);
                String fieldType = field.getType().getName();
                try {
                    if (fieldType.equals(Double.class.getClass().getName())) {
                        field.set(this, Double.parseDouble(str_value));
                    }
                    if (fieldType.equals(String.class.getClass().getName())) {
                        field.set(this, str_value);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    success = false;
                }
            }
        }

        return success;
    }
    
    public String getPlain_name() {
        return plain_name;
    }

    public void setPlain_name(String plain_name) {
        this.plain_name = plain_name;
    }

    public int getTakeoff_accelerate_speed() {
        return takeoff_accelerate_speed;
    }

    public void setTakeoff_accelerate_speed(int takeoff_accelerate_speed) {
        this.takeoff_accelerate_speed = takeoff_accelerate_speed;
    }

    public int getTakeoff_accelerate_throttel() {
        return takeoff_accelerate_throttel;
    }

    public void setTakeoff_accelerate_throttel(int takeoff_accelerate_throttel) {
        this.takeoff_accelerate_throttel = takeoff_accelerate_throttel;
    }

    public int getTakeoff_accelerate_throttel_rate() {
        return takeoff_accelerate_throttel_rate;
    }

    public void setTakeoff_accelerate_throttel_rate(int takeoff_accelerate_throttel_rate) {
        this.takeoff_accelerate_throttel_rate = takeoff_accelerate_throttel_rate;
    }

    public int getTakeoff_liftoff_speed() {
        return takeoff_liftoff_speed;
    }

    public void setTakeoff_liftoff_speed(int takeoff_liftoff_speed) {
        this.takeoff_liftoff_speed = takeoff_liftoff_speed;
    }

    public int getTakeoff_ascend_throttel() {
        return takeoff_ascend_throttel;
    }

    public void setTakeoff_ascend_throttel(int takeoff_ascend_throttel) {
        this.takeoff_ascend_throttel = takeoff_ascend_throttel;
    }

    public int getTakeoff_ascend_throttle_rate() {
        return takeoff_ascend_throttle_rate;
    }

    public void setTakeoff_ascend_throttle_rate(int takeoff_ascend_throttle_rate) {
        this.takeoff_ascend_throttle_rate = takeoff_ascend_throttle_rate;
    }

    public int getMax_ascend_angle() {
        return max_ascend_angle;
    }

    public void setMax_ascend_angle(int max_ascend_angle) {
        this.max_ascend_angle = max_ascend_angle;
    }

    public int getCruse_throttel() {
        return cruse_throttel;
    }

    public void setCruse_throttel(int cruse_throttel) {
        this.cruse_throttel = cruse_throttel;
    }

    public int getCruse_throttel_rate() {
        return cruse_throttel_rate;
    }

    public void setCruse_throttel_rate(int cruse_throttel_rate) {
        this.cruse_throttel_rate = cruse_throttel_rate;
    }

    public int getCruse_land_height() {
        return cruse_land_height;
    }

    public void setCruse_land_height(int cruse_land_height) {
        this.cruse_land_height = cruse_land_height;
    }

    public int getCruse_water_height() {
        return cruse_water_height;
    }

    public void setCruse_water_height(int cruse_water_height) {
        this.cruse_water_height = cruse_water_height;
    }

    public int getLanding_decend_throttel() {
        return landing_decend_throttel;
    }

    public void setLanding_decend_throttel(int landing_decend_throttel) {
        this.landing_decend_throttel = landing_decend_throttel;
    }

    public int getLanding_decend_throttle_rate() {
        return landing_decend_throttle_rate;
    }

    public void setLanding_decend_throttle_rate(int landing_decend_throttle_rate) {
        this.landing_decend_throttle_rate = landing_decend_throttle_rate;
    }

    public int getMax_descend_angle() {
        return max_descend_angle;
    }

    public void setMax_descend_angle(int max_descend_angle) {
        this.max_descend_angle = max_descend_angle;
    }

    public int getLanding_wheels_retract_time() {
        return landing_wheels_retract_time;
    }

    public void setLanding_wheels_retract_time(int landing_wheels_retract_time) {
        this.landing_wheels_retract_time = landing_wheels_retract_time;
    }

    public int getLanding_wheels_buffer_time() {
        return landing_wheels_buffer_time;
    }

    public void setLanding_wheels_buffer_time(int landing_wheels_buffer_time) {
        this.landing_wheels_buffer_time = landing_wheels_buffer_time;
    }
    
}
