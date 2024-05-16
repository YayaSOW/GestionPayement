package entities;

public class ProduitCommande {
    private int qteProduit;
    private double montant;

    //Attribut navigable
    //ManyToOne (ProduitCommande => Commande)
    private Commande commande;
    //ManyToOne (ProduitCommande => Produit)
    private Produit produit;

    public ProduitCommande(int qteProduit) {
        this.qteProduit = qteProduit;
        // montant =qteProduit*produit.getPrix();
        // montant =qteProduit*produit.getPrix();
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getQteProduit() {
        return qteProduit;
    }

    public void setQteProduit(int qteProduit) {
        this.qteProduit = qteProduit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
        montant =qteProduit*produit.getPrix();
    }

    @Override
    public String toString() {
        return "ProduitCommande [montant=" + montant + ", commande=" + commande + ", produit=" + produit + "]";
    }

}
