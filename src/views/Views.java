package views;


public interface Views<T> {
    T saisi();
    void afficher(T[] tabObj);
}