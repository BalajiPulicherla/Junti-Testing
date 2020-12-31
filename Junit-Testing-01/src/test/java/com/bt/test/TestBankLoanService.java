package com.bt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.bt.service.BankLoanService;

@DisplayName("TestMyBankLoanService")
//@TestMethodOrder(value=OrderAnnotation.class)
//@TestMethodOrder(value=MethodName.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class TestBankLoanService {
	
	private static 	BankLoanService service;
	@BeforeAll
	public static void setUpOnce() {
		System.out.println("TestBankLoanService.setUpOnce()");
		service=new BankLoanService();
		
	}
	
	/*
	 * @BeforeEach public void setUp() {
	 * System.out.println("TestBankLoanService.setUp()"); service=new
	 * BankLoanService();
	 */
	
		
	
	@Test
	@DisplayName("Test with Big Number")
	//@Order(1)
	public void testcalcSimpleInterestAmtWithBigNumber() {
		System.out.println("TestBankLoanService.testcalcSimpleInterestAmtWithBigNumber()");
		//BankLoanService service=new BankLoanService();
		float actual=service.calcSimpleInterestAmt(100000, 2, 12);
		float expected=24000.0f;
		assertEquals(expected, actual,"May be results are not matching");
		
	}
	@Test
	@DisplayName("Test With Small Number")
	//@Order(5)
	public void testcalcSimpleInterestAmtWithSmallNumber() {
		System.out.println("TestBankLoanService.testcalcSimpleInterestAmtWithSmallNumber()");
		//BankLoanService service=new BankLoanService();
		float actual=service.calcSimpleInterestAmt(100000, 2, 12);
		float expected=24000.12f;
		assertEquals(expected, actual, 0.12, "May be results are not matching");
	}
	
	@Test
	@DisplayName("Test With invalid inputs")
	//@Order(2)
	public void testcalcSimpleInterestAmtWithInvalidInputs() {
		System.out.println("TestBankLoanService.testcalcSimpleInterestAmtWithInvalidInputs()");
		//BankLoanService service=new BankLoanService();
		/*
		 * float actual=service.calcSimpleInterestAmt(0, 2, 12);// if runtime errrors
		 * are happened we can handle //that by using assertThorws keywords belows liike
		 * this float expected=24000.12f; assertEquals(expected, actual, 0.12,
		 * "May be results are not matching");
		 */
		
		  assertThrows(IllegalArgumentException.class, ()->{
		  service.calcSimpleInterestAmt(0, 2,12); },
		  "May be exception raised is not matching");
					 
	}

	
	  @Test
	 // @Disabled
	  @DisplayName("Test with Timer")
	  //@Order(0)
	  public void testcalcSimpleInterestAmtWithTimer() { System.out.println(
	  "TestBankLoanService.testcalcSimpleInterestAmtWithInvalidInputs()");
	  BankLoanService service=new BankLoanService();
	  assertTimeout(Duration.ofMillis(20000), ()->{
	  service.calcSimpleInterestAmt(100000, 12, 1.5f); } ); }
	 
	/*
	 * @Test public void testcalcSimpleInterestAmtWithTimer() { System.out.println(
	 * "TestBankLoanService.testcalcSimpleInterestAmtWithInvalidInputs()");
	 * //BankLoanService service=new BankLoanService(); assertDoesNotThrow(()->{
	 * service.calcSimpleInterestAmt(1000, 2, 12); }); }
	 */
	
	
	/*
	 * @AfterEach public void clear() {
	 * System.out.println("TestBankLoanService.clear()"); service=null;
	 * //actual=0.0f; }
	 */
	@AfterAll
	public static void clearUpOnce() {
		System.out.println("TestBankLoanService.clearUpOnce()");
		service=null;
		System.out.println(service);
}
	}
