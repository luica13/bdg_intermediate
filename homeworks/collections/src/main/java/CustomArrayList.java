package main;

public class CustomArrayList <T>{
   private T array[] ;
   private int capacity = 2;
   private int size;

   public CustomArrayList(){
       size = 0;
       array = (T[])new Object[capacity];
   }

   public CustomArrayList(int capacity){
       if(capacity < 0)
           throw new IllegalArgumentException();
       size = 0;
       array = (T[])new Object[capacity];
   }

   public T getItem(int index){
       if(index < 0 || index >= size)
           throw new ArrayIndexOutOfBoundsException();
       else return array[index];
   }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
       return capacity;
    }

    public void add(T item){
       if(size <= capacity)
           updateCapacity();
       for(int i = 0; i< capacity; i++) {
           if (array[i] == null) {
               array[i] = item;
               break;
           }
       }
       size++;
    }

    public void add(int index, T value){
       if(index < 0 || index > size)
           throw new ArrayIndexOutOfBoundsException();
       if(index == size) {
           add(value);
           return;
       }
       array[index] = value;
    }

    public void remove(int index){
        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException();
        for(int i = index; i < size - 1; i++) {
            array[i] = array[++i];
            i--;
        }
        size--;
    }
    private void updateCapacity(){
        capacity = capacity * 2;
        T[] tempArray = (T[])new Object[capacity];
        for (int i =0 ; i < size; i++)
            tempArray[i] = array[i];
        array = tempArray;
    }

    public void print(){
        for(int i = 0; i < size; i++)
            System.out.println(array[i]);
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(84);
        list.add(45);
        list.add(2, 11);
        list.remove(4);
        list.print();

    }
}
