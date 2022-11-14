package com.liu.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.liu.parents.ParentTest;

/**
 * 加入书架
 * @author Administrator
 *
 */
public class AddToBookShelf extends ParentTest 
{
	/**
	 * 关闭额外弹窗，比如：签到
	 */
	@Test
	public void before() {
		
		//确认签到页面弹出，并点击×
		autoWait("//*[@text='签到并得翻倍奖励']");
		List<WebElement> list= $$("//*[@class='android.widget.ImageView']");
		list.get(list.size()-1).click();
		//关闭青少年模式提醒
		$("//*[@text='我知道了']").click();
		
	}
	
	@Test
	public void search() {
		$("//*[@text='发现']").click();
		//关闭广告
		$(By.id("com.qidian.QDReader:id/imgClose")).click();
		//点击搜索，输入书名，点击搜索,点击搜索结果
		$(By.id("com.qidian.QDReader:id/search")).click();
		$(By.id("com.qidian.QDReader:id/booksview_activity_search_edittext")).sendKeys(bookName);
		$(By.id("com.qidian.QDReader:id/booksview_search_btn")).click();
		$$("//*[@text='回到明朝当王爷']").get(1).click();
	}
	
	@Test
	public void addToBookShelf() 
	{
		$("//*[@text='加入书架']").click();
	}

}
