/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domain.Rezervacija;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sapsaj
 */
public class ModelTabeleRezervacija extends AbstractTableModel {

    List<Rezervacija> lista;

    public List<Rezervacija> getLista() {
        return lista;
    }

    public ModelTabeleRezervacija() {
        lista = new ArrayList<>();
    }

    String[] kolone = new String[]{"Naziv rezervacije", "Datum rezervacije", " Datum od", " Datum do", "Cena"};

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
        Rezervacija r = lista.get(rowIndex);
        if (r != null) {
            switch (columnIndex) {
                case 0:
                    return r.getNaziv();
                case 1:
                    return r.getDatumRezervacije();
                case 2:
                    return r.getDatumOd();
                case 3:
                    return r.getDatumDo();
                case 4:
                    return r.getCenaRezervacije();
                default:
                    return null;
            }
        } else {
            return null;
        }

    }

    public void ubaci(Rezervacija r) {
        // if (!lista.contains(r) && r != null) {
        lista.add(r);
        //   lista.sort(Comparator.comparing(Rezervacija::getNaziv));

        fireTableDataChanged();

    }

    public void ubaciUTabelu(Rezervacija r) {
        lista.add(r);
        lista.sort(Comparator.comparing(Rezervacija::getNaziv));

        fireTableDataChanged();

    }

    public void izbaci(Rezervacija r) {
        lista.remove(r);
        fireTableDataChanged();

    }

}
