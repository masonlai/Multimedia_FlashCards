package com.masonlai.FlashCards.Model.Repositories;

import com.masonlai.FlashCards.Model.Entities.FlashCardDeck;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "flashCardDecks", path = "flashCardDecks")
public interface FlashCardDeckRepository extends PagingAndSortingRepository<FlashCardDeck, Long> {
    List<FlashCardDeck> findByid(@Param("id") Long id);
}