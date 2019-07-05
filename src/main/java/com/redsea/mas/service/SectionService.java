package com.redsea.mas.service;


import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Faculty;
import com.redsea.mas.domain.Section;

import java.util.List;

public interface SectionService {
    Section findByFacultyAndBlock(Faculty faculty, Block block);
    List<Block> blockTeachByProfessors(Faculty professor);
    Section save(Section section);
    List<Section> findAll();
    Section findById(Long id);
}
