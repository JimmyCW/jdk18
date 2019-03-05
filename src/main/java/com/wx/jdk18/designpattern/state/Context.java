package com.wx.jdk18.designpattern.state;

/**
 * @author weixing
 * @date 2019/3/3
 **/
public class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void stateTaste() {
        if(state.getState() > 0) {
            state.positive();
        } else {
            state.negative();
        }
    }

    public static void main(String[] args) {
        State state = new State(1);
        Context context = new Context(state);
        context.stateTaste();
        state.setState(-1);
        context.stateTaste();
    }
}
