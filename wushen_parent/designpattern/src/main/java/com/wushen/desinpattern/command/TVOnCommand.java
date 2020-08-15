package com.wushen.desinpattern.command;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 9:15
 */
public class TVOnCommand implements Command{
    // 聚合 TVReceiver
    TVReceiver tv;

    // 构造器
    public TVOnCommand(TVReceiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        // 调用接收者的方法
        tv.on();
    }

    @Override
    public void undo() {
        // 调用接收者的方法
        tv.off();
    }
}
