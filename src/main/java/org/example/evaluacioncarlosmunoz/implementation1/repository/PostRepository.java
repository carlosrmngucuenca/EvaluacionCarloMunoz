package org.example.evaluacioncarlosmunoz.implementation1.repository;

import org.example.evaluacioncarlosmunoz.implementation1.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUserId(Long userId);
}
