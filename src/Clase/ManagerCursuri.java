package Clase;

import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;


public class ManagerCursuri implements OperatiiManagerCursuri {
    //AICI IMPLEMENTAM OPERATII MANAGER CURSURI
    Set<Curs> cursuri;

    public ManagerCursuri() {
        Connection conn = null;
        this.cursuri=new HashSet<>();
    }

    public void AddCurs(Curs curs) {
       cursuri.add(curs);
    }

    public void AfiseazaCursuriLaConsola() {
        for (Curs c : cursuri)
            System.out.println(c);
    }

    public void StergereCurs(Curs curs_nou) {
     cursuri.remove(curs_nou);
    }

    public void ModificaCurs(Curs curs_cautat, Curs curs_nou_modificat) {


        cursuri.remove(curs_cautat);
        cursuri.add(curs_nou_modificat);
    }

    public void ArataNumaiCurs() {
        for (Curs curs : cursuri) {
            System.out.println("Curs" + curs.getNumeCurs());
        }

    }


}