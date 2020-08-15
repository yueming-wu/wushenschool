package com.wushen.desinpattern.command;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 9:15
 */
public class TVOffCommand implements Command {
    // 聚合 TVReceiver
    TVReceiver tv;

    // 构造器
    public TVOffCommand(TVReceiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        // 调用接收者的方法
        tv.off();
    }

    @Override
    public void undo() {
        // 调用接收者的方法
        tv.on();
    }
}
