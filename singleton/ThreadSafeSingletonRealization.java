package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ThreadSafeSingletonRealization {

    private static  ThreadSafeSingletonRealization instance;

    private ThreadSafeSingletonRealization(){
        if(instance != null) {
            throw new UnsupportedOperationException("should not do that");
        }
//        int a = 7;
    }

    public static  ThreadSafeSingletonRealization getInstance(){
        if(instance == null) {
            synchronized(ThreadSafeSingletonRealization.class) {
                if(instance == null ) {
                    instance = new ThreadSafeSingletonRealization();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
//        ThreadSafeSingletonRealization instanceOne = ThreadSafeSingletonRealization.getInstance();
        ThreadSafeSingletonRealization instanceTwo = null;
        try {
            Constructor[] constructors = ThreadSafeSingletonRealization.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (ThreadSafeSingletonRealization) constructor.newInstance();
                break;
            }
        }  catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(instanceTwo == null);

    }
}
