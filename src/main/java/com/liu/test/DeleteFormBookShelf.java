package com.liu.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.liu.parents.ParentTest;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
/**
 * 从书架删除刚才收藏的书籍
 * @author Administrator
 *
 */
public class DeleteFormBookShelf extends ParentTest
{
	/**
	 * 处理前期工作，比如:返回
	 */
	@Test
	public void before() 
	{
		//3次返回，退回到主页
		KeyEvent event=new KeyEvent(AndroidKey.BACK);
		driver.pressKey(event);
		driver.pressKey(event);
		driver.pressKey(event);
	}
	
	@Test
	public void deleteFromBookShelf() 
	{
		$("//*[@text='书架']").click();
		//先根据书名定位到点击按钮的父级菜单
		$("//*[@text='回到明朝当王爷']/../../preceding-sibling::android.widget.RelativeLayout[1]").
		findElement(By.className("android.widget.ImageView")).click();;
		//打赏送至尊盟主卡有时会出现
		$("//*[@text='打赏送至尊盟主卡']/..").click();
		autoWaitInVisiable("//*[@text='打赏送至尊盟主卡']/..");
		$("//*[@text='删除']/..").click();
		$("//*[@text='删除本书']/../..").click();
	}

}
