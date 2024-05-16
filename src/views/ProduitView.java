package views;

import entities.Produit;

public class ProduitView extends ViewImp<Produit>{
    @Override
    public Produit saisi(){
        Produit produit = new Produit();
        System.out.println("Entrer le liblle du produit");
        produit.setLibelle(scanner.nextLine());
        System.out.println("Entrer la qte en Stock du produit");
        produit.setQteStock(scanner.nextInt());
        System.out.println("Entrer le prix du produit");
        produit.setPrix(scanner.nextDouble());
        scanner.nextLine();
        return produit;
    }

}
