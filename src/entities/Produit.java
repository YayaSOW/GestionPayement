package entities;

import java.util.Arrays;

public class Produit {
    private int id;
    private String libelle;
    private int qteStock; 
    private double prix; 
    private static int nbProduit;

    //Attribut navigable
    //OneToMany Produit => ProduiCommande
    private static final int N =5;
    private static int nbProduitCommande;
    private ProduitCommande[] produitCommandes=new ProduitCommande[N];
    
    public Produit(String libelle, int qteStock, double prix) {
        this.id = ++nbProduit;
        this.libelle = libelle;
        this.qteStock = qteStock;
        this.prix = prix;
    }

    public Produit() {
        id = ++nbProduit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ProduitCommande[] getProduitCommandes() {
        return produitCommandes;
    }

    public void add(ProduitCommande produitCommande) {
        if (nbProduitCommande<N) {
            produitCommandes[nbProduitCommande++] = produitCommande;
        }
    }

    @Override
    public String toString() {
        return "Produit [id=" + id + ", libelle=" + libelle + ", qteStock=" + qteStock + ", prix=" + prix +"]";
    }
}
