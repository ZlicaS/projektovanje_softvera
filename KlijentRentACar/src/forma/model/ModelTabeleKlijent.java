/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domain.Klijent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sapsaj
 */
public class ModelTabeleKlijent extends AbstractTableModel {

    List<Klijent> lista;

    public List<Klijent> getLista() {
        return lista;
    }

    String kolone[] = new String[]{"Ime i prezime", "Datum rodjenja", "Broj telefona", "Vozacka dozvola", "Ime zaposlenog"};

    public ModelTabeleKlijent(List<Klijent> lista) {
        this.lista = lista;

    }

    public ModelTabeleKlijent() {
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
        Klijent k = lista.get(rowIndex);
        if (k != null) {
            switch (columnIndex) {
                case 0:
                    return k.getImePrezimeKlijent();
                case 1:
                    return k.getDatumRodjenja();
                case 2:
                    return k.getBrojTelefona();
                case 3:
                    return k.getVozackaDozvola();
                case 4:
                    return k.getZaposleniId().toString();
                default:
                    return null;
            }
        }
        return null;
    }

    public void ubaci(Klijent k) {
        if (!lista.contains(k)) {
            lista.add(k);
            lista.sort(Comparator.comparing(Klijent::getImePrezimeKlijent));
            fireTableDataChanged();
        }
    }

}
