import java.util.ArrayList;
//opretter vores Ordreliste class
public class OrdreListe {
    private static ArrayList<Ordre> OrdreListe = new ArrayList<>();
    public OrdreListe() {

    }

//Opretter en metode som gør at vi kan tilføje en ordre, til vores ordreliste.
public void tilføjOrdre(Ordre ordre) {
        OrdreListe.add(ordre);
}
//Opretter en metode som udskriver vores ordreliste.
public void udskrivOrdreListen(){
        for (Ordre ordre : OrdreListe) {
            ordre.visOrdre();
        }
 }
}
