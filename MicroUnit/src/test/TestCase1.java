package test;

import microunit.Assert;
import microunit.Test;
import static microunit.Assert.*;

public class TestCase1 {

	@Test
	public void method1(){
		System.out.println("method1");
		Assert.assertEquals(2, 2);
		/*Assert.assertEquals(3, 2);
		Assert.assertEquals(null, 2);
		*/
	}
	
	@Test
	public void method2(){
		Assert.assertEquals(null, 2);
	}
	
	
	public void method3(){
		System.out.println("method3");
	}


}
