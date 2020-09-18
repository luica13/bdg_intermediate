package CustomArrayList;

public interface Simple<E> extends  Iterable<E>{
  //methods for our ArrayList

    boolean add(E e);
    void delete(int index);
    E get(int index);
    int size();
    void update(int index,E e);
}
