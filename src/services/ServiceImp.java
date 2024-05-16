package services;

import core.Service;

public abstract class ServiceImp<T> implements Service<T> {
    protected static final int N=5;
    protected T[] tab;
    
    @Override
    public T[] lister() {
        return tab;
    }
    
}
