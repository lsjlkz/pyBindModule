# pyBindModule
pycharm中开发python项目可将指定名字的对象绑定到某个模块的某个类上，输入可自动补全提示

PyBindModule：安装后在设置-工具-PyBindModule中配置名字绑定到类上，
格式如下： role;Develop/PyHelp/C/cRoleClass.py;cRoleClass;false;2
以英文分号;作为分隔符。其中1是绑定的字符串，2是模块所在相对路径（绝对路径），3是对应的类，4是（是否为绝对路径），5是函数注释的偏移行数。
现暂定最多10个配置，还需要更多的要修改代码。

