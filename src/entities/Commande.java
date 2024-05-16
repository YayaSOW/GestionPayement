package entities;

import java.time.LocalDate;

public class Commande {
    private int id;
    private String numero;
    private LocalDate date;
    private double montant; 
    private static int nbCommande;

    // Attributs navigables
        // oneToMany (Commande => ProduitCommande)
        private static final int N = 5;
        private static int nbProduitCommande;
        private ProduitCommande[] produitCommandes = new ProduitCommande[N];

        private Facture facture;

        public Commande() {
            this.id = ++nbCommande;
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

        public ProduitCommande[] getProduitCommandes() {
            return produitCommandes;
        }

        public void add(ProduitCommande produitCommande) {
            if (nbProduitCommande<N) {
                produitCommandes[nbProduitCommande++] = produitCommande;
                // Mettre à jour le montant de la commande
                montant+=produitCommande.getMontant();
            }
        }

        public Facture getFacture() {
            return facture;
        }

        public void setFacture(Facture facture) {
            this.facture = facture;
        }
        public String genereNumero(){
            int size=String.valueOf(id).length();
            return "COM"+"0".repeat(size<=4?4-size:0)+id;
        }

        @Override
        public String toString() {
            return "Commande [id=" + id + ", numero=" + numero + ", date=" + date + ", montant=" + montant + "]";
        }
    }
