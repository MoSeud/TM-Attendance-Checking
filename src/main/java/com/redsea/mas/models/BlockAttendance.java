package com.redsea.mas.models;

import com.redsea.mas.domain.Block;
import com.redsea.mas.domain.Student;


public class BlockAttendance {

    private Student student;
    private Block block;
    private Integer sessionsInBlock;
    private Integer daysPresent;
    private Double percentageAttended;
    private Double extraCreditPoints;

    public Integer getSessionsInBlock() {
        return sessionsInBlock;
    }

    public void setSessionsInBlock(Integer sessionsInBlock) {
        this.sessionsInBlock = sessionsInBlock;
    }

    public Integer getDaysPresent() {
        return daysPresent;
    }

    public void setDaysPresent(Integer daysPresent) {
        this.daysPresent = daysPresent;
    }

    public Double getPercentageAttended() {
        return percentageAttended;
    }

    public void setPercentageAttended(Double percentageAttended) {
        this.percentageAttended = percentageAttended;
    }

    public Double getExtraCreditPoints() {
        return extraCreditPoints;
    }

    public void setExtraCreditPoints(Double extraCreditPoints) {
        this.extraCreditPoints = extraCreditPoints;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
