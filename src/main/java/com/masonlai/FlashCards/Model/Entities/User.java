package com.masonlai.FlashCards.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "UserName",
                        name = "uniqueNameConstraint")}
)
public class User {
    @JsonIgnore
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    private String userName;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //Had not use @jsonIgnore because it is conflict with nullable checking.
    //validator cannot retrieve the password to check -> throw error
    private String password;

    @Column(name = "RegistrationDate",
            insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date RegistrationDate;

   @OneToMany(targetEntity=FlashCardDeck.class,cascade = CascadeType.ALL, orphanRemoval = true)
   private List<FlashCardDeck> flashCardDeckList;

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public UUID getId() {
        return id;
    }

    public void setRegistrationDate(Date registrationDate) {
        RegistrationDate = registrationDate;
    }


    public List<FlashCardDeck> getFlashCardDeckList() {
        return flashCardDeckList;
    }

    public void setFlashCardDeckList(List<FlashCardDeck> flashCardDeckList) {

        if (flashCardDeckList != null) {
            flashCardDeckList.forEach(f -> f.setUser(this));
        }
        this.flashCardDeckList = flashCardDeckList;
    }

    public void setId(UUID id) {
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

    public void setPassword(String password) { // <3>
        this.password = PASSWORD_ENCODER.encode(password);
        //this.password = password;
    }
}