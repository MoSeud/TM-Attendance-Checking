package com.redsea.mas.repository;

import com.redsea.mas.domain.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BlockRepo extends CrudRepository<Block, Long> {
    List<Block> findAllByStartDateAfter(LocalDate localDate);
}
