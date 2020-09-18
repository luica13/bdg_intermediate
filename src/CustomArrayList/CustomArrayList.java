package CustomArrayList;

import java.util.Iterator;

public class CustomArrayList<E> implements Simple<E> {

    //make as a array
    private  E[] values;

    //constructor
   public CustomArrayList(){
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {

       try{
           //dynamicaly array
           E[] temp = values;
           values = (E[]) new Object[temp.length + 1]; //adding one element
           System.arraycopy(temp,0,values,0,temp.length); //copy all arguments from temp to values
           values[values.length -1] = e;
           return true;
       }catch(ClassCastException ex){
           ex.printStackTrace();
       };
       return  false;
    }

    @Override
    public void delete(int index) {
       try {
           //dynamicaly array
           E[] temp = values;
           values = (E[]) new Object[temp.length - 1]; //removing one element
           System.arraycopy(temp,0,values,0,index); //copy untill removing element
           int afterIndex = temp.length - index - 1;
           System.arraycopy(temp,index + 1,values,index,afterIndex); //copy after removing index
       }catch(ClassCastException ex){
           ex.printStackTrace();
       };
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
         values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    public static void main(String[] args) {
        Simple<String> strings = new CustomArrayList<>();

        strings.add("Yerevan");
        strings.add("Abovyan");
        strings.add("Kirovakan");

        System.out.println(strings.get(2));
        System.out.println(strings.size());
        strings.delete(1);
        for(String k : strings){
            System.out.println(k);
        }
    }
}
