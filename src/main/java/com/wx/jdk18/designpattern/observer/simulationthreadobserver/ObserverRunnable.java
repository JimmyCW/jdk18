package com.wx.jdk18.designpattern.observer.simulationthreadobserver;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public abstract class ObserverRunnable implements Runnable {

    protected final LifeCycleListener lifeCycleListener;

    public ObserverRunnable(final LifeCycleListener lifeCycleListener) {
        this.lifeCycleListener = lifeCycleListener;
    }

    protected void notifyChange(final RunnableEvent runnableEvent) {
        lifeCycleListener.onEvent(runnableEvent);
    }

    public enum RunnableState {
        RUNNING, ERROR, DONE;
    }

    public static class RunnableEvent {
        private final RunnableState runnableState;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState runnableState, Thread thread, Throwable cause) {
            this.runnableState = runnableState;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getRunnableState() {
            return runnableState;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}
