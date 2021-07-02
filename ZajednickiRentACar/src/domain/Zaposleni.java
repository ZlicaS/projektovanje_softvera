/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lizasapsaj
 */
public class Zaposleni implements Serializable, OpstaDomenskaKlasa {

    private Long idZaposleni;
    private String imePrezimeZaposleni;
    private Date datumRodjenja;
    private String username;
    private String password;
    private String jmbg;

    public Zaposleni() {
    }

    public Zaposleni(Long idZaposleni, String imePrezimeZaposleni, Date datumRodjenja, String username, String password, String jmbg) {
        this.idZaposleni = idZaposleni;
        this.imePrezimeZaposleni = imePrezimeZaposleni;
        this.datumRodjenja = datumRodjenja;
        this.username = username;
        this.password = password;
        this.jmbg = jmbg;
    }

    public Long getIdZaposleni() {
        return idZaposleni;
    }

    public String getImePrezimeZaposleni() {
        return imePrezimeZaposleni;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setIdZaposleni(Long idZaposleni) {
        this.idZaposleni = idZaposleni;
    }

    public void setImePrezimeZaposleni(String imePrezimeZaposleni) {
        this.imePrezimeZaposleni = imePrezimeZaposleni;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public String toString() {
        return imePrezimeZaposleni;
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
        final Zaposleni other = (Zaposleni) obj;
        return true;
    }

    @Override
    public String vratiImeKlase() {
        return "Zaposleni";
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {

        if (rs.next()) {
            Long idZaposleni1 = rs.getLong("idZaposleni");
            String imeIPrezime1 = rs.getString("imePrezimeZaposleni");
            Date datum1 = rs.getDate("datumRodjenja");
            String korisnickoIme1 = rs.getString("username");
            String lozinka1 = rs.getString("password");
            String jmbg1 = rs.getString("jmbg");
            System.out.println(idZaposleni1+" "+imeIPrezime1+""+datum1+""+korisnickoIme1+""+lozinka1+""+jmbg1);
            return new Zaposleni(idZaposleni1, imeIPrezime1, datum1, korisnickoIme1, lozinka1, jmbg1);

        }

        throw new Exception("Uneli ste pogresne podatke, nema zaposlenog sa ovim podacima");
    }

    @Override
    public String vratiUslovZaJednog() {
        return "username='" + username + "' AND password='" + password + "'";
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiAtributa() {
        return idZaposleni + ", " + (imePrezimeZaposleni == null ? null : "'" + imePrezimeZaposleni + "'") + ", " + (datumRodjenja == null ? null : "'" + datumRodjenja + "'") + ", " + (username == null ? null : "'" + username + "'") + ", " + (password == null ? null : "'" + password + "'") + ", " + (jmbg == null ? null : "'" + jmbg + "'");
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "idZaposleni=" + idZaposleni + ", " + "imeIPrezimeZaposleni='" + imePrezimeZaposleni + "'" + "datumRodjenja='" + datumRodjenja + "'" + "username=" + "'" + username + "', " + "password='" + password + "', " + "jmbg" + jmbg + "'";
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        String[] kolone = {"idZaposleni", "imePrezimeZaposleni", "datumRodjenja", "username", "password", "jmbg"};
        return kolone[kolona];
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String vratiNaziveKolona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostAtributaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
