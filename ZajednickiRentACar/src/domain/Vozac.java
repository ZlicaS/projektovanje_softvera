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
import java.util.List;

/**
 *
 * @author lizasapsaj
 */
public class Vozac implements Serializable, OpstaDomenskaKlasa {

    private Long idVozac;
    private String imePrezimeVozac;
    private int daLiJeSlobodan;
    private String jmbg;
    private Zaposleni zaposleni;

    public Vozac() {
    }

    public Vozac(Long idVozac, String imePrezimeVozac, int daLiJeSlobodan, String jmbg, Zaposleni zaposleni) {
        this.idVozac = idVozac;
        this.imePrezimeVozac = imePrezimeVozac;
        this.daLiJeSlobodan = daLiJeSlobodan;
        this.jmbg = jmbg;
        this.zaposleni = zaposleni;
    }

    public Long getIdVozac() {
        return idVozac;
    }

    public String getImePrezimeVozac() {
        return imePrezimeVozac;
    }

    public String getJmbg() {
        return jmbg;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setIdVozac(Long idVozac) {
        this.idVozac = idVozac;
    }

    public void setImePrezimeVozac(String imePrezimeVozac) {
        this.imePrezimeVozac = imePrezimeVozac;
    }

    public int getDaLiJeSlobodan() {
        return daLiJeSlobodan;
    }

    public void setDaLiJeSlobodan(int daLiJeSlobodan) {
        this.daLiJeSlobodan = daLiJeSlobodan;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    @Override
    public String vratiImeKlase() {
        return "Vozac";
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        if (!rs.next()) {
            throw new Exception("Nema vozaca koji odgovaraju unetim kriterijumima");
        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                long idVozac = rs.getLong("idVozac");
                String imePrezime = rs.getString("imePrezimeVozac");
                String jmbg = rs.getString("jmbg");
                int slobodan = rs.getInt("daLiJeSlobodan");
                Zaposleni z = new Zaposleni();

                Vozac v = new Vozac(idVozac, imePrezime, slobodan, jmbg, z);

                lista.add(v);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNaziveKolona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostAtributaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSpajanje() {
        return "";
    }

    @Override
    public String vratiSortiranje() {
        return "order by imePrezimeVozac";
    }

}
