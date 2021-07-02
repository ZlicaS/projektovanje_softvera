/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.unajmljivanje;

import domain.OpstaDomenskaKlasa;
import domain.Unajmljivanje;
import java.util.LinkedList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Sapsaj
 */
public class SOUnosUnajmljivanja extends OpstaSistemskaOperacija {

    List<Unajmljivanje> lista = new LinkedList<Unajmljivanje>();

    @Override
    protected void validacija(Object objekat) throws Exception {
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        Unajmljivanje unajm = (Unajmljivanje) object;
        brokerBaze.sacuvaj((OpstaDomenskaKlasa) unajm);
           
        
    }

}
