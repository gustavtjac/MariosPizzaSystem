import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//Opretter en class der indeholder alle pizzaens attributter
public class Pizza {
    private String pizzaName;
    private String pizzaToppings;
    private static ArrayList<Pizza> Menu = new ArrayList<>();
    private static int totalPizzaNummer = 0;
    private int pizzaNummer;
    private int pizzaPris;
    private int antalSolgt;

    //Laver en constructor.
    Pizza(String pizzaName, String pizzaToppings,int pizzaPris) {
        this.pizzaName = pizzaName;
        this.pizzaToppings = pizzaToppings;
        this.pizzaNummer = totalPizzaNummer + 1;
        this.pizzaPris = pizzaPris;

        totalPizzaNummer++;
        Menu.add(this);

    }
    public static void loadPizza() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Gustavo Rock\\Desktop\\skuul\\MariosPizzaSystemR\\MariosOrdrerSystem\\pizzasalg\\all_pizza_sales.txt", StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String pizzaID = parts[0].trim(); // Extracted ID from file
                    int salesCount = Integer.parseInt(parts[1].replace(" Solgte", "").trim());

                    boolean pizzaFound = false;

                    for (Pizza pizza : Menu) {
                        String menuPizzaID = pizza.filPizzaNavn().trim();

                        if (menuPizzaID.equals(pizzaID)) {
                            pizza.setAntalSolgt(salesCount);
                            pizzaFound = true;
                            break;
                        }
                    }

                    if (!pizzaFound) {
                        System.out.println("No matching pizza found for ID: " + pizzaID);
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }

            System.out.println("All pizza sales data loaded successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
    public String filPizzaNavn(){
        return String.valueOf(this.pizzaNummer);
    }
    //Her laver vi en metode hvorpå vi instansierer alle vores pizzaer.
    public static void instansierPizza() {
        Pizza pepperoni = new Pizza("Pepperoni", "Tomatsovs, Ost og Pepperoni", 95);
        Pizza hawaii = new Pizza("Hawaii", "Tomatsovs, Ost, Skinke og Ananas", 100);
        Pizza margherita = new Pizza("Margherita", "Tomatsovs og Ost", 85);
        Pizza quattroStagioni = new Pizza("Quattro Stagioni", "Tomatsovs, Ost, Skinke, Svampe, og Oliven", 95);
        Pizza capricciosa = new Pizza("Capricciosa", "Tomatsovs, Ost, Skinke og Svampe", 105);
        Pizza diavola = new Pizza("Diavola", "Tomatsovs, Ost, Spicy Salami og Peberfrugt", 110);
        Pizza vegetariana = new Pizza("Vegetariana", "Tomatsovs, Ost, Peberfrugt, Svampe, Løg, og Oliven", 95);
        Pizza prosciutto = new Pizza("Prosciutto", "Tomatsovs, Ost og Skinke", 90);
        Pizza quattroFormaggi = new Pizza("Quattro Formaggi", "Tomatsovs og Fire Oste", 95);
        Pizza marinara = new Pizza("Marinara", "Tomatsovs, Hvidløg og Oregano", 75);
        Pizza funghi = new Pizza("Funghi", "Tomatsovs, Ost og Svampe", 90);
        Pizza tonno = new Pizza("Tonno", "Tomatsovs, Ost, Tun og Løg", 115);
        Pizza napolitana = new Pizza("Napolitana", "Tomatsovs, Ost, Ansjoser og Oliven", 100);
        Pizza rustica = new Pizza("Rustica", "Tomatsovs, Ost, Kartofler og Rosmarin", 95);
        Pizza salsiccia = new Pizza("Salsiccia", "Tomatsovs, Ost og Italiensk Pølse", 110);
        Pizza calzone = new Pizza("Calzone", "Tomatsovs, Ost, Skinke og Svampe (indbagt)", 125);
        Pizza pollo = new Pizza("Pollo", "Tomatsovs, Ost, Kylling og Peberfrugt", 105);
        Pizza mexicana = new Pizza("Mexicana", "Tomatsovs, Ost, Jalapeños, Oksekød og Løg", 115);
        Pizza carbonara = new Pizza("Carbonara", "Tomatsovs, Ost, Pancetta og Æg", 120);
        Pizza parmigiana = new Pizza("Parmigiana", "Tomatsovs, Ost, Aubergine og Basilikum", 95);
        Pizza bufalina = new Pizza("Bufalina", "Tomatsovs, Buffalo Mozzarella og Basilikum", 110);
        Pizza fruttiDiMare = new Pizza("Frutti di Mare", "Tomatsovs, Ost, Fisk og Skaldyr", 130);
        Pizza prosciuttoCrudo = new Pizza("Prosciutto Crudo", "Tomatsovs, Ost og Parmaskinke", 95);
        Pizza cipolla = new Pizza("Cipolla", "Tomatsovs, Ost og Løg", 85);
        Pizza boscaiola = new Pizza("Boscaiola", "Tomatsovs, Ost, Skinke og Champignon", 105);
        Pizza salmone = new Pizza("Salmone", "Tomatsovs, Ost og Røget Laks", 135);
        Pizza gamberi = new Pizza("Gamberi", "Tomatsovs, Ost og Rejer", 130);
        Pizza pesto = new Pizza("Pesto", "Pesto, Ost og Soltørrede Tomater", 100);
        Pizza truffle = new Pizza("Truffle", "Trøffelsovs, Ost og Svampe", 140);
        Pizza gorgonzola = new Pizza("Gorgonzola", "Tomatsovs, Gorgonzola og Valnødder", 120);
        Pizza bacon = new Pizza("Bacon", "Tomatsovs, Ost og Bacon", 100);
    }

    //Opretter en metode til at kunne printe pizzaens attributter i en string som bliver brugt til at instanticiere en menu
    public String getPizzaString() {


        return String.format("\u001B[33m" + "|   %-2d: %-20s |%-50s |Pris: %6d,- %3s", this.pizzaNummer, this.pizzaName, this.pizzaToppings, this.pizzaPris, " |" + "\u001B[0m");
        //return this.pizzaNummer +": "+ this.pizzaName + " " + this.pizzaToppings + " |Pris: " + this.pizzaPris + " Kr";
    }

    //Opretter en metode til at printe pizzaens attributter i en string, uden ingredienserne, for at skabe bedre readability for Mario
    public String kortPizzaString(){
        return "\u001B[34m"+ this.pizzaNummer + ": " + this.pizzaName + "\u001B[0m";
    }

    //En metode for at printe alle instansierede pizzaer.
    public static void getMenu(){
        System.out.println("\u001B[33m" + "___________________________________________________________________________________________________" + "\u001B[0m");
        System.out.println("\u001B[33m" + "|                                              PIZZAER                                            |" + "\u001B[0m");
        System.out.println("\u001B[33m" + "|                                                                                                 |" + "\u001B[0m");
        for(Pizza pizza : Menu){
            System.out.println(pizza.getPizzaString());
        }
        System.out.println("\u001B[33m" + "|_________________________________________________________________________________________________|" + "\u001B[0m");
        System.out.println(" ");
    }

    //Laver en getter der viser menuen.
    public static ArrayList<Pizza> fåMenuArray(){
        return Menu;
    }

    //Laver en getter, for at få pizzaens pris.
    public int fåPizzaPris(){
        return this.pizzaPris;
    }

    //Laver en metode som tilføjer solgte antal pizzaer.
    public void tilføjSolgtPizza(){
        this.antalSolgt++;
    }
    //hvis du vil fjerne et enkelt pizza
    public void fjernSolgtPizza(){
        this.antalSolgt--;
    }
    //Setter til at sætte hvor mange pizzaer der er solgt
    public void setAntalSolgt(int antal){
        this.antalSolgt = antal;
    }

    //Laver en metode som viser total antal pizzaer solgt.
    public int antalSolgtPiza(){
        return this.antalSolgt;
    }

    //Laver en metode som viser total antal pizzaer solgt, koblet til det specifikke pizza-objekt.
    public static void visAntalsolgtePizza(){
        ArrayList<Pizza> temp = new ArrayList<>(Menu);
        temp.sort(Comparator.comparing(Pizza::antalSolgtPiza).reversed());
        System.out.println("________________________________________________");
        for (Pizza pizza : temp){
            System.out.println("\u001B[32m" + "Pizza nummer: "+ pizza.pizzaNummer + " Antal solgt: " + pizza.antalSolgtPiza()+ " stk." + "\u001B[0m");
        }
    }
    public int fåPizzaId(){
        return this.pizzaNummer;
    }
    public static void pizzaSalgMaker() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Gustavo Rock\\Desktop\\skuul\\MariosPizzaSystemR\\MariosOrdrerSystem\\pizzasalg\\all_pizza_sales.txt", StandardCharsets.UTF_8))) {

            for (Pizza pizza : Pizza.fåMenuArray()) {
                String line = pizza.filPizzaNavn() + ": " + pizza.antalSolgtPiza() + " Solgte";
                writer.write(line);
                writer.newLine();

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Pizza salg gemt");
    }

}
