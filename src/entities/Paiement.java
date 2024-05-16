package entities;

import java.time.LocalDate;

public class Paiement {
    private double montantVerser;
    private LocalDate datePaiement;
    private static int nbPaiement;
    //Attribut navigable
    //ManyToNoe
    private Facture facture;
    public Paiement(double montantVerser) {
        this.montantVerser = montantVerser;
        this.datePaiement = LocalDate.now();
    }
    public Paiement() {
    }
    public double getMontantVerser() {
        return montantVerser;
    }
    public void setMontantVerser(double montantVerser) {
        this.montantVerser = montantVerser;
    }
    public LocalDate getDatePaiement() {
        return datePaiement;
    }
    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }
    public Facture getFacture() {
        return facture;
    }
    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    @Override
    public String toString() {
        return "Paiement [montantVerser=" + montantVerser + ", datePaiement=" + datePaiement + ", facture=" + facture
                + "]";
    }
}
