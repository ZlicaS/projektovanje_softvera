/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domain.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lizasapsaj
 */
public class TableModel extends AbstractTableModel {

    List<Zaposleni> zaposleni;
    String header[] = new String[]{"Ime i prezime", "Korisnicko ime"};

    public TableModel(List<Zaposleni> zaposleni) {
        this.zaposleni = zaposleni;
    }

    public TableModel() {
        zaposleni = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (zaposleni == null) {
            return 0;
        }
        return zaposleni.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;

    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaposleni z = zaposleni.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return z.getImePrezimeZaposleni();
            case 1:
                return z.getUsername();
            default:
                return "N/A";
        }
    }

    public Zaposleni izbaciRed(int index) {
        Zaposleni z = zaposleni.get(index);
        zaposleni.remove(index);
        fireTableDataChanged();
        return z;

    }

    public void dodajZaposlenog(Zaposleni z) {
        zaposleni.add(z);
        fireTableDataChanged();
    }

    public void izbaciZaposlenog(Zaposleni z) {
        zaposleni.remove(z);
        fireTableDataChanged();
    }

}
