package com.example.springdemo.repo;

import com.example.springdemo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PostRepo extends JpaRepository<Post,String> {
    @Query(value = "Select * from post where title like ?1%",nativeQuery = true)
    Page<Post> getAll(String searchText,Pageable pageable);

    @Query(value = "Select COUNT(*) from post where title like ?1%",nativeQuery = true)
    long countDataCount(String searchText);

    Post findPostByPropertyId(String propertyId);

}
