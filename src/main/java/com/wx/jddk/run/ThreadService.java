package com.wx.jddk.run;

/**
 * @author weixing
 * @date 2019/3/17
 **/
public class ThreadService {

    private Thread forceEndCurRunnableThread;
    private boolean flag = false;

    /**
     * 执行runnable方法
     * @param runnable
     */
    public void execute(Runnable runnable) {
        forceEndCurRunnableThread = new Thread(() ->{
           Thread runner = new Thread(runnable);
           //runner是exethread的守护线程，exe挂，runner over
           runner.setDaemon(true);
           runner.start();
            try {
                //exe要等runner执行完成
                runner.join();
                flag = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        forceEndCurRunnableThread.start();
    }

    public void shutdown(long mills) {
        long curr = System.currentTimeMillis();
        while (!flag) {
            if((System.currentTimeMillis() - curr) >= mills) {
                //这个打断，runner也interrupt
                forceEndCurRunnableThread.interrupt();
                break;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("interrupt the exethread");
                break;
            }
        }
        flag = false;
    }
}
