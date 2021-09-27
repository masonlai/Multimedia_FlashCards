package com.masonlai.FlashCards.Model.Projection;

import com.masonlai.FlashCards.Model.Entities.User;
import org.springframework.data.rest.core.config.Projection;

@Deprecated
@Projection(name = "passwords", types = { User.class })
interface PasswordProjection {

    String getPassword();
}
