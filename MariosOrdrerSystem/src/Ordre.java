import java.util.ArrayList;
//Laver en class der laver en liste over pizzaer i en ordre.
public class Ordre {
    ArrayList<Pizza> pizzaerIOrdre;

   Ordre(ArrayList<Pizza> pizzaerIOrdre) {
this.pizzaerIOrdre = pizzaerIOrdre;

   }

//Metode til at tilføje en pizza til en ordre
    public void addPizza(Pizza pizza){
       this.pizzaerIOrdre.add(pizza);
    }

//Metode til at vise alle pizzaer i ordren
public void visOrdre(){
    System.out.println("Her der din ordre");
       for (Pizza pizza : pizzaerIOrdre){
           System.out.println(pizza.kortPizzaString());
       }
}


}
