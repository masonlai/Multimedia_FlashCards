package com.masonlai.FlashCards.Model.Repositories;

import com.masonlai.FlashCards.Model.Entities.CardBackImage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "cardBackimage", path = "cardBackimage")
public interface CardBackImageRepository extends PagingAndSortingRepository<CardBackImage,UUID>{
List<CardBackImage> findByid(@Param("id") UUID id);
}


