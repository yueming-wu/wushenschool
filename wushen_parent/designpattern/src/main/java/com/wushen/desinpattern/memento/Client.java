package com.wushen.desinpattern.memento;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 22:30
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("状态1:攻击力为100");
        Memento memento = originator.saveState();
        caretaker.add(memento);
        System.out.println(originator.getState());
        originator.setState("状态2:攻击力为80");
        caretaker.add(originator.saveState());
        System.out.println(originator.getState());
        originator.setState("状态3:攻击力为50");
        caretaker.add(originator.saveState());
        System.out.println(originator.getState());
        System.out.println("恢复转态到2");
        originator.getStateFromMemento(caretaker.getIndexMemento(1));
        System.out.println(originator.getState());
    }
}
