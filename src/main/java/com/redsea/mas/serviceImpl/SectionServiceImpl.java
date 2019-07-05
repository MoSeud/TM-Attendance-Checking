package com.redsea.mas.serviceImpl;

import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Faculty;
import com.redsea.mas.domain.Section;
import com.redsea.mas.repository.SectionRepository;
import com.redsea.mas.service.SectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionRepository sectionRepository;

    @Override
    public Section findByFacultyAndBlock(Faculty faculty, Block block) {
        return sectionRepository.findByProfessorAndBlock(faculty,block);
    }

    @Override
    public List<Block> blockTeachByProfessors(Faculty professor) {
        List<Section> sections= sectionRepository.findAllByProfessor(professor);
        return sections.stream().map(Section::getBlock).collect(Collectors.toList());
    }

    @Override
    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public List<Section> findAll() {
        return (List<Section>) sectionRepository.findAll();
    }

    @Override
    public Section findById(Long id) {
        return sectionRepository.findById(id).get();
    }
}
