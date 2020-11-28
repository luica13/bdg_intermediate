package patterns.basepatterns.creational.abstractFactory;

public interface ProjectTeamFactory {
    Developer getDeveloper();
    ProjectManager getProjectManager();
    Tester getTester();

}
