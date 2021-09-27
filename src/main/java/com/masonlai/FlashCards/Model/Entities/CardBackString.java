package com.masonlai.FlashCards.Model.Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class CardBackString {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column(nullable = false)
    private String content;

    @OneToOne
    @JoinColumn(name = "flashCard_id")
    private FlashCard flashCard;
}
