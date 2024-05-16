package views;

import entities.Commande;

public class CommandeView extends ViewImp<Commande>{
    @Override
    public Commande saisi(){
        return new Commande();
    }
}
