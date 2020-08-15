package com.wushen.desinpattern.command;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 8:24
 */
public interface Command {
    // 执行动作（操作）
    void execute();
    // 撤销动作（操作）
    void undo();
}
