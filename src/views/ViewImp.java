package views;

import java.util.Scanner;

public abstract class ViewImp<T> implements Views<T> {
    protected Scanner scanner;
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void afficher(T[] tabObj) {
        for (T obj : tabObj) {
            if (obj==null) return;
            System.out.println(obj);
        }
    }

    
}
