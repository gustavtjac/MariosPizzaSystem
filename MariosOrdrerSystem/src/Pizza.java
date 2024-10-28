import java.util.ArrayList;
//Opretter en class der indeholder alle pizzaens attributter
public class Pizza {
private String pizzaName;
private String pizzaToppings;
private static ArrayList<Pizza> Menu = new ArrayList<>();
private static int totalPizzaNummer = 0;
private int pizzaNummer;

//Laver en constructor.
Pizza(String pizzaName, String pizzaToppings) {

    this.pizzaName = pizzaName;
    this.pizzaToppings = pizzaToppings;
    this.pizzaNummer = totalPizzaNummer + 1;
    totalPizzaNummer++;

    Menu.add(this);
}
//Her laver vi en metode hvorpå vi instansierer alle vores pizzaer.
    public static void instansierPizza() {

        Pizza pepperoni = new Pizza("Pepperoni","Tomatsovs, Ost og Pepperoni");
        Pizza hawaii = new Pizza("Hawaii","Tomatsovs, Ost, Skinke og Ananas");
        Pizza margherita = new Pizza("Margherita", "Tomatsovs og Ost");
        Pizza quattroStagioni = new Pizza("Quattro Stagioni", "Tomatsovs, Ost, Skinke, Svampe, Artiskokker og Oliven");
        Pizza capricciosa = new Pizza("Capricciosa", "Tomatsovs, Ost, Skinke og Svampe");
        Pizza diavola = new Pizza("Diavola", "Tomatsovs, Ost, Spicy Salami og Peberfrugt");
        Pizza vegetariana = new Pizza("Vegetariana", "Tomatsovs, Ost, Peberfrugt, Svampe, Løg, Oliven og Artiskokker");
        Pizza prosciutto = new Pizza("Prosciutto", "Tomatsovs, Ost og Skinke");
        Pizza quattroFormaggi = new Pizza("Quattro Formaggi", "Tomatsovs og Fire Oste");
        Pizza marinara = new Pizza("Marinara", "Tomatsovs, Hvidløg og Oregano");
        Pizza funghi = new Pizza("Funghi", "Tomatsovs, Ost og Svampe");
        Pizza tonno = new Pizza("Tonno", "Tomatsovs, Ost, Tun og Løg");
        Pizza napolitana = new Pizza("Napolitana", "Tomatsovs, Ost, Ansjoser og Oliven");
        Pizza rustica = new Pizza("Rustica", "Tomatsovs, Ost, Kartofler og Rosmarin");
        Pizza salsiccia = new Pizza("Salsiccia", "Tomatsovs, Ost og Italiensk Pølse");
        Pizza calzone = new Pizza("Calzone", "Tomatsovs, Ost, Skinke og Svampe (indbagt)");
        Pizza pollo = new Pizza("Pollo", "Tomatsovs, Ost, Kylling og Peberfrugt");
        Pizza mexicana = new Pizza("Mexicana", "Tomatsovs, Ost, Jalapeños, Oksekød og Løg");
        Pizza carbonara = new Pizza("Carbonara", "Tomatsovs, Ost, Pancetta og Æg");
        Pizza parmigiana = new Pizza("Parmigiana", "Tomatsovs, Ost, Aubergine og Basilikum");
        Pizza bufalina = new Pizza("Bufalina", "Tomatsovs, Buffalo Mozzarella og Basilikum");
        Pizza fruttiDiMare = new Pizza("Frutti di Mare", "Tomatsovs, Ost og Blandet Fisk og Skaldyr");
        Pizza prosciuttoCrudo = new Pizza("Prosciutto Crudo", "Tomatsovs, Ost og Parma Skinke");
        Pizza cipolla = new Pizza("Cipolla", "Tomatsovs, Ost og Løg");
        Pizza boscaiola = new Pizza("Boscaiola", "Tomatsovs, Ost, Skinke og Champignon");
        Pizza salmone = new Pizza("Salmone", "Tomatsovs, Ost og Røget Laks");
        Pizza gamberi = new Pizza("Gamberi", "Tomatsovs, Ost og Rejer");
        Pizza pesto = new Pizza("Pesto", "Pesto, Ost og Soltørrede Tomater");
        Pizza truffle = new Pizza("Truffle", "Trøffelsovs, Ost og Svampe");
        Pizza gorgonzola = new Pizza("Gorgonzola", "Tomatsovs, Gorgonzola og Valnødder");
        Pizza bacon = new Pizza("Bacon", "Tomatsovs, Ost og Bacon");
    }


//Opretter en metode til at kunne printe pizzaens attributter i en string som bliver brugt til at instanticiere en menu
public String getPizzaString() {
    return this.pizzaNummer +": "+ this.pizzaName + " " + this.pizzaToppings;
}
//Opretter en metode til at printe pizzaens attributter i en string, uden ingredienserne, for at skabe bedre readability for Mario
public String kortPizzaString(){
    return this.pizzaNummer + ": " + this.pizzaName;
}

//En metode for at printe alle instansierede pizzaer.
public static void getMenu(){
    System.out.println("Menukort");
    for(Pizza pizza : Menu){
        System.out.println(pizza.getPizzaString());
    }
}

public static ArrayList<Pizza> fåMenuArray(){
    return Menu;
}



}
