// Android 项目中用得最多最火的第三方框架<br/>
https://www.cnblogs.com/jingping/p/10471056.html
https://book.flutterchina.club/


// 代理
maven { url 'https://maven.aliyun.com/repository/google' }
        maven { url 'https://maven.aliyun.com/repository/jcenter' }
        maven { url 'http://maven.aliyun.com/nexus/content/groups/public' }

###异常
## 非法数据
java.lang.IllegalArgumentException

kotlin.NotImplementedError: An operation is not implemented: Not yet implemented
在Android里面加个TODO并不会影响程序运行，可是在Kotlin里面就不一样啦，如果你在某个函数的第一行添加TODO的话，那么很抱歉，它不会跳过，然后运行下一行代码。那如果真要添加TODO的话，那就只能在函数的最后一行添加了。

知道原理后就好办了，我们只需要把TODO("not implemented") 这句话去掉就可以啦

作者：黄宏发
链接：https://www.jianshu.com/p/d167cfed2521
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
