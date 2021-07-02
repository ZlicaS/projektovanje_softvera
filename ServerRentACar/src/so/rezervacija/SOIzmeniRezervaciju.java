/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import domain.OpstaDomenskaKlasa;
import domain.Rezervacija;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Sapsaj
 */
public class SOIzmeniRezervaciju extends OpstaSistemskaOperacija{

    @Override
    protected void validacija(Object objekat) throws Exception {
       if(!equals(objekat instanceof Rezervacija)){
           throw new Exception("Neodgovarajuc parametar!");
       }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
       brokerBaze.izmeni((OpstaDomenskaKlasa) object);
       Rezervacija r=(Rezervacija) object;
       
    }
    
}
