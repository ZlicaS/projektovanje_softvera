/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.panel;

import domain.Klijent;
import domain.OpstaDomenskaKlasa;
import domain.Unajmljivanje;
import domain.Vozac;
import forma.FrmForma;
import forma.GlavnaForma;
import forma.IPanel;
import forma.ModForme;
import forma.model.ModelTabeleVozac;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import kontroler.Kontroler;

/**
 *
 * @author Sapsaj
 */
public class PnlUnajmljivanje extends javax.swing.JPanel implements IPanel {

    ModForme model;
    Klijent k;
    Vozac v;
    ModelTabeleVozac m;

    /**
     * Creates new form PnlUnajmljivanje
     */
    public PnlUnajmljivanje(ModForme modelForme) {
        model = modelForme;
        m = new ModelTabeleVozac();
        initComponents();
        pripremiFormu();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lblDatum = new javax.swing.JLabel();
        lblKlijent = new javax.swing.JLabel();
        btnIzborKlijijenta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblImePrezime = new javax.swing.JLabel();
        lblDatumRodjenja = new javax.swing.JLabel();
        lblBrojTelefona = new javax.swing.JLabel();
        dpDatum = new datechooser.beans.DateChooserCombo();
        lblNacinPlacanja = new javax.swing.JLabel();
        cbNacinPlacanja = new javax.swing.JComboBox<>();
        lblCena = new javax.swing.JLabel();
        txtCenaUnajmljivanja = new javax.swing.JTextField();
        btnVratiSveVozace = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVozaci = new javax.swing.JTable();
        btnIzaberi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        lblDatum.setText("Datum unajmljivanja:");

        lblKlijent.setText("Klijent:");

        btnIzborKlijijenta.setText("Izbor klijenta");
        btnIzborKlijijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzborKlijijentaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci o klijentu"));

        lblImePrezime.setText("Ime i prezime:");

        lblDatumRodjenja.setText("Datum rodjenja:");

        lblBrojTelefona.setText("Broj telefona:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImePrezime)
                    .addComponent(lblDatumRodjenja)
                    .addComponent(lblBrojTelefona))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImePrezime)
                .addGap(18, 18, 18)
                .addComponent(lblDatumRodjenja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(lblBrojTelefona)
                .addContainerGap())
        );

        dpDatum.setLocale(new java.util.Locale("sr", "BA", ""));

        lblNacinPlacanja.setText("Nacin placanja:");

        lblCena.setText("Cena unajmljivanja:");

        btnVratiSveVozace.setText("Prikazi slobodne vozace");
        btnVratiSveVozace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiSveVozaceActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Slobodni vozaci"));

        tblVozaci.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVozaci);

        btnIzaberi.setText("Izaberi");
        btnIzaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnIzaberi)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnIzaberi)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblKlijent)
                                .addGap(28, 28, 28)
                                .addComponent(btnIzborKlijijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCena)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCenaUnajmljivanja))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDatum)
                                        .addComponent(lblNacinPlacanja))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dpDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbNacinPlacanja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btnVratiSveVozace, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(btnSacuvaj)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblKlijent)
                        .addComponent(btnIzborKlijijenta))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDatum)
                    .addComponent(dpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNacinPlacanja)
                    .addComponent(cbNacinPlacanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCena)
                    .addComponent(txtCenaUnajmljivanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnVratiSveVozace)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj)
                .addGap(211, 211, 211))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzborKlijijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzborKlijijentaActionPerformed
        PnlPretragaKlijenta panel = new PnlPretragaKlijenta();
        panel.izaberi();
        FrmForma forma = new FrmForma(panel);
        forma.setParent((Frame) SwingUtilities.getWindowAncestor(this));
        forma.setVisible(true);

    }//GEN-LAST:event_btnIzborKlijijentaActionPerformed

    private void btnIzaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiActionPerformed
        int index = tblVozaci.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red u tabeli");
            return;
        }

        v = m.getLista().get(index);
        sesija.Sesija.getInstanca().getMapa().put("trenutniVozac", v);
        JOptionPane.showMessageDialog(this, "Izabran je vozac");
        /*(((FrmForma) SwingUtilities.getWindowAncestor((FrmForma) SwingUtilities.getWindowAncestor(this)))).getPanel().popuniPodatke();
        ((FrmForma) SwingUtilities.getWindowAncestor(this)).dispose();*/
    }//GEN-LAST:event_btnIzaberiActionPerformed

    private void btnVratiSveVozaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiSveVozaceActionPerformed
        try {
            m = new ModelTabeleVozac();
            List<Vozac> lista = kontroler.Kontroler.getInstanca().vratiSveVozace();

            for (Vozac v : lista) {
                m.ubaci(v);
            }
            tblVozaci.setModel(m);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
    }//GEN-LAST:event_btnVratiSveVozaceActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        Date datum = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        datum = java.sql.Date.valueOf(format.format(dpDatum.getSelectedDate().getTime()));
        String nacinPlacanja = (String) cbNacinPlacanja.getSelectedItem();
        
        // v = (Vozac) sesija.Sesija.getInstanca().getMapa().get("trenutniVozac");
        Klijent k = (Klijent) sesija.Sesija.getInstanca().getMapa().get("trenutniKlijent");

        
        boolean va = validacija(k, nacinPlacanja, txtCenaUnajmljivanja.getText(), v);
       
        if (va) {
            double cena = Double.parseDouble(txtCenaUnajmljivanja.getText());
            Unajmljivanje unajmljivanje = new Unajmljivanje(datum, nacinPlacanja, cena, k, v);
             System.out.println(unajmljivanje);
            try {

                String poruka = Kontroler.getInstanca().unesiUnajmljivanje(unajmljivanje);
                JOptionPane.showMessageDialog(this, poruka);
                ((FrmForma) SwingUtilities.getWindowAncestor(this)).dispose();
                if (((SwingUtilities.getWindowAncestor((FrmForma) SwingUtilities.getWindowAncestor(this)))) instanceof GlavnaForma) {
                    return;
                }

                sesija.Sesija.getInstanca().setUnajmljivanje2(unajmljivanje);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Neuspesno cuvanje");
                //Logger.getLogger(PnlStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzaberi;
    private javax.swing.JButton btnIzborKlijijenta;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnVratiSveVozace;
    private javax.swing.JComboBox<String> cbNacinPlacanja;
    private datechooser.beans.DateChooserCombo dpDatum;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBrojTelefona;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblDatumRodjenja;
    private javax.swing.JLabel lblImePrezime;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JLabel lblNacinPlacanja;
    private javax.swing.JTable tblVozaci;
    private javax.swing.JTextField txtCenaUnajmljivanja;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() {
        dpDatum.setEnabled(false);
        cbNacinPlacanja.removeAllItems();
        tblVozaci.setModel(m);
        try {
            String[] nacinPlacanja = {"kes", "kartica", "cek"};

            for (String np : nacinPlacanja) {
                cbNacinPlacanja.addItem(np);

            }

        } catch (Exception ex) {
            Logger.getLogger(PnlUnajmljivanje.class.getName()).log(Level.SEVERE, null, ex);

        }
        if (model == ModForme.pregled) {
            popuniPolja(sesija.Sesija.getInstanca().getMapa().get("trenutnoUnajmljivanje"));

        }
        
        
    }

    @Override
    public void popuniPodatke() {
        k = (Klijent) sesija.Sesija.getInstanca().getMapa().get("trenutniKlijent");
        if (k != null) {
            lblImePrezime.setText("Ime i prezime: " + k.getImePrezimeKlijent());
            lblDatumRodjenja.setText("Datum rodjenja: " + k.getDatumRodjenja());
            lblBrojTelefona.setText("Broj telefona: " + k.getBrojTelefona());
        }
    }

    @Override
    public void popuniPolja(OpstaDomenskaKlasa odk) {
        lblKlijent.setVisible(false);
        Unajmljivanje u = (Unajmljivanje) odk;
        System.out.println(u);
        btnSacuvaj.setVisible(false);
        btnIzborKlijijenta.setVisible(false);
        txtCenaUnajmljivanja.setEditable(false);

        txtCenaUnajmljivanja.setText(u.getCenaUnajmljivanja() + "");
        cbNacinPlacanja.setSelectedItem(u.getNacinPlacanja());

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(u.getDatumUnajmljivanja());
        dpDatum.setSelectedDate(gc);

        Klijent k = u.getKlijent();

        lblImePrezime.setText("Ime i prezime: " + k.getImePrezimeKlijent());
        lblDatumRodjenja.setText("Datum rodjenja: " + k.getDatumRodjenja());
        lblBrojTelefona.setText("Broj telefona: " + k.getBrojTelefona());

        Vozac v = (Vozac) sesija.Sesija.getInstanca().getMapa().get("trenutniVozac");
    }

    private boolean validacija(Klijent k, String nacinPlacanja, String cena, Vozac v) {
        if (k == null || nacinPlacanja.isEmpty() || v == null || cena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti sve podatke!");
            return false;
        }
        return true;
    }

}
