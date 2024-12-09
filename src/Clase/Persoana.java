package Clase;
public abstract class Persoana {
   //IMPLEMENTAM VARIABILELE NUME/ PRENUME CARE SE VOR MOSTENI IN CLASA PROFESOR RESPECTIV STUDENT
    String nume;
    String prenume;

    @Override
    public String toString() {
        return "Persoana{" + "nume=" + nume + ", prenume=" + prenume + '}';
    }
}
