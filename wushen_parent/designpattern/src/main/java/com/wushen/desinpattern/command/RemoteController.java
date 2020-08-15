package com.wushen.desinpattern.command;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 8:30
 */
public class RemoteController {
    // 开按钮的命令数组
    Command[] onCommands;
    // 关按钮的命令数组
    Command[] offCommands;
    // 执行撤销的命令;必须要有
    Command undoCommand;
    // 构造器,完成对按钮的初始化
    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            /*开关命令此时没有任何命令内容*/
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    // 给我们的按钮设置你需要的命令[组命令,打开命令,关闭命令][对应遥控器的数据结构]
    public void setCommand(int no, Command onCommand, Command offCommand){
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }
    // 按下开按钮
    public void onButtonWasPushed(int no){
        // 找到你按下的开的按钮,并调用对应方法
        onCommands[no].execute();
        // 记录这次的操作,用于撤销
        undoCommand = onCommands[no];
    }

    // 按下关按钮
    public void offButtonWasPushed(int no){
        // 找到你按下的开的按钮,并调用对应方法
        offCommands[no].execute();
        // 记录这次的操作,用于撤销
        undoCommand = offCommands[no];
    }
    // 按下撤销按钮
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }
}
