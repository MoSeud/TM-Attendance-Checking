package com.redsea.mas.service;



import com.redsea.mas.domain.Phone;

import java.util.List;

public interface PhoneService {
    Phone save(Phone phone);
    Phone findById(Long id);
    List<Phone> getAllPhones();
    List<Phone> findByArea(Integer area);
}
