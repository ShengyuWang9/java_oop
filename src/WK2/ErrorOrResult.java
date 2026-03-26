package WK2;
//我现在大致明白了 看看我的思路 现在我们单独创建一个类ErrorOrResult 这个类里面有三个方法 一个是判断有没有失败 一个是失败打印的信息
// 一个是成功时候打印的信息 然后在主函数就是测试文件里写try直接调用字符串变数字的方法 判断是否成功了 成功了的话继续运行 打印成功的结果
// 失败的话直接catch报错 然后报告失败的信息也就是抛出异常 这里我一开始想到了这个类里面应该有一些基本属性 但是没有想到是两个字符串error和result
// 但是想了想 如果要定义一个类 这里面必须有两个基本参数 成功的话判断对象是不是integer就行
//praseIntorfail里面直接写上调用字符串百年数字的方法 成功的话就继续 打印成功信息 失败的话抓取异常值 打印失败信息

//先定义一个 ErrorOrResult 类，它不是负责打印，而是负责保存“成功结果”或者“失败原因”。这个类里有两个字段：
// String error 和 Integer result，并且一次只会有一个有值。它提供 failed() 判断是否失败，error() 取失败原因，
// result() 取成功结果；如果在不合适的状态下调用 error() 或 result()，就抛 NoSuchElementException。然后在 parseIntOrFail(String input)
// 这个方法里使用 try-catch 调用 Integer.parseInt(input)：如果成功，就返回一个装着整数结果的 ErrorOrResult；如果失败，
// 就 catch NumberFormatException，再返回一个装着错误信息的 ErrorOrResult。主函数只负责测试和打印返回对象


//failed()：判断当前对象是不是失败状态
//error()：返回失败原因
//result()：返回成功得到的整数
//也就是说，这三个方法主要是“取值”和“判断状态”，不是专门负责打印。
//打印通常是 toString() 的工作。题目也明确提到要实现 toString()。

//在主函数就是测试文件里写try直接调用字符串变数字的方法
//这里不太是题目真正想考的重点。
//这题更标准的思路是：
//把 try-catch 写在 parseIntOrFail 方法里面
//主函数 / 测试文件只负责调用这个方法，看返回结果
//“失败的话 catch 报错，也就是抛出异常” 这个说法要分清
    //你这里有点把两件事混在一起了：
    //第一件事：parseIntOrFail 处理 parseInt 的失败
    //这里不是把异常继续往外抛，而是：
    //catch 住 NumberFormatException
    //然后把错误信息包装成 ErrorOrResult
    //再返回出去
    //也就是：
    //这里的目标不是继续抛异常，而是把失败变成返回值

    //第二件事：error() 和 result() 在非法使用时抛异常
    //比如：当前对象明明是成功状态
    //你却去调用 error()
    //这时才应该抛 NoSuchElementException。
    //题目对这个要求写得很明确。
    //所以你要分清：
    //parseIntOrFail 里 catch 的是 NumberFormatException
    //error() / result() 里可能抛的是 NoSuchElementException
    //这两个异常不是一回事。

//“应该有两个字符串 error 和 result” 这个地方不对
//你自己也感觉这里有点不稳，这里我帮你彻底理顺：
//error 应该是 String，因为失败原因是文字。
//但是 result 不应该是 String，而应该是 整数类型。
//更准确地说，通常写成：
//private final String error;
//private final Integer result;
//注意是 Integer，不是 int。
//为什么是 Integer 不是 int？
//因为 Integer 可以是 null，而 int 不可以。
//这样就能表达两种状态：
//成功：result 有值，error == null
//失败：error 有值，result == null

import java.util.NoSuchElementException;

//4）“成功的话判断对象是不是 Integer 就行” 这个思路不太对
//这里不需要去“判断对象是不是 Integer”。
//因为这个类本来就是你自己设计的，你不需要到处用“类型判断”去推断成功失败。
//更好的方法是：
//直接让类里有两个字段：error 和 result
//用 error != null 判断失败
//或者用 result != null 判断成功
//比如：
//boolean failed() {
//    return error != null;
//}
//这个就够了。
//所以这题考的不是 instanceof 那种“类型判断”，
//而是考你怎么设计“状态”。

class ErrorOrResult {
    //想成一个装状态的盒子
    private final String error;     //为什么这里要用final      一但是构造器赋值了之后 就不能再被修改了 非常适合这里ErrorOrResult一旦创建了对象就不能再去修改了 要么是成功对象 要么是失败的对象
    private final Integer result;   //int 和Integer的区别是什么
                                    //因为Integer可以有null类型 int不能
    //成功Integer的结果是result
    private ErrorOrResult(Integer result) {
        this.error = null;
        this.result = result;
    }
    //失败error的结果是“error”
    private ErrorOrResult(String error) {
        this.error = error;
        this.result = null;   //这里用Integer的原因就是这里可以保存null值？
    }

    //问这个盒子现在是不是失败状态
    boolean failed() {       //为啥这前面不写public static 那些
        return error != null;     //为什么这里是不返回null值
                                    //如果error并不是null 就说明这里装了错误信息返回True 转整数失败了
    }

    //如果当前是失败状态 就把错误信息拿出来
    String error() throws NoSuchElementException {              //这里的格式为什么是这样的
                                                                    //前面和其他方法都是一样的 在方法的执行中可能会抛出NoSuchElementException异常（throws写说明书
        if (error == null) throw new NoSuchElementException();  //这里两次抛异常是什么意思
                                                                    //真正的执行抛异常操作（throw抛真正的异常
        return error;
    //为什么这里要抛异常
        //因为总有一个里面是空值 空值抛异常
    }

    //如果当前是成功状态 就把返回数字拿出来
    int result() throws NoSuchElementException {
        if (result == null) throw new NoSuchElementException();
        return result;
        //这个函数返回int 不能为null 如果为null直接抛异常
        //抛异常就直接结束了对吧 就不会在继续下面的返回了/
    }

    @Override //这里才是打印所有信息
    public String toString() {
        return failed() ? "Error: " + error : "OK: " + result;
    }
//    System.out.println(ErrorOrResult.parseIntOrFail("1"));
    //调用print（对象）的时候 自动调用toString也就是print（对象.toString）

    //把可能成功可能失败的一个操作变成一个返回对象
    static ErrorOrResult parseIntOrFail(String input){      //为什么这里要加上static  不需要对象内部数据的方法用static
        try {
            return new ErrorOrResult(Integer.parseInt(input));      //Integer.parseInt()可以直接被调用吗 可以parseInt是Integer的一个静态类方法
        } catch (NumberFormatException e){          //如果发生报错了 就把这个报错存给error？ 这里的e是抓到的哪个异常对象
            return new ErrorOrResult(e.getMessage());
        }
    }
}

//运行流程System.out.println(ErrorOrResult.parseIntOrFail("12"));
//1.进入parseIntOrFail 参数“12”
//2.执行try Integer.parseInt(input)
    //成功-》创建一个result为integer类型的对象
        //返回成功对象
        //最后打印这个对象 调用toString failed判断是否成功 成功打印result
    //失败-》创建一个error为异常值的对象
        //返回失败对象
        //最后打印这个对象 调用toString failed判断是否成功 失败error
//没有调用error（）和result（）这两个是拿对象里面的值时候才用得上