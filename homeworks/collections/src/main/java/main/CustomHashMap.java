package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


class Person{

    private String name;
    public Person(String value){

        name=value;
    }
    String getName(){return name;}
}


public class CustomHashMap{

    public static void main(String[] args) {

        Map<Integer, String> states = new HashMap<Integer, String>();
        states.put(1, "Germany");
        states.put(2, "Spain");
        states.put(4, "France");
        states.put(3, "Italy");


        String first = states.get(2);
        System.out.println(first);

        Set<Integer> keys = states.keySet();

        Collection<String> values = states.values();

        boolean q=states.containsKey(6);
        System.out.println(q);
        boolean q1=states.isEmpty();
        System.out.println(q1);
        int c=states.size();
        System.out.println(c);

        states.replace(1, "Poland");

        states.remove(2);
        System.out.println(states.size());

        for(Map.Entry<Integer, String> item : states.entrySet()){

            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
        }

        Map<String, Person> people = new HashMap<String, Person>();
        people.put("1240i54", new Person("Tom"));
        people.put("1564i55", new Person("Bill"));
        people.put("4540i56", new Person("Nick"));

        for(Map.Entry<String, Person> item : people.entrySet()){

            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
        }
    }
}
