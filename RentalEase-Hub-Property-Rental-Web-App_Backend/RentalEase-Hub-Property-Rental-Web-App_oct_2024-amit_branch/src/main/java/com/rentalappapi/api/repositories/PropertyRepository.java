package com.rentalappapi.api.repositories;

import com.rentalappapi.api.entity.PropertyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PropertyRepository extends CrudRepository<PropertyEntity,Integer> {

	@Query(value = "select * from  amit_properties", nativeQuery = true)
	Page<PropertyEntity> listAllPropertiesFromDB(Pageable pageable);

	@Query(value = "SELECT count(*) from amit_properties", nativeQuery = true)
	String countNumberOfProperties();

}
