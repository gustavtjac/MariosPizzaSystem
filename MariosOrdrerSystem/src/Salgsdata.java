import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Laver en salgsdata klasse, for at skabe overblik over hvor mange pizzaer der er blevet solgt i alt og hvad omsætningen er
public class Salgsdata {
    private static int omsætning = 0;


    //Laver en metode som tilføjer en ordres totalpris til statisk omsætning.
    public static void tilføjOmsætning(int ordreOmsætning){
        omsætning += ordreOmsætning;
    }
    //Metode til at fjerne fjra omsætning
    public static void fjernOmsætning(int ordreOmsætning){
        omsætning -= ordreOmsætning;
    }
    //setter til at sætte omsætning.
    public static void setOmsætning(int setoms){
        omsætning = setoms;
    }

public static void opdaterOmsætning(){
    try {

        String currentDir = System.getProperty("user.dir");
        Scanner myReader = new Scanner(new File("MariosOrdrerSystem/Content/src/omsætning.txt"));
        int salg = Integer.parseInt(myReader.nextLine());
        Salgsdata.setOmsætning(salg);
        myReader.close();
    }catch (FileNotFoundException e) {
        System.out.println("File not found for omsætning");
    }
}
    public static int getOmsætning(){
        return omsætning;
    }

    //laver en metode som viser den totale omsætning.
    public static void visOmsætning(){
        System.out.println("___________________________________________");
        System.out.println("\u001B[32m" + "Total omsætning: " + omsætning + " Kr." + "\u001B[0m");
        System.out.println("___________________________________________");
    }
}
