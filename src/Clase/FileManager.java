package Clase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager extends ManagerCursuri implements OperatiiManagerCursuri{

  String cursPath="cursuri.txt";
  String studentiPath="studenti.txt";
  String profesoriPath="profesori.txt";
  String outPath="output.txt";

  public FileManager() {

  try{
      File studenti=new File(studentiPath);
      File profesori=new File(profesoriPath);
      File curs=new File(cursPath);
  } catch (Exception ex){
      System.out.println(ex.getMessage());
  }

  }
    public void CitesteDate(){
      List<Student>studenti=CitireStudenti();
      List<Profesor>profesor=CitireProfesori();
      List<Curs>cursuri=CitireCursuri();
}
    public List<Student> CitireStudenti() {
        List<Student> students = new ArrayList<Student>();
        try {

            File f = new File(studentiPath);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");

                Student s = new Student(splituri[0], splituri[1].trim(), Integer.parseInt(splituri[2].trim()));
                students.add(s);
                line = br.readLine();
            }
            return students;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return students;
    }
    public List<Profesor> CitireProfesori() {
        List<Profesor> profesors = new ArrayList<Profesor>();
        try {
            File f = new File(profesoriPath);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");
                Profesor prof=new Profesor(splituri[0],splituri[1]);
                profesors.add(prof);
                line = br.readLine();
            }return profesors;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Curs>CitireCursuri() {
      List<Curs>cursuri=new ArrayList<>();
      try{
          File f = new File(cursPath);
          BufferedReader br = new BufferedReader(new FileReader(f));
          String linie=br.readLine();
          if (linie != null) {
              linie=linie.trim();
              String[] splituri = linie.split(",");
              Curs curs=new Curs(splituri[0],splituri[1]);
              cursuri.add(curs);
              linie= br.readLine();

          }return cursuri;
      } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
    }
    public void ScrieStud(Student student) {
        try {
            File f = new File(studentiPath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
            try {
                bw.write(student.getNume() + "," + student.getPrenume() + "," + student.getGrupa() + "\r\n");
                bw.flush();
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                bw.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void ScrieProf(Profesor prof)  {
      try{
          File f = new File(profesoriPath);
          BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
          try{
              bw.write(prof.getNume()+","+prof.getPrenume()+ "\r\n");
              bw.flush();
          } catch (IOException e) {
              System.out.println(e);
          }finally {
              bw.close();
          }
      }catch (Exception exceptie){
          System.out.println(exceptie);
      }
}
    public void ScrieCurs(Curs curs)  {
        try{
            File f = new File(cursPath);
            BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
            try{
                bw.write(curs.getNumeCurs()+ "\r\n");
                bw.flush();
            } catch (IOException e) {
                System.out.println(e);
            }finally {
                bw.close();
            }
        }catch (Exception exceptie){
            System.out.println(exceptie);
        }
    }


}










