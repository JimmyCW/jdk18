package com.wx.jdk18.designpattern.observer.simlation2;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public abstract class ObserverRunnable implements Runnable {
    private final LifeCycleListener lifeCycleListener;

    public ObserverRunnable(LifeCycleListener lifeCycleListener) {
        this.lifeCycleListener = lifeCycleListener;
    }

    protected void notifyChange(RunnableEvent event) {
        lifeCycleListener.onEvent(event);
    }

    public enum RunnableStatus {
        RUNNING, ERROR, DONE;
    }

    public static class RunnableEvent {
        private final RunnableStatus runnableStatus;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableStatus runnableStatus, Thread thread, Throwable cause) {
            this.runnableStatus = runnableStatus;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableStatus getRunnableStatus() {
            return runnableStatus;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}
