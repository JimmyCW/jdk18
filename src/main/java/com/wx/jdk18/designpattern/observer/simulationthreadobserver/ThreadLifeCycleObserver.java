package com.wx.jdk18.designpattern.observer.simulationthreadobserver;

import java.util.List;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object lock = new Object();

    public void concurrentQuery(List<String> ids) {
        if(ids == null || ids.isEmpty()) {
            return;
        }
        ids.stream().forEach(id -> new Thread(new ObserverRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    System.out.println("query for the id :" + id);
                    Thread.sleep(1000L);
                    notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                } catch (Exception e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), null));
                }
            }
        }, id).start());
    }

    @Override
    public void onEvent(ObserverRunnable.RunnableEvent runnableEvent) {
        synchronized (lock) {
            System.out.println("the runnable thread: " + runnableEvent.getThread().getName() + " status: " + runnableEvent.getRunnableState());
            if(runnableEvent.getCause() != null) {
                System.out.println("thread " + runnableEvent.getThread().getName() + " failed");
                runnableEvent.getCause().printStackTrace();
            }
        }
    }
}
