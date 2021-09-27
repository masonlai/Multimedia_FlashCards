package com.masonlai.FlashCards.Model.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "flashCardDeck")
public class FlashCardDeck {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column(nullable = false)
    private String deckName;

    @Column(name="LastUpdated",
            insertable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;

    @OneToMany(targetEntity=FlashCard.class,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlashCard> flashCardList;

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
