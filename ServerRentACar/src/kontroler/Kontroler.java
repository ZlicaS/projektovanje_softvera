/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domain.Klijent;
import domain.OpstaDomenskaKlasa;
import domain.Rezervacija;
import domain.Unajmljivanje;
import domain.Vozac;
import domain.Vozilo;
import domain.Zaposleni;
import forma.GlavnaForma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaZahteva;
import so.OpstaSistemskaOperacija;
import so.klijent.SOIzmeniKlijenta;
import so.klijent.SOUnosKlijenta;
import so.klijent.SOVratiOdredjeneKlijente;
import so.klijent.SOVratiSveKlijente;
import so.rezervacija.SOUnosRezervacije;
import so.rezervacija.SOVratiOdredjeneRezervacije;
import so.rezervacija.SOVratiSveRezervacije;
import so.unajmljivanje.SOUnosUnajmljivanja;
import so.vozac.SOVratiSveVozace;
import so.vozilo.SOUnosVozila;
import so.vozilo.SOVratiOdredjenaVozila;
import so.vozilo.SOVratiSvaVozila;
import so.zaposleni.SOPrijavljivanjeZaposlenog;
import transfer.Odgovor;
import transfer.util.StatusOdgovora;

/**
 *
 * @author lizasapsaj
 */
public class Kontroler {

    private static Kontroler instanca;

    public static void setInstanca(Kontroler aInstanca) {
        instanca = aInstanca;
    }
    private List<ObradaZahteva> prijavljeniZaposleni;
    private GlavnaForma forma;

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Kontroler() {
        prijavljeniZaposleni = new ArrayList<>();
    }

    public List<ObradaZahteva> getPrijavljeniZaposleni() {
        return prijavljeniZaposleni;
    }

    public GlavnaForma getForma() {
        return forma;
    }

    public void setPrijavljeniZaposleni(List<ObradaZahteva> prijavljeniZaposleni) {
        this.prijavljeniZaposleni = prijavljeniZaposleni;
    }

    public void setForma(GlavnaForma forma) {
        this.forma = forma;
    }

    public Zaposleni prijaviSe(Zaposleni z) throws Exception {

        OpstaSistemskaOperacija so = new SOPrijavljivanjeZaposlenog();
        so.opsteIzvrsenje(z);

        return ((SOPrijavljivanjeZaposlenog) so).getZaposleni();
    }

    public void odjaviZaposlenog(Zaposleni an) {
        forma.odjaviZaposlenog(an);
    }

    public void ubaciKlijenta(Klijent k) throws Exception {
        OpstaSistemskaOperacija so = new SOUnosKlijenta();
        so.opsteIzvrsenje(k);

    }

    public List<OpstaDomenskaKlasa> vratiSveKlijente() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSveKlijente();
        so.opsteIzvrsenje(new Klijent());
        return ((SOVratiSveKlijente) so).getLista();
    }

    public List<OpstaDomenskaKlasa> vratiOdredjeneKlijente(Klijent klijent) throws Exception {
        OpstaSistemskaOperacija so = new SOVratiOdredjeneKlijente();
        so.opsteIzvrsenje(klijent);
        return ((SOVratiOdredjeneKlijente) so).getLista();
    }

    public void izmeniKlijenta(Klijent k) throws Exception {
        OpstaSistemskaOperacija so = new SOIzmeniKlijenta();
        so.opsteIzvrsenje(k);
    }

    public void ubaciVozilo(Vozilo v) throws Exception {
        OpstaSistemskaOperacija so = new SOUnosVozila();
        so.opsteIzvrsenje(v);
    }

    public List<OpstaDomenskaKlasa> vratiSvaVozila() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSvaVozila();
        so.opsteIzvrsenje(new Vozilo());
        return ((SOVratiSvaVozila) so).getLista();

    }

    public List<OpstaDomenskaKlasa> vratiOdredjenaVozila(Vozilo vozilo) throws Exception {
        OpstaSistemskaOperacija so = new SOVratiOdredjenaVozila();
        so.opsteIzvrsenje(vozilo);
        return ((SOVratiOdredjenaVozila) so).getLista();
    }

    public List<OpstaDomenskaKlasa> vratiOdredjeneRezervacije(Rezervacija rezervacija) throws Exception {
        OpstaSistemskaOperacija so = new SOVratiOdredjeneRezervacije();
        so.opsteIzvrsenje(rezervacija);
        return ((SOVratiOdredjeneRezervacije) so).getLista();
    }

    public List<OpstaDomenskaKlasa> vratiSveRezervacije() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSveRezervacije();
        so.opsteIzvrsenje(new Rezervacija());
        return ((SOVratiSveRezervacije) so).getLista();
    }

    public void ubaciRezervacije(List<Rezervacija> ang) throws Exception {
        OpstaSistemskaOperacija so = new SOUnosRezervacije();
        so.opsteIzvrsenje(ang);
    }

    public List<OpstaDomenskaKlasa> vratiSveVozace() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSveVozace();
        so.opsteIzvrsenje(new Vozac());
        return ((SOVratiSveVozace) so).getLista();
    }

    public void ubaciUnajmljivanje(Unajmljivanje u) throws Exception {
        OpstaSistemskaOperacija so = new SOUnosUnajmljivanja();
        so.opsteIzvrsenje(u);
    }

    public void izbaciZaposlenog(Zaposleni z) {
        for (int i = 0; i < prijavljeniZaposleni.size(); i++) {
            if (prijavljeniZaposleni.get(i).getZ().equals(z)) {
                Odgovor o = new Odgovor();
                o.setGreska("Gotovo");
                o.setPodaci("Gotovo! Odjavljeni ste sa sistema!");
                o.setStatus(StatusOdgovora.KRAJ_RADA);
                System.out.println(o);
                prijavljeniZaposleni.get(i).posaljiOdgovor(o);
                prijavljeniZaposleni.get(i).setKraj(true);
                try {
                    prijavljeniZaposleni.get(i).getSoket().close();
                } catch (IOException ex) {
                    Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                }
                prijavljeniZaposleni.remove(i);

            }

        }
    }

}
