import java.util.Scanner;
import java.util.Random;
public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean spilIgen = true;

        while (spilIgen) {
            int antalGæt = 0;
            //Kalder metoden for velkomst-meddelelse
            welcome();
            //Kalder metoden for valg af sværhedsgrad
            vælgSværhedsgrad();
            //Definerer variabler
            int maxNummer = 0;
            int sværhedsgrad = -1;
            //Starter while løkke som starter forfra hvis brugeren taster et forkert input
            while(sværhedsgrad < 1 || sværhedsgrad > 3){
                if (input.hasNextInt()) {
                    sværhedsgrad = input.nextInt();
                    if (sværhedsgrad < 1 || sværhedsgrad > 3){
                        ugyldigSværhedsgrad();
                        vælgSværhedsgrad();
                    }
                } else {
                    System.out.println("Ugyldigt input, skriv venligst et tal ");
                    input.next();
                }
            }
            //Sætter variablen maxNummer lig med vores metode for valg af sværhedsgrad
            maxNummer = hentSværhedsGrad(sværhedsgrad, maxNummer);
            int randomNum = randomNum(maxNummer);

            //Her holder vi styr om om brugeren har gættet rigtigt, hvor mange forsøg de bruger og om de vil spille igen
            boolean gættetRigtigt = false;
            while (!gættetRigtigt) {
                System.out.println("Gæt et tal mellem 1 og " + maxNummer);
                int spillerGæt = input.nextInt();
                antalGæt++;
                gættetRigtigt = checkSvar(spillerGæt, randomNum);
            }
            System.out.println("Du gættede rigtigt på " + antalGæt + ". forsøg");
            System.out.println("Vil du spille igen? 1: ja 2: nej");
            int spillerValg = input.nextInt();
            spilIgen = spilIgen(spillerValg);
        }
        takForSpillet();
        input.close();

    }
    //Dette printer en velkomstbesked til brugeren
    public static void welcome(){
        System.out.println("Hej og velkommen til !");
        System.out.println("   > Gæt et Tal! < ");
    }//Metoden slutter her

    public static void vælgSværhedsgrad(){
        System.out.println("Vælg venligst en sværhedsgrad: 1(1-10), 2(1-50), 3(1-100) ");
    } // slut for VælgSværhedsGrad

    public static void ugyldigSværhedsgrad(){
        System.out.println("Ugyldigt valg!");
    }

    // Henter brugerens input til at bestemme sværhedsgraden af spillet
    public static int hentSværhedsGrad (int sværhedsgrad, int maxNummer) {

        if (sværhedsgrad == 1) {
            maxNummer = 10;
        } else if (sværhedsgrad == 2) {
            maxNummer = 50;
        } else if (sværhedsgrad == 3) {
            maxNummer = 100;
        }
        else{
            ugyldigtValg();
        }

        return maxNummer;
    }//Metoden for valg af sværhedsgrad slutter her
    //Her laves metoden som printer en besked om ugyldigt valg til brugeren og derefter
    //kalder metoden for valg af sværhedsgrad igen.
    public static void ugyldigtValg(){
        System.out.println("Ugyldigt valg");
        vælgSværhedsgrad();
    }//slut for ugyldigtValg
    // dette giver et tilfældigt nummer til vores spil
    public static int randomNum (int maxNummer) {
        Random randomNum = new Random();
        return randomNum.nextInt(maxNummer) + 1;
    }// slut for randomNum
    // Tjekker brugerens gæt og bruger if og if else statements til at sende den returnerede værdi videre i programmet.
    public static boolean checkSvar(int spillerGæt, int randomNum){
        Scanner input = new Scanner(System.in);
        if (spillerGæt == randomNum){
            System.out.println("Du har gættet rigtigt!");
            return true;
        }
        else if (spillerGæt < randomNum){
            System.out.println("Du har gættet for lavt, prøv igen ");
        }
        else if (spillerGæt > randomNum){
            System.out.println("Du har gættet for højt, prøv igen ");
        }
        return false;
    }// slut for checkSvar

    // angiver om spilleren har lyst til at spille igen
    public static boolean spilIgen(int spilIgen){
        switch (spilIgen){
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("Ugyldigt valg, afslutter spillet");
                return false;
        }
    }// slut for spilIgen

    public static void takForSpillet(){
        System.out.println("Tak for at du ville spille med :)");
    }//slut for takForSpillet
}


