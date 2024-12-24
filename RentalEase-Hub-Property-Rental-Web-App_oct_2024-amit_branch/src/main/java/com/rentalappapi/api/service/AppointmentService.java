package com.rentalappapi.api.service;

import com.rentalappapi.api.entity.AppointmentEntity;
import com.rentalappapi.api.model.AppointmentIdRequest;
import com.rentalappapi.api.model.AppointmentRequestBody;
import com.rentalappapi.api.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class AppointmentService  {

    @Autowired
    private AppointmentRepository AppointmentRepository;

    private LocalDate parseDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }

    private LocalTime parseTime(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ISO_TIME);
    }

    public AppointmentEntity createAppointment(AppointmentRequestBody appointmentRequestBodyObj) {
        AppointmentEntity newAppointment = new AppointmentEntity();
        newAppointment.setUserId(appointmentRequestBodyObj.getUserId());
        newAppointment.setOwnerId(appointmentRequestBodyObj.getOwnerId());
        newAppointment.setPropertyId(appointmentRequestBodyObj.getPropertyId());
        newAppointment.setAppointmentDate(parseDate(appointmentRequestBodyObj.getAppointmentDate()));
        newAppointment.setAppointmentTime(parseTime(appointmentRequestBodyObj.getAppointmentTime()));
        newAppointment.setAppointmentStatus(appointmentRequestBodyObj.getAppointmentStatus());
        newAppointment.setReasonForVisit(appointmentRequestBodyObj.getReasonForVisit());
        return AppointmentRepository.save(newAppointment);
    }

    public AppointmentEntity updateAppointment(AppointmentRequestBody appointmentRequestBodyObj) {
        int appointmentId = appointmentRequestBodyObj.getAppointmentId();
        AppointmentEntity newAppointment = AppointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment Not Found!"));

        newAppointment.setUserId(appointmentRequestBodyObj.getUserId());
        newAppointment.setOwnerId(appointmentRequestBodyObj.getOwnerId());
        newAppointment.setPropertyId(appointmentRequestBodyObj.getPropertyId());
        newAppointment.setAppointmentDate(parseDate(appointmentRequestBodyObj.getAppointmentDate()));
        newAppointment.setAppointmentTime(parseTime(appointmentRequestBodyObj.getAppointmentTime()));
        newAppointment.setAppointmentStatus(appointmentRequestBodyObj.getAppointmentStatus());
        newAppointment.setReasonForVisit(appointmentRequestBodyObj.getReasonForVisit());
        return AppointmentRepository.save(newAppointment);
    }

    public Page<AppointmentEntity> listallappointmentsfromdb(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return AppointmentRepository.listallappointmentsfromdb(pageable);
    }

    public String deleteAppointment(AppointmentIdRequest appointment) {
        int AppointmentId = appointment.getAppointmentId();
        AppointmentRepository.deleteById(AppointmentId);
        return "Appointment Deleted";
    }

    public String countNumberOfAppointments() {
        return AppointmentRepository.countNumberOfAppointment();
    }

}
