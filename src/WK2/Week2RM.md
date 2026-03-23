# Week 2 README — OOP 第二周知识点总结

## 这周到底在学什么？

第二周可以把它理解成一句话：

**对象创建出来以后，程序到底是怎么“拿着它、用它、传它、比较它、继承它、调用它”的。**

也就是说，这一周不只是继续认识“类和对象”，而是开始真正理解：

* 变量里装的到底是不是对象
* `new` 之后对象去了哪里
* 为什么会有 `null`
* `==` 和 `equals()` 到底差在哪
* `this` 到底是谁
* 数组里装的是什么
* 为什么子类可以当父类用
* 什么叫继承、抽象类、多态、动态分派

---

# Part 1. 先建立一个最重要的脑图

## 1.1 Java 里最容易搞混的三样东西

很多初学者会把下面三个东西混在一起：

1. **类 class**：蓝图、模板
2. **对象 object**：根据类造出来的真实东西
3. **引用 reference**：变量里保存的“找到对象的线索”

最简单的理解方式：

* **类** = 房子的设计图
* **对象** = 真正盖出来的房子
* **引用** = 房子的地址

所以：

```java
Robot c3po = new Robot("C3PO");
```

不要一整句混着看，应该拆开看：

* `Robot`：引用类型
* `c3po`：引用变量名
* `new Robot("C3PO")`：创建一个新的对象
* `=`：让 `c3po` 指向这个新对象

**结论：`c3po` 不是对象本身，而是指向对象的引用。**

---

# Part 2. 对象、属性、方法

## 2.1 属性是什么

属性（attributes / fields）描述的是：

**一个对象“有什么”。**

比如 Robot：

* `name`
* `numLegs`
* `powerLevel`

每个对象都有自己的一份属性值。

比如：

```java
Robot a = new Robot("A");
Robot b = new Robot("B");
```

虽然它们都来自同一个类 `Robot`，但：

* `a.name` 和 `b.name` 可以不同
* `a.powerLevel` 和 `b.powerLevel` 也可以不同

这说明：

**对象共享类的“结构”，但不共享自己的“状态”。**

这句话非常重要。

---

## 2.2 方法是什么

方法（methods）描述的是：

**对象“能做什么”。**

比如：

* `talk(String phrase)`
* `charge(float amount)`

方法是和对象交流的主要方式。

你平时写：

```java
c3po.charge(10);
c3po.talk("Hello");
```

其实就是在给对象发送消息，让它执行行为。

---

## 2.3 属性和方法的关系

最通俗的理解：

* **属性** = 当前状态
* **方法** = 改变状态 / 使用状态的动作

例如：

```java
void charge(float amount) {
    powerLevel += amount;
}
```

这里方法 `charge` 就会改变对象自己的 `powerLevel`。

所以对象不是死的值，而是：

**有状态、会变化、会响应消息的实体。**

---

# Part 3. 构造器、实例化、对象生命周期

## 3.1 构造器是干什么的

构造器（constructor）是在对象创建时执行的特殊方法。

它的作用就是：

**给新对象做初始化。**

例如：

```java
Robot(String name) {
    this.name = name;
    numLegs = 2;
    powerLevel = 2.0f;
}
```

对象一出生，就把最基本的信息准备好。

---

## 3.2 `new` 干了什么

```java
Robot c3po = new Robot("C3PO");
```

`new` 至少做了两件关键的事：

1. 在内存里创建对象
2. 调用构造器初始化对象

然后把这个对象的引用交给 `c3po`。

---

## 3.3 对象的生命周期怎么理解

对象不是创建完就立刻消失。

只要**还有引用指向它**，它就还活着。

如果一个对象已经**没有任何引用能再找到它**，那它就会变成“垃圾对象”，之后可能被垃圾回收（garbage collection）。

可以记成一句话：

**对象是否还活着，不看变量名在不在，而看还有没有引用连着它。**

---

# Part 4. 栈和堆：对象到底放哪

这是第二周最核心的理解点之一。

## 4.1 最粗暴但最有效的记法

### 栈 Stack

一般放：

* 局部变量
* 方法参数
* 临时引用
* 方法调用的栈帧

### 堆 Heap

一般放：

* 用 `new` 创建出来的对象
* 数组对象

---

## 4.2 你要形成的画面

```java
Robot c3po = new Robot("C3PO");
```

不是 `c3po` 这个名字里装了整个对象。

而是：

* `c3po` 这个局部变量在栈上
* 真正的 Robot 对象在堆上
* `c3po` 里面存的是“通向这个对象的引用”

所以：

**引用在栈上，对象在堆上。**

这句话你考试和写代码时都要一直记着。

---

## 4.3 为什么方法结束了，对象还可能在

看下面这种思想：

```java
String refA;
{
    String refB = new String("hello");
    refA = refB;
}
```

虽然 `refB` 出作用域了，但对象还没死，因为 `refA` 还指着它。

所以：

* **引用变量**有作用域
* **对象**没有“跟着变量一起立刻消失”

对象只要还能被某个引用找到，就还留在堆里。

---

# Part 5. 引用 reference：变量不是对象本身

## 5.1 一个引用可以给另一个引用

```java
Adder adder = new Adder();
Adder adder2 = adder;
```

这里不是复制出了两个对象。

只是：

* `adder`
* `adder2`

这两个引用都指向同一个对象。

所以改一个对象状态，其实看到的是同一个对象的变化。

---

## 5.2 最容易错的地方

很多人会误以为：

```java
positions[2] = positions[1];
```

是把 `positions[1]` 里的对象“复制”给 `positions[2]`。

其实不是。

这是：

**让两个数组位置都指向同一个对象。**

所以之后如果：

```java
positions[1].move(0, -1);
```

你会发现 `positions[2]` 看到的也是改过后的结果。

因为它们本来就是同一个对象。

---

# Part 6. `null` 到底是什么

## 6.1 最通俗的理解

`null` 表示：

**这个引用现在不指向任何对象。**

例如：

```java
Adder adder = null;
adder.add(1);
```

这会出问题，因为你相当于在说：

“帮我对一个根本不存在的对象调用方法。”

这就会导致空引用错误（通常是 `NullPointerException`）。

---

## 6.2 为什么数组里一开始常常是 null

```java
Robot[] robots = new Robot[3];
```

这里创建的是：

* 一个长度为 3 的数组对象
* 但数组里的每个位置目前只是“3 个引用槽位”
* 这些槽位一开始都还没指向真正的 Robot 对象

所以默认是 `null`。

也就是说：

```java
robots[0]
```

一开始不是一个 Robot，而是一个空引用。

你得再写：

```java
robots[0] = new Robot("C3PO");
```

才真的把一个对象放进去。

---

# Part 7. `==` 和 `equals()` 的区别

这是第二周非常关键、也非常容易丢分的点。

## 7.1 `==` 比较什么

### 对于基本类型

```java
7 == 5 + 2
```

比较的是**值是否相同**。

### 对于引用类型

```java
fooA == fooB
```

比较的是：

**这两个引用是不是指向同一个对象。**

不是比内容。

---

## 7.2 `equals()` 比较什么

`equals()` 一般用来比较：

**两个对象的内容 / 逻辑意义上是否相等。**

比如字符串：

```java
fooC.equals(fooA)
```

比较的是字符内容是不是一样。

---

## 7.3 一句话死记版

* `==`：比是不是**同一个东西**
* `equals()`：比是不是**看起来内容一样**

例如：

```java
String a = "C3PO";
String b = new String("C3PO");
```

* `a == b` 可能是 `false`
* `a.equals(b)` 是 `true`

因为它们可能不是同一个对象，但内容一样。

---

# Part 8. `this` 到底是什么意思

## 8.1 最简单解释

`this` 就是：

**当前这个对象自己。**

谁在调用方法，`this` 就是谁。

---

## 8.2 为什么构造器里常见 `this.name = name`

```java
Robot(String name) {
    this.name = name;
}
```

这里有两个 `name`：

* `this.name`：对象的属性
* `name`：传进来的参数

参数名和属性名撞名了，怎么办？

`this.name` 就明确表示：

“当前对象的那个 `name` 属性。”

所以这句意思是：

**把传进来的参数 name 赋值给当前对象的 name 属性。**

---

## 8.3 `this(...)` 还能调用另一个构造器

例如：

```java
Robot() {
    this("Standard Model");
}
```

这表示：

当前这个无参构造器，不自己重复写初始化逻辑，而是转去调用另一个构造器。

这是一种很常见的“构造器复用”。

---

# Part 9. 数组 arrays

## 9.1 数组在 Java 里也是对象

这点非常重要。

```java
Robot[] robots = new Robot[3];
```

这里创建出来的数组本身也是对象，放在堆上。

数组里装的不是 Robot 实体本身，而是：

**多个 Robot 引用的位置。**

---

## 9.2 创建数组和创建里面元素是两件事

```java
Robot[] robots = new Robot[3];
```

只创建了数组。

```java
robots[0] = new Robot("C3PO");
```

这才创建第一个 Robot 对象。

所以你必须分清：

* 创建容器
* 往容器里放对象

---

## 9.3 增强 for 循环怎么理解

```java
for (Robot robot : robotsB) {
    System.out.println(robot.name);
}
```

意思是：

数组里每次拿出一个元素的引用，暂时叫 `robot`，然后执行循环体。

注意：

这个 `robot` 只是“每轮临时拿到的引用”，不是数组槽位本身。

所以你如果只是改 `robot` 这个变量指向哪，通常不会改掉数组里原本存的引用。

---

## 9.4 为什么下面这样不行

```java
Position[] positions = new Position[3];
for (Position p : positions)
    p = new Position(1, i++);
```

很多人以为这样能初始化数组，实际上不行。

因为这里你改的是循环变量 `p`，不是 `positions[0]`、`positions[1]` 这些数组位置本身。

真正要初始化数组位置，应该用下标：

```java
for (int index = 0; index < positions.length; index++) {
    positions[index] = new Position(1, i++);
}
```

这个坑非常经典。

---

# Part 10. 作用域 scope 和对象持久性 persistence

## 10.1 变量的作用域

局部变量、参数变量都只在自己的代码块或方法里可见。

例如：

```java
{
    String refB = new String("hello");
}
```

出了这个大括号，`refB` 名字就不能再用了。

---

## 10.2 但对象不跟着变量名一起消失

只要别的地方还有引用连着它，对象就还在。

这就叫对象持久性。

你可以理解成：

* “门牌号变量”没了
* 但“房子对象”只要还有别的门牌号指过去，就还在

---

## 10.3 垃圾回收什么时候可能发生

当一个对象已经没有任何引用能到达它时，它才**可能**成为垃圾回收目标。

注意是“可能”，不是“立刻”。

Java 的垃圾回收不是你手动精确控制的。

---

# Part 11. 对象有独立状态

## 11.1 两个对象即使内容一样，也仍然是两个不同对象

例如两个 `Position`：

* 一个是 `(1,2)`
* 另一个也是 `(1,2)`

它们看起来一样，但依旧可能是堆里的两个不同实例。

所以你要分清：

* **对象身份 identity**：是不是同一个对象
* **对象状态 state**：里面数据是不是刚好一样

这是理解 `==` 和 `equals()` 的基础。

---

## 11.2 对象修改是持久的

```java
positions[2].move(1,1);
```

这不是改一个“临时副本”，而是改那个堆里的真实对象。

只要后来你还通过别的引用访问到这个对象，就会看到被改过后的状态。

---

# Part 12. 参数传递：基本类型 vs 对象引用

## 12.1 基本类型传进去，外面通常不变

```java
static int square(int x) {
    x *= x;
    return x;
}
```

这里改的是方法内部那份 `x`。

外面的原变量不受影响。

---

## 12.2 对象传进去，改属性会影响原对象

```java
static int square(Number n) {
    n.x *= n.x;
    return n.x;
}
```

这里 `n` 是一个引用参数。

虽然参数本身也是“值传递”，但传进去的是**引用这个值**。

所以方法里仍然能通过这个引用找到原对象，并改掉它的属性。

于是外面看到的对象也变了。

---

## 12.3 最好记的版本

* 基本类型：传的是数值本身
* 对象类型：传的是“引用的副本”
* 但这个引用副本仍然指向同一个对象

所以：

**不是对象整体被复制过去了，而是“通往同一个对象的地址线索”被复制过去了。**

---

# Part 13. 继承 inheritance

现在进入第二周后半部分最核心的 OOP 内容。

## 13.1 继承是什么

继承就是：

**让一个新类自动拥有旧类已经写好的属性和方法，然后再加自己的东西。**

例如：

```java
public class TranslationRobot extends Robot
```

意思是：

`TranslationRobot` 是 `Robot` 的子类。

它自动继承 Robot 已有的东西，比如：

* `name`
* `numLegs`
* `powerLevel`
* `talk()`
* `charge()`

然后它还可以再加：

* 新属性 `substitute`
* 新方法 `translate()`
* 或重写 `charge()`

---

## 13.2 为什么要继承

最核心原因：

**减少重复代码。**

也就是 DRY：Do Not Repeat Yourself。

如果多个类有共同部分，把共同部分写进父类最省事，也最容易维护。

---

## 13.3 子类能做三件事

子类通常可以：

### 1）增加新属性

比如：

```java
String substitute;
```

### 2）增加新方法

比如：

```java
void translate(String phrase)
```

### 3）重写已有方法

比如：

```java
@Override
void charge(float amount)
```

---

# Part 14. `extends` 和 is-a 关系

## 14.1 什么时候该用继承

只有当子类和父类之间是：

**is-a（是一个）**

关系时，才适合继承。

例如：

* Dog is a Mammal
* Dolphin is a Mammal
* TranslationRobot is a Robot

这都合理。

---

## 14.2 什么情况不该继承

如果是 **has-a（有一个）** 的关系，一般不该继承。

例如：

* Robot has a Motor

这不表示 Robot 是 Motor。

所以不该写成 `Robot extends Motor`。

这个判断很重要。

---

# Part 15. 方法重写 overriding

## 15.1 重写是什么

父类原本已经有一个方法，子类提供自己的版本，这就叫重写。

例如 `TranslationRobot` 重写 `charge(float amount)`：

```java
@Override
void charge(float amount) {
    System.out.println(name + " charges double.");
    powerLevel = powerLevel + 2 * amount;
}
```

这表示：

同样叫 `charge`，但 TranslationRobot 的充电规则不同。

---

## 15.2 `@Override` 有什么用

它是一个标记：

**告诉编译器：我现在是想重写父类的方法。**

好处是如果你方法名写错、参数写错，编译器会提醒你。

所以这是一个非常好的习惯。

---

# Part 16. 里氏替换原则 Liskov Substitution Principle

这是理解继承“该不该用”的思想标准。

最通俗的说法：

**凡是能用父类对象的地方，最好也能正常用子类对象，而不会把程序本来的逻辑搞坏。**

例如：

如果某段代码本来接收 `Robot`，那么它也应该能合理接收 `TranslationRobot`。

这说明子类真的保留了“父类应有的承诺”。

---

# Part 17. 抽象类 abstract class 和抽象方法

## 17.1 抽象类是什么

抽象类就是：

**拿来当“共同模板”的类，但它自己不应该直接被实例化。**

例如：

```java
public abstract class Mammal
```

意思是 Mammal 代表“哺乳动物”这个大类概念，但你通常不直接 `new Mammal(...)`。

更常见的是：

* `new Dog(...)`
* `new Dolphin(...)`
* `new Lion(...)`

---

## 17.2 抽象方法是什么

抽象方法只有声明，没有方法体。

例如：

```java
public abstract void makeNoise();
```

意思是：

“所有 Mammal 都应该会发出声音，但具体怎么叫，不在这里写，由子类自己决定。”

---

## 17.3 为什么抽象方法很有用

它能强制子类完成某个“接口承诺”。

所以：

* Mammal 统一规定：每个哺乳动物都必须会 `makeNoise()`
* Dog / Dolphin / Lion 各自实现不同版本

这就同时做到：

* 父类统一规范
* 子类自由实现细节

---

# Part 18. 多态 polymorphism

这是第二周最重要的关键词之一。

## 18.1 多态最通俗的解释

多态就是：

**同一种父类引用，可以指向不同的子类对象。**

例如：

```java
Robot c5po = new TranslationRobot("e");
```

这里：

* 引用类型是 `Robot`
* 实际对象是 `TranslationRobot`

这是合法的。

因为 TranslationRobot 是 Robot 的子类。

---

## 18.2 为什么这很强大

这样你就可以把“很多不同子类对象”统一当成“父类”来管理。

比如：

```java
Mammal[] mammalArrayObject = new Mammal[3];
mammalArrayObject[0] = new Dolphin(40,20);
mammalArrayObject[1] = new Dog(10,20);
mammalArrayObject[2] = new Lion(12,250);
```

这就是典型多态。

一个 `Mammal[]` 里可以装不同种类的哺乳动物对象。

---

## 18.3 为什么反过来不行

```java
TranslationRobot x = new Robot();
```

这是不行的。

因为不是每个 Robot 都一定具备 TranslationRobot 特有的功能。

父类对象不一定是子类对象。

---

# Part 19. 动态分派 dynamic dispatch

这是多态背后的执行规则。

## 19.1 最重要的一句定义

当你通过一个引用去调用**被重写的方法**时，

**实际执行哪个版本，不看引用类型，看对象真实类型。**

---

## 19.2 用老师代码理解

```java
Robot c5po = new TranslationRobot("e");
c5po.charge(10);
```

虽然 `c5po` 的引用类型是 `Robot`，

但它实际指向的是 `TranslationRobot` 对象。

而 `charge()` 在子类里被重写了。

所以运行时执行的是：

**TranslationRobot 版本的 `charge()`**

不是 Robot 版本。

这就叫单一动态分派（single dynamic dispatch）。

---

## 19.3 你必须会说的考试句子

**方法调用最终执行哪个重写版本，是在运行时根据接收者对象的真实类型决定的。**

这句话非常标准。

---

# Part 20. Mammal 例子怎么一口气看懂

## 20.1 先看父类 Mammal

`Mammal` 提供：

* 共同属性：`lifeSpanYears`, `weightKg`
* 共同方法：`stateAttributes()`
* 抽象方法：`makeNoise()`

这就像在说：

“所有哺乳动物都有这些共同基本信息，但叫声各不相同。”

---

## 20.2 再看子类

### Dog

实现：

```java
public void makeNoise() {
    System.out.println("Woof woof\n");
}
```

### Dolphin

实现：

```java
public void makeNoise() {
    System.out.println("Squeek Click\n");
}
```

### Lion

实现：

```java
public void makeNoise() {
    System.out.println("GRRRRRRRRRR Roar!\n");
}
```

所以同一个 `makeNoise()`，不同对象会有不同表现。

这就是多态 + 重写 + 动态分派一起工作。

---

## 20.3 再看数组遍历

```java
for (Mammal mCurr : mammalArrayObject) {
    mCurr.stateAttributes();
    mCurr.makeNoise();
}
```

这里 `mCurr` 的静态类型都是 `Mammal`。

但每一轮它实际可能指向：

* Dolphin
* Dog
* Lion

所以：

* `stateAttributes()` 用父类公共实现
* `makeNoise()` 用各子类自己的实现

这个例子非常经典，必须会看。

---

# Part 21. AbstractRobot / greet 例子在讲什么

这个例子比前面的多态再进一步，开始接触“分派”问题。

## 21.1 `AbstractRobot` 为什么是抽象类

```java
abstract class AbstractRobot extends Robot {
  abstract void greet(AbstractRobot other);
  abstract void greet(TranslationRobot other);
  abstract void greet(CarrierRobot other);   
}
```

意思是：

老师定义了一个更抽象的“机器人打招呼体系”，但不打算直接创建 `AbstractRobot` 对象。

它只是规定：

所有具体机器人子类都必须会处理不同 `greet(...)` 情况。

---

## 21.2 `TranslationRobot` 和 `CarrierRobot` 的 `greet` 实现

它们各自实现：

* 遇到 TranslationRobot 怎么打招呼
* 遇到 CarrierRobot 怎么打招呼
* 遇到更泛化的 AbstractRobot 怎么转发调用

例如：

```java
@Override
void greet(AbstractRobot other) {
    other.greet(this);
}
```

这句很关键。

它不是自己决定全部逻辑，而是把“你遇见我”这件事反过来交给对方再判断。

这是一种为了模拟更复杂分派效果的写法。

---

## 21.3 `DispatchWorld` 在演示什么

```java
AbstractRobot c3po = new TranslationRobot("e");
AbstractRobot c4po = new TranslationRobot("o");
AbstractRobot c5po = new CarrierRobot();
AbstractRobot c6po = new CarrierRobot();
```

虽然所有引用都写成 `AbstractRobot`，

但实际对象有两种：

* TranslationRobot
* CarrierRobot

然后：

```java
c3po.greet(c4po);
c5po.greet(c4po);
c4po.greet(c5po);
c5po.greet(c6po);
```

这个例子主要是让你看到：

* 引用类型可以很抽象
* 实际执行逻辑仍然取决于运行时对象
* 方法重载和重写混在一起时，理解“谁来决定调用哪个方法”会更复杂

你现在先记住老师想让你看到的核心：

**多态让同一套调用形式可以对不同对象表现出不同结果。**

---

# Part 22. 类层次结构 class hierarchy

## 22.1 Java 是单继承

Java 中一个类只能直接继承一个父类。

这叫：

**single inheritance 单继承**

例如：

* Dog extends Mammal
* Mammal 默认最终也继承自 Object

---

## 22.2 所有类最终都连到 Object

Java 的类层次树最顶端是：

```java
Object
```

也就是说：

**每个 Java 类最终都是 Object 的子类。**

只不过有的直接继承，有的间接继承。

---

# Part 23. UML 图怎么读

第二周也开始让你接触类图。

一个类的 UML 方框通常分三层：

1. 类名
2. 属性
3. 方法

例如 Robot 图里就会写：

* 类名：`Robot`
* 属性：`name`, `numLegs`, `powerLevel`
* 方法：`talk(String)`, `charge(float)`

继承关系通常画成：

**从子类指向父类的三角箭头。**

所以图不是装饰，它是在帮你看清：

“谁继承谁，谁有什么共同特征，谁增加了什么。”

---

# Part 24. 这一周最容易错的坑

## 24.1 以为变量就是对象

错。

变量通常只是引用。

---

## 24.2 以为 `a = b` 会复制整个对象

错。

通常只是让两个引用指向同一个对象。

---

## 24.3 以为 `==` 比的是内容

错。

对于对象引用，`==` 比的是是不是同一个对象。

---

## 24.4 以为数组创建了，里面元素也都创建了

错。

数组里的对象引用一开始通常是 `null`。

---

## 24.5 以为增强 for 可以直接给数组每个位置赋新对象

通常不行。

因为你改的是循环变量，不是数组槽位。

---

## 24.6 以为父类引用调用方法时，看引用类型决定

不完整。

如果是重写方法，实际执行版本看对象真实类型。

---

## 24.7 以为继承是“为了偷懒乱用”

不对。

继承只能用于真正的 is-a 特化关系。

---

# Part 25. 用一句人话串起第二周全部内容

第二周的核心，就是把下面这条链彻底打通：

**类定义结构 → `new` 创建对象 → 引用指向对象 → 对象存在于堆上 → 多个引用可指向同一对象 → `null` 表示不指向任何对象 → 比较对象要分清 `==` 和 `equals()` → 数组里存的是引用 → 子类继承父类 → 父类引用可指向子类对象 → 重写方法在运行时动态分派 → 抽象类负责规定共同模板。**

如果你把这条链真正搞懂，这一周就算学明白了。

---

# Part 26. 考试/做题必背简答句

## 26.1 什么是 reference？

A reference is a variable that refers to an object rather than storing the object itself.

## 26.2 `null` 是什么？

`null` means a reference does not refer to any object.

## 26.3 `==` 和 `equals()` 区别？

For objects, `==` compares reference identity, while `equals()` compares logical/content equality.

## 26.4 什么是 inheritance？

Inheritance allows a child class to reuse and extend the features of a parent class.

## 26.5 什么是 polymorphism？

Polymorphism means a superclass reference can refer to objects of different subclasses.

## 26.6 什么是 overriding？

Overriding is when a subclass provides its own implementation of a method already defined in the parent class.

## 26.7 什么是 dynamic dispatch？

Dynamic dispatch means the overridden method to execute is chosen at runtime based on the actual object type.

## 26.8 什么是 abstract class？

An abstract class is a class that cannot be instantiated directly and is used as a conceptual parent for subclasses.

---

# Part 27. 这一周你应该真正会做的事

学完第二周，你应该能独立做到：

* 解释“引用”和“对象”的区别
* 画出简单的 stack / heap 图
* 判断一段代码里哪些变量指向同一个对象
* 判断哪里会出现 `null` 问题
* 解释 `==` 和 `equals()` 的不同
* 写出带 `this` 的构造器
* 正确创建并初始化对象数组
* 写出父类、子类、抽象类
* 写出方法重写
* 解释为什么 `Robot r = new TranslationRobot(...)` 是合法的
* 解释为什么调用重写方法时执行子类版本

---

# Part 28. 最后给你一个超短总结版

## 第二周浓缩成 8 句话

1. 类是蓝图，对象是实例，引用是找到对象的线索。
2. `new` 创建对象，对象通常在堆上。
3. 引用变量通常在栈上，里面装的不是对象本身。
4. 多个引用可以指向同一个对象，`null` 表示不指向任何对象。
5. `==` 比是不是同一个对象，`equals()` 比内容是否相等。
6. 数组本身也是对象，数组里装的通常是引用。
7. 继承让子类复用父类，并可添加/重写功能。
8. 多态 + 动态分派让父类引用在运行时调用到子类重写的方法。

---

# Part 29. 给你一个复习建议

复习这一周，不要只背定义。

最有效的方法是每看到一段代码，都问自己 5 个问题：

1. 这里谁是类，谁是对象，谁是引用？
2. 对象现在在堆里有几个？
3. 哪几个引用指向同一个对象？
4. 这里调用的方法到底会执行哪个版本？
5. 这里有没有 `null` 或引用混淆的风险？

只要你每道题都这样拆，第二周的内容会越来越清楚。
