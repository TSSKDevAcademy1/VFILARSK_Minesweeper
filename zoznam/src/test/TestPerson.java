package test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPerson {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}
	
	@Test
	private boolean isValidPhoneNUmber(String phoneNumber){
		Pattern p = Pattern.compile("[0-9]*");
		Matcher m = p.matcher(phoneNumber);
		boolean b = m.matches();
        if(b){
        	return true;
        } else {
        	return false;
        }
	}
}
