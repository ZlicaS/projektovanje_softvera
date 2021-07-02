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
public class Rezervacija implements Serializable, OpstaDomenskaKlasa {

    private Long idRezervacija;
    private String naziv;
    private Date datumRezervacije;
    private Date datumOd;
    private Date datumDo;
    private double cenaRezervacije;
    private Vozilo vozilo;
    private Klijent klijent;

    public Rezervacija() {
    }

    public Rezervacija(Long idRezervacija, String naziv, Date datumRezervacije, Date datumOd, Date datumDo, double cenaRezervacije, Vozilo vozilo, Klijent klijent) {
        this.idRezervacija = idRezervacija;
        this.naziv = naziv;
        this.datumRezervacije = datumRezervacije;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.cenaRezervacije = cenaRezervacije;
        this.vozilo = vozilo;
        this.klijent = klijent;
    }

    public Long getIdRezervacija() {
        return idRezervacija;
    }

    public String getNaziv() {
        return naziv;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public double getCenaRezervacije() {
        return cenaRezervacije;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setIdRezervacija(Long idRezervacija) {
        this.idRezervacija = idRezervacija;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public void setCenaRezervacije(double cenaRezervacije) {
        this.cenaRezervacije = cenaRezervacije;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Rezervacija other = (Rezervacija) obj;
        if (this.idRezervacija != other.idRezervacija) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "idRezervacija=" + idRezervacija + ", naziv=" + naziv + ", datumRezervacije=" + datumRezervacije + ", datumOd=" + datumOd
                + ", datumDo=" + datumDo + ", cenaRezervacije=" + cenaRezervacije + ",vozilo=" + vozilo + ",klijent=" + klijent + '}';
    }

    @Override
    public String vratiImeKlase() {
        return "Rezervacija";
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJednog() {
        return "idRezervacija= " + idRezervacija;
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        if (!rs.next()) {
            throw new Exception("Nema rezervacije koji odgovaraju unetim kriterijumima");
        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                Long id = rs.getLong("r.idRezervacija");
                String naziv = rs.getString("r.nazivRezervacije");
                Date datum = rs.getDate("r.datumRezervacije");
                Date datumOd = rs.getDate("r.datumOd");
                Date datumDo = rs.getDate("r.datumDo");
                Double cena = rs.getDouble("r.cenaRezervacije");

                long idv = rs.getLong("v.idVozilo");
                double kilometraza = rs.getDouble("v.kilometraza");
                String tipVozila = rs.getString("v.tipVozila");

                int brojPutnika = rs.getInt("v.brojPutnika");
                double cenav = rs.getDouble("v.cenaPoDanu");
                String marka = rs.getString("v.marka");

                long idZaposleni = rs.getLong("z.idZaposleni");
                String imePrezimeZaposleni = rs.getString("z.imePrezimeZaposleni");
                Date datumRodjenjaz = rs.getDate("z.datumRodjenja");
                String username = rs.getString("z.username");
                String password = rs.getString("z.password");
                String jmbg = rs.getString("z.jmbg");

                Zaposleni z = new Zaposleni(idZaposleni, imePrezimeZaposleni, datumRodjenjaz, username, password, jmbg);
                Vozilo v = new Vozilo(idv, kilometraza, tipVozila, brojPutnika, cenav, z, marka);

                long idKlijent = rs.getLong("k.idKlijent");
                String imePrezimeKlijent = rs.getString("k.imePrezimeKlijent");
                Date datumRodjenja = rs.getDate("k.datumRodjenja");
                String brojTelefona = rs.getString("k.brojTelefona");
                String vozackaDozvola = rs.getString("k.vozackaDozvola");

                Klijent k = new Klijent(idKlijent, imePrezimeKlijent, datumRodjenja, brojTelefona, vozackaDozvola, z);

                Rezervacija r = new Rezervacija(id, naziv, datum, datumOd, datumDo, cena, v, k);
                lista.add(r); 
            }
        } catch (SQLException ex) {

            Logger.getLogger(Rezervacija.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
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
        return "'" + naziv + "','" + datumRezervacije + "','" + datumOd + "','" + datumDo  + "'," + cenaRezervacije+"," + vozilo.getIdVozilo()+"," + klijent.getIdKlijent();
    
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNaziveKolona() {
        return "nazivRezervacije,datumRezervacije,datumOd,datumDo,cenaRezervacije,voziloId,klijentId";
    }

    @Override
    public String postaviVrednostAtributaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSortiranje() {
        return " order by r.nazivRezervacije";
    }

    @Override
    public String vratiSpajanje() {
        return " r inner join vozilo v on r.voziloId=v.idVozilo  inner join zaposleni z on z.idZaposleni=v.zaposleniId"
                + " inner join klijent k on r.klijentId=k.idKlijent";

    }

    @Override
    public String vratiUslovZaVise() {
        String rez = " where";
        if (klijent != null) {
            rez += " r.klijentId=" + klijent.getIdKlijent() + " and";
        }
        if (vozilo != null) {
            rez += " r.voziloId=" + vozilo.getIdVozilo() + " and";
        }

        if (rez.equals(" where")) {
            return "";
        }
        return rez.substring(0, rez.length() - 4);
    }

}
