package com.wushen.desinpattern.template;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 21:34
 */
public abstract class SoyMilk {
    // 模板方法,make,模板方法可以做成final,不让子类去覆盖
    final void make(){
        select();
        addCondiments();
        soak();
        beat();
    }

    // 选材料
    void select(){
        System.out.println("第一步：选择好的新鲜黄豆 ");
    }

    // 添加不同的配料,抽象方法,子类具体实现
    abstract void addCondiments();

    // 浸泡
    void soak(){
        System.out.println("第三步：黄豆和配料开始浸泡，需要3 个小时");
    }

    // 打浆
    void beat(){
        System.out.println("第四步：黄豆和配料放到豆浆机去打碎");
    }
}
