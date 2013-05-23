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
public class AutopilotThread extends Thread {
    
    public AbstractPlain plain = null;
    
    public AutopilotThread (AbstractPlain plain) {
        this.plain = plain;
    }
    
    @Override
    public void run () {
        plain.getAutopilot().run();
    }

    public AbstractPlain getPlain() {
        return plain;
    }

    public void setPlain(AbstractPlain plain) {
        this.plain = plain;
    }
    
}
