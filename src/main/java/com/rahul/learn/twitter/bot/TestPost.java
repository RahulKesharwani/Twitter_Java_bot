package com.rahul.learn.twitter.bot;

import twitter4j.PagableResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.UserList;

public class TestPost {

  private static final Twitter twitter = TwitterFactory.getSingleton();
  public static void main(String[] args){
    sendTweets();
  }

  public static void fetchUser(){
    try {
      PagableResponseList<UserList> usrList = twitter.list().getUserListMemberships(100);
      System.out.println("UserList object has: " + usrList.toString());
      for(UserList user : usrList){
        System.out.println("Printing now");
        System.out.println(user.getFullName());
        System.out.println(user.getSlug());
        System.out.println(user.getUser().getFollowersCount());
      }
    } catch (TwitterException e) {
      e.printStackTrace();
    }
  }

  public static void sendTweets(){
    StatusUpdate status = new StatusUpdate("This is test status from java client");
    //status.setAttachmentUrl("https://91Products.com");
    try {
      Status res = twitter.updateStatus(status);
      System.out.println(res);
    } catch (TwitterException e) {
      e.printStackTrace();
    }
  }

  public static void replyToSomeone(){

  }
}
