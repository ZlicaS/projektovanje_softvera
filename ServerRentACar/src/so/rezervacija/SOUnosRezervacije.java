/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import domain.OpstaDomenskaKlasa;
import domain.Rezervacija;
import java.util.LinkedList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author lizasapsaj
 */
public class SOUnosRezervacije extends OpstaSistemskaOperacija{
    List<Rezervacija> lista=new LinkedList<Rezervacija>();

    @Override
    protected void validacija(Object objekat) throws Exception {
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        lista = (List<Rezervacija>) object;
        for (Rezervacija r : lista) {
            brokerBaze.sacuvaj((OpstaDomenskaKlasa) r);
           
        }
    }
    
}
