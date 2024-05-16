import java.util.Scanner;

import entities.Commande;
import entities.Facture;
import entities.Paiement;
import entities.Produit;
import entities.ProduitCommande;
import services.CommandeService;
import services.ProduitService;
import views.CommandeView;
import views.ProduitView;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ProduitView produitView = new ProduitView();
        CommandeView commandeView = new CommandeView();
        CommandeService commandeService = new CommandeService();
        ProduitService produitService = new ProduitService();

        produitView.setScanner(scanner);

        int choice;
        do {
            choice = menu();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    produitService.add(produitView.saisi());
                }
                case 2 -> {
                    produitView.afficher(produitService.lister());
                }
                case 3 -> {
                    System.out.println("Les produits:");
                    for (Produit produit : produitService.lister()) {
                        if (produit == null)
                            break;
                        System.out.println(produit);
                    }
                    Commande commande = commandeView.saisi();
                    System.out.print("Entrer le libelle du produit:");
                    String libelle = scanner.nextLine();
                    Produit produit = produitService.getBy(libelle);
                    if (produit == null) {
                        System.out.println("Produit inexistant!!!");
                    } else {
                        System.out.println(produit);
                        System.out.print("Entrer la qte a acheter:");
                        int qteAcheter = scanner.nextInt();
                        ProduitCommande produitCommande = new ProduitCommande(qteAcheter);
                        // Produit vers ProduitCommande
                        produit.add(produitCommande);
                        // ProduitCommande => Produit
                        produitCommande.setProduit(produit);
                        // ProduitCommande => Commande
                        produitCommande.setCommande(commande);
                        // Commande => ProduitCommande
                        commande.add(produitCommande);
                        Facture facture = new Facture();
                        // ajout de la commande
                        commandeService.add(commande);
                        }
                        

                        // for (Produit prod : produitService.lister()) {
                        //     if (prod == null)
                        //         break;
                        //     else {
                        //         // prod.getProduitCommandes().
                        //         if (prod.getLibelle().compareToIgnoreCase(libelle) == 0) {
                        //             produitCommande.setProduit(prod);
                        //         } else {
                        //             // Produit vers ProduitCommande
                        //             produit.add(produitCommande);
                        //             // ProduitCommande => Produit
                        //             produitCommande.setProduit(produit);
                        //             // ProduitCommande => Commande
                        //             produitCommande.setCommande(commande);
                        //             // Commande => ProduitCommande
                        //             commande.add(produitCommande);
                        //             // ajout de la commande
                        //             commandeService.add(commande);
                        //         }
                        //     }
                        // }
                    }
                case 4 -> {
                    commandeView.afficher(commandeService.lister());
                }
                case 5 -> {
                    System.out.print("Entrer le numero de la commande:");
                    String num = scanner.nextLine();
                    Commande commande = commandeService.getBy(num);
                    if (commande!=null) {
                        for (ProduitCommande produitCommande : commande.getProduitCommandes()) {
                            if (produitCommande==null) break;
                            else{
                                System.out.println("[Libelle = " + produitCommande.getProduit().getLibelle()
                                + ", Qte Vendue = " + produitCommande.getQteProduit() + ", Montant = "
                                + produitCommande.getMontant() + "]");
                            }
                            System.out.println("Total Commande : " + commande.getMontant());
                        }
                    }else{
                        System.out.println("Commande Introuvable!!!");
                    }
                }
                case 6 -> {
                    System.out.print("Entrer le numero de la commande:");
                    String num = scanner.nextLine();
                    Commande commande = commandeService.getBy(num);
                    if (commande!=null) {
                        if (countItem(commande.getFacture().getPaiements()) != 0){

                            for (Paiement paiement : commande.getFacture().getPaiements()) {
                                if (paiement != null) {
                                    System.out.println(paiement);
                                }
                            }
                        }else{
                            System.out.println("Aucun paiement");
                        }
                    }else{
                        System.out.println("Commande Introuvable!!!");
                    }
                }
                case 7 -> {
                    System.out.print("Entrer le numero de la commande:");
                    String num = scanner.nextLine();
                    Commande commande = commandeService.getBy(num);
                    if (commande != null) {
                        System.out.println(commande.getFacture());
                        if (commande.getFacture().getMontant() > 0){
                            Paiement paiement = new Paiement();
                            do {
                                System.out.println("Montant A Payer ?");
                                paiement.setMontantVerser(scanner.nextDouble());
                                if (paiement.getMontantVerser() > commande.getFacture().getMontant()){
                                    System.out.println("Le montant peut pas dépasser " + commande.getFacture().getMontant());
                                }
                            } while (paiement.getMontantVerser() > commande.getFacture().getMontant() || paiement.getMontantVerser() <= 0);
                            commande.getFacture().add(paiement);
                        }else{
                            System.out.println("Cette Commande est deja solde");
                        }
                    } else {
                        System.out.println("commande non trouvé");
                    }
                }
                default -> {
                }
            }
        } while (choice != 8);
    }

    public static int menu() {
        System.out.println("1- Creer un produit");
        System.out.println("2- Lister les produits");
        System.out.println("3- Créer une commande ");
        System.out.println("4- Lister les commandes");
        System.out.println("5- Lister les produits d’une commande");
        System.out.println("6- Lister les Paiements du commande");
        System.out.println("7- Faire un paiement d une commande");
        System.out.println("8- Quitter");
        System.out.print("Enter your choice : ");
        return scanner.nextInt();
    }

    public static int countItem(Paiement[] tableau){
        int counter = 0;
        for (Paiement paiement : tableau) {
            if (paiement != null){
                counter++;
            }
        }
        return counter;
    }
}
