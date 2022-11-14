# appium_example
android autotest by appium


前提：配置好andriod环境，执行adb devices,appium
	手机打开开发者选项，usb调试
环境：win7 真机小米8 android9版本 sdk28 jdk1.8 
	起点读书7.9.12_415（build 57b9f51a）native_app
框架：appium+testng
执行文件:src/main/java/suit.xml
逻辑：登录起点，搜索《回到明朝当王爷》
	并加入书架，在书架中删除《回到明朝当王爷》,退出
其它：需在config/config.properties中配置好起点账号、 密码