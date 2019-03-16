//package com.glassdoor.test.intern.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
  // I combined userName Map and addresses Map to USER_INFORMATION
  public static final Map<Integer, Infor> USER_INFORMATION = new HashMap<>();

  public UserDatabase() {
    readDB();
  }

  public void readDB() {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(
        UserDatabase.class.getClassLoader().getResourceAsStream("user_database.txt")))) {

      String line;
      while ((line = br.readLine()) != null) {
        String splits[] = line.split("\t");

        // I call the addNewUser method to insert user information to the map instead of using put method of map directly
        addNewUser(Integer.parseInt(splits[0]), splits[1],splits[2]);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void addNewUser(Integer userId, String username, String address) throws Exception{
    // Since the userId is unique, if one userId is going to insert into map second time, it will throw an exception.
    if(USER_INFORMATION.containsKey(userId)) throw new Exception("UserId already exist!");
    else{
      USER_INFORMATION.put(userId, new Infor(username, address));
    }
  }
}

// I used Infor class to store userName and userAdd together.
class Infor{

  private String userName;

  private String userAdd;

  public Infor(){}

  public Infor(String s1, String s2){
    this.userName = s1;
    this.userAdd = s2;
  }

  public String getUserName() {
    return userName;
  }


  public String getUserAdd() {
    return userAdd;
  }
}