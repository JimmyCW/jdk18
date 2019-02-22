package com.wx.jdk18.designpattern.chainofresponsibility;

/**
 * @author weixing
 * @date 2019/2/22
 **/
public abstract class Support {

    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {
        if(resolve(trouble)) {
            done(trouble);
        } else if(next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is already resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " is cant resolved by " + this + ".");
    }

    @Override
    public String toString() {
        return "Support{" +
                "name='" + name + '\'' +
                "}";
    }
}
