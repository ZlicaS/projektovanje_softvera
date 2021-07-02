/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vozilo;

import domain.OpstaDomenskaKlasa;
import domain.Vozilo;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author lizasapsaj
 */
public class SOUnosVozila extends OpstaSistemskaOperacija {

    @Override
    protected void validacija(Object objekat) throws Exception {
        if (!(objekat instanceof Vozilo)) {
            throw new Exception("Neodgovarajuc parametar!");

        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        brokerBaze.sacuvaj((OpstaDomenskaKlasa) object);
    }

}
