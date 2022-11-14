package com.liu.test;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.liu.parents.ParentTest;
import com.liu.utils.Constants;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends  ParentTest
{
	/**
	 *  进入登录页面的前期工作，关闭警告之类的
	 */
	@Test
	public void before() 
	{
		$("//*[@text='我知道了']").click();
		//第1项权限(共2项)
		autoWait("//*[@text='第 1 项权限（共 2 项）']");
		$("//*[@text='允许']").click();
		autoWait("//*[@text='第 2 项权限（共 2 项）']");
		$("//*[@text='允许']").click();
		$("//*[@text='同意']").click();
		$("//*[@text='其他方式登录']").click();
		assertThat($(By.id("com.qidian.QDReader:id/mPwdEditText")).getText()).as("校验密码框失败").isEqualTo("密码");
	}
	
	@Test
	public void login()	
	{
		$(By.id("com.qidian.QDReader:id/mNickNameEditText")).sendKeys(props.get(Constants.USERNAME).toString());
		$(By.id("com.qidian.QDReader:id/mPwdEditText")).sendKeys(props.get(Constants.PASSWD).toString());
		$(By.id("com.qidian.QDReader:id/unCheckImg")).click();
		$(By.id("com.qidian.QDReader:id/button_text_id")).click();
		autoWaitInVisiable(By.id("com.qidian.QDReader:id/button_text_id"));
	}
	

	

}
