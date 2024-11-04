import java.util.ArrayList;
import java.util.Comparator;

//Opretter vores Ordreliste class.
public class OrdreListe {
    private static ArrayList<Ordre> OrdreListe = new ArrayList<>();
    public OrdreListe() {

    }

    //Opretter en metode som gør at vi kan tilføje en ordre, til vores ordreliste.
    public static void tilføjOrdre(Ordre ordre) {
        OrdreListe.add(ordre);
    }

    //Opretter en metode som udskriver vores ordreliste.
    public static void udskrivOrdreListen(){
        OrdreListe.sort(Comparator.comparing(Ordre::fåAfhentningsTid));
        for (Ordre ordre : OrdreListe) {
            ordre.visOrdre();
        }
    }

    //Laver en metode hvor vi kan fjerne en ordre fra ordrelisten.
    public static void fjernOrdreFraListe(int nummer) {
        int temp = -1;
        for (Ordre ordre : OrdreListe) {
            if (nummer==ordre.fåOrdreId()){
                temp = OrdreListe.indexOf(ordre);
            }
        }
        OrdreListe.remove(temp);
        System.out.println("Ordren er nu slettet.");
    }

    //Laver en metode der gør man kan afslutte en ordre og gemme de nødvendige salgsdata.
    public static void FærdiggørOrdreFraListe(int nummer){
        int temp = -1;
        for (Ordre ordre : OrdreListe) {
            if (nummer==ordre.fåOrdreId()){
                temp = OrdreListe.indexOf(ordre);
            }
        }

        Salgsdata.tilføjOmsætning(OrdreListe.get(temp).fåTotalPrisOrdre());
        OrdreListe.get(temp).tilføjPizzaSalg();
        Main.tempOrdre = OrdreListe.get(temp);
        OrdreListe.remove(temp);
        System.out.println("Ordren er nu fjernet og data er talt op");
    }

    //Laver en getter der får ordrelisten.
    public static ArrayList<Ordre> fåOrdreliste(){
        return OrdreListe;
    }


}
