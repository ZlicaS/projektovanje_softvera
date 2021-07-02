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
public class Unajmljivanje implements Serializable,OpstaDomenskaKlasa {

    private Long idUnajmljivanje;
    private Date datumUnajmljivanja;
    private String nacinPlacanja;
    private double cenaUnajmljivanja;
    private Klijent klijent;
    private Vozac vozac;

    public Unajmljivanje() {
    }

    public Unajmljivanje(Date datumUnajmljivanja, String nacinPlacanja, double cenaUnajmljivanja, Klijent klijent, Vozac vozac) {
        
        this.datumUnajmljivanja = datumUnajmljivanja;
        this.nacinPlacanja = nacinPlacanja;
        this.cenaUnajmljivanja = cenaUnajmljivanja;
        this.klijent = klijent;
        this.vozac = vozac;
    }
    
    

    public Long getIdUnajmljivanje() {
        return idUnajmljivanje;
    }

    public Date getDatumUnajmljivanja() {
        return datumUnajmljivanja;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public double getCenaUnajmljivanja() {
        return cenaUnajmljivanja;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setIdUnajmljivanje(Long idUnajmljivanje) {
        this.idUnajmljivanje = idUnajmljivanje;
    }

    public void setDatumUnajmljivanja(Date datumUnajmljivanja) {
        this.datumUnajmljivanja = datumUnajmljivanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public void setCenaUnajmljivanja(double cenaUnajmljivanja) {
        this.cenaUnajmljivanja = cenaUnajmljivanja;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    @Override
    public String vratiImeKlase() {
        return "Unajmljivanje";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "'" + datumUnajmljivanja + "','" + nacinPlacanja + "','" + cenaUnajmljivanja + "'," + klijent.getIdKlijent()  + "," + vozac.getIdVozac();
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNaziveKolona() {
        return "datumUnajmljivanja,nacinPlacanja,cenaUnajmljivanja,klijentId,vozacId";
    }

    @Override
    public String postaviVrednostAtributaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return datumUnajmljivanja+" "+nacinPlacanja+" "+cenaUnajmljivanja;
    }
    
    

}
