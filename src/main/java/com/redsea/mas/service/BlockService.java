package com.redsea.mas.service;


import com.redsea.mas.domain.Block;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface BlockService {
    List<Block> findAll();
    Block save(Block block);
    void delete(Long id);
    Block findById(Long id);
    List<Block> findByYear(int year);
    Block findByDate(LocalDate localDate);
    List<Block> isAfter(LocalDate localDate);
}
