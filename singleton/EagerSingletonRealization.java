package main;

public class EagerSingletonRealization {
    private static final EagerSingletonRealization instance = new EagerSingletonRealization();

    private EagerSingletonRealization(){}

    public static EagerSingletonRealization getInstance(){
        return instance;
    }
}
