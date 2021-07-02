/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import domain.OpstaDomenskaKlasa;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author lizasapsaj
 */
public class SOVratiOdredjeneKlijente extends OpstaSistemskaOperacija {

    List<OpstaDomenskaKlasa> lista;

    public List<OpstaDomenskaKlasa> getLista() {
        return lista;
    }

    public SOVratiOdredjeneKlijente() {
        lista = new ArrayList<>();
    }

    @Override
    protected void validacija(Object objekat) throws Exception {
       
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        System.out.println("U IZVRSI");
        lista = brokerBaze.vratiVise((OpstaDomenskaKlasa) object);
    }

}
