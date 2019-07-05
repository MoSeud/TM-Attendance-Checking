package com.redsea.mas.serviceImpl;

import com.redsea.mas.domain.Student;
import com.redsea.mas.domain.TmCheckRetreat;
import com.redsea.mas.dto.TmCheckRetreatDto;
import com.redsea.mas.repository.StudentRepository;
import com.redsea.mas.repository.TmCheckRetreatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
public class TmCheckRetreatService {

    @Autowired
    private TmCheckRetreatRepository tmCheckRetreatRepository;

    @Autowired
    private StudentRepository studentRepository;


    public TmCheckRetreat saveTmCheckRetreat(TmCheckRetreatDto dto) {
        TmCheckRetreat tmCheckRetreat = dto.getId() == null ? new TmCheckRetreat()
                : tmCheckRetreatRepository.findById(dto.getId()).get();
        tmCheckRetreat.setDate(dto.getDate());
        tmCheckRetreat.setType(dto.getType());
        if (tmCheckRetreat.getStudent() != null) {
            tmCheckRetreat.getStudent().getTmCheckRetreatList().remove(tmCheckRetreat);
        }
        Student student = studentRepository.findById(dto.getStudent().getId()).get();
        tmCheckRetreat.setStudent(student);
        student.getTmCheckRetreatList().add(tmCheckRetreat);
        return tmCheckRetreatRepository.save(tmCheckRetreat);

    }

    public void removeTmCheckRetreat(long id) {
        TmCheckRetreat tmCheckRetreat = tmCheckRetreatRepository.findById(id).get();
        tmCheckRetreat.getStudent().getTmCheckRetreatList().remove(tmCheckRetreat);
        tmCheckRetreat.setStudent(null);
        tmCheckRetreatRepository.delete(tmCheckRetreat);
    }

    public TmCheckRetreatDto findTmCheckRetreatById(Long id) {
        TmCheckRetreat result = tmCheckRetreatRepository.findById(id).get();
        result.getStudent().getBarCode();
        TmCheckRetreatDto dto = new TmCheckRetreatDto();
        dto.setDate(result.getDate());
        dto.setId(result.getId());
        dto.setStudent(result.getStudent());
        dto.setType(result.getType());
        return dto;
    }

    public List<TmCheckRetreat> findTmCheckRetreatByDate(LocalDate startDate, LocalDate endDate) {
        //return tmCheckRetreatRepository.findByDateBetweenOrderByIdDesc(startDate, endDate);
        return (List<TmCheckRetreat>) tmCheckRetreatRepository.findAll();

    }

    public boolean checkDuplicate(TmCheckRetreatDto dto) {
        if (dto.getStudent() == null) {
            return true;
        }
        return !studentRepository.findById(dto.getStudent().getId()).get().getTmCheckRetreatList().stream()
                .filter(tm -> !tm.getId().equals(dto.getId()) && tm.getDate().equals(dto.getDate())).findAny()
                .isPresent();
    }


}
