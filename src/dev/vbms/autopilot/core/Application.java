package dev.vbms.autopilot.core;

import dev.vbms.autopilot.gui.ApplicationFrame;
import javax.swing.JFrame;

public class Application {
    
    public static void main(String args[]) {
        initEnv();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run () {
                new ApplicationFrame().setVisible(true);
            }
        });
    }
    
    public static void initEnv () {        
        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            //UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
        } catch (Exception e) {
        }
    }
}
