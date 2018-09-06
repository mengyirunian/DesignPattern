package com.blackfish.creator.factoryPattern;

/**
 * 玩过英雄联盟的玩家一定知道，在地图当中，小兵是作为发育、对抗重要的资源角色。
 * 每一波兵线从泉水当中诞生，意味着战争变得愈发残酷刺激。
 * 那么有没有想过，在游戏开发当中，这些小兵又是怎么生产出来的呢？
 * 如果是我，我一定是用工厂模式开发的！
 */
public class Start {

    public static void main(String[] args) {

        // 每一波兵线出来 3个近战兵 3个远程兵 当然还有一个牛逼的法拉利大炮车兵

        // 如果不使用工厂模式

        for (int i = 0; i < 3; i++) {
            Soldier closeCombatSoldier = new CloseCombatSoldier();
            closeCombatSoldier.attack();
            closeCombatSoldier.defense();
        }

        for (int i = 0; i < 3; i++) {
            Soldier longDistanceSoldier = new LongDistanceSoldier();
            longDistanceSoldier.attack();
            longDistanceSoldier.defense();
        }

        /**
         * 会发现，每一次创建小兵，都要主动地通过new的方式
         * 即当前这个Start类十分依赖每种小兵类
         * 那有什么办法能够降低这几者之间的耦合度呢？
         * 这就可以用到我们的工厂模式开发
         */

        // 使用简单工厂模式
        System.out.println("------反正亦是空空空空如也的分隔线------");
        for (int i = 0; i < 3; i++) {
            Soldier closeCombatSoldier = SimpleSoldierFactory.createSoldier(1);
            closeCombatSoldier.attack();
            closeCombatSoldier.defense();
        }

        for (int i = 0; i < 3; i++) {
            Soldier longDistanceSoldier = SimpleSoldierFactory.createSoldier(2);
            longDistanceSoldier.attack();
            longDistanceSoldier.defense();
        }

        /**
         * 每次我只要告诉SimpleSoldierFactory这个工厂类我需要哪一种类型的小兵
         * 它就会乖乖地生产出来
         * 与上面不使用工厂模式不同的是，我不需要再关心这个类型的小兵是怎么创建的
         * 因为Start类没有跟那些小兵类直接关联
         * 而是通过SimpleSoldierFactory进行了解耦
         */

        /**
         * 这样看起来好像没什么问题
         * 但是英雄联盟的玩家可不爽，怎么只有近战兵、远程兵
         * 我牛逼哄哄的法拉利呢！
         * 于是乎，为了安抚这些热衷的玩家
         * 我不得不在SimpleSoldierFactory这个类当中，再创建一个法拉利大炮车兵
         *
         * 各位发现了问题不，就是在维护SimpleSoldierFactory类当中会发现到一个重要的瓶颈
         * 就是如果日后小兵种类不断增加，那么这个SimpleSoldierFactory类的维护会变得越来越臃肿
         * 虽然我已经使用了很优雅的switch语句
         * 但是如果小兵种类增加到100中，那么我就要写上100个case语句
         * 不敢想象！
         *
         * 另外呢，也了解到，这种情况其实是违反了开闭原则
         * 所谓开闭原则，原文是这么描述：
         * Software entities should be open for extension,but closed for modification
         * 软件试题应该对扩展开放，对修改关闭
         * 由此可见，上面的做法确实大大地破坏了"对修改关闭"
         *
         * 那有没有更加可扩展的方式呢？方法还是有的
         *
         * 首先我们来想想显示生活当中的例子，手机。
         * 手机是现在生活当中不可缺少的用品，反正我是离开手机就跟离开氧气一样无法生存。
         * 比如到移动营业厅去买手机，好像见到的都是oppo和vivo，哈哈哈
         * 那比如我想买一个oppo R17手机，然后我跟工作人员说要买这一款。这里如果不考虑存货的情况下。
         * 然后工作人员就是通知oppo公司，然后oppo公司会通知到下面的工厂生产。
         * 同理，如果我要买一个vivo X23，流程也是一样的。
         * 由此可见，这里出现了两个生产手机的工厂，每个工厂生产不同的手机，互不相关
         * 那么运用到上述例子中，会是怎么样子呢？
         */

        System.out.println("------我懵懵懂懂过了一年的分隔线------");

        for (int i = 0; i < 3; i++) {
            SoldierFactory soldierFactory = new CloseCombatSoldierFactory();
            Soldier closeCombatSoldier = soldierFactory.createSoldier();
            closeCombatSoldier.attack();
            closeCombatSoldier.defense();
        }

        for (int i = 0; i < 3; i++) {
            SoldierFactory soldierFactory = new LongDistanceSoldierFactory();
            Soldier longDistanceSoldier = soldierFactory.createSoldier();
            longDistanceSoldier.attack();
            longDistanceSoldier.defense();
        }

        /**
         *  那么这样子有什么不一样吗？
         *  当然不一样，因为代码变多了嘛！
         *  哈哈哈
         *  言归正传，来分析一下。
         *  我们知道之前的写法其实可以看成是一个工厂，由这一个工厂来做对象的创建。
         *  但是现在的做法是，一个兵种由一个工厂来创建。
         *  这样一来，如果需要增加大炮车兵，就不需要修改以前的代码，只需要在创建一个大炮车工厂就好了
         *  如下：
         */

        for (int i = 0; i < 1; i++) {
            SoldierFactory soldierFactory = new FerrariSoldierFactory();
            Soldier ferrariSoldier = soldierFactory.createSoldier();
            ferrariSoldier.attack();
            ferrariSoldier.defense();
        }

        /**
         * 不知道各位有没有发现。如果使用普通工厂方法
         * 当出现需要添加大炮车兵的时候时候，就需要去修改源代码
         * 但是现在只需要新增代码而不用去动原先的代码
         * 这个才是开发当中最希望看到的样子
         * 这也才是符合开闭原则的做法
         *
         *          * 那以上其实是创建单个小兵的做法，但是事实上，其实我们可以作为一个整体来做。
         *          * 玩家们都知道，每次兵线都不一样的，分为有炮车和没有炮车的兵线，交替产生。
         *          * 那么针对这种情况我们可以怎么使用工厂模式呢？
         */

        System.out.println("------这一年似乎没有改变的分隔线------");

        /**
         * 貌似有一些同学提到了抽象工厂模式
         * 没错，上面的两种工厂模式就是"简单工厂模式"和"工厂方法模式"
         * 确实还有一种抽象工厂模式，那么什么叫抽象工厂模式呢
         * 我们先来看看上面讲到的工厂方法模式
         * 咋眼一看，好像是一个很完美的解决方案，而且确实挺符合开闭原则的，好像没啥问题
         * 但是细细一想，如果兵种很多，是不是就会出现很多的工厂类
         * 很多就很多呗，反正还是挺优雅的。
         * 但是这样子，项目当中就有很多类了，难道你没有强迫症吗！！！
         * 我们知道，兵线的创建时有规则的
         * 要么就是三个近战兵+三个远程兵，要么就是三个近战兵+大炮车兵+三个远程兵
         * 那么是否有一个统一的工厂来创建呢？
         * 答案是肯定的，这就是用到了抽象工厂模式
         */

        SoldierLineFactory soldierLineFactory1 = new SoldierLineWithFerrariFactory();
        soldierLineFactory1.createCloseCombatSoldier();
        soldierLineFactory1.createFerrariSoldier();
        soldierLineFactory1.createLongDistanceSoldier();

        SoldierLineFactory soldierLineFactory2 = new SoldierLineWithoutFerrariFactory();
        soldierLineFactory2.createCloseCombatSoldier();
        soldierLineFactory2.createFerrariSoldier();
        soldierLineFactory2.createLongDistanceSoldier();

        /**
         * 因为两种类型的兵线，有一个共同点就是都有三个近战兵+三个远程兵，区别在于有无大炮车兵
         * 所以我写了一个抽象类作为基类
         * 那么问题来了，这样子怎么就不一样了呢？
         *
         * 其实我们可以发现，"工厂方法模式"下，一个工厂只能生产一个种对象
         * 但是在抽象工厂模式下，我们可以生产多个对象。
         * 是否可以理解为，工厂方法模式是一种极端情况的抽象工厂模式
         * 这样一来，如果兵种很多，我们可以将其中一些兵种归类在某一个工厂下生产。
         * 这就是在一定程度上减少"工厂方法模式"下造成大量的工厂类的诟病。
         *
         */

        System.out.println("------守着你离开后的世界空空如也的分隔线------");

        /**
         * 那么，来总结一下吧。
         * 为什么要有工厂模式，我觉得可能是有一下几点原因：
         * 1.希望创建的对象保持统一。正如我们平常所见的工厂一样，
         * 在工厂当中，同一种类型的产品都是一样的，因为一样的流程保持了产品的统一性
         * 在这里也不例外，追求对象的统一性。
         *
         * 2.进行对象之间的解耦。即对象的使用方不应该能够直接创建对象。
         * 对象的创建应该通过其他统一暴露的类来提供接口，那么工厂模式下的工厂类会是一个很好的选择
         * 正如Spring的IOC一样的思路，对象的创建不应该直接使用创建，而是交由Spring容器。
         * 在XML或者Annotation的方式中，进行解耦使用。
         *
         * 3.减少代码量。因为有了工厂的思路，所以一样的流程可以抽象在工厂模式当中
         * 不需要再重复写代码。在存在大量重复创建相同对象的情况下，可以选择工厂模式进行精简。
         *
         * 4.在代码扩展架构上留下便利。正如上面的例子，在使用工厂方法模式中，如果有新的业务
         * 那么使用工厂模式，则可以在不修改原有的业务代码的基础上进行开发。
         *
         * 以上就是我个人的一些小小见解，有什么问题欢迎交流，虚心接受！
         *
         */


    }

}
