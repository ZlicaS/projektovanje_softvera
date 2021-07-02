/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author lizasapsaj
 */
public interface OpstaDomenskaKlasa extends Serializable {

    String vratiVrednostiAtributa();

    String postaviVrednostiAtributa();

    String postaviVrednostAtributaID();

    String vratiImeKlase();

    String vratiUslovZaJednog();

    default String vratiUslovZaVise() {
        return "";
    }

    ;

    OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception;

    String vratiNazivKolone(int kolona);

    List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception;

    default String vratiSpajanje() {
        return "";
    }

    default String vratiSortiranje() {
        return "";
    }

    public String vratiNaziveKolona();

}
