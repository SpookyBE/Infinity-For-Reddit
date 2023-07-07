package com.spookybe.infinityforreddit.events;

import com.spookybe.infinityforreddit.post.Post;

public class PostUpdateEventToPostDetailFragment {
    public final Post post;

    public PostUpdateEventToPostDetailFragment(Post post) {
        this.post = post;
    }
}
