//Laver en salgsdata klasse, for at skabe overblik over hvor mange pizzaer der er blevet solgt i alt og hvad omsætningen er
public class Salgsdata {
    private static int omsætning = 0;

//Laver en metode som tilføjer en ordres totalpris til statisk omsætning.
public static void tilføjOmsætning(int ordreOmsætning){
        omsætning += ordreOmsætning;
    }
//laver en metode som viser den totale omsætning.
public static void visOmsætning(){
        System.out.println("Total omsætning: " + omsætning + " Kr.");
    }
}
