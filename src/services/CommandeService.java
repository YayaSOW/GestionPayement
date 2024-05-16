package services;

import entities.Commande;

public class CommandeService extends ServiceImp<Commande> {
    private static int nbr;

    public CommandeService() {
        tab = new Commande[N];
    }

    @Override
    public boolean add(Commande commande) {
        if (nbr < N) {
            tab[nbr++] = commande;
            return true;
        }
        return false;
    }

    @Override
    public Commande getBy(String numero) {
        for (Commande commande : tab) {
            if (commande != null && commande.genereNumero().compareToIgnoreCase(numero) == 0) {
                return commande;
            }
        }
        return null;
    }
}
