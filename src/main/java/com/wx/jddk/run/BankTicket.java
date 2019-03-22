package com.wx.jddk.run;

/**
 * @author weixing
 * @date 2019/3/17
 **/
public class BankTicket implements Runnable{

    public static void main(String[] args) {
        BankTicket bankTicket = new BankTicket();
        Thread t1 = new Thread(bankTicket, "no 1 ,");
        Thread t2 = new Thread(bankTicket, "no 2 ,");
        Thread t3 = new Thread(bankTicket, "no 3 ,");
        t1.start();
        t2.start();
        t3.start();
    }

    private final static int MAX = 500;

    private int index = 1;

    @Override
    public void run() {
        while (true) {
            if(!ticket()) {
                break;
            }
        }
    }

    private boolean ticket() {
        synchronized (this) {
            if(index <= MAX) {
                System.out.println(Thread.currentThread().getName() + index++);
                return true;
            } else {
                return false;
            }
        }
    }
}
