/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domain.Klijent;
import domain.OpstaDomenskaKlasa;
import domain.Rezervacija;
import domain.Unajmljivanje;
import domain.Vozilo;
import domain.Zaposleni;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author lizasapsaj
 */
public class ObradaZahteva extends Thread {

    private Socket soket;
    private boolean kraj = false;
    private Zaposleni zap;

    public ObradaZahteva(Socket s) {
        this.soket = s;

    }

    public Socket getSoket() {
        return soket;
    }

    public boolean isKraj() {
        return kraj;
    }

    public Zaposleni getZ() {
        return zap;
    }

    public void setSoket(Socket soket) {
        this.soket = soket;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

    public void setZ(Zaposleni zap) {
        this.zap = zap;
    }

    @Override
    public void run() {
        try {
            while (!kraj) {
                Zahtev z = vratiZahtev();
                System.out.println("Primljen zahtev: " + z.toString());
                Odgovor o = new Odgovor();
                List<OpstaDomenskaKlasa> lista = new ArrayList<>();
                try {
                    switch (z.getOperacija()) {
                        case Operacija.PRIJAVA:

                            zap = (Zaposleni) z.getPodaci();

                            zap = kontroler.Kontroler.getInstanca().prijaviSe(zap);
                            o.setPodaci(zap);
                            o.setStatus(StatusOdgovora.OK);
                            kontroler.Kontroler.getInstanca().getPrijavljeniZaposleni().add(this);
                            kontroler.Kontroler.getInstanca().getForma().dodajPrijavljenogZaposlenog(zap);
                            System.out.println("Zaposleni" + zap);
                            System.out.println("ZAVRSIO JE PRIJAVA");
                            break;

                        case Operacija.UNESI_KLIJENTA:
                            Klijent k = (Klijent) z.getPodaci();
                            Kontroler.getInstanca().ubaciKlijenta(k);
                            o.setPodaci("Uspesno ste uneli klijenta");
                            o.setStatus(StatusOdgovora.OK);
                            System.out.println("ZAVRSIO JE UNESI");

                            break;

                        case Operacija.VRATI_SVE_KLIJENTE:
                            lista = Kontroler.getInstanca().vratiSveKlijente();
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);
                            break;

                        case Operacija.VRATI_ODREDJENE_KLIJENTE:
                            lista = Kontroler.getInstanca().vratiOdredjeneKlijente((Klijent) z.getPodaci());
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);
                            break;

                        case Operacija.IZMENI_KLIJENTA:
                            k = (Klijent) z.getPodaci();
                            Kontroler.getInstanca().izmeniKlijenta(k);
                            o.setPodaci("Uspesno ste izmenili klijenta");
                            o.setStatus(StatusOdgovora.OK);

                            break;

                        case Operacija.UNESI_VOZILO:
                            System.out.println("U unesi vozilo");
                            Vozilo v = (Vozilo) z.getPodaci();
                            Kontroler.getInstanca().ubaciVozilo(v);
                            o.setPodaci("Uspesno ste uneli vozilo");
                            o.setStatus(StatusOdgovora.OK);
                            System.out.println("ZAVRSIO JE UNESI vozilo");
                            break;

                        case Operacija.VRATI_SVA_VOZILA:
                            lista = Kontroler.getInstanca().vratiSvaVozila();
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;

                        case Operacija.VRATI_ODREDJENA_VOZILA:
                            lista = Kontroler.getInstanca().vratiOdredjenaVozila((Vozilo) z.getPodaci());
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;

                        case Operacija.VRATI_SVE_REZERVACIJE:
                            lista = Kontroler.getInstanca().vratiSveRezervacije();
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;

                        case Operacija.VRATI_ODREDJENE_REZERVACIJE:

                            lista = Kontroler.getInstanca().vratiOdredjeneRezervacije((Rezervacija) z.getPodaci());
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;

                        case Operacija.UNESI_REZERVACIJE:
                            List<Rezervacija> ang = (List<Rezervacija>) z.getPodaci();
                            Kontroler.getInstanca().ubaciRezervacije(ang);
                            o.setPodaci("Uspesno ste uneli rezervacije");
                            o.setStatus(StatusOdgovora.OK);
                            break;

                        case Operacija.VRATI_SVE_VOZACE:
                            lista = Kontroler.getInstanca().vratiSveVozace();
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);
                            break;

                        case Operacija.UNESI_UNAJMLJIVANJE:

                            Unajmljivanje u = (Unajmljivanje) z.getPodaci();
                            Kontroler.getInstanca().ubaciUnajmljivanje(u);
                            o.setPodaci("Uspesno ste uneli unajmljivanje");
                            o.setStatus(StatusOdgovora.OK);

                            break;

                        case Operacija.ODJAVA:
                            if (z.getPodaci() == null) {
                                Kontroler.getInstanca().getPrijavljeniZaposleni().remove(this);
                                kraj = true;
                                break;
                            } else {
                                Zaposleni an = (Zaposleni) z.getPodaci();
                                Kontroler.getInstanca().odjaviZaposlenog(an);
                                o.setStatus(StatusOdgovora.OK);
                                o.setPodaci("Uspesno ste se odjavili sa servera!");
                            }
                    }
                } catch (Exception ex) {
                    o.setStatus(StatusOdgovora.GRESKA);
                    o.setGreska(ex);
                }
                System.out.println(o);
                posaljiOdgovor(o);
            }

        } catch (Exception e) {

        }
        System.out.println("Zaposleni se odjavio");

    }

    public void posaljiOdgovor(Odgovor o) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(o);
        } catch (Exception ex) {
           // ex.printStackTrace();
        }

    }

    public Zahtev vratiZahtev() {
        Zahtev z = new Zahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            z = (Zahtev) ois.readObject();
        } catch (Exception ex) {
           // ex.printStackTrace();
        }

        return z;
    }

}
