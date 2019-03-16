//package com.glassdoor.test.intern.first;

public class PaymentProcessor {


  // I change the input of processPayment method because I think this method is used to compare the information of incomingrequest and database.
  // I don't need to involve the database in this method, instead, I just need to give the userInformation of database to this method.
  public boolean processPayment(IncomingRequest incomingrequest, Infor userInformation) {

      // both userName and userAddress, I used validate method to identity whether the data from request is the same as the data from database
      if (validateInfor(incomingrequest.userName, userInformation.getUserName())
          && validateInfor(incomingrequest.billingAddress, userInformation.getUserAdd())) {
        try {
          submitPayment(incomingrequest.cardNumber, incomingrequest.amount);
          return true;
        } catch (Exception e) {
          return false;
        }
      }
      return false;
  }

  public boolean validateInfor(String informationFromRequest, String informationFromDatabase) {
    if (informationFromRequest.equals(informationFromDatabase)) {
      return true;
    } else {
      return false;
    }
  }

  public void submitPayment(String card, int amount) {
    //Don't implement this.
  }
}