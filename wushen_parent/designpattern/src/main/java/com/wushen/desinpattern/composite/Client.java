package com.wushen.desinpattern.composite;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 9:58
 */
public class Client {
    public static void main(String[] args) {
        /*创建学校*/
        OrganizationComponent university = new University("清华大学","中国最高等学府");
        /*创建学院*/
        OrganizationComponent computerCollage = new Collage("计算机学院","国家制定专业");
        OrganizationComponent artCollage = new Collage("艺术学院","国家老牌专业");
        /*添加系部门*/
        computerCollage.add(new Department("软件工程部","软件开发"));
        computerCollage.add(new Department("网络工程部","网络维护"));
        artCollage.add(new Department("古代艺术部","古代泼墨画"));
        artCollage.add(new Department("现代艺术部","毕加索抽象画"));
        /*给组织添加具体的非叶子节点*/
        university.add(computerCollage);
        university.add(artCollage);
        /*打印学校及以下的结构*/
//        university.print();
        computerCollage.print();
    }
}
