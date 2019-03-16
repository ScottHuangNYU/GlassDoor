//package com.glassdoor.test.intern.first;

public class PaymentApplication {
  private static UserDatabase database;

  //I used 4 threads to test 4 incomingRequest at the same time. when there are a large number of incomingRequest request to make a payment,
  //Multiply thread can deal with multiply request at the same time and improve the efficiency.
  public static void main(String[] args) {


    database = new UserDatabase();
    IncomingRequest incomingRequest1 = new IncomingRequest(1,"ABC", "123 Some Street, City Name, ST", 1,"");

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        if(database.USER_INFORMATION.containsKey(incomingRequest1.userId)) {
          boolean res = new PaymentProcessor().processPayment(incomingRequest1, database.USER_INFORMATION.get(incomingRequest1.userId));
          System.out.println("The result of " + Thread.currentThread().getName() + ":" + res);
        }else{
          System.out.println("The result of " + Thread.currentThread().getName() + ":" + false);
        }
      }
    });

    IncomingRequest incomingRequest2 = new IncomingRequest(2, "ABC", "456 Other Street, Cool City, SS",2,"");

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        if(database.USER_INFORMATION.containsKey(incomingRequest2.userId)) {
          boolean res = new PaymentProcessor().processPayment(incomingRequest2, database.USER_INFORMATION.get(incomingRequest2.userId));
          System.out.println("The result of " + Thread.currentThread().getName() + ":" + res);
        }else{
          System.out.println("The result of " + Thread.currentThread().getName() + ":" + false);
        }
      }
    });

    IncomingRequest incomingRequest3 = new IncomingRequest(2, "XYZ", "400 Other Street, Cool City, SS",2,"");

    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        if(database.USER_INFORMATION.containsKey(incomingRequest3.userId)) {
          boolean res = new PaymentProcessor().processPayment(incomingRequest3, database.USER_INFORMATION.get(incomingRequest3.userId));
          System.out.println("The result of " + Thread.currentThread().getName() + ":" + res);
        }else{
          System.out.println("The result of " + Thread.currentThread().getName() + ":" + false);
        }
      }
    });

    IncomingRequest incomingRequest4 = new IncomingRequest(3, "ABC", "123 Some Street, City Name, ST",1,"");
    Thread t4 = new Thread(new Runnable() {
      @Override
      public void run() {
        if(database.USER_INFORMATION.containsKey(incomingRequest4.userId)) {
          boolean res = new PaymentProcessor().processPayment(incomingRequest4, database.USER_INFORMATION.get(incomingRequest4.userId));
          System.out.println("The result of " + Thread.currentThread().getName() + ":" + res);
        }else{
          System.out.println("The result of " + Thread.currentThread().getName() + ":" + false);
        }
      }
    });

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
