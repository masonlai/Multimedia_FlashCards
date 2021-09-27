package com.masonlai.FlashCards.Model.Repositories;

import com.masonlai.FlashCards.Model.Entities.CardBackSound;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "cardBackSound", path = "cardBackSound")
public interface CardBackSoundRepository extends PagingAndSortingRepository<CardBackSound, UUID> {
    List<CardBackSound> findByid(@Param("id") UUID id);
}
