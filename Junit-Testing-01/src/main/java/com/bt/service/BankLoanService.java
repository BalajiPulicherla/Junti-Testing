package com.bt.service;

public class BankLoanService {
	
	public float calcSimpleInterestAmt(float pAmt, float rate, float time) {
		if(pAmt<=0 || rate<=0 || time<=0)throw new IllegalArgumentException("Invalid Inputs");
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return pAmt*rate*time/100.0f;
	}

}
