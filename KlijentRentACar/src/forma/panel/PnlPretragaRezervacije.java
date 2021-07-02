/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.panel;

import domain.Klijent;
import domain.OpstaDomenskaKlasa;
import domain.Rezervacija;
import domain.Vozilo;
import forma.FrmDialog;
import forma.FrmForma;
import forma.IPanel;
import forma.ModForme;
import forma.model.ModelTabeleRezervacija;
import java.awt.Frame;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sapsaj
 */
public class PnlPretragaRezervacije extends javax.swing.JPanel implements IPanel {

    ModelTabeleRezervacija model;
    Vozilo v;
    Klijent k;

    /**
     * Creates new form PnlPretragaRezervacije
     */
    public PnlPretragaRezervacije() {
        initComponents();
        pripremiFormu();
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

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblMarka = new javax.swing.JLabel();
        lblKilometraza = new javax.swing.JLabel();
        lblTipVozila = new javax.swing.JLabel();
        lblBrojPutnila = new javax.swing.JLabel();
        lblCenaPoDanu = new javax.swing.JLabel();
        btnIzborVozila = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblImeIPrezime = new javax.swing.JLabel();
        lblDatumRodjenja = new javax.swing.JLabel();
        lblBrojTelefona = new javax.swing.JLabel();
        btnIzborKlijenta = new javax.swing.JButton();
        jPnl2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRezervacija = new javax.swing.JTable();
        btnPrikaziDetalje = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();
        btnVratiSve = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci o vozilu"));

        lblMarka.setText("Marka vozila:");

        lblKilometraza.setText("Kilometraza:");

        lblTipVozila.setText("Tip vozila:");

        lblBrojPutnila.setText("Broj putnika:");

        lblCenaPoDanu.setText("Cena po danu:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarka)
                    .addComponent(lblKilometraza)
                    .addComponent(lblTipVozila)
                    .addComponent(lblBrojPutnila)
                    .addComponent(lblCenaPoDanu))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblMarka)
                .addGap(18, 18, 18)
                .addComponent(lblKilometraza)
                .addGap(18, 18, 18)
                .addComponent(lblTipVozila)
                .addGap(18, 18, 18)
                .addComponent(lblBrojPutnila)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lblCenaPoDanu)
                .addGap(22, 22, 22))
        );

        btnIzborVozila.setText("Izaberi vozilo");
        btnIzborVozila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzborVozilaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci o klijentu"));

        lblImeIPrezime.setText("Ime i prezime:");

        lblDatumRodjenja.setText("Datum rodjenja:");

        lblBrojTelefona.setText("Broj telefona:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBrojTelefona)
                    .addComponent(lblDatumRodjenja)
                    .addComponent(lblImeIPrezime))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblImeIPrezime)
                .addGap(27, 27, 27)
                .addComponent(lblDatumRodjenja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lblBrojTelefona)
                .addContainerGap())
        );

        btnIzborKlijenta.setText("Izaberi klijenta");
        btnIzborKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzborKlijentaActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Rezervacija"));

        tblRezervacija.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRezervacija);

        btnPrikaziDetalje.setText("Prikazi detalje");
        btnPrikaziDetalje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziDetaljeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnPrikaziDetalje)
                .addGap(44, 44, 44))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnPrikaziDetalje)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPnl2Layout = new javax.swing.GroupLayout(jPnl2);
        jPnl2.setLayout(jPnl2Layout);
        jPnl2Layout.setHorizontalGroup(
            jPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnl2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPnl2Layout.setVerticalGroup(
            jPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnl2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
        );

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnVratiSve.setText("Vrati sve");
        btnVratiSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiSveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnIzborVozila, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzborKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171)))
                .addGap(23, 23, 23))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnVratiSve, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIzborVozila)
                            .addComponent(btnIzborKlijenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnVratiSve))
                .addGap(38, 38, 38)
                .addComponent(jPnl2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 864, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzborVozilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzborVozilaActionPerformed
        PnlPretragaVozila panel = new PnlPretragaVozila();
        panel.izaberi();
        FrmForma forma = new FrmForma(panel);
        forma.setParent((Frame) SwingUtilities.getWindowAncestor(this));
        forma.setVisible(true);
    }//GEN-LAST:event_btnIzborVozilaActionPerformed

    private void btnIzborKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzborKlijentaActionPerformed
        PnlPretragaKlijenta panel = new PnlPretragaKlijenta();
        panel.izaberi();
        FrmForma forma = new FrmForma(panel);
        forma.setParent((Frame) SwingUtilities.getWindowAncestor(this));
        forma.setVisible(true);
    }//GEN-LAST:event_btnIzborKlijentaActionPerformed

    private void btnPrikaziDetaljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziDetaljeActionPerformed
        pripremiDialog(ModForme.pregled);
    }//GEN-LAST:event_btnPrikaziDetaljeActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        Rezervacija a = new Rezervacija();
        a.setKlijent(k);
        a.setVozilo(v);

        List<Rezervacija> lista;
        model = new ModelTabeleRezervacija();
        try {

            lista = kontroler.Kontroler.getInstanca().vratiOdredjeneRezervacije(a);

            for (Rezervacija s : lista) {

                model.ubaci(s);
            }
            tblRezervacija.setModel(model);
            //  ponisti();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            vratiSve();
            ex.printStackTrace();
//            Logger.getLogger(PnlPretragaStudenata.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnVratiSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiSveActionPerformed
        try {
            List<Rezervacija> lista = kontroler.Kontroler.getInstanca().vratiRezervacije();
            model = new ModelTabeleRezervacija();
            for (Rezervacija s : lista) {
                model.ubaci(s);

            }
            tblRezervacija.setModel(model);
            ponisti();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(PnlPretragaStudenata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVratiSveActionPerformed

    private void pripremiFormu() {
        model = new ModelTabeleRezervacija();
        tblRezervacija.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzborKlijenta;
    private javax.swing.JButton btnIzborVozila;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPrikaziDetalje;
    private javax.swing.JButton btnVratiSve;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPnl2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrojPutnila;
    private javax.swing.JLabel lblBrojTelefona;
    private javax.swing.JLabel lblCenaPoDanu;
    private javax.swing.JLabel lblDatumRodjenja;
    private javax.swing.JLabel lblImeIPrezime;
    private javax.swing.JLabel lblKilometraza;
    private javax.swing.JLabel lblMarka;
    private javax.swing.JLabel lblTipVozila;
    private javax.swing.JTable tblRezervacija;
    // End of variables declaration//GEN-END:variables

    private void pripremiDialog(ModForme modForme) {
        if (modForme != ModForme.unos) {
            int index = tblRezervacija.getSelectedRow();

            if (index == -1) {

                JOptionPane.showMessageDialog(this, "Morate izabrati red!");
                return;
            }
            Rezervacija rm = model.getLista().get(index);

            sesija.Sesija.getInstanca().getMapa().put("trenutnaRezervacija", rm);
            PnlRezervacija panel = new PnlRezervacija(modForme);
            FrmDialog dialog = new FrmDialog((Frame) SwingUtilities.getWindowAncestor(this), true, panel);
            dialog.setVisible(true);
        }

    }

    @Override
    public void popuniPodatke() {
        k = (Klijent) sesija.Sesija.getInstanca().getMapa().get("trenutniKlijent");
        if (k != null) {

            lblImeIPrezime.setText("Ime i prezime: " + k.getImePrezimeKlijent());
            lblDatumRodjenja.setText("Datum rodjenja: " + k.getDatumRodjenja());
            lblBrojTelefona.setText("Broj telefona: " + k.getBrojTelefona());
        }
        v = (Vozilo) sesija.Sesija.getInstanca().getMapa().get("trenutnoVozilo");
        if (v != null) {
            lblMarka.setText("Marka vozila: " + v.getMarka());

            lblKilometraza.setText("Kilometraza: " + v.getKilometraza());
            lblTipVozila.setText("Tip vozila: " + v.getTipVozila());
            lblBrojPutnila.setText("Broj putnika: " + v.getBrojPutnika());
            lblCenaPoDanu.setText("Cena po danu: " + v.getCenaPoDanu());

        }
    }

    @Override
    public void popuniPolja(OpstaDomenskaKlasa odk) {
        Rezervacija r = (Rezervacija) odk;
        if (r != null) {
            Klijent k = r.getKlijent();
            lblImeIPrezime.setText("Ime i prezime: " + k.getImePrezimeKlijent());
            lblDatumRodjenja.setText("Datum rodjenja: " + k.getDatumRodjenja());
            lblBrojTelefona.setText("Broj telefona: " + k.getBrojTelefona());

            Vozilo v = r.getVozilo();
            lblMarka.setText("Marka vozila: " + v.getMarka());
            lblKilometraza.setText("Kilometraza: " + v.getKilometraza());
            lblTipVozila.setText("Tip vozila: " + v.getTipVozila());
            lblBrojPutnila.setText("Broj putnika: " + v.getBrojPutnika());
            lblCenaPoDanu.setText("Cena po danu: " + v.getCenaPoDanu());

        }
    }

    private void ponisti() {
        lblMarka.setText("Marka vozila: ");
        lblKilometraza.setText("Kilometraza: ");
        lblTipVozila.setText("Tip vozila: ");
        lblBrojPutnila.setText("Broj putnika: ");
        lblCenaPoDanu.setText("Cena po danu: ");
        lblImeIPrezime.setText("Ime i prezime: ");
        lblDatumRodjenja.setText("Datum rodjenja: ");
        lblBrojTelefona.setText("Broj telefona: ");

        k = null;
        v = null;
    }

    private void vratiSve() {
         try {
            List<Rezervacija> lista = kontroler.Kontroler.getInstanca().vratiRezervacije();
            model = new ModelTabeleRezervacija();
            for (Rezervacija s : lista) {
                model.ubaci(s);

            }
            tblRezervacija.setModel(model);
            ponisti();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(PnlPretragaStudenata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
