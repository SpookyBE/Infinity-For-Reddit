package com.spookybe.infinityforreddit.asynctasks;

import android.os.Handler;

import java.util.concurrent.Executor;

import com.spookybe.infinityforreddit.RedditDataRoomDatabase;
import com.spookybe.infinityforreddit.account.Account;
import com.spookybe.infinityforreddit.subscribedsubreddit.SubscribedSubredditData;

public class CheckIsSubscribedToSubreddit {

    public static void checkIsSubscribedToSubreddit(Executor executor, Handler handler, RedditDataRoomDatabase redditDataRoomDatabase,
                                                    String subredditName, String accountName,
                                                    CheckIsSubscribedToSubredditListener checkIsSubscribedToSubredditListener) {
        executor.execute(() -> {
            if (accountName == null) {
                if (!redditDataRoomDatabase.accountDao().isAnonymousAccountInserted()) {
                    redditDataRoomDatabase.accountDao().insert(Account.getAnonymousAccount());
                }
            }
            SubscribedSubredditData subscribedSubredditData = redditDataRoomDatabase.subscribedSubredditDao().getSubscribedSubreddit(subredditName, accountName == null ? "-" : accountName);
            handler.post(() -> {
                if (subscribedSubredditData != null) {
                    checkIsSubscribedToSubredditListener.isSubscribed();
                } else {
                    checkIsSubscribedToSubredditListener.isNotSubscribed();
                }
            });
        });
    }

    public interface CheckIsSubscribedToSubredditListener {
        void isSubscribed();

        void isNotSubscribed();
    }
}
