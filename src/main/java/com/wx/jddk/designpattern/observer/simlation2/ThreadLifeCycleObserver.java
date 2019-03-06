package com.wx.jddk.designpattern.observer.simlation2;

import java.util.List;
import java.util.Optional;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object lock = new Object();

    public void concurrentQuery(List<String> ids) {
       ids.stream().forEach( id -> {
           new Thread(new ObserverRunnable(this) {
               @Override
               public void run() {
                   try {
                       this.notifyChange(new RunnableEvent(RunnableStatus.RUNNING, Thread.currentThread(), null));
                       Optional.of("ok").ifPresent(System.out::println);
                       this.notifyChange(new RunnableEvent(RunnableStatus.DONE, Thread.currentThread(), null));
                   } catch (Exception e) {
                        this.notifyChange(new RunnableEvent(RunnableStatus.ERROR, Thread.currentThread(), e));
                   }
               }
           }, id).start();
       });
    }


    @Override
    public void onEvent(ObserverRunnable.RunnableEvent event) {
        synchronized (lock) {
            if(event.getCause() == null) {
                System.out.println("ok");
            } else {
                System.out.println("fail");
            }
        }
    }
}
