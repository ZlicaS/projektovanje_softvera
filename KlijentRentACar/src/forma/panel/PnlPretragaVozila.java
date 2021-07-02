/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.panel;

import domain.Vozilo;
import forma.FrmDialog;
import forma.FrmForma;
import forma.IPanel;
import forma.ModForme;
import forma.model.ModelTabeleVozilo;
import java.awt.Frame;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sapsaj
 */
public class PnlPretragaVozila extends javax.swing.JPanel implements IPanel {

    ModelTabeleVozilo model;

    /**
     * Creates new form PnlPretragaVozila
     */
    public PnlPretragaVozila() {
        initComponents();
        pripremiFormu();
        btnIzaberi.setVisible(false);
        vratiSve();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNazivMarke = new javax.swing.JLabel();
        txtNazivMarke = new javax.swing.JTextField();
        btnPronadji = new javax.swing.JButton();
        btnVratiSve = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVozilo = new javax.swing.JTable();
        btnKreirajNovo = new javax.swing.JButton();
        btnPrikaziDetalje = new javax.swing.JButton();
        btnIzaberi = new javax.swing.JButton();

        lblNazivMarke.setText("Naziv marke:");

        btnPronadji.setText("Pronadji");
        btnPronadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPronadjiActionPerformed(evt);
            }
        });

        btnVratiSve.setText("Vrati sve");
        btnVratiSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiSveActionPerformed(evt);
            }
        });

        tblVozilo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVozilo);

        btnKreirajNovo.setText("Kreiraj novo vozilo");
        btnKreirajNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajNovoActionPerformed(evt);
            }
        });

        btnPrikaziDetalje.setText("Prikazi detalje");
        btnPrikaziDetalje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziDetaljeActionPerformed(evt);
            }
        });

        btnIzaberi.setText("Izaberi");
        btnIzaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblNazivMarke, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPronadji)
                                .addGap(65, 65, 65)
                                .addComponent(btnVratiSve))
                            .addComponent(txtNazivMarke, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnKreirajNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPrikaziDetalje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIzaberi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNazivMarke, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNazivMarke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPronadji)
                    .addComponent(btnVratiSve))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKreirajNovo)
                        .addGap(28, 28, 28)
                        .addComponent(btnPrikaziDetalje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzaberi)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVratiSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiSveActionPerformed
        try {
            List<Vozilo> lista = kontroler.Kontroler.getInstanca().vratiSvaVozila();
            model = new ModelTabeleVozilo();
            for (Vozilo s : lista) {
                model.ubaci(s);

            }
            tblVozilo.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(PnlPretragaVozila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVratiSveActionPerformed

    private void btnPrikaziDetaljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziDetaljeActionPerformed
        pripremiDialog(ModForme.pregled);
    }//GEN-LAST:event_btnPrikaziDetaljeActionPerformed

    private void btnIzaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiActionPerformed
        int index = tblVozilo.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red u tabeli");
            return;
        }
        Vozilo v = model.getLista().get(index);
        sesija.Sesija.getInstanca().getMapa().put("trenutnoVozilo", v);
        System.out.println(v);
        (((FrmForma) SwingUtilities.getWindowAncestor((FrmForma) SwingUtilities.getWindowAncestor(this)))).getPanel().popuniPodatke();
        ((FrmForma) SwingUtilities.getWindowAncestor(this)).dispose();
    }//GEN-LAST:event_btnIzaberiActionPerformed

    private void btnPronadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPronadjiActionPerformed
        String naziv = txtNazivMarke.getText();
        Vozilo v = new Vozilo();
        if (!naziv.isEmpty()) {
            v.setMarka(naziv);
        }
        List<Vozilo> lista;

        try {
            lista = kontroler.Kontroler.getInstanca().vratiVozila(v);
            model = new ModelTabeleVozilo();
            for (Vozilo vo : lista) {
                System.out.println(vo);
                model.ubaci(vo);
            }
            tblVozilo.setModel(model); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            vratiSve();
            Logger.getLogger(PnlPretragaVozila.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnPronadjiActionPerformed

    private void btnKreirajNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajNovoActionPerformed
        pripremiDialog(ModForme.unos); 
    }//GEN-LAST:event_btnKreirajNovoActionPerformed

    private void pripremiFormu() {

        ModelTabeleVozilo model = new ModelTabeleVozilo();
        tblVozilo.setModel(model);

    }

    private void pripremiDialog(ModForme modForme) {
        if (modForme != ModForme.unos) {
            int index = tblVozilo.getSelectedRow();

            if (index == -1) {

                JOptionPane.showMessageDialog(this, "Morate izabrati red!");
                return;
            }
            Vozilo v = model.getLista().get(index);
            sesija.Sesija.getInstanca().getMapa().put("trenutnoVozilo", v);
        }

        PnlUnosVozila panel = new PnlUnosVozila(modForme);
        FrmDialog dialog = new FrmDialog((Frame) SwingUtilities.getWindowAncestor(this), true, panel);
        dialog.setVisible(true);
    }

    @Override
    public void popuniPodatke() {
        model = (ModelTabeleVozilo) tblVozilo.getModel();
        if (sesija.Sesija.getInstanca().getMapa().get("trenutnoVozilo") != null) {
            model.ubaci((Vozilo) sesija.Sesija.getInstanca().getMapa().get("trenutnoVozilo"));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzaberi;
    private javax.swing.JButton btnKreirajNovo;
    private javax.swing.JButton btnPrikaziDetalje;
    private javax.swing.JButton btnPronadji;
    private javax.swing.JButton btnVratiSve;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNazivMarke;
    private javax.swing.JTable tblVozilo;
    private javax.swing.JTextField txtNazivMarke;
    // End of variables declaration//GEN-END:variables

    void izaberi() {
        btnIzaberi.setVisible(true);
    }

    private void vratiSve() {
         try {
            List<Vozilo> lista = kontroler.Kontroler.getInstanca().vratiSvaVozila();
            model = new ModelTabeleVozilo();
            for (Vozilo s : lista) {
                model.ubaci(s);

            }
            tblVozilo.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(PnlPretragaVozila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
