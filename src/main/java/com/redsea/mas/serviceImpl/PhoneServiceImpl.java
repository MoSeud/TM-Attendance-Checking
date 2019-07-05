package com.redsea.mas.serviceImpl;

import com.redsea.mas.domain.Phone;
import com.redsea.mas.repository.PhoneRepository;
import com.redsea.mas.service.PhoneService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
   @Autowired
   private PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findById(id).get();
    }

    @Override
    public List<Phone> getAllPhones() {
        return (List<Phone>) phoneRepository.findAll();
    }

    @Override
    public List<Phone> findByArea(Integer area) {
        return phoneRepository.findAllByArea(area);
    }
}
