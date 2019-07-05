package com.redsea.mas.models;




import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Student;

import java.util.List;

public class CumulativeAttendance {

    private Student student;

    private List<Block> blocks;

    private Integer totalSession;

    private Integer totalAttended;

    private Double attendedPercent;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Integer getTotalSession() {
        return totalSession;
    }

    public void setTotalSession(Integer totalSession) {
        this.totalSession = totalSession;
    }

    public Integer getTotalAttended() {
        return totalAttended;
    }

    public void setTotalAttended(Integer totalAttended) {
        this.totalAttended = totalAttended;
    }

    public Double getAttendedPercent() {
        return attendedPercent;
    }

    public void setAttendedPercent(Double attendedPercent) {
        this.attendedPercent = attendedPercent;
    }
}
