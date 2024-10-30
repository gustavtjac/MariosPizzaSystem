import java.util.ArrayList;
//importerer java's tidsfunktion, så der kan laves et tidspunkt til ordren.
import java.time.*;
//Laver en class der laver en liste over pizzaer i en ordre.
public class Ordre {
    ArrayList<Pizza> pizzaerIOrdre;
    LocalDateTime afhentningsTidspunkt;
    private int totalPrisOrdre = 0;
    private static int antalOrdre = 0;
    private int ordreId;

    //Laver vores constructor
    Ordre(ArrayList<Pizza> pizzaerIOrdre) {
        this.pizzaerIOrdre = pizzaerIOrdre;
        this.afhentningsTidspunkt = LocalDateTime.now().plusMinutes(20);
        antalOrdre++;
        this.ordreId = antalOrdre;
        this.totalPrisOrdre = udregnTotalPrisOrdre();
    }

    //Metode til at tilføje en pizza til en ordre.
    public void addPizza(Pizza pizza) {
        this.pizzaerIOrdre.add(pizza);
    }

    //Metode til at vise alle pizzaer i ordren, derudover også en metode til at vise afhentningstidspunktet.
    public void visOrdre() {
        System.out.println("\u001B[31m" + "Ordrenummer: " + this.ordreId + "\u001B[0m");
        for (Pizza pizza : pizzaerIOrdre) {
            System.out.println(pizza.kortPizzaString());
        }
        System.out.println("\u001B[32m" + "Ordretotal: " + this.totalPrisOrdre + " Kr." + "\u001B[0m");
        System.out.println("\u001B[33m" + "Afhentningstidspunkt: " + this.afhentningsTidspunkt.getHour() + ":" + this.afhentningsTidspunkt.getMinute() + "\u001B[0m");
        System.out.println("-----------------------------");
    }

    //Laver en metode der giver Ordrene et ID.
    public int fåOrdreId() {
        return this.ordreId;
    }

    //Opretter en metode for at kunne finde total-prisen på en ordre.
    public int udregnTotalPrisOrdre() {
        int tempTotal = 0;
        for (Pizza pizza : this.pizzaerIOrdre) {
            tempTotal += pizza.fåPizzaPris();
        }
        return tempTotal;
    }

    //Laver en getter til at kunne få totalprisen.
    public int fåTotalPrisOrdre() {
        return this.totalPrisOrdre;
    }

    //Laver en metode der tilføjer hvilket nummer på en pizza der er blevet solgt.
    public void tilføjPizzaSalg() {
        for (Pizza pizza : this.pizzaerIOrdre) {
            pizza.tilføjSolgtPizza();
        }


    }
    //metode til at fjerne alle pizzaernes salg fra ordren
    public void fjernPizzaSalg() {
        for (Pizza pizza : this.pizzaerIOrdre) {
            pizza.fjernSolgtPizza();
        }

    }
}
