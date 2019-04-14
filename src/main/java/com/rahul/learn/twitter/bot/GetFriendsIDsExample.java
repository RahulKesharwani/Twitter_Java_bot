package com.rahul.learn.twitter.bot;

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class GetFriendsIDsExample {

  /**
   * Usage: java twitter4j.examples.friendsandfollowers.GetFriendsIDs [screen name]
   *
   * @param args message
   */
  public static void main(String[] args) {
    try {
      Twitter twitter = TwitterFactory.getSingleton();
      long cursor = -1;
      IDs ids;
      System.out.println("Listing following ids.");
      do {
        if (0 < args.length) {
          ids = twitter.getFriendsIDs(args[0], cursor);
        } else {
          ids = twitter.getFriendsIDs(cursor);
        }
        for (long id : ids.getIDs()) {
          System.out.println(id);
        }
        for(User user : twitter.users().lookupUsers(ids.getIDs())){
          System.out.println("Printing now");
          System.out.println(user.getName());
          System.out.println(user.getDescription());
          System.out.println(user.getFollowersCount());
        }
      } while ((cursor = ids.getNextCursor()) != 0);
      System.exit(0);
    } catch (TwitterException te) {
      te.printStackTrace();
      System.out.println("Failed to get friends' ids: " + te.getMessage());
      System.exit(-1);
    }
  }
}
