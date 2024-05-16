package core;

public interface Service<T> {

    boolean add(T object);
    T[] lister();
    T getBy(String critere);
}
