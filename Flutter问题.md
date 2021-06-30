
## Flutter相关问题
### 1.插件的版本比项目的版本高
Incompatible classes were found in dependencies. Remove them from the classpath or use '-Xskip-metadata-version-check' to suppress errors
flutter Execution failed for task ‘:audioplayers:compileReleaseKotlin

原因：插件的版本比项目的版本高
解决办法：android->build.gradle文件，修改ext.kotlin_version = ‘1.5.10’
