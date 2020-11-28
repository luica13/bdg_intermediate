package patterns.basepatterns.creational.abstractFactory.banking;

import patterns.basepatterns.creational.abstractFactory.Developer;

public class JavaDeveloper  implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes java code...");
    }
}
