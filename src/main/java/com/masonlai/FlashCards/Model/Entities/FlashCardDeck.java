package com.masonlai.FlashCards.Model.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flashCardDeck")
public class FlashCardDeck {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false)
    private String deckName;

    @Column(name="LastUpdated",
            insertable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
