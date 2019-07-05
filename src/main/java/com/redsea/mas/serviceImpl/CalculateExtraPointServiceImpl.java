package com.redsea.mas.serviceImpl;


import com.redsea.mas.service.CalculateExtraPointService;
import com.redsea.mas.util.MeditationAttendancePercentage;
import com.redsea.mas.util.MeditationExtraPoint;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CalculateExtraPointServiceImpl implements CalculateExtraPointService {
    @Override
    public Double getExtraPoint(Double attendancePercentage) {
        Double high= MeditationAttendancePercentage.HIGH_ATTENDANCE.getValue();
        Double midume=MeditationAttendancePercentage.MEDIUM_ATTENDANCE.getValue();
        Double ok=MeditationAttendancePercentage.OK_ATTENDANCE.getValue();
        if(attendancePercentage >= high) return MeditationExtraPoint.HIGH_ATTENDANCE.getValue();
        else if(attendancePercentage >= midume ) return  MeditationExtraPoint.MEDIUM_ATTENDANCE.getValue();
        else if(attendancePercentage >= ok  ) return MeditationExtraPoint.OK_ATTENDANCE.getValue();
        else return MeditationExtraPoint.LOW_ATTENDANCE.getValue();
    }

    @Override
    public Double getPercentageAttendance(Integer sessionInBlock, Integer dayPresent) {
        DecimalFormat df2= new DecimalFormat(".#");
        Double percentage= (double) ((dayPresent * 100)/sessionInBlock) ;
        return Double.parseDouble(percentage.toString());
    }
}
