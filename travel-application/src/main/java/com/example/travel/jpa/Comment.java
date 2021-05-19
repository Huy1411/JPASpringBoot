package com.example.travel.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"location","customer"})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private String commentName;

    private String commentInfo;

    private Date commentDate;

    @Min(value = 1, message = "Please chose a status")
    private int status;

    @Min(value = 1)
    @Max(value = 5)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "locationId")
    @JsonIgnoreProperties("comments")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "customerId")
    @JsonIgnoreProperties("comments")
    private Customer customer;


    public Comment() {
    }

    public Comment(int commentId, String commentName, String commentInfo, Date commentDate, @Min(value = 1, message = "Please chose a status") int status, @Min(value = 1) @Max(value = 5) int rating, Location location, Customer customer) {
        this.commentId = commentId;
        this.commentName = commentName;
        this.commentInfo = commentInfo;
        this.commentDate = commentDate;
        this.status = status;
        this.rating = rating;
        this.location = location;
        this.customer = customer;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
