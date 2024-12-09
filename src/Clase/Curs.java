package Clase;

import java.util.*;
import java.util.HashMap;

//AICI IMPLEMENTAM OPERATII CURS
public class Curs implements OperatiiCurs {
    String nume;
    String descriere;
    List<Profesor> profu;

    HashMap<Student, List<Double>> StudentiSiNote;


    public Curs(String nume, String descriere){
        this.nume = nume;
        this.descriere = descriere;
        this.profu = new ArrayList<>();
        this.StudentiSiNote=new HashMap<>();


    }

    public void AddStudent(Student student) {

      if (!StudentiSiNote.containsKey(student)) {
          StudentiSiNote.put(student, null);
          System.out.println("Studentul "+student+"a fost adaugat cu succes");
      }else {
          System.out.println("Studentul "+student+" nu a fost adaugat deloc");
      }
    }

    public void StergereStudenti(Student student) {
        if (StudentiSiNote.remove(student) != null) {
            System.out.println("Studentul " + student + " a fost eliminat din curs.");
        } else {
            System.out.println("Studentul " + student + " nu există în curs.");
        }

    }
    public void ModificaStudent(Student student_decautat, Student student_nou) {
        if (StudentiSiNote.containsKey(student_decautat)) {
            List<Double> note = StudentiSiNote.remove(student_decautat);
            StudentiSiNote.put(student_nou, note);
            System.out.println("Studentul " + student_decautat + " a fost înlocuit cu " + student_nou);
        } else {
            System.out.println("Studentul " + student_decautat + " nu există în curs.");
        }
    }


    public void AddProfesor(Profesor profesor) {
        profu.add(profesor);

    }

    public void StergereProfesor(Profesor profesor) {
       profu.remove(profesor);
    }

    public void ModificaProfesor(Profesor profesor_c, Profesor prof_nou) {
       profu.remove(profesor_c);
       profu.add(prof_nou);
    }

    public String getNumeCurs() {
        return nume;
    }

    @Override
    public String toString() {
        String str = "Curs: " + "nume=" + nume + ",\n" +
                "descriere=" + descriere + ",\n" +

                "studenti:\n";
        for (Student s : StudentiSiNote.keySet()) {
            str += s + "\n";
        }
        str += "Profesor:\n";
        for (Profesor p : profu) {
            str += p + "\n";
        }
        return str;
    }
    public void noteazaStud(Profesor profesor, Student student, Double nota) {
        if (profu.contains(profesor)) {
            StudentiSiNote.putIfAbsent(student, new ArrayList<>());
            StudentiSiNote.get(student).add(nota);
            System.out.println("Nota " + nota + " a fost adăugată pentru studentul " + student);
        } else {
            System.out.println("Profesorul " + profesor + " nu este asociat acestui curs.");
        }
    }

    public void afisareNote(Student student) {
        if (StudentiSiNote.containsKey(student)) {
            List<Double> note = StudentiSiNote.get(student);
            System.out.println("Student: " + student + " are notele: " + note);
        } else {
            System.out.println("Studentul " + student + " nu este înregistrat la acest curs.");
        }
    }
    public void afisareMedie(Student student) {
        if (StudentiSiNote.containsKey(student)) {
            List<Double> note = StudentiSiNote.get(student);
            if (note != null && !note.isEmpty()) {
                double suma = 0.0;
                for (Double nota : note) {
                    suma += nota;
                }
                double media = suma / note.size();
                System.out.println("Media notelor pentru " + student + ": " + media);
            } else {
                System.out.println("Studentul " + student + " nu are note.");
            }
        } else {
            System.out.println("Studentul " + student + " nu este înregistrat la acest curs.");
        }
    }






}
