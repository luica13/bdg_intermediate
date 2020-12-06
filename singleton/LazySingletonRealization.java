package main;

public class LazySingletonRealization {

    private static  LazySingletonRealization instance;

    private LazySingletonRealization(){}

    public static LazySingletonRealization getInstance(){
        if(instance == null) {
            instance = new LazySingletonRealization();
        }
        return instance;
    }
}
