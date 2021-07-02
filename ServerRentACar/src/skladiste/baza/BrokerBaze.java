/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.baza;

import domain.OpstaDomenskaKlasa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import skladiste.BrokerBazeInterfejs;
import skladiste.baza.konekcija.BazaKonekcija;

/**
 *
 * @author lizasapsaj
 */
public class BrokerBaze implements BrokerBazeInterfejs {

    @Override
    public OpstaDomenskaKlasa vratiJednog(OpstaDomenskaKlasa ok) throws Exception {
        Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
        String upit = "SELECT * FROM " + ok.vratiImeKlase() + " WHERE " + ok.vratiUslovZaJednog();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        ok = ok.napuni(rs);
        rs.close();
        s.close();
        // System.out.println("ISPISI SE:"+ok);
        return ok;
    }

    @Override
    public List<OpstaDomenskaKlasa> vratiSve(OpstaDomenskaKlasa ok) throws Exception {
        Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
        String upit = "select * from " + ok.vratiImeKlase()+ " " + ok.vratiSpajanje() + ok.vratiSortiranje();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        List<OpstaDomenskaKlasa> lista = ok.napuniListu(rs);
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public List<OpstaDomenskaKlasa> vratiVise(OpstaDomenskaKlasa ok) throws Exception {
        Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
        String upit = "select * from " + ok.vratiImeKlase() +" "+ ok.vratiSpajanje()+" "+ok.vratiUslovZaVise()+" "+ok.vratiSortiranje();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        List<OpstaDomenskaKlasa> lista = ok.napuniListu(rs);
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public Long sacuvaj(OpstaDomenskaKlasa ok) throws Exception {
        try {
            Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
        
            String upit = "INSERT INTO " + ok.vratiImeKlase() +"(" + ok.vratiNaziveKolona()+ ")"+  " VALUES (" + ok.postaviVrednostiAtributa()+ ")";
            System.out.println(upit);
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.executeUpdate();

            //ResultSet rs = ps.getGeneratedKeys();
            long id = 0;
            //System.out.println("BIRA ID");
           // if (rs.next()) {
            //    id = rs.getLong(1);
           // }
            return id;
           
        } catch (SQLException ex) {
//            Logger.getLogger(BrokerBaze.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno cuvanje!");
        }

    }

    @Override
    public void izmeni(OpstaDomenskaKlasa ok) throws Exception {
        try {
            Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
            String upit = "update " + ok.vratiImeKlase() + " set " + ok.postaviVrednostAtributaID()+ " where " + ok.vratiUslovZaJednog();
            System.out.println(upit);
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.executeUpdate();
        } catch (SQLException ex) {
//            ex.printStackTrace();
            throw new Exception("Neuspesna izmena!");
        }
    }
}
