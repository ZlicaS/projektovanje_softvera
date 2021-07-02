/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domain.Vozilo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sapsaj
 */
public class ModelTabeleVozilo extends AbstractTableModel {

    List<Vozilo> lista;
    String[] kolone = new String[]{"Kilometraza", "Tip vozila", "Broj putnika", "Cena po danu", "Marka"};

    public List<Vozilo> getLista() {
        return lista;
    }

    public ModelTabeleVozilo() {
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
        Vozilo v = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v.getKilometraza();
            case 1:
                return v.getTipVozila();
            case 2:
                return v.getBrojPutnika();
            case 3:
                return v.getCenaPoDanu();
            case 4:
                return v.getMarka();
            default:
                return null;
        }

    }

    public void ubaci(Vozilo v) {
        if (!lista.contains(v) && v != null) {
            lista.add(v);
            lista.sort(Comparator.comparing(Vozilo::getMarka));
            fireTableDataChanged();
        }
    }

}
