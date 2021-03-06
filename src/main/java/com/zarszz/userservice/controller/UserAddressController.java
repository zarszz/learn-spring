package com.zarszz.userservice.controller;

import com.zarszz.userservice.requests.v1.useraddress.CreateUserAddressDto;
import com.zarszz.userservice.requests.v1.useraddress.UpdateUserAddressDto;
import com.zarszz.userservice.persistence.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user-address")
public class UserAddressController {

    @Autowired
    UserAddressService userAddressService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CreateUserAddressDto createUserAddressDto) throws Exception {
        userAddressService.create(createUserAddressDto);
        return ResponseEntity.ok("Request success");
    }

    @GetMapping
    ResponseEntity<?> get() {
        return ResponseEntity.ok(userAddressService.get());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userAddressService.getById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateUserAddressDto updateUserAddressDto) {
        userAddressService.update(updateUserAddressDto, id);
        return ResponseEntity.ok("Request success");
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userAddressService.delete(id);
        return ResponseEntity.ok("Request success");
    }
}
