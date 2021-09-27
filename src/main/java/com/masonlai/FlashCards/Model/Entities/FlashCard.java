package com.masonlai.FlashCards.Model.Entities;

import javax.persistence.*;
import java.util.UUID;


@Entity(name = "FlashCard")
@Table(name = "flashCard")
public class FlashCard {
    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    private String font;

    @ManyToOne
    @JoinColumn (name="flashCardDeck_id")
    private FlashCardDeck flashCardDeck;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public FlashCardDeck getFlashCardDeck() {
        return flashCardDeck;
    }

    public void setFlashCardDeck(FlashCardDeck flashCardDeck) {
        this.flashCardDeck = flashCardDeck;
    }
}
