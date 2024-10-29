import java.util.ArrayList;
import java.util.Scanner;
public class Main {
//Laver en metode til at vise User Interface.
    public static void visUI(){
        System.out.println("1: Vis menukort");
        System.out.println("2: Tilføj en ordre");
        System.out.println("3: Færdiggør ordre");
        System.out.println("4: Vis ordreliste");
        System.out.println("5: Fjern ordre");
        System.out.println("6: Vis regnskab");
    }
//Laver en metode der viser menu.
    public static void visMenu(){
        Pizza.getMenu();
    }
//Laver en metode der tilføjer en ordre.
    public static void tilføjOrdre(){
        Scanner sc = new Scanner(System.in);
        int tempsvar;
        boolean iGang = true;
        visMenu();
        System.out.println("Skriv nummeret på den/de pizzaer du vil tilføje til ordren");
        System.out.println("Tast '0' når du er færdig med ordren: ");
        ArrayList<Pizza> temp = new ArrayList<>();
        while (iGang) {
            try {
                tempsvar = sc.nextInt();
                if (tempsvar == 0) {
                    iGang = false;
                    OrdreListe.tilføjOrdre(new Ordre(temp));
                    System.out.println("Ordren er nu tilføjet til ordrelisten.");

                } else if (tempsvar > 0 && tempsvar<=Pizza.fåMenuArray().size()) {
                    temp.add(Pizza.fåMenuArray().get(tempsvar - 1));
                    System.out.println("tilføjer pizzaer til ordren...");
                }else {
                    System.out.println("Den pizza eksistere ikke!");
                }

            } catch (Exception e) {
                System.out.println("forkert input!");
                sc.nextLine();
            }

        }

    }
//Laver en metode der afslutter en ordre, samt gemmer salgsdata.
    public static void færdiggørOrdre(){

       if (OrdreListe.fåOrdreliste().size()<1){
           System.out.println("Der er ingen aktive ordre");
       }else{
           Scanner sc = new Scanner(System.in);
           OrdreListe.udskrivOrdreListen();
           System.out.println("Skriv det ordrenummer du vil have fjernet");
           int tempsvar = sc.nextInt();
           OrdreListe.FærdiggørOrdreFraListe(tempsvar);
       }

    }
//Laver en metode der sletter en ordre, uden at gemme salgsdata.
    public static void fjernOrdre(){
        if (OrdreListe.fåOrdreliste().size()<1){
            System.out.println("Der er ingen aktive ordre");
        }else{
            Scanner sc = new Scanner(System.in);
            OrdreListe.udskrivOrdreListen();
            System.out.println("Skriv det ordrenummer du vil have fjernet");
            int tempsvar = sc.nextInt();
            OrdreListe.fjernOrdreFraListe(tempsvar);
        }

    }
//Laver en metode der viser alle ordre i en liste.
    public static void visOrdreListe() {
        Scanner sc = new Scanner(System.in);
        boolean visOrdreListeAktiv = true;
        System.out.println("Her er hele Ordrelisten");
        while(visOrdreListeAktiv){
            OrdreListe.udskrivOrdreListen();
            System.out.println("Tryk '0' for at gå tilbage til menuen, tryk på alt andet for at opdatere listen");
            String tempsvar = sc.nextLine();
            if (tempsvar.equals("0")) {
                visOrdreListeAktiv = false;
                break;
            }
            else{

            }



        }

    }
//Laver en metode der viser vores omsætning og viser total antal pizzaer solgt, koblet til det specifikke pizza-objekt.
    public static void visRegnskab(){
        Scanner sc = new Scanner(System.in);
        boolean iGang = true;
        System.out.println("her har du omsætning for pizzariaet samt data for hver pizza");
        while(iGang) {
            Pizza.visAntalsolgtePizza();
            Salgsdata.visOmsætning();
            System.out.println("Tryk '0' for at gå tilbage til menuen, tryk på alt andet for at opdatere listen");
            String tempsvar = sc.nextLine();
            if (tempsvar.equals("0")) {
                iGang = false;
                break;
            }
            else{

            }
        }

    }
//Tilføjer alle vores metoder til vores program, som vi kører i et while-loop.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pizza.instansierPizza();
        int tempSvar;
        boolean iGang = true;
        while(iGang) {
            visUI();
            try {
                tempSvar = sc.nextInt();
                    switch (tempSvar){
                        case 1:
                            visMenu();
                            break;
                        case 2:
                            tilføjOrdre();
                            break;
                        case 3:
                            færdiggørOrdre();
                            break;
                        case 4:
                            visOrdreListe();
                            break;
                        case 5:
                            fjernOrdre();

                            break;
                        case 6:
                            visRegnskab();
                            break;
                        default:
                                System.out.println("Forkert input!");
                            break;
                    }
            }catch (Exception e) {
                System.out.println("Forkert input!!");
                sc.nextLine();
            }
        }
    }
}
