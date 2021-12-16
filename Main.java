/**
* @autor Equipo B
*/

import modelo.Nombres;
import modelo.Proyectos;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {    

    Scanner sc =new Scanner(System.in);
    System.out.println("Opcion: ");
    int opc = sc.nextInt();sc.nextLine();
    

}



    public static void registros()
    {
      int count=0, id=1;
      String datos[] = new String[49];
      
      Nombres nom = new Nombres();
      Proyectos proy = new Proyectos();
      System.out.printf("%-5s | %-15s  %-15s  %-15s | %-12s | %n","Id","Nombre","Apellido P.","Apellido M.","Edad");
      
      try
      {
        FileWriter fw = new FileWriter("Trabajadores.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salida = new PrintWriter(bw);

        datos[0]="ID Trabajador ";datos[1]=" Nombre "; datos[2]=" Apellido M. "; datos[3]=" Apellido P. ";
        datos[4]=" Antiguedad "; datos[5]=" Calle "; datos[6]=" Colonia "; datos[7]=" Municipio "; datos[8]=" Proyectos Vigentes "; datos[11]=" Proyectos Historicos ";

        salida.println(Arrays.toString(datos));


        for(int i=0;i<100;i++)
        {
          datos = new String[datos.length];

          int a = (int) (Math.random() * 20);
          int b = (int) (Math.random() * 20);
          int c = (int) (Math.random() * 40 + 1);
          int d = (int) (Math.random() *489);

          System.out.printf("%-5s | %-15s  %-15s  %-15s | %-12s | %n",id,nom.getNombres()[a],nom.getApellidos()[a],nom.getApellidos()[b],c);
          datos[0] = String.valueOf(id); 
          id++;
          datos[1] = nom.getNombres()[a];
          datos[2] = nom.getApellidos()[a]; 
          datos[3] = nom.getApellidos()[b]; 
          datos[4] = String.valueOf(c); 

          try
          {
            FileReader fr = new FileReader("direcciones.csv");
            BufferedReader br = new BufferedReader(fr);
            while(count<=d)
            {
              String linea = br.readLine();
              count++;
              if(count==d)
              {
                datos[5] = linea;
                String datosDireccion[] = linea.split(","); 
                String calle = datosDireccion[0];
                String colonia = datosDireccion[1];
                String municipio = datosDireccion[2];
                System.out.println("Direccion: "+calle+" "+colonia+" "+municipio);
                datosDireccion=null; 
              }
            }
            count=0;
          }
          catch(FileNotFoundException ex)
          {
            System.out.println(ex.getMessage());
          }
          catch(IOException ex)
          {
            System.out.println(ex.getMessage());
          }

          int e = (int) (Math.random() * 3 + 1);
          int f = (int) (Math.random() *41);
          int numProyect = e+f;

          System.out.println("Numero total de Proyectos: "+numProyect);
          System.out.println("Proyectos Vigentes: "+e);
          for(int j=0;j<e;j++)
          {
            int g = (int) (Math.random() * 9);
            System.out.println("\t"+proy.getProyectosVigentes()[g]);
            datos[j+6] = proy.getProyectosVigentes()[g]; 
          }

          System.out.println("Proyectos Historicos: "+f);
          for(int k=0;k<f;k++)
          {
            int h = (int) (Math.random() * 39);
            System.out.println("\t"+proy.getProyectosHistoricos()[h]);
            datos[k+9] = proy.getProyectosHistoricos()[h]; 
          }      

          System.out.println("\n\n");
          
          salida.println(Arrays.toString(datos));
        }
        salida.close();
      }
      catch(IOException ex)
      {
        System.out.println(ex.getMessage());
      }
    }



    public static void modificaciones(){
      
      Scanner sc =new Scanner(System.in);
    
      int count=0;

      String datos[] = new String[49];
      datos = new String[datos.length];

      System.out.println("Trabajador a modificar: ");
      int modificar = sc.nextInt();sc.nextLine();


      try
      {
        FileWriter fw = new FileWriter("Editor.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salida = new PrintWriter(bw);

        datos[0]="ID Trabajador ";datos[1]=" Nombre "; datos[2]=" Apellido P. "; datos[3]=" Apellido M. ";
        datos[4]=" Antiguedad "; datos[5]=" Calle "; datos[6]=" Colonia "; datos[7]=" Municipio "; datos[8]=" Proyectos Vigentes "; datos[11]=" Proyectos Historicos ";

        salida.println(Arrays.toString(datos));


        FileReader fr = new FileReader("Trabajadores.csv");
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();

        while(count<modificar-1)
        {
          linea = br.readLine();
          salida.println(linea);

          count++;
        }

        if(count==modificar-1)
        {
          linea = br.readLine();

          System.out.println("Nombre: ");
          String n = sc.nextLine();sc.nextLine();
          System.out.println("Apellido Paterno: ");
          String aP = sc.nextLine();sc.nextLine();
          System.out.println("Apellido Materno: ");
          String aM = sc.nextLine();sc.nextLine();
          System.out.println("Antiguedad: ");
          String an = sc.nextLine();sc.nextLine();
          System.out.println("Calle: ");
          String ca = sc.nextLine();sc.nextLine();
          System.out.println("Colonia: ");
          String col = sc.nextLine();sc.nextLine();
          System.out.println("Municipio: ");
          String mun = sc.nextLine();sc.nextLine();

          datos[0]=String.valueOf(modificar); datos[1]=n; datos[2]=aP; datos[3]=aM; datos[4]=an; datos[5]=ca; datos[6]=col; datos[7]=mun;

          System.out.println("Numero de proyectos Vigentes: ");
          int numPV = sc.nextInt();sc.nextLine();
          for(int i=0;i<numPV;i++)
          {
            System.out.println(i+1);
            String pV = sc.nextLine();sc.nextLine();
            datos[i+8]=pV;
          }

          System.out.println("Numero de proyectos Historicos: ");
          int numPH = sc.nextInt();sc.nextLine();
          for(int j=0;j<numPH;j++)
          {
            System.out.println(j+1);
            String pH = sc.nextLine();sc.nextLine();
            datos[j+11]=pH;
          }

          salida.println(Arrays.toString(datos));
          count++;

          System.out.println("Trabajador modificado: \n\tNombre: "+ n +"\n\tApellido Paterno: " + aP +"\n\tApellido Materno: "+aM+"\n\tAntigüedad: "+an+"\n\tCalle: "+ca+"\n\tColonia: "+col+"\n\tMunicipio: "+mun+"\n\tProyectos Vigentes: "+numPV+"\n\tProyectos Historicos: "+numPH);

        }


      while(count>modificar-1 && count<100)
        {
          linea = br.readLine();
          salida.println(linea);

          count++;
        }

        salida.close();

      }
      catch(IOException ex)
      {
        System.out.println(ex.getMessage());
      }
      

      try
      {
        FileWriter fw = new FileWriter("Trabajadores.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salida = new PrintWriter(bw);

        FileReader fr = new FileReader("Editor.csv");
        BufferedReader br = new BufferedReader(fr);

        for(int k=0;k<101;k++)
        {
          String linea = br.readLine();
          salida.println(linea);
        }
        salida.close();

      }catch(IOException ex)
      {
        System.out.println(ex.getMessage());
      }

    }
}


 
 