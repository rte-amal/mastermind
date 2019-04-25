import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args)
    {
        System.out.println("Bienvenue au jeu Masrter Mind");
        System.out.println("Il faut vous devinez le code. Le code est 4 balls colorés.");
        System.out.println("Les couleurs sont : bleu, vert, rouge, orange,  jaune, marron, violet, noir.");





        ArrayList listeDeCode = new ArrayList();
        ArrayList listeDeChoix = new ArrayList();

        ArrayList couleurs = new ArrayList();
        couleurs.add("bleu");
        couleurs.add("vert");
        couleurs.add("rouge");
        couleurs.add("orange");
        couleurs.add("jaune");
        couleurs.add("marron");
        couleurs.add("violet");
        couleurs.add("noir");




        listeDeCode = (ArrayList) proposeCode(couleurs);
        System.out.println(listeDeCode);

        listeDeChoix= (ArrayList) saisirChoix();
        System.out.println(listeDeChoix);

        System.out.println(verifierResultat(listeDeCode, listeDeChoix));







    }

    // Les Methodes :

    // Function proposer le code.
    public static List proposeCode(List listeDeCouleurs)
    {

        int couleurhazar = 0;
        ArrayList code = new ArrayList();
        Random r = new Random();

        for (int i = 0; i < 4; i++)
        {
            couleurhazar = (int) (Math.random() * listeDeCouleurs.size());
            code.add(listeDeCouleurs.get(couleurhazar));
        }
        return code;
    }

    // Function saisir le choix.
    public static List saisirChoix()
    {

        Scanner sc = new Scanner(System.in);
        ArrayList choix = new ArrayList();
        for (int i =0; i<4; i++)
        {
            System.out.println("Entrer votre choix : ");
            String value = sc.nextLine();
            choix.add(value);
        }
        return choix;
    }

    // Function vérifier le résultat.
    public static List verifierResultat(List verifierDeCode, List verifierDeChoix)
    {

        ArrayList resultat = new ArrayList();
        for (int i =0; i<4; i++)
        {
            if (verifierDeCode.get(i).equals(verifierDeChoix.get(i)))
            {
                resultat.add("reussi");
            }
            else
            {
                resultat.add("echoué");
            }
        }

        return resultat;
    }




















}









