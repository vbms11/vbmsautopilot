/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.vbms.autopilot.core;

import dev.vbms.autopilot.gui.ApplicationFrame;

/**
 *
 * @author pcmobile
 */
public class Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run () {
                new ApplicationFrame().setVisible(true);
            }
        });
    }
}
