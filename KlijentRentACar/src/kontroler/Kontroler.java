/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domain.Klijent;
import domain.Rezervacija;
import domain.Unajmljivanje;
import domain.Vozac;
import domain.Vozilo;
import domain.Zaposleni;
import forma.GlavnaForma;
import java.util.ArrayList;
import java.util.List;
import komunikacija.Komunikacija;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author Sapsaj
 */
public class Kontroler {

    private static Kontroler instanca;
    private GlavnaForma forma;

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    private Kontroler() {
    }

    public void setForma(GlavnaForma forma) {
        this.forma = forma;
    }

    public GlavnaForma getForma() {
        return forma;
    }

    public Zaposleni prijavaNaSistem(String korisnickoIme, String sifra) throws Exception {
        Zaposleni z = new Zaposleni();
        z.setUsername(korisnickoIme);
        z.setPassword(sifra);
        System.out.println(z);
        Zahtev za = new Zahtev(Operacija.PRIJAVA, z);
        Komunikacija.getInstanca().posaljiZahtev(za);
        System.out.println("Poslat zahtev je: " + za);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            sesija.Sesija.getInstanca().setZaposleni((Zaposleni) o.getPodaci());

            return (Zaposleni) o.getPodaci();

        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public String odjavaSaSistema(Zaposleni zaposleni) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.ODJAVA, zaposleni);
        Komunikacija.getInstanca().posaljiZahtev(zahtev);

        Odgovor odgovor = Komunikacija.getInstanca().vratiOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (String) odgovor.getPodaci();
        }
        throw (Exception) odgovor.getGreska();
    }

    public String unesiKlijenta(Klijent k) throws Exception {
        Zahtev z = new Zahtev(Operacija.UNESI_KLIJENTA, k);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Klijent> vratiSveKlijente() {
        Zahtev z = new Zahtev(Operacija.VRATI_SVE_KLIJENTE, new Klijent());
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        List<Klijent> lista = new ArrayList<>();
        lista = (List<Klijent>) o.getPodaci();
        return lista;
    }

    public List<Klijent> vratiKlijente(Klijent kl) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_ODREDJENE_KLIJENTE, kl);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            List<Klijent> lista = new ArrayList<>();
            lista = (List<Klijent>) o.getPodaci();
            return lista;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;

    }

    public String izmeniKlijenta(Klijent k) throws Exception {
        Zahtev z = new Zahtev(Operacija.IZMENI_KLIJENTA, k);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public String unesiVozilo(Vozilo v) throws Exception {
        Zahtev z = new Zahtev(Operacija.UNESI_VOZILO, v);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Vozilo> vratiSvaVozila() {
        Zahtev z = new Zahtev(Operacija.VRATI_SVA_VOZILA, null);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        List<Vozilo> lista = new ArrayList<>();
        lista = (List<Vozilo>) o.getPodaci();
        return lista;
    }

    public List<Vozilo> vratiVozila(Vozilo v) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_ODREDJENA_VOZILA, v);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            List<Vozilo> lista = new ArrayList<>();
            lista = (List<Vozilo>) o.getPodaci();
            return lista;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Rezervacija> vratiRezervacije() throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_SVE_REZERVACIJE, null);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            List<Rezervacija> lista = new ArrayList<>();
            lista = (List<Rezervacija>) o.getPodaci();
            return lista;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Rezervacija> vratiOdredjeneRezervacije(Rezervacija a) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_ODREDJENE_REZERVACIJE, a);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            List<Rezervacija> lista = new ArrayList<>();
            lista = (List<Rezervacija>) o.getPodaci();
            return lista;
        }
        Exception ex = (Exception) o.getGreska();
        ex.printStackTrace();
        throw ex;
    }

    public String unesiRezervacije(List<Rezervacija> a) throws Exception {
        Zahtev z = new Zahtev(Operacija.UNESI_REZERVACIJE, a);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Vozac> vratiSveVozace() {
        Zahtev z = new Zahtev(Operacija.VRATI_SVE_VOZACE,null);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        List<Vozac> lista = new ArrayList<>();
        lista = (List<Vozac>) o.getPodaci();
        return lista;

    }

    public String unesiUnajmljivanje(Unajmljivanje unajmljivanje) throws Exception {
        Zahtev z = new Zahtev(Operacija.UNESI_UNAJMLJIVANJE, unajmljivanje);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }
}
