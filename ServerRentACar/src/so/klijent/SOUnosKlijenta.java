/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import domain.Klijent;
import domain.OpstaDomenskaKlasa;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author lizasapsaj
 */
public class SOUnosKlijenta extends OpstaSistemskaOperacija {

    @Override
    protected void validacija(Object objekat) throws Exception {
        if (!(objekat instanceof Klijent)) {
            throw new Exception("Pogresan parametar");
        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        brokerBaze.sacuvaj((OpstaDomenskaKlasa) object);
    }

}
