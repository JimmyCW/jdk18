package com.wx.jddk.run;

public class ThreadLocal {
    public static void main(String[] args) {
        new Thread(()->{
            AMessage aMessage = new AMessage();
            aMessage.setNote("aaaa");
//            MyUtil.set(aMessage);
            ThreadLocalMyUtil.set(aMessage);
            MessageConsumer.consumer();
        }, "th1").start();

        new Thread(()->{
            AMessage aMessage = new AMessage();
            aMessage.setNote("bbbb");
//            MyUtil.set(aMessage);
            ThreadLocalMyUtil.set(aMessage);
            MessageConsumer.consumer();
        }, "th2").start();
    }


}
class MessageConsumer {
    public static void consumer(AMessage aMessage) {
        aMessage.printNote();
    }

    public static void consumer() {
//        MyUtil.aMessage.printNote();
//        ThreadLocalMyUtil.aMessage.get().printNote();
        ThreadLocalMyUtil.get().printNote();
    }
}

class MyUtil {
    public static AMessage aMessage;
    public static void set(AMessage aMessage1) {
        aMessage = aMessage1;
    }

    public static AMessage get() {
        return aMessage;
    }
}

class ThreadLocalMyUtil {
    public static java.lang.ThreadLocal<AMessage> aMessage = new java.lang.ThreadLocal<>();
    public static void set(AMessage aMessage1) {
        aMessage.set(aMessage1);
    }

    public static AMessage get() {
        return aMessage.get();
    }
}

class AMessage {
    private String note;

    public void setNote(String note) {
        this.note = note;
    }

    public void printNote() {
        System.out.println(Thread.currentThread().getName() + "===" + note);
    }
}
