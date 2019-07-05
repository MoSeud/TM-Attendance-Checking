package com.redsea.mas.serviceImpl;


import com.redsea.mas.domain.Block;
import com.redsea.mas.repository.BlockRepo;
import com.redsea.mas.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    BlockRepo blockRepo;

    @Override
    public List<Block> findAll() {
        return (List<Block>) blockRepo.findAll();
    }

    @Override
    public Block save(Block block) {
        return blockRepo.save(block);
    }

    @Override
    public void delete(Long id) {
        blockRepo.deleteById(id);
    }

    @Override
    public Block findById(Long id) {
        return blockRepo.findById(id).orElse(null);
    }

    @Override
    public List<Block> findByYear(int year) {
        List<Block> blocks=findAll();
        return blocks.stream().filter(block -> block.getEndDate().getYear() == year).collect(Collectors.toList());

    }

    @Override
    public Block findByDate(LocalDate localDate) {
        List<Block> blocks=findAll();
        Block block= blocks.stream().filter(date -> {
            return ((localDate.isAfter(date.getStartDate()) && localDate.isBefore(date.getEndDate())) || localDate.isEqual(date.getEndDate()) || localDate.isEqual(date.getStartDate()) );

        }).findFirst().orElse(null);
        return block;
    }

    @Override
    public List<Block> isAfter(LocalDate localDate) {
        return blockRepo.findAllByStartDateAfter(localDate);
    }
}
