/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lizasapsaj
 */
public class Vozilo implements Serializable, OpstaDomenskaKlasa {

    private Long idVozilo;
    private Double kilometraza;
    private String tipVozila;
    private int brojPutnika;
    private Double cenaPoDanu;
    private Zaposleni zaposleniId;
    private String marka;

    public Vozilo() {
    }

    public Vozilo(Long idVozilo, Double kilometraza, String tipVozila, int brojPutnika, Double cenaPoDanu, Zaposleni zaposleniId, String marka) {
        this.idVozilo = idVozilo;
        this.kilometraza = kilometraza;
        this.tipVozila = tipVozila;
        this.brojPutnika = brojPutnika;
        this.cenaPoDanu = cenaPoDanu;
        this.zaposleniId = zaposleniId;
        this.marka = marka;
    }

    public Long getIdVozilo() {
        return idVozilo;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Double getKilometraza() {
        return kilometraza;
    }

    public String getTipVozila() {
        return tipVozila;
    }

    public int getBrojPutnika() {
        return brojPutnika;
    }

    public Double getCenaPoDanu() {
        return cenaPoDanu;
    }

    public Zaposleni getZaposleniId() {
        return zaposleniId;
    }

    public void setIdVozilo(Long idVozilo) {
        this.idVozilo = idVozilo;
    }

    public void setKilometraza(Double kilometraza) {
        this.kilometraza = kilometraza;
    }

    public void setTipVozila(String tipVozila) {
        this.tipVozila = tipVozila;
    }

    public void setBrojPutnika(int brojPutnika) {
        this.brojPutnika = brojPutnika;
    }

    public void setCenaPoDanu(Double cenaPoDanu) {
        this.cenaPoDanu = cenaPoDanu;
    }

    public void setZaposleniId(Zaposleni zaposleniId) {
        this.zaposleniId = zaposleniId;
    }

    @Override
    public String toString() {
        return "Vozilo{" + "idVozilo=" + idVozilo + ",kilometraza" + kilometraza + ", tipVozila" + tipVozila
                + ",brojPutnika" + brojPutnika + ",cenaPoDanu:" + cenaPoDanu + ",zaposleni" + zaposleniId + ",marka" + marka;
    }

    @Override
    public String vratiImeKlase() {
        return "Vozilo";
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        return null;
    }

    @Override
    public String vratiUslovZaJednog() {
        return "idVozilo= " + idVozilo;
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        if (!rs.next()) {
            throw new Exception("Nema vozila koja odgovaraju unetim kriterijumima");
        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {

                long id = rs.getLong("v.idVozilo");
                double kilometraza = rs.getDouble("v.kilometraza");
                String tipVozila = rs.getString("v.tipVozila");

                int brojPutnika = rs.getInt("v.brojPutnika");
                double cena = rs.getDouble("v.cenaPoDanu");
                String marka = rs.getString("v.marka");

                long idZaposleni = rs.getLong("z.idZaposleni");
                String imePrezimeZaposleni = rs.getString("z.imePrezimeZaposleni");
                Date datumRodjenjaz = rs.getDate("z.datumRodjenja");
                String username = rs.getString("z.username");
                String password = rs.getString("z.password");
                String jmbg = rs.getString("z.jmbg");

                Zaposleni z = new Zaposleni(idZaposleni, imePrezimeZaposleni, datumRodjenjaz, username, password, jmbg);

                Vozilo v = new Vozilo(id, kilometraza, tipVozila, brojPutnika, cena, z, marka);
                lista.add(v);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Vozilo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return idVozilo + ", " + (kilometraza == null ? null : "'" + kilometraza + "'")
                + ", " + (tipVozila == null ? null : "'" + tipVozila + "'") + ", "
                + (brojPutnika == 0 ? null : "'" + brojPutnika + "'") + ", "
                + (cenaPoDanu == null ? null : "'" + cenaPoDanu) + ", " + zaposleniId.getIdZaposleni()
                + ", " + (marka == null ? null : "'" + marka + "'");
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "'" + kilometraza + "','" + tipVozila + "','" + brojPutnika + "','" + cenaPoDanu + "'," + zaposleniId.getIdZaposleni() + ",'" + marka + "'";
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNaziveKolona() {
        return "kilometraza,tipVozila,brojPutnika,cenaPoDanu,zaposleniId,marka";
    }

    @Override
    public String postaviVrednostAtributaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMarka() {
        return marka;
    }

    @Override
    public String vratiSpajanje() {
        return "v inner join zaposleni z on v.zaposleniId=z.idZaposleni";
    }

    @Override
    public String vratiSortiranje() {
        return OpstaDomenskaKlasa.super.vratiSortiranje(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {

        return " WHERE marka LIKE '%" + marka + "%'";

    }

}
