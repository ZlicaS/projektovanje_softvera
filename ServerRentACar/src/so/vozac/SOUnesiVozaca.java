/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vozac;

import domain.OpstaDomenskaKlasa;
import domain.Vozac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author lizasapsaj
 */
public class SOUnesiVozaca extends OpstaSistemskaOperacija{

    
    @Override
    protected void validacija(Object objekat) throws Exception {
      if (!(objekat instanceof Vozac)) {
            throw new Exception("Objekat nije validan");
        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
         brokerBaze.sacuvaj((OpstaDomenskaKlasa) object);
    }
    
}
