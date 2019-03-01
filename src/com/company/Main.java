package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> couleurs = new ArrayList<>(Arrays.asList("bleu", "vert", "rouge", "orange", "jaune", "marron", "violet", "noir"));
        List<String> codeSecret = new ArrayList<>();
        int nbEssai = 12;

        // Creation du code secret
        for (int i = 0; i < 4; i++) {
            int auHasard = (int) (Math.random() * (couleurs.size()));
            codeSecret.add(couleurs.get(auHasard));
        }

        System.out.println("Liste des couleurs = " + couleurs);
        System.out.println("code secret = " + codeSecret);

        while (nbEssai != 0) {
            System.out.println("Il vous reste " + nbEssai + " essai(s)");
            if (comparer(tentative(), codeSecret) == true) {
                System.out.println("Gagne !");
                break;
            }
            nbEssai -= 1;
        }
        if (nbEssai == 0) {
            System.out.println("Perdu...");
        }
    }

    // Methode permettant de comparer une proposition et le code secret
    public static boolean comparer(List propositions, List codeSecret) {
        int compteur = 0;
        boolean resultat = false;
        for (int i = 0; i < codeSecret.size(); i++) {
            if (propositions.get(compteur).equals(codeSecret.get(compteur))) {
                System.out.println(propositions.get(compteur) + " est bien place");
            } else if (codeSecret.contains(propositions.get(compteur)) && !propositions.get(compteur).equals(codeSecret.get(compteur))) {
                System.out.println(propositions.get(compteur) + " est mal place");
            } else {
                System.out.println(propositions.get(compteur) + " n'est pas dans le code");
            }
            compteur += 1;
            if (codeSecret.equals(propositions)) {
                resultat = true;
            }
        }
        return resultat;
    }

    // Methode permettant d'écrire une proposition et de vérifier si cette dernière est conforme
//    public static List tentative() {
//        List<String> couleurs = new ArrayList<>(Arrays.asList("bleu", "vert", "rouge", "orange", "jaune", "marron", "violet", "noir"));
//        List<String> propositions = new ArrayList<>();
//        Scanner proposition = new Scanner(System.in);
//        String couleurChoisie = "";
//        for (int i = 0; i < 4; i++) {
//            System.out.println("choisissez une couleur");
//            do {
//                couleurChoisie = proposition.nextLine();
//                if (!couleurs.contains(couleurChoisie)) {
//                    System.out.println("veuillez ressaisir un mot parmis les couleurs proposées sans espace ni majuscule");
//                }
//            } while (!couleurs.contains(couleurChoisie));
//            propositions.add(couleurChoisie);
//        }
//        return propositions;
//    }

    // Methode permettant d'écrire une proposition (de 4 couleurs d'un coup) et de vérifier si cette dernière est conforme
    public static List tentative() {
        List<String> couleurs = new ArrayList<>(Arrays.asList("bleu", "vert", "rouge", "orange", "jaune", "marron", "violet", "noir"));
        List<String> propositions = new ArrayList<>();
        Scanner proposition = new Scanner(System.in);
        String couleurChoisie = "";
        while (propositions.size() != 4) {
            propositions.clear();
            System.out.println("Choisissez vos 4 couleurs separé par des virgules (mais sans espace)");
            couleurChoisie = proposition.nextLine();
            couleurChoisie += ",";
            for (int i = 0; i < couleurChoisie.length(); i++) {
                int sub = couleurChoisie.indexOf(",");
                String couleur = couleurChoisie.substring(0, sub);
                couleurChoisie = couleurChoisie.substring(sub + 1);
                if (!couleurs.contains(couleur)) {
                    System.out.println("Erreur : saisie erronné");
                } else propositions.add(couleur);
            }
        }
        return propositions;
    }
}