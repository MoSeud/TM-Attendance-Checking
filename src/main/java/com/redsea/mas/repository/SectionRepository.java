package com.redsea.mas.repository;


import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Faculty;
import com.redsea.mas.domain.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends CrudRepository<Section,Long> {

    Section findByProfessorAndBlock(Faculty faculty, Block block);

    List<Section> findAllByProfessor(Faculty faculty);
}
