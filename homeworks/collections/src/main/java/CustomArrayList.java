package main;

import  java.util.*;

public class CustomArrayList {
    private  Object store[];
    public  int listSize = 0;
    public CustomArrayList() {
        store = new Object [10]; // DEFAULT_CAPACITY = 10
    }
    public Object  get(int index){
        if(index < listSize ) {
            Object obj = store[index];
            return  obj;
        }
        else throw  new ArrayIndexOutOfBoundsException();
    }

    public void add(Object obj){
        if(store.length-listSize == 0) {
            increaseSize();
        }
        store[listSize ++] = obj;
    }

    public void  increaseSize () {
        store = Arrays.copyOf(store, (int) (store.length*1.5+1));
        System .out.println("\n New store capacity is "+store.length);
    }

    public Object remove(int index ){
        if(index < listSize ){
            Object obj = store[index];
            store[index] = null;

            int temp = index;
            while(temp < listSize ){
                store[temp] = store[temp+1];
                store[temp+1] =null;
                temp++;
            }
            listSize --;
            return obj;
        }
        else throw new ArrayIndexOutOfBoundsException();
    }

    public int size(){
        return listSize;
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        System .out.println("\n list size is " + list.size() + " before adding 11th element");

        list.add(11); // increased size before adding


        System.out.print("list is: ");
        for(int i =0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System .out.println("\n list size is " + list.size() + " now");


        // remove one element
        System.out.println("\n remove "+list.remove (2));
        System.out.print("list is: ");
        for(int j=0;j<list.size();j++){
            System.out.print  (list.get(j)+" ");
        }
        System .out.println("\n list size is " + list.size() + " now");
    }
}