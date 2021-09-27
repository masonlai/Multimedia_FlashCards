package com.masonlai.FlashCards.Model.Repositories;

import com.masonlai.FlashCards.Model.Entities.FlashCardDeck;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;


@RepositoryRestResource(collectionResourceRel = "flashCardDecks", path = "flashCardDecks")
public interface FlashCardDeckRepository extends PagingAndSortingRepository<FlashCardDeck, UUID> {
    List<FlashCardDeck> findByid(@Param("id") UUID id);
}