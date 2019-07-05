package com.redsea.mas.service;

import org.springframework.stereotype.Service;


public interface CalculateExtraPointService {

    Double getExtraPoint(Double attendancePercentage);
    Double getPercentageAttendance(Integer sessionInBlock, Integer dayPresent);
}
