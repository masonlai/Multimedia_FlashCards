package com.masonlai.FlashCards.Model.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "UserName",
                        name = "uniqueNameConstraint")}
)
public class User {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

    @Column(name = "RegistrationDate",
            insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date RegistrationDate;

   @OneToMany(targetEntity=FlashCardDeck.class,cascade = CascadeType.ALL, orphanRemoval = true)
   private List<FlashCard> flashCardList = new ArrayList<>();

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}