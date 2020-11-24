package com.company;

public class Producer implements Runnable{
    Main.PC pc;

    public Producer(Main.PC pc) {
        this.pc = pc;
    }

    public void run() {
        try {
            pc.produce();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
