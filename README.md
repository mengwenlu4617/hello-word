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
非法访问异常

###Flutter相关问题
## 插件的版本比项目的版本高
Incompatible classes were found in dependencies. Remove them from the classpath or use '-Xskip-metadata-version-check' to suppress errors
flutter Execution failed for task ‘:audioplayers:compileReleaseKotlin

原因：插件的版本比项目的版本高
解决办法：android->build.gradle文件，修改ext.kotlin_version = ‘1.5.10’
