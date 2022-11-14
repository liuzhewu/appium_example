package com.liu.parents;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.liu.utils.ConfigManger;
import com.liu.utils.Constants;
import com.liu.utils.LogUtils;

import io.appium.java_client.android.AndroidDriver;
/**
 * 所有测试类的父类
 * @author Administrator
 *
 */
public abstract class ParentTest  
{
	@SuppressWarnings("rawtypes")
	protected static AndroidDriver driver;
	protected Properties props=ConfigManger.getConfig();
	protected final String bookName=props.getProperty(Constants.BOOKNAME);
	
	protected void sleep(long n) {
		try {
			Thread.sleep(n*Constants.THOUSAND);
		} catch (InterruptedException e) {
			LogUtils.error(e.getMessage());
		}
	}
	
	protected void sleep() {
		sleep(1);
	} 
	
	/**
	 * 等待某个元素出现
	 * @param xpath
	 */
	protected void autoWait(By by) 
	{
		try
		{
			new WebDriverWait(driver,Constants.MAX_PAGE_LOAD_TIMEOUT).
			until(ExpectedConditions.presenceOfElementLocated(by));
		}
		catch (Exception e) 
		{
			LogUtils.warn(e.getMessage());
			sleep(Constants.EXCEPTION_WAIT_TIME);
		}
	}
	
	protected void autoWait(String xpath) 
	{
		try
		{
			new WebDriverWait(driver,Constants.MAX_PAGE_LOAD_TIMEOUT).
			until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}
		catch (Exception e) 
		{
			LogUtils.warn(e.getMessage());
			sleep(Constants.EXCEPTION_WAIT_TIME);
		}
	}
	
	/**
	 * 等待元素消失不见，用于加载中消失不见
	 * @param xpath
	 */
	protected void autoWaitInVisiable(String xpath) 
	{
		try 
		{
			new WebDriverWait(driver,Constants.MAX_PAGE_LOAD_TIMEOUT).
			until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(xpath))));
		}
		catch (Exception e) 
		{
			LogUtils.warn(e.getMessage());
			sleep(Constants.EXCEPTION_WAIT_TIME);
		}
		
	}
	
	protected void autoWaitInVisiable(By by) 
	{
		try 
		{
			new WebDriverWait(driver,Constants.MAX_PAGE_LOAD_TIMEOUT).
			until(ExpectedConditions.stalenessOf(driver.findElement(by)));
		}
		catch (Exception e) 
		{
			LogUtils.warn(e.getMessage());
			sleep(Constants.EXCEPTION_WAIT_TIME);
		}
		
	}
	/**
	 * 模仿selenide，用$
	 * @param xpath
	 * @return
	 */
	protected WebElement $(By by) 
	{
		autoWait(by);
		return driver.findElement(by);
		
	}
	
	protected WebElement $(String xpath) 
	{
		autoWait(By.xpath(xpath));
		return driver.findElement(By.xpath(xpath));
		
	}
	
	/**
	 * 模仿selenide，用$$
	 * @param xpath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<WebElement> $$(By by) 
	{
		return driver.findElements(by);
	}
	
	@SuppressWarnings("unchecked")
	protected List<WebElement> $$(String xpath) 
	{
		return driver.findElements(By.xpath(xpath));
	}

} 
