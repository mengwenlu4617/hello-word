
## Flutter相关问题
### 1.插件的版本比项目的版本高
Incompatible classes were found in dependencies. Remove them from the classpath or use '-Xskip-metadata-version-check' to suppress errors
flutter Execution failed for task ‘:audioplayers:compileReleaseKotlin

原因：插件的版本比项目的版本高
解决办法：android->build.gradle文件，修改ext.kotlin_version = ‘1.5.10’

### 2.布局出错
The following assertion was thrown during performResize():
Vertical viewport was given unbounded height.

### 3.Exception caught by rendering library
The following assertion was thrown during performLayout():
An InputDecorator, which is typically created by a TextField, cannot have an unbounded width.
This happens when the parent widget does not provide a finite width constraint. For example, if the InputDecorator is contained by a Row, then its width must be constrained. An Expanded widget or a SizedBox can be used to constrain the width of the InputDecorator or the TextField that contains it.
'package:flutter/src/material/input_decorator.dart':
Failed assertion: line 948 pos 7: 'layoutConstraints.maxWidth < double.infinity'
