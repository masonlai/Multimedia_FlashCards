package com.masonlai.FlashCards.Model.Repositories;

import com.masonlai.FlashCards.Model.Entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource( collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, UUID> {
    List<User> findByid(@Param("id") UUID id);
}