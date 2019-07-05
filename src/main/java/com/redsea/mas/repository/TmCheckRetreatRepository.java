package com.redsea.mas.repository;

import com.redsea.mas.domain.TmCheckRetreat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TmCheckRetreatRepository extends CrudRepository<TmCheckRetreat, Long> {
	List<TmCheckRetreat> findByDateBetweenOrderByIdDesc(LocalDate start, LocalDate end);
}
