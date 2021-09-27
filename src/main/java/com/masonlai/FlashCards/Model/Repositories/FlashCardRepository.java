package com.masonlai.FlashCards.Model.Repositories;


import com.masonlai.FlashCards.Model.Entities.FlashCard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "flashCards", path = "flashCards")
public interface FlashCardRepository extends PagingAndSortingRepository<FlashCard, UUID> {
    List<FlashCard> findByid(@Param("id") UUID id);
}