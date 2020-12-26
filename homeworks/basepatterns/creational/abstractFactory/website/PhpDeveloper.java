package patterns.basepatterns.creational.abstractFactory.website;

import patterns.basepatterns.creational.abstractFactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer writes php code...");
    }
}
