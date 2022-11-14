package com.liu.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.liu.parents.ParentTest;
import com.liu.utils.Constants;
import com.liu.utils.LogUtils;

import io.appium.java_client.android.AndroidDriver;

public class BeforeTest extends ParentTest 
{
	@Test
	public void before() 
	{
		LogUtils.info("---begin---");
		openApp();
	}
	

	public void openApp() {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		//指定测试平台
		cap.setCapability(Constants.PLATFORM_NAME, Constants.ANDROID);
		//指定测试机的ID，通过adb devices命令获取
		cap.setCapability(Constants.DEVICE_NAME, Constants.DEVICE);
		cap.setCapability(Constants.PLATFORM_VERSION, Constants.VERSION9);
		//设置包路径
		cap.setCapability(Constants.APP, Constants.APP_FILE);
		cap.setCapability(Constants.UNICODEKEYBOARD, Constants.TRUE);
		cap.setCapability(Constants.RESETKEYBOARD, Constants.TRUE);
		cap.setCapability(Constants.SESSION_OVERRIDE, true);
		try {
			//这里控制是android还是ios,由于暂
			//时只有android，所以不考虑将手机类型放到配置文件中
			driver=new AndroidDriver<WebElement>(new URL(Constants.ANDROID_URL), cap);
		} catch (MalformedURLException e) {
			LogUtils.error("初始化失败");
			assertThat(false).as("初始化失败");
		}
	}



}
