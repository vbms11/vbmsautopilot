/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

import dev.vbms.autopilot.pain.AbstractPlain;

/**
 *
 * @author pcmobile
 */
public class Context {
    
    public static AbstractPlain getPlain () {
        return ((AutopilotThread)Thread.currentThread()).getPlain();
    }
    
}
