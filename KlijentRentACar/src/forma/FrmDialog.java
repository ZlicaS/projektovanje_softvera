/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma;

import java.awt.Container;

/**
 *
 * @author Sapsaj
 */
public class FrmDialog extends javax.swing.JDialog {
    private IPanel panel;

    /**
     * Creates new form FrmDialog
     */
    public FrmDialog(java.awt.Frame parent, boolean modal,IPanel panel) {
        super(parent, modal);
        initComponents();
        this.panel=panel;
        postaviPanel();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    private void postaviPanel() {
        setContentPane((Container) getPanel());
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public IPanel getPanel() {
        return panel;
    }

    public void setPanel(IPanel panel) {
        this.panel = panel;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
