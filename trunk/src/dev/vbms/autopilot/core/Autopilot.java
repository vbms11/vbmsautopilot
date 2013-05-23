/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

import dev.vbms.autopilot.math.Vector2d;
import dev.vbms.autopilot.pain.AbstractPlain;
import java.util.List;
import sun.net.www.content.text.plain;

/**
 *
 * @author pcmobile
 */
public class Autopilot {
    
    static final int state_system_startup = -2;
    static final int state_system_shutdown = -1;
    static final int state_landed = 0;
    static final int state_takeoff_prepear = 1;
    static final int state_takeoff_accelerate = 2;
    static final int state_takeoff_try_gain = 3;
    static final int state_takeoff_gain_success = 4;
    static final int state_takeoff_gain_continue = 5;
    static final int state_takeoff_finnished = 6;
    static final int state_objective_next = 7;
    static final int state_objective_continue = 8;
    static final int state_objective_complete = 9;
    static final int state_landing_approach = 10;
    static final int state_landing_prepear = 11;
    static final int state_landing_estimate = 12;
    static final int state_landing_attempt = 13;
    static final int state_landing_abort = 14;
    static final int state_landing_success = 15;
    
    static final int phase_takeoff = -11;
    static final int phase_objectives = -12;
    static final int phase_landing = -13;
    static final int phase_grounded = -14;
    
    static Thread autopilotThread;
    static Object lock;
    
    static double throttelIncreasRate;
    static double throttelSteps;
    
    AbstractPlain plain;
    
    int state;
    
    class Objective {
        final int type_wait = 1;
        final int type_trolly = 2;
        final int type_takeoff = 3;
        final int type_flyto = 4;
        final int type_cargo_drop = 5;
        final int type_cargo_load = 6;
        final int type_refule = 7;
        final int type_land = 8;
        final int type_calibrate = 9;
        final int type_startup = 10;
        final int type_shutdown = 11;
        final int type_manual = 12;
        final int type_roam = 13;
        final int type_recover = 14;
        
        int type = 0;
        
        double radius;
        Position position;
        
        public boolean isCompelete () {
            boolean result = false;
            switch (type) {
                case type_flyto:
                    Position plainPosition = ;
                    Vector2d offset = new Vector2d(position.longditude - plainPosition.longditude, position.latitude - plainPosition.latitude);
                    if (offset.getLength() <= radius) {
                        result = true;
                    }
                    break;
            }
            return result;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }
        
        
    }
    
    List<Objective> objectives;
    int currentObjective;
    
    void run () {
        
        plain = Context.getPlain();
        PlainConfig plainConfig = plain.getPlainConfig();
        
        long lastTime = System.currentTimeMillis();
        while (state != state_system_shutdown) {
            
            long currentTime = System.currentTimeMillis();
            long interval = currentTime - lastTime;
            
            switch (state) {
    
                case state_system_startup:
                    break;
                case state_system_shutdown:
                    break;
                case state_landed:
                    // check if objectives exist
                    break;
                case state_takeoff_prepear:
                    // make calculations for direction or takeoff
                    // assume the plain will takeoff in the direction it was placed
                    break;
                case state_takeoff_accelerate:
                    // regulate throttle rate
                    if (plain.getMotorThrott() < plainConfig.maxTakeoffAccelerateThrottle) {
                        plain.setMotorThrottle(plain.getMotorThrott() + (interval * plainConfig.takeoffThrottleRate));
                    }
                    // regulate takeoff angle
                    break;
                case state_takeoff_try_gain:
                    // regulate takeoff angle
                case state_takeoff_gain_success:
                    //
                case state_takeoff_gain_continue:
                case state_takeoff_finnished:
                case state_objective_next:
                    currentObjective++;
                case state_objective_continue:
                    Objective objective = objectives.get(currentObjective);
                    if (objective.isCompelete()) {
                        state = state_objective_complete;
                    } else {
                        // get distance
                        // get heading to objective
                        Position objectivePosition = objective.getPosition();
                        objectivePosition =  null;
                    }
                    break;
                case state_objective_complete:
                    state = state_objective_next;
                    break;
                case state_landing_approach:
                    
                    
                    
                    // needs course corrections ?
                    // dont loose height
                    // do course corrections
                    break;
                case state_landing_prepear:
                case state_landing_estimate:
                case state_landing_attempt:
                case state_landing_abort:
                    state = landing_prepear;
                    break;
                case state_landing_success:
                    state = state_landed;
                    phase = phase_grounded;
                    break;
                
            }
            
            // estimate new position
            FlightSimulator simulator = new FlightSimulator();
            simulator.updateIntended();
            simulator.getHorizontalAngel();
            
            // update flight controlles
            plain.setHorizontalValue(throttelSteps);
            plain.setVerticalValue(throttelSteps);
            plain.setRoleValue(throttelSteps);
            plain.setMotorThrottle(throttelSteps);
        }
    }
    
    
    
    static void main (String[] args) {
        
    }
    
}
