/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domain.Klijent;
import domain.Vozac;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sapsaj
 */
public class ModelTabeleVozac extends AbstractTableModel {

    List<Vozac> lista;
    
        

    public List<Vozac> getLista() {
        return lista;
    }
    String kolone[] = new String[]{"Ime i prezime", "JMBG", "Slobodan"};

    public ModelTabeleVozac(List<Vozac> lista) {
        this.lista = lista;
    }

    public ModelTabeleVozac() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (lista == null) {
            return 0;
        }
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vozac v = lista.get(rowIndex);
        if (v != null) {
            switch (columnIndex) {
                case 0:
                    return v.getImePrezimeVozac();
                case 1:
                    return v.getJmbg();
                case 2:
                    return slob(v.getDaLiJeSlobodan());

                default:
                    return null;
            }
        }
        return null;
    }
    
    public String slob(int slobodan){
        if(slobodan==1){
            return "slobodan";
        }else{
            return "zauzet";
        }
    }

    public void ubaci(Vozac k) {
        if (!lista.contains(k)) {
            lista.add(k);
            lista.sort(Comparator.comparing(Vozac::getImePrezimeVozac));
            fireTableDataChanged();
        }
    }

}
