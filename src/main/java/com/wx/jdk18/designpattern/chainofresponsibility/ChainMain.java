package com.wx.jdk18.designpattern.chainofresponsibility;

/**
 * @author weixing
 * @date 2019/2/22
 **/
public class ChainMain {

    public static void main(String[] args) {
        Support a = new LimitSupport("a", 10);
        Support b = new NoSupport("b");
        Support c = new SpecialSupport("c", 13);
        Support d = new OddSupport("d");
        Support e = new SpecialSupport("e", 14);
        a.setNext(b).setNext(c).setNext(d).setNext(e);

        for (int i = 10; i < 20; i++) {
            a.support(new Trouble(i));
            System.out.println("--------------------------");
        }

    }

}
