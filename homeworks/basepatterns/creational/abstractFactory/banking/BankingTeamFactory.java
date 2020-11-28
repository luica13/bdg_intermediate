package patterns.basepatterns.creational.abstractFactory.banking;

import patterns.basepatterns.creational.abstractFactory.Developer;
import patterns.basepatterns.creational.abstractFactory.ProjectManager;
import patterns.basepatterns.creational.abstractFactory.ProjectTeamFactory;
import patterns.basepatterns.creational.abstractFactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }
}
