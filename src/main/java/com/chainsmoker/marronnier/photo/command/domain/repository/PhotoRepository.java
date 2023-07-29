package com.chainsmoker.marronnier.photo.command.domain.repository;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long > {

    List<Photo> findAllByOriginIdAndAndPhotoCategory(long originId, PhotoCategory category);

}
