//package com.glassdoor.test.intern.first;

public class IncomingRequest {
  public int userId;
  public String userName;
  public String billingAddress;
  public int amount;
  // change the name of attribute.
  public String cardNumber;


  public IncomingRequest(int userId, String userName, String billingAddress, int amount, String cardNumber){
    this.userId = userId;
    this.userName = userName;
    this.billingAddress = billingAddress;
    this.amount = amount;
    this.cardNumber = cardNumber;
  }
}