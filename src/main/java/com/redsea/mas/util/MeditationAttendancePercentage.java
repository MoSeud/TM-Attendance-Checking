package com.redsea.mas.util;

public enum MeditationAttendancePercentage {
    HIGH_ATTENDANCE(90.0),
    MEDIUM_ATTENDANCE (80.0),
    OK_ATTENDANCE(70.0);

    private Double value;
    MeditationAttendancePercentage(Double value){

        this.value=value;
    }

    public Double getValue()
    {
        return value;
    }
}
