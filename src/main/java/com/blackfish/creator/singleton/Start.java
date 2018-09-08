package com.blackfish.creator.singleton;

public class Start {

    public static void main(String[] args) {

        /**
         * 说实在的，单例模式可能是最简单的也是最不易理解的设计模式了。
         * 说他简单，是因为见名知意，单例嘛，就是全局只有一个对象。
         * 就比如我只有一个女朋友，要是有多个女朋友，那可就乱套了。（当然我很爱她，不可能有多个。）
         * 说他不易理解，也是因为过于简单，所以实在是不懂为何这东西也是一个设计模式。
         *
         * 但是既然作为一种设计模式，终归还是有可以学习、使用的地方的。
         * 我也是同大家一样，一起学习
         *
         */

        /**
         * 说到单例模式，我想网上应该有很多例子与资料。
         * 当然，可能会有点重复，但是我还是愿意用我的方式，去解读
         */

        System.out.println("------一定是特别的缘分的分隔线------");

        /**
         * 所谓单例模式，就是说全局只有一个对象。
         * 就比如我们比较常见的网页访问人数的计数器，就肯定是一个单例。
         * 如果不是单例，每一个用户的访问都各自维护自己的计数器，那么将是一个多么愚蠢的事情。
         * 那么怎么去实现单例模式呢？
         * 目前来看被总结起来的分为以下几类：
         * -->1.饿汉式
         * -->2.懒汉式
         * -->3.双重加锁式
         * -->4.静态内部类式
         * -->5.枚举类式
         */

        // 饿汉式
        HungrySingleton.genInstance();

        /**
         * 可能就比较简单，但是还是有几个地方需要注意的：
         * -->1.需要将构造函数进行private。
         * 我们平时在定义类的时候，一般不会去写构造方法。但是又听说new的这个关键字就是在通知JVM去调用构造方法
         * 那又是怎么回事呢？
         * 这是因为JVM会帮我们提供一个默认的无参的构造方法。
         * 所以我们需要重载这个方法，将其置为private
         *
         * -->2.既然是饿汉模式，所以在类加载的时候，就会创建好这个对象
         *
         * 这样看来好像没啥大的问题。但是要是大量的对象都在一开始就创建好了
         * 那么在一开始是否会造成大量的堆内存被占用
         * 而在一开始不见得所有的对象都会被使用到
         * 在这种情况下，对于堆内存的使用其实不是那么友好？
         * 所以我们是不是可以采用一种方式，思路是说，直到需要用到的时候才会被创建。
         * 当然，对象的创建对于使用者来说肯定是无感知的，这就是懒汉式
         */

        // 懒汉式
        LazySingleton.getInstance();

        /**
         * 这样一来，直到被需要的时候，才会被创建对象。
         * 我们都知道，在Java后端开发当中，Servlet可是最核心的组件了。
         * 而Servlet也正式采用了这样的单例模式。
         * 在标准的Servlet接口，定义了init()  service()  destory()这三个重要的接口
         * 以前看书的时候，有一种说法，叫做"第一次惩罚"
         * 所谓"第一次惩罚"，就是说，在第一次使用对象的时候，因为还涉及到创建对象等一系列工作
         * 所以会导致第一次响应比较慢，而之后的访问就显得很快了。
         * 其实这里就是使用了懒汉式单例模式。
         * 对于Servlet来说，当第一次访问的时候，才会去创建对象，才会去调用init()方法
         * 而之后的访问，就不必再调用init()，直接访问service()方法啦。
         * 当然，所谓的doGet() doPost()那都是被HttpServlet处理的
         */

        System.out.println("------才可以一路走来变成了一家人的分隔线------");

        /**
         * 但是很遗憾的是，目前成熟的做法都不会是这样做的。
         * 啥？可是我觉得很完美呀，为什么不这么做！那不然怎么写！
         * 既然我这么说了，我当然是有我的想法啦。
         * 为什么不这么做呢？我们先来想一个问题。
         * 我们直到，采用单例模式，不仅仅说对于对象的创建交由该对象直接来创建
         * 更重要的是，全局有且仅有一份这样的对象。
         * 那么这是否就意味着，该对象就是一份临界资源、共享资源。
         * 既然看到这几个词，是否就能意识到问题的所在了呢？
         * 没错，就是线程安全的问题。
         * 问题出在哪里呢？我们来看看代码
         * 嗯，就是在 lazySingleton == null 这个判断上。
         * 我们知道，对于单例多线程的访问下，是十分需要注意考虑到并发问题的。
         * 因为，多线程的使用是依赖于时间片，这就造成了线程访问的随机性。
         * 假如现在有线程A和线程B两条线程同时访问LazySingleton.getInstance()
         *
         * 情景是这样的：
         *
         * 时间片轮到ThreadA:ThreadA -> lazySingleton == null
         * 时间片轮到ThreadB:ThreadB -> lazySingleton == null
         *                 ThreadB -> lazySingleton = new LazySingleton()
         *
         * 这个时候因为ThreadA已经判断过lazySingleton == null -> TRUE
         * 所以这个时候ThreadA又会创建一个对象。
         * 这样子就会存在竞争的情况。
         *
         * 那么怎么解决这个问题呢？毫无疑问，加锁！
         */
        SafeLazySingleton.getInstance1();
        SafeLazySingleton.getInstance2();

        /**
         * 这两种方式都是加锁的体现，这样一来通过锁机制，让每一次情况都能按照队列形式进行访问。
         * 虽然吧，是牺牲了一些性能问题，但是好歹是解决了上面的痛点。
         * 但是，在牛逼哄哄的Spring当中，却不是使用这种方式
         * 为什么？
         * 那么来看看下面的实现吧
         */
        SafeAndFastLazySingleton.getInstance();

        /**
         * 在术语上，有一个专有名词，叫做"双重检查锁"，Double-Check-Lock（DCL）。
         * 那么这样子的做法好处是什么呢？
         * 在回答这个问题之前，我们先来看看上面的做法。
         * 上面的做法，无论哪种方法，都是将锁的粒度扩展到方法级别了。
         * 这样本质上是没有错，但是要知道，为了初次创建对象保证线程安全问题进行加锁
         * 但是一旦创建完对象，那么对于后续的线程请求，在不需要创建对象的情况下依然进行同步访问
         * 这就有点得不偿失了。
         *
         * 而DCL的做法是在发现目标对象为null的情况下，进行同步访问
         * 接下来要注意到的是，它的做法是再次判断了一遍
         * 这是因为如果有多个线程都在这个锁的等待队列当中，就要这些线程再次判断
         * 这样就可以避免先前因为控制不好并发问题，造成再次创建对象的问题。
         *
         * 但是有一个地方略微有点不同，不知道有没有注意到，这里使用了volatile这个关键字。
         * volatile确保了目标对象每次都是在主内存当中获取，即取得的是最新的副本。
         * 因为在多线程的环境中，就不得不考虑到Java的内存模型。
         *
         * 在Spring的DefaultSingletonBeanRegistry当中的getSingleton方法当中
         * 如果singletonObjects当中没有目标对象，就是使用DCL方法创建对象
         * 哈哈哈，这个是之前看Spring源码的时候看到的。
         *
         */

        System.out.println("------他多爱你几分你多还他几分的分隔线------");

        /**
         * 这样看应该是没什么问题了。但是还有另外一种更加高效的方式实现单例模式。
         * 这就是静态内部类的实现方式。
         */

        StaticInnerSingleton.getInstance();

        /**
         * 这里就来脑补一下类加载的时机吧：
         * 1.遇到new、get static、put static或invoke static这四条字节码指令。
         * 如果类没有进行过初始化，则需要先对其进行初始化。生成这四条指令的最常见的Java代码场景是：
         * -->使用new关键字实例化对象的时候
         * -->读取或设置一个类的静态字段（被final修饰，已在编译器把结果放入常量池的静态字段除外）的时候
         * -->调用一个类的静态方法的时候
         *
         * 2.使用java.lang.reflect包的方法对类进行反射调用的时候，如果类没有进行过初始化，则需要先触发其初始化。
         *
         * 3.当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
         *
         * 4.当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类。
         *
         * 5.当使用JDK 1.7等动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的解析结果REF_getStatic、REF_putStatic、REF_invokeStatic的方法句柄，并且这个方法句柄所对应的类没有进行过初始化，则需要先触发其初始化。
         * 这5种情况被称为是类的主动引用，注意，这里《虚拟机规范》中使用的限定词是"有且仅有"，那么，除此之外的所有引用类都不会对类进行初始化，称为被动引用。静态内部类就属于被动引用的行列。
         *
         * 好的吧，以上确实都是网上找的资料。
         * 那么我们来看看这里的做法吧。
         * 我们可以看到，这里在调用getInstance()的时候就没有多次new对象
         * 而是直接Holder.singleton。
         * 这样一来就将对象的创建及线程问题交由这个静态内部类来实现了。
         * 根据上面所述的情况，只有在执行这一个语句的时候，才会去加载这个静态内部类
         * 才会去创建这个对象。而JVM在多线程环境中就能保证只有一条线程才会去加载初始化这个类。
         * 这样一来效率就会比DCL的做法快很多，因为是基于JVM层面的同步实现。
         *
         * 虽然效率是上去了，但是静态内部类有一个极大的弊端，就是在于单例对象实现时进行传参。
         * 因为都被private起来了！！！
         *
         */

        System.out.println("------找幸福的可能的分隔线------");

        /**
         * 所以，上面两种办法，看具体情况具体分析使用吧。
         * 最后还有一种枚举类的实现单例模式
         * 但是目前来看，好像也存在比较多的争议，这里就细讲了
         * 介绍一下简单的用法吧。
         */

        EnumSingleton.getObject();

        /**
         * 因为Enum中的实例只能被实例化一次，在访问的时候，会自动调用构造方法被实例化
         * 而且也只会被实例化一次。
         * 这一点相当于也是有JVM机制来保证的。
         */

        System.out.println("------张宇给你们的分隔线------");

        /**
         * 那么，来总结一下吧：
         * 为什么要有单例模式，我觉得可能是有一下几点原因：
         * 1.希望全局有且只有一个对象。
         * 因为只有一个对象，相应的就会减少内存的使用，控制实例数量
         * 此外，也因为只有一个对象，其实只要保证这个对象的管理就好
         * 而多例的情况下，就会变得冗杂不利于管理，而且还容易造成数据不一致性。
         *
         * 2.对象的创建有该对象本身实现并有本身提供方法访问
         * 这样一来，对于对象访问者来说，则无需也无权创建对象。收回对象创建的权力，也是保证对象与对象之间的隔离性。
         * 并且对外都能提供一个稳定、统一的对象。
         *
         */

    }

}
