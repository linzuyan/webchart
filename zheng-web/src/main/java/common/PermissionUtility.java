package common;

import spi.system.PermissionSPI;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by XR on 2016/9/8.
 */
/*同一个变量的一个新的副本*/
public class PermissionUtility {
    /*定义了一个string的方法*/
    /*在并发编程的时候，成员变量如果不做任何处理其实是线程不安全的，各个线程都在操作同一个变量，显然是不行的，并且我们也
    知道volatile这个关键字也是不能保证线程安全的。那么在有一种情况之下，我们需要满足这样一个条件：变量是同一个，但是每个
    线程都使用同一个初始值，也就是使用同一个变量的一个新的副本*/
    private static ThreadLocal<String> threadLocal=new ThreadLocal<String>();

    public static String getPerms(){
        return threadLocal.get();
    }
    public static void changePerms(String perms){
        threadLocal.set(perms);
    }
}
