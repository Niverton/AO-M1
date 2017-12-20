package model.interfaces;

public interface IList<T> {
    public T getObject(int t);

    public void add(T nMO);

    public T getByNameObject(String s);
}
