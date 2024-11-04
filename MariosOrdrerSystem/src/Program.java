import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.concurrent.ForkJoinPool;

public class Program {
    private static boolean iGang = true;
    //Laver en metode til at vise User Interface.
    public static void visUI() {
        System.out.println("\u001B[33m" + "1: Vis menukort" + "\u001B[0m");
        System.out.println("\u001B[32m" + "2: Tilføj en ordre" + "\u001B[0m");
        System.out.println("\u001B[32m" + "3: Færdiggør ordre" + "\u001B[0m");
        System.out.println("\u001B[34m" + "4: Vis ordreliste" + "\u001B[0m");
        System.out.println("\u001B[31m" + "5: Fjern ordre" + "\u001B[0m");
        System.out.println("\u001B[32m" + "6: Vis regnskab" + "\u001B[0m");
        System.out.println("\u001B[36m" + "7: Genskab sidste fjernet ordre" + "\u001B[0m");
        System.out.println("\u001B[31m" + "8: Stop program" + "\u001B[0m");
    }
    //Laver en metode der tilføjer en ordre samt giver mulighed for at fjerne en tilføjet pizza til ordren.
    public static void tilføjOrdre() {
        Scanner sc = new Scanner(System.in);
        String tempsvar;
        boolean iGang = true;
        Pizza.getMenu();
        System.out.println("Skriv nummeret på den/de pizzaer du vil tilføje til ordren");
        System.out.println("Tast 's' for at slette den sidste tilføjede pizza");
        System.out.println("Tast '0' når du er færdig med ordren: ");
        ArrayList<Pizza> temp = new ArrayList<>();
        while (iGang) {
            try {
                tempsvar = sc.nextLine();
                if (tempsvar.equalsIgnoreCase("s")) {
                    if (!temp.isEmpty()) {
                        temp.remove(temp.size() - 1);
                        System.out.println("Sidst tilføjede pizza er fjernet fra ordren.");
                    } else {
                        System.out.println("Ordren er allerede tom.");
                    }
                } else if (Integer.valueOf(tempsvar) == 0) {
                    iGang = false;
                    OrdreListe.tilføjOrdre(new Ordre(temp));
                    System.out.println("Ordren er nu tilføjet til ordrelisten.");
                } else if (Integer.valueOf(tempsvar) > 0 && Integer.valueOf(tempsvar) <= Pizza.fåMenuArray().size()) {
                    temp.add(Pizza.fåMenuArray().get(Integer.valueOf(tempsvar) - 1));
                    System.out.println("Tilføjer pizza til ordren...");
                } else {
                    System.out.println("Den pizza eksisterer ikke!");
                }
            } catch (Exception e) {
                System.out.println("Forkert input!");
                sc.nextLine();
            }
        }
    }
    //Laver en metode der afslutter en ordre, samt gemmer salgsdata.
    public static void færdiggørOrdre() {

        if (OrdreListe.fåOrdreliste().size() < 1) {
            System.out.println("Der er ingen aktive ordrer!");
        } else {
            Scanner sc = new Scanner(System.in);
            OrdreListe.udskrivOrdreListen();
            System.out.println("Skriv det ordrenummer du vil have fjernet: ");
            int tempsvar = sc.nextInt();
            OrdreListe.FærdiggørOrdreFraListe(tempsvar);
        }

    }
    //Laver en metode der viser alle ordre i en liste.
    public static void visOrdreListe() {
        Scanner sc = new Scanner(System.in);
        boolean visOrdreListeAktiv = true;
        System.out.println("Ordreliste:");
        while (visOrdreListeAktiv) {
            OrdreListe.udskrivOrdreListen();
            System.out.println("Tryk '0' for at gå tilbage til menuen, tryk på alt andet for at opdatere listen");
            String tempsvar = sc.nextLine();
            if (tempsvar.equals("0")) {
                break;
            } else {

            }


        }

    }
    //Laver en metode der sletter en ordre, uden at gemme salgsdata.
    public static void fjernOrdre() {
        if (OrdreListe.fåOrdreliste().size() < 1) {
            System.out.println("Der er ingen aktive ordre!");
        } else {
            Scanner sc = new Scanner(System.in);
            OrdreListe.udskrivOrdreListen();
            System.out.println("Skriv det ordrenummer du vil have fjernet: ");
            int tempsvar = sc.nextInt();
            Main.tempOrdre = OrdreListe.fåOrdreliste().get(tempsvar - 1);
            OrdreListe.fjernOrdreFraListe(tempsvar);
        }

    }
    //Laver en metode der viser vores omsætning og viser total antal pizzaer solgt, koblet til det specifikke pizza-objekt.
    //Indeni er der også en metode for at manuelt kunne opdatere sine salgsdata.
    public static void visRegnskab() {
        Scanner sc = new Scanner(System.in);
        boolean iGang = true;
        System.out.println("Data for hver pizza samt total omsætning: ");
        while (iGang) {
            Pizza.visAntalsolgtePizza();
            Salgsdata.visOmsætning();
            System.out.println("Tryk '0' for at gå tilbage til menuen");
            System.out.println("Tryk '1' for at opdatere omsætning");
            System.out.println("Tryk '2' for at opdatere antal pizzaer solgt");
            String tempsvar = sc.nextLine();
            if (tempsvar.equals("0")) {
                iGang = false;
                break;
            } else if (tempsvar.equals("1")) {
                boolean omsætningLoop = true;
                System.out.println("Hvad vil du opdatere omsætningen til? Tryk på et vilkårligt bogstav for at fortryde");
                while (omsætningLoop) {
                    tempsvar = sc.nextLine();
                    try {
                        Salgsdata.setOmsætning(Integer.valueOf(tempsvar));
                        omsætningLoop = false;
                        break;
                    } catch (Exception e) {
                        System.out.println("forkert input");
                        omsætningLoop = false;
                        break;
                    }
                }


            } else if (tempsvar.equals("2")) {
                boolean pizzaLoop = true;
                System.out.println("Skriv nummeret på den pizza du vil opdatere salg på: ");

                while (pizzaLoop) {
                    try {
                        String tempsvar1 = sc.nextLine();

                        int pizzaNum = Integer.valueOf(tempsvar1);
                        if (pizzaNum <= Pizza.fåMenuArray().size() && pizzaNum > 0) {
                            System.out.println("Skriv antallet af solgte pizzaer: ");

                            String tempsvar2 = sc.nextLine();
                            int antalSolgt = Integer.valueOf(tempsvar2);

                            for (Pizza p : Pizza.fåMenuArray()){
                                if (p.fåPizzaId()==Integer.valueOf(tempsvar1)) {
                                    p.setAntalSolgt(antalSolgt);
                                }
                            }

                            System.out.println("Pizzaen er nu opdateret");
                            pizzaLoop = false;
                        } else {
                            System.out.println("Forkert input, indtast venligst et gyldigt pizzanummer.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Forkert input!");
                        pizzaLoop = false;
                    }catch (IndexOutOfBoundsException e) {
                        System.out.println("Forkert input!");
                        pizzaLoop = false;
                    }
                }
            }

        }

    }
    //Laver en metode der gør at man kan fortryde, hvis man enten har færdiggjort eller fjernet en ordre.
    public static void annullerSidstFjernedeOrdre() {
        Scanner sc = new Scanner(System.in);
        boolean iGang = true;
        OrdreListe.tilføjOrdre(Main.tempOrdre);
        System.out.println("Hvilken en af nedenstående muligheder blev brugt til at fjerne ordren?");
        System.out.println("\u001B[31m" + "'1': for annulleret ordre." + "\u001B[0m");
        System.out.println("\u001B[32m" + "'2': færdiggjort ordre." + "\u001B[0m");
        System.out.println("'0': Gå tilbage.");
        while (iGang) {
            try {
                int tempsvar = sc.nextInt();
                switch (tempsvar) {
                    case 1:
                        System.out.println("Den annullerede ordre er tilføjet tilbage.");
                        iGang = false;
                        break;
                    case 2:
                        Main.tempOrdre.fjernPizzaSalg();
                        Salgsdata.fjernOmsætning(Main.tempOrdre.fåTotalPrisOrdre());
                        System.out.println("Den færdiggjorte ordre er tilføjet tilbage, og salgsdata er opdateret.");
                        iGang = false;
                        break;
                    case 0:
                        iGang = false;
                        break;
                    default:
                        System.out.println("Forkert input!");
                        break;

                }


            } catch (Exception e) {
                System.out.println("Forkert input!");
                sc.nextLine();
            }
        }
    }
    public static void lukprogram(){
        iGang = false;

        Pizza.pizzaSalgMaker();

        try {
            File myObj = new File("MariosOrdrerSystem/Content/src/omsætning.txt");

            // Create the file if it does not exist
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("Omsætning gemt");
            }
            FileWriter myWriter = new FileWriter(myObj);
            if(Salgsdata.getOmsætning()>0){
                myWriter.write(String.valueOf(Salgsdata.getOmsætning()));
            }else {
                myWriter.write(String.valueOf(0));
            }
            myWriter.close();


        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
    public static void startProgram(){
        Scanner sc = new Scanner(System.in);
        Pizza.instansierPizza();
        Salgsdata.opdaterOmsætning();
        Pizza.loadPizza();
        int tempSvar;

        while(iGang) {
            Program.visUI();
            try {
                tempSvar = sc.nextInt();
                switch (tempSvar){
                    case 1:
                        Pizza.getMenu();
                        break;
                    case 2:
                        Program.tilføjOrdre();
                        break;
                    case 3:
                        Program.færdiggørOrdre();
                        break;
                    case 4:
                        Program.visOrdreListe();
                        break;
                    case 5:
                        Program.fjernOrdre();
                        break;
                    case 6:
                        Program.visRegnskab();
                        break;
                    case 7:
                        Program.annullerSidstFjernedeOrdre();
                        break;
                    case 8:
Program.lukprogram();
                        break;
                    default:
                        System.out.println("Forkert input, Tast et nummer fra menuen");
                        break;
                }
            }catch (Exception e) {
                System.out.println("Forkert input!");
                sc.nextLine();
            }
        }
    }
}
