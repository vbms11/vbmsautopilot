package dev.vbms.autopilot.gui;

import dev.vbms.autopilot.sim.cad.FlightView;
import dev.vbms.autopilot.vehicle.AeroplainVehicle;

public class FlightPanel extends javax.swing.JPanel {
    
    public FlightPanel() {
        initComponents();
    }
    
    public void initViews () {
        AeroplainVehicle selectedPlain = new AeroplainVehicle();
        jMonkeyPanel1.run(new FlightView());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonkeyPanel1 = new dev.vbms.autopilot.gui.JMonkeyPanel();

        javax.swing.GroupLayout jMonkeyPanel1Layout = new javax.swing.GroupLayout(jMonkeyPanel1);
        jMonkeyPanel1.setLayout(jMonkeyPanel1Layout);
        jMonkeyPanel1Layout.setHorizontalGroup(
            jMonkeyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
        jMonkeyPanel1Layout.setVerticalGroup(
            jMonkeyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMonkeyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMonkeyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private dev.vbms.autopilot.gui.JMonkeyPanel jMonkeyPanel1;
    // End of variables declaration//GEN-END:variables
}
