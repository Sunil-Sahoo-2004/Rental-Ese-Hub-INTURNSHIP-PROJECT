package com.rentalappapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rentalappapi.api.entity.AppointmentEntity;

@Repository
public interface  AppointmentRepository extends CrudRepository<AppointmentEntity,Integer> {

    @Query(value = "select * from  amit_appointments", nativeQuery = true)
    Page<AppointmentEntity> listallappointmentsfromdb(Pageable pageable);

    @Query(value = "SELECT count(*) from amit_appointments", nativeQuery = true)
    String countNumberOfAppointment();

}
