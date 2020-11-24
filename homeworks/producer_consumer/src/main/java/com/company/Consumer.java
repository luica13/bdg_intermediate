package com.company;


public class Consumer implements Runnable {
    private Main.PC pc;
    private String name;

    public Consumer(Main.PC pc, String name) {
        this.pc = pc;
        this.name = name;
    }

    public void run() {
        try {
            pc.consume(name);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
