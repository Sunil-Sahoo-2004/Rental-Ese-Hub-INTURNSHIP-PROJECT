package com.rentalappapi.api.repositories;

import com.rentalappapi.api.entity.OwnerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Integer> {
    @Query(value = "select * from amit_owners", nativeQuery = true)
    Page<OwnerEntity> listallownersfromdb(Pageable pageable);

    @Query(value = "SELECT count(*) from amit_owners", nativeQuery = true)
    String countNumberOfOwner();
}