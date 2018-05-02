package com.test.java8.functionalInterface;

public class MainApp {
	
	
public static void main(String[] args) {

	MainApp mainApp=new MainApp();
	mainApp.callCreditTxn(()->System.out.println("This is ICIC Credit transaction"));
	mainApp.callCreditTxn(()->System.out.println("This is SBI Credit transaction"));
	
}

public void callCreditTxn(BankTransaction bankTransaction)
{
	bankTransaction.creditTxn();
}


}
