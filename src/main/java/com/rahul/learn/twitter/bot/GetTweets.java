package com.rahul.learn.twitter.bot;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

/**
 * Shows up to 100 of the first retweets of a given tweet.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class GetTweets {
  /**
   * Usage: java twitter4j.examples.tweets.GetRetweets [status id]
   *
   * @param args message
   */
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Usage: java twitter4j.examples.tweets.GetRetweets [status id]");
      System.exit(-1);
    }
    System.out.println("Showing up to 100 of the first retweets of the status id - [" + args[0] + "].");
    try {
      Twitter twitter = new TwitterFactory().getInstance();
      List<Status> statuses = twitter.getRetweets(Long.parseLong(args[0]));
      for (Status status : statuses) {
        System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
      }
      System.out.println("done.");
      System.exit(0);
    } catch (TwitterException te) {
      te.printStackTrace();
      System.out.println("Failed to get retweets: " + te.getMessage());
      System.exit(-1);
    }
  }
}