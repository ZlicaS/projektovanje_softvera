/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

import domain.OpstaDomenskaKlasa;
import domain.Zaposleni;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author lizasapsaj
 */
public class SOPrijavljivanjeZaposlenog extends OpstaSistemskaOperacija {

    private Zaposleni zaposleni;

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    @Override
    protected void validacija(Object objekat) throws Exception {
         if(!(objekat instanceof Zaposleni)){
        throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        zaposleni = (Zaposleni) brokerBaze.vratiJednog((OpstaDomenskaKlasa) object);
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

}
