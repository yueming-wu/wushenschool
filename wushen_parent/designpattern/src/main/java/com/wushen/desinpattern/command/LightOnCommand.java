package com.wushen.desinpattern.command;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 8:25
 */
public class LightOnCommand implements Command {
    // 聚合 LightReceiver
    LightReceiver light;

    // 构造器
    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        // 调用接收者的方法
        light.on();
    }

    @Override
    public void undo() {
        // 调用接收者的方法
        light.off();
    }
}
