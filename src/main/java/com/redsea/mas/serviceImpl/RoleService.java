package com.redsea.mas.serviceImpl;

import com.redsea.mas.domain.Role;
import com.redsea.mas.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

@Autowired
RoleRepository roleRepository;

public Role save(Role r){
    return roleRepository.save(r);
}
}
