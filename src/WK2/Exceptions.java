package WK2;
//异常=程序运行过程中出现非正常情况时 Java用来中断当前正常流程的一种机制
//    你想把 "123" 变成整数，没问题
//    你想把 "abc" 变成整数，就不行
//    这时候 Java 不会返回一个正常 int
//    它会“抛出”一个异常，告诉你：这里出错了
//    throw这里出问题了 往外报告
//    catch我知道这里可能出问题 我来接住它并且处理
//为什么需要异常
    //因为有些操作有失败的可能，比如：
    //读文件，文件可能不存在
    //字符串转整数，字符串可能不合法
    //除法，分母可能为 0
    //从空集合里取元素，可能取不到
//也就是说：异常本质上是在表达：这个操作不一定成功
public class Exceptions {
    static void main(String[] args) {
        try {
            int x = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("转换失败");
        }//试着运行try 没问题就正常走下去 出现问题NumberFormatException 跳到catch里
    }
}
