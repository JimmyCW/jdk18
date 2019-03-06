package com.wx.jddk.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weixing
 * @date 2018/12/4
 **/
public class FlyWeightFactory {
    private Map<String, FlyWeight> flyWeightMap = new HashMap<>();
    public FlyWeight build(String status) {
        FlyWeight flyWeight = flyWeightMap.get(status);
        if(flyWeight == null) {
            flyWeight = new ConcreteFlyWeight(status);
            flyWeightMap.put(status, flyWeight);
        }
        return flyWeight;
    }


}
