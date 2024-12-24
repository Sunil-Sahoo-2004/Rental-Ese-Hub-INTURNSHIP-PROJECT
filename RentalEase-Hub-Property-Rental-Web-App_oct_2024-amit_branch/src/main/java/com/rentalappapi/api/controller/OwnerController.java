package com.rentalappapi.api.controller;

import com.rentalappapi.api.entity.OwnerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rentalappapi.api.model.OwnerIdRequest;
import com.rentalappapi.api.model.OwnerRequestBody;
import com.rentalappapi.api.service.OwnerService;

@RestController
@CrossOrigin
public class OwnerController {

    @Autowired
    private OwnerService OwnerService;

    @RequestMapping(value = "/createOwner", method = RequestMethod.POST)
    public ResponseEntity<?> createOwner(@RequestBody OwnerRequestBody OwnerReqBody) throws Exception {
        return ResponseEntity.ok(OwnerService.createOwner(OwnerReqBody));
    }

    @RequestMapping(value = "/updateOwner", method = RequestMethod.PUT)
    public ResponseEntity<?> updateOwner(@RequestBody OwnerRequestBody OwnerReqBody) throws Exception {
        return ResponseEntity.ok(OwnerService.updateOwner(OwnerReqBody));
    }

    @RequestMapping(value = "/listAllOwners", method = RequestMethod.GET)
    public ResponseEntity<?> listAllOwners(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                          @RequestParam(defaultValue = "10") final Integer size) throws Exception {
        return ResponseEntity.ok(OwnerService.listallownersfromdb(pageNumber, size));
    }

    @RequestMapping(value = "/owner/{ownerId}", method = RequestMethod.GET)
    public ResponseEntity<OwnerEntity> getOwnerById(@PathVariable int ownerId) {
        return ResponseEntity.ok(OwnerService.getOwnerById(ownerId));
    }

    @RequestMapping(value = "/deleteOwner", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOwner(@RequestBody OwnerIdRequest owner) throws Exception {
        return ResponseEntity.ok(OwnerService.deleteOwner(owner));
    }

    @RequestMapping(value = "/ownersCount", method = RequestMethod.GET)
    public ResponseEntity<?> countNumberOfOwners() throws Exception {
        return ResponseEntity.ok((OwnerService.countNumberOfOwners()));
    }

}
