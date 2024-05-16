package entities;

import java.time.LocalDate;

public class Facture {
    private int id;
    private String numero;
    private LocalDate date;
    private double montant;
    private static int nbFacture;

    //Attribut navigable
    //OneToOne (Facture => Commande)
    private Commande commande;
    //OneToMany (Facture => Paiement)
    private static final int N=5;
    private static int nbrPaiement;
    private Paiement[] paiements = new Paiement[N];

    public Facture() {
        this.id = ++nbFacture;
        this.numero = genereNumero();
        this.date = LocalDate.now();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public Commande getCommande() {
        return commande;
    }
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    public Paiement[] getPaiements() {
        return paiements;
    }
    public void add(Paiement paiement) {
        if (nbrPaiement<N) {
            paiements[nbrPaiement++] = paiement;
            montant-=paiement.getMontantVerser();//diminuer le montant a payer
        }
    }
    public String genereNumero(){
        int size=String.valueOf(id).length();
        return "COM"+"0".repeat(size<=4?4-size:0)+id;
    }
    @Override
    public String toString() {
        return "Facture [id=" + id + ", numero=" + numero + ", date=" + date + ", montant=" + montant + "]";
    }
    
}
