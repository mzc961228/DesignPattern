package com.testantd.demo.service;

import com.testantd.demo.bean.Address;

import java.util.List;

public interface AddressService {
    
    
    Address getAddressById(Integer id, Integer userId);

    Address saveAddress(Address address);

    List<Address> getAddressesByUserId(Integer userId);

    void deleteAddress(Integer id,Integer userId);

    Address getAddressById(Integer addressId);
}
