package patterns.basepatterns.creational.abstractFactory.website;

import patterns.basepatterns.creational.abstractFactory.Developer;
import patterns.basepatterns.creational.abstractFactory.ProjectManager;
import patterns.basepatterns.creational.abstractFactory.ProjectTeamFactory;
import patterns.basepatterns.creational.abstractFactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }
}
