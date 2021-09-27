package com.masonlai.FlashCards.Model.Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class CardBackImage {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column(nullable = false)
    private String location;

    @OneToOne
    @JoinColumn(name = "flashCard_id")
    private FlashCard flashCard;
}
