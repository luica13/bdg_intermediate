package patterns.basepatterns.creational.abstractFactory.banking;

import patterns.basepatterns.creational.abstractFactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Banking PM manages banking project...");
    }
}
