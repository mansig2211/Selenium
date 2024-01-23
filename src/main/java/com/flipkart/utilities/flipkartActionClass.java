package com.flipkart.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import baseClass.baseClassSetup;

public class flipkartActionClass extends baseClassSetup{
	
	Actions act;
	public void pressKey()
	{
		act= new Actions(driver);
		act.keyDown(Keys.ENTER);
		//act.keyUp(Keys.ENTER);
	}

}
