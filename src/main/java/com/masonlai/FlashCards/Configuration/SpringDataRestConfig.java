package com.masonlai.FlashCards.Configuration;

import com.masonlai.FlashCards.Model.Entities.*;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class SpringDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(CardBackImage.class);
        config.exposeIdsFor(CardBackSound.class);
        config.exposeIdsFor(CardBackString.class);
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(FlashCard.class);
        config.exposeIdsFor(FlashCardDeck.class);
    }
}