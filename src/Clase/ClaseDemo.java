package Clase;

import java.io.File;
import java.util.List;

public class ClaseDemo {
    public static void main(String[] args) {
//definire studenti
        Student[] studenti = new Student[]{};
//definire profesor
        Profesor[] profu = new Profesor[]{};

//definire curs nou
        Curs curs = new Curs("Rezistenta Materialelor", "calculul reacţiunilor,\n" +
                "diagramele de eforturi, calculul caracteristicilor geometrice ale\n" +
                "suprafeţelor plane şi calculul elementelor de rezistenţă la solicitări simple\n"
                );
        Curs curs2 = new Curs("Mecanica Fluidelor", "studiul curgerii fluidelor,\n" +
                "ecuațiile de continuitate, calculul vitezei și presiunii,\n" +
                "analiza debitului și efectele vâscozității în conducte,\n" +
                "comportamentul fluidelor în regimuri de curgere variate\n"
                );
        Curs curs3 = new Curs("Termodinamica", "studiul transferului de căldură,\n" +
                "legile termodinamicii, calculul energiei interne și entalpiei,\n" +
                "procese izoterme și adiabate, analiza ciclurilor termodinamice,\n" +
                "comportamentul gazelor ideale și reale\n"
                );


//adaugare curs in lista de cursuri
        ManagerCursuri cursuri = new ManagerCursuri();
        cursuri.AddCurs(curs);
        cursuri.AddCurs(curs2);
        cursuri.ModificaCurs(curs2, curs3);
        //facem studenti
        Student student1 = new Student("Andrei", "Negoita", 2231);
        //il adaugam la curs
        curs.AddStudent(student1);
        //la fel si aici , facem un student
        Student student2 = new Student("Ion", "Mateescu", 4221);
        //il adaugam la cursul3
        curs3.AddStudent(student2);
        //la fel si aici , mai facem inca unu
        Student student3 = new Student("Raul", "Beldiman", 3453);
       //il adaugam
        curs3.AddStudent(student3);
        //stergem ultimul student adaugat
       // curs3.StergereStudenti(student3);
        //mai facem un student
        Student student4 = new Student("Ion", "Popescu", 4222);
        //am modificat studentul pe care l am sters mai sus , de aia e comentata functia stergere....
        curs3.ModificaStudent(student3, student4);
        //facem un prof , la fel ca la studenti
        Profesor profesor1 = new Profesor("Mihael", "Gabi");
       //adaugam cativa
        curs.AddProfesor(profesor1);
        curs2.AddProfesor(profesor1);
        curs3.AddProfesor(profesor1);
        //stergem unu
        curs2.StergereProfesor(profesor1);
        //mai facem un prof sa il modificam dupa
        Profesor profesor2 = new Profesor("Gabi", "Mabi");
       //modificam profu
        curs3.ModificaProfesor(profesor1, profesor2);
       //dam print
        cursuri.AfiseazaCursuriLaConsola();
       // aratam numa cursuri
        cursuri.ArataNumaiCurs();
        // studenti per curs..
       // cursuri.StudentiperCurs(curs3);
           curs.noteazaStud(profesor1,student1,9.8);
           curs.noteazaStud(profesor1,student1,9.2);
           curs3.noteazaStud(profesor2,student2,8.9);
           curs3.noteazaStud(profesor2,student2,6.0);
           curs3.noteazaStud(profesor2,student4,4.9);
           curs3.noteazaStud(profesor2,student4,6.0);
           curs3.afisareNote(student4);
           curs3.afisareMedie(student4);
//         Student studentdesters = new Student("desters", "desters", 9999);
//         curs.AddStudent(studentdesters);
//         curs.StergereStudenti(studentdesters);



        FileManager csv=new FileManager();
        Student extra=new Student("Colegu","Nou",12);
        Student extra1=new Student("Colegu","Mai nou",12);
        csv.ScrieStud(extra1);
        System.out.println(csv.CitireStudenti());
        csv.CitesteDate();





    }
}