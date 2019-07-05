package com.redsea.mas.repository;


import com.redsea.mas.domain.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepository extends CrudRepository<Phone,Long> {
    List<Phone> findAllByArea(Integer area);
}
