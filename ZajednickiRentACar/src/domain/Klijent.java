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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lizasapsaj
 */
public class Klijent implements Serializable, OpstaDomenskaKlasa {

    private Long idKlijent;
    private String imePrezimeKlijent;
    private Date datumRodjenja;
    private String brojTelefona;
    private String vozackaDozvola;
    private Zaposleni zaposleniId;

    public Klijent() {
    }

    public Klijent(Long idKlijent, String imePrezimeKlijent, Date datumRodjenja, String brojTelefona, String vozackaDozvola, Zaposleni zaposleniId) {
        this.idKlijent = idKlijent;
        this.imePrezimeKlijent = imePrezimeKlijent;
        this.datumRodjenja = datumRodjenja;
        this.brojTelefona = brojTelefona;
        this.vozackaDozvola = vozackaDozvola;
        this.zaposleniId = zaposleniId;
    }

    public Klijent(String imePrezimeKlijent, Date datumRodjenja, String brojTelefona, String vozackaDozvola, Zaposleni zaposleniId) {
        this.imePrezimeKlijent = imePrezimeKlijent;
        this.datumRodjenja = datumRodjenja;
        this.brojTelefona = brojTelefona;
        this.vozackaDozvola = vozackaDozvola;
        this.zaposleniId = zaposleniId;
    }

    public Klijent(Long idKlijent, String imePrezimeKlijent, Date datumRodjenja, String brojTelefona, String vozackaDozvola) {
        this.idKlijent = idKlijent;
        this.imePrezimeKlijent = imePrezimeKlijent;
        this.datumRodjenja = datumRodjenja;
        this.brojTelefona = brojTelefona;
        this.vozackaDozvola = vozackaDozvola;

    }

    public Long getIdKlijent() {
        return idKlijent;
    }

    public String getImePrezimeKlijent() {
        return imePrezimeKlijent;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public String getVozackaDozvola() {
        return vozackaDozvola;
    }

    public Zaposleni getZaposleniId() {
        return zaposleniId;
    }

    public void setIdKlijent(Long idKlijent) {
        this.idKlijent = idKlijent;
    }

    public void setImePrezimeKlijent(String imePrezimeKlijent) {
        this.imePrezimeKlijent = imePrezimeKlijent;
    }

    public void setDatumRodjenja(Date datumRodjanja) {
        this.datumRodjenja = datumRodjanja;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public void setVozackaDozvola(String vozackaDozvola) {
        this.vozackaDozvola = vozackaDozvola;
    }

    public void setZaposleniId(Zaposleni zaposleniId) {
        this.zaposleniId = zaposleniId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Klijent other = (Klijent) obj;
        if (!Objects.equals(this.idKlijent, other.idKlijent)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Klijent:{ idKlijent:" + idKlijent + " imePrezimeKlijent " + imePrezimeKlijent + " datumRodjenja " + datumRodjenja
                + "brojTelefona " + brojTelefona + " vozackaDozvola " + vozackaDozvola;
    }

    @Override
    public String vratiImeKlase() {
        return "Klijent";
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        return null;
    }

    @Override
    public String vratiUslovZaJednog() {
        return "idKlijent= " + idKlijent;
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        if (!rs.next()) {
            throw new Exception("Nema klijenata koji odgovaraju unetim kriterijumima");
        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                long idKlijent = rs.getLong("k.idKlijent");
                String imePrezimeKlijent = rs.getString("k.imePrezimeKlijent");
                Date datumRodjenja = rs.getDate("k.datumRodjenja");
                String brojTelefona = rs.getString("k.brojTelefona");
                String vozackaDozvola = rs.getString("k.vozackaDozvola");

                long idZaposleni = rs.getLong("z.idZaposleni");
                String imePrezimeZaposleni = rs.getString("z.imePrezimeZaposleni");
                Date datumRodjenjaz = rs.getDate("z.datumRodjenja");
                String username = rs.getString("z.username");
                String password = rs.getString("z.password");
                String jmbg = rs.getString("z.jmbg");

                Zaposleni z = new Zaposleni(idZaposleni, imePrezimeZaposleni, datumRodjenjaz, username, password, jmbg);

                Klijent k = new Klijent(idKlijent, imePrezimeKlijent, datumRodjenja, brojTelefona, vozackaDozvola, z);
                lista.add(k);

            }
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;

    }

    @Override
    public String vratiVrednostiAtributa() {
        return idKlijent + ", " + (imePrezimeKlijent == null ? null : "'" + imePrezimeKlijent + "'")
                + ", " + (datumRodjenja == null ? null : "'" + datumRodjenja + "'") + ", "
                + (brojTelefona == null ? null : "'" + brojTelefona + "'") + ", "
                + (vozackaDozvola == null ? null : "'" + vozackaDozvola) + ", " + zaposleniId.getIdZaposleni();
    }

    @Override
    public String postaviVrednostiAtributa() {
        /* return /*"IdKlijent=" + idKlijent + "imePrezimeKlijent='" + imePrezimeKlijent + "',datumRodjenja='" + datumRodjenja
                + "',brojTelefona='" + brojTelefona + "',vozackaDozvola='" + vozackaDozvola + "'," + 1;*/
        return "'" + imePrezimeKlijent + "','" + datumRodjenja + "','" + brojTelefona + "','" + vozackaDozvola + "'," + zaposleniId.getIdZaposleni();
    }

    @Override
    public String postaviVrednostAtributaID() {
         return "imePrezimeKlijent='" + imePrezimeKlijent + "',datumRodjenja='" + datumRodjenja + "',brojTelefona='"
                + brojTelefona + "',vozackaDozvola='" + vozackaDozvola + "',zaposleniId=" + zaposleniId.getIdZaposleni();
    }

    
   

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {
        return " WHERE imePrezimeKlijent LIKE '%" + imePrezimeKlijent + "%'";
    }

    @Override
    public String vratiSpajanje() {
        return "k inner join zaposleni z on k.zaposleniId=z.idZaposleni";
    }

    @Override
    public String vratiNaziveKolona() {
        return "imePrezimeKlijent,datumRodjenja,brojTelefona,vozackaDozvola,zaposleniId";
    }
}
