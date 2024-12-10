package Clase;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persoana{

    List<Double> notep;
    @Override
    public String toString() {
        return "Profesor{" + "nume=" + nume + ", prenume=" + prenume + '}';
    }
    public Profesor(String nume, String prenume)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.notep = new ArrayList<Double>();
    }


    public String getNume() {
        return nume;
    }
   public void setNume(String nume) {
        this.nume = nume;
   }
   public String getPrenume() {
        return prenume;
   }
   public void setPrenume(String prenume) {
        this.prenume = prenume;
   }



}