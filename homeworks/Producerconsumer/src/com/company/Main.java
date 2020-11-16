package com.company;

public class Main {
// usumnasirel em yst axbyuri ` https://www.geeksforgeeks.org/understanding-threads-on-producer-consumer-problem-java/
//    nerkayacvac xndir@ der asinxron ashxatanqn e irakanacnum
   public static void main(String[] args)
    {
        Producer p = new Producer();
        p.start();
        Consumer c = new Consumer(p);
        c.start();
    }
}
