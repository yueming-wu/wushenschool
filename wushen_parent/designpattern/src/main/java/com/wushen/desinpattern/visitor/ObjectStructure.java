package com.wushen.desinpattern.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 11:39
 */
public class ObjectStructure {
    /*它管理着很多元素即男人和女人*/
    /*它本身是一个数据结构,存放着是每一个元素,
    每个元素都能接受一个访问者并给出反馈,因此
    客户端只需访问数据结构就可得知访问者及元素
    情况*/
    /*聚合了具体的元素*/
    private List<Person> persons = new LinkedList<>();
    /*向列表中添加元素*/
    public void addAttach(Person person){
        persons.add(person);
    }
    /*删除列表里的元素*/
    public void deleteAttach(Person person){
        persons.add(person);
    }
    /*显示访问者得到的投票结果*/
    public void display(Action action){
        for (Person person : persons) {
            person.accept(action);
        }
    }
}
