package com.rentalappapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentalappapi.api.model.AppointmentIdRequest;
import com.rentalappapi.api.model.AppointmentRequestBody;
import com.rentalappapi.api.service.AppointmentService;

@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentService AppointmentService;

    @RequestMapping(value = "/createAppointment", method = RequestMethod.POST)
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentRequestBody AppointmentReqBody) throws Exception {
        return ResponseEntity.ok(AppointmentService.createAppointment(AppointmentReqBody));
    }

    @RequestMapping(value = "/updateAppointment", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentRequestBody AppointmentReqBody) throws Exception {
        return ResponseEntity.ok(AppointmentService.updateAppointment(AppointmentReqBody));
    }

    @RequestMapping(value = "/listAllAppointments", method = RequestMethod.GET)
    public ResponseEntity<?> listAllAppointments(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                               @RequestParam(defaultValue = "10") final Integer size) throws Exception {
        return ResponseEntity.ok(AppointmentService.listallappointmentsfromdb(pageNumber, size));
    }

    @RequestMapping(value = "/deleteAppointment", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAppointment(@RequestBody AppointmentIdRequest user) throws Exception {
        return ResponseEntity.ok(AppointmentService.deleteAppointment(user));
    }

    @RequestMapping(value = "/appointmentCount", method = RequestMethod.GET)
    public ResponseEntity<?> countNumberOfAppointments() throws Exception {
        return ResponseEntity.ok((AppointmentService.countNumberOfAppointments()));
    }

}
