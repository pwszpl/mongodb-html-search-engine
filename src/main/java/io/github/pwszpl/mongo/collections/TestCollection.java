package io.github.pwszpl.mongo.collections;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@Document("TestCollection")
public class TestCollection {
    @Column
    public String authorName;
    @Column
    public String comment;
    @Column
    public Integer rating;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
