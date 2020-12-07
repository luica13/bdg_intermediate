package main;

public class StaticBlockSingletonRealization {
    private static  StaticBlockSingletonRealization instance;

    static {
        try {
            instance = new StaticBlockSingletonRealization();
        }catch (Exception e) {
            System.out.println("constructorum ban chem grel vor exception gci");
        }
    }

    private StaticBlockSingletonRealization(){}

    public static StaticBlockSingletonRealization getInstance(){
        return instance;
    }
}
