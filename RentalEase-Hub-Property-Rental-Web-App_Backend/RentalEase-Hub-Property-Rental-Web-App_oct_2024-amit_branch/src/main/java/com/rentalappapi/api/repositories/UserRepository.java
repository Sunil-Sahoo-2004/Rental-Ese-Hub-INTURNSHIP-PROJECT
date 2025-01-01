package com.rentalappapi.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rentalappapi.api.entity.UserEntity;
import com.rentalappapi.api.model.UserRequestBody;

@Repository
public interface  UserRepository extends CrudRepository<UserEntity,Integer> {

//    @Query(value = "select * from  main_User ", nativeQuery = true)
    @Query(value = "select * from amit_users", nativeQuery = true)
    Page<UserEntity> listallusersfromdb(Pageable pageable);

    @Query(value = "SELECT count(*) from amit_users", nativeQuery = true)
    String countNumberOfUser();

}
