package com.rentalappapi.api.service;

import com.rentalappapi.api.entity.OwnerEntity;
import com.rentalappapi.api.model.OwnerIdRequest;
import com.rentalappapi.api.model.OwnerRequestBody;
import com.rentalappapi.api.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class OwnerService  {

    @Autowired
    private OwnerRepository OwnerRepository;

    public OwnerEntity createOwner(OwnerRequestBody ownerRequestBodyObj) {
        OwnerEntity newOwner = new OwnerEntity();
        newOwner.setFirstName(ownerRequestBodyObj.getFirstName());
        newOwner.setLastName(ownerRequestBodyObj.getLastName());
        newOwner.setEmail(ownerRequestBodyObj.getEmail());
        newOwner.setPassword(ownerRequestBodyObj.getPassword());
        newOwner.setPhoneNumber(ownerRequestBodyObj.getPhoneNumber());
        newOwner.setAddress(ownerRequestBodyObj.getAddress());
        return OwnerRepository.save(newOwner);
    }

    public OwnerEntity updateOwner(OwnerRequestBody ownerRequestBodyObj) {
        OwnerEntity newOwner = new OwnerEntity();
        newOwner.setOwnerId(ownerRequestBodyObj.getOwnerId());
        newOwner.setFirstName(ownerRequestBodyObj.getFirstName());
        newOwner.setLastName(ownerRequestBodyObj.getLastName());
        newOwner.setEmail(ownerRequestBodyObj.getEmail());
        newOwner.setPassword(ownerRequestBodyObj.getPassword());
        newOwner.setPhoneNumber(ownerRequestBodyObj.getPhoneNumber());
        newOwner.setAddress(ownerRequestBodyObj.getAddress());
        return OwnerRepository.save(newOwner);
    }

    public Page<OwnerEntity> listallownersfromdb(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return OwnerRepository.listallownersfromdb(pageable);
    }

    public OwnerEntity getOwnerById(int ownerId) {
        return OwnerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found with id: " + ownerId));
    }

    public String deleteOwner(OwnerIdRequest owner) {
        int OwnerId = owner.getOwnerId();
        OwnerRepository.deleteById(OwnerId);
        return "Owner Deleted";
    }

    public String countNumberOfOwners() {
        return OwnerRepository.countNumberOfOwner();
    }

}
