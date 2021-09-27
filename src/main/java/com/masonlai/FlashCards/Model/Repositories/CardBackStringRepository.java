package com.masonlai.FlashCards.Model.Repositories;

import com.masonlai.FlashCards.Model.Entities.CardBackString;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "cardBackString", path = "cardBackString")
public interface CardBackStringRepository extends PagingAndSortingRepository<CardBackString, UUID> {
    List<CardBackString> findByid(@Param("id") UUID id);
}
