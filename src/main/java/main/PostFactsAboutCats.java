package main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostFactsAboutCats {
    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final int upvotes;

    public PostFactsAboutCats(@JsonProperty("id") String id,
                              @JsonProperty("text") String text,
                              @JsonProperty("type") String type,
                              @JsonProperty("user") String user,
                              @JsonProperty("upvotes") int upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "PostFactsAboutCats: " +
                "\n id = " + id +
                "\n text = " + text +
                "\n type =" + type +
                "\n user = " + user +
                "\n upvotes=" + upvotes;
    }

    public int getUpvotes() {
        return upvotes;
    }
}
