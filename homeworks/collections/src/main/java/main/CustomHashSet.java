package main;
import java.util.HashSet;



class TestPerson{
    private String name;
    public TestPerson(String value){
        name=value;
    }
    String getName(){return name;}
}

public class CustomHashSet {

    public static void main(String[] args) {

        HashSet<String> states = new HashSet<String>();


        states.add("Germany");
        states.add("France");
        states.add("Italy");

        boolean isAdded = states.add("Germany");
        System.out.println(isAdded);

        for(String state : states){
            System.out.println(state);
        }

        System.out.printf("Set contains %d elements \n", states.size());
        states.remove("Germany");
        System.out.printf("Set contains %d elements \n", states.size());


        HashSet<TestPerson> people = new HashSet<TestPerson>();
        people.add(new TestPerson("Mike"));
        people.add(new TestPerson("Tom"));
        people.add(new TestPerson("Nick"));
        for(TestPerson p : people){

            System.out.println(p.getName());
        }
    }
}
