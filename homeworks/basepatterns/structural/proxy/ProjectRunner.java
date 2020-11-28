package patterns.basepatterns.structural.proxy;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new ProxyProject("https://www.github.com/luicia13/branches");
        //comment and uncomment project.run() method and we see that proxy object is created!!!
        project.run();
    }
}
