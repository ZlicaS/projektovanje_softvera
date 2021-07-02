/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domain.OpstaDomenskaKlasa;
import domain.Rezervacija;
import domain.Unajmljivanje;
import domain.Zaposleni;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sapsaj
 */
public class Sesija {

    private static Sesija instanca;
    private Zaposleni zaposleni;
    private final Map<String, OpstaDomenskaKlasa> mapa;
    private List<Rezervacija> rezervacije;
    private List<Unajmljivanje> unajmljivanje;
    private Unajmljivanje u;

    public List<Unajmljivanje> getUnajmljivanje() {
        return unajmljivanje;
    }

    public void setUnajmljivanje(List<Unajmljivanje> unajmljivanje) {
        this.unajmljivanje = unajmljivanje;
    }

    public static Sesija getInstanca() {
        if (instanca == null) {
            instanca = new Sesija();
        }
        return instanca;
    }

    public Sesija() {
        mapa = new HashMap<>();
        rezervacije = new LinkedList<>();
        unajmljivanje = new LinkedList<>();
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public Map<String, OpstaDomenskaKlasa> getMapa() {
        return mapa;
    }

    public void setUnajmljivanje2(Unajmljivanje unajmljivanje) {
        this.u = unajmljivanje;
    }

}
