package services;

import entities.Produit;

public class ProduitService extends ServiceImp<Produit>{
    private static int nbr;
    public ProduitService(){
        tab = new Produit[N];
    }
    @Override
    public boolean add(Produit produit) {
        if (nbr < N) {
            tab[nbr++] = produit;
            return true;
        }
        return false;
    }
    @Override
    public Produit getBy(String libelle){
        for (Produit produit : tab) {
            if (produit!=null && produit.getLibelle().compareToIgnoreCase(libelle)==0) {
                return produit;
            }
        }
        return null;
    }
}
