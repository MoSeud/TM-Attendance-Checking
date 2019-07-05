package com.redsea.mas.util;

public enum MeditationExtraPoint {
    HIGH_ATTENDANCE(1.5),
    MEDIUM_ATTENDANCE (1.0),
    OK_ATTENDANCE(0.5),
    LOW_ATTENDANCE(0.0);

    private Double value;
    MeditationExtraPoint(Double value)
    {
        this.value=value;
    }

    public Double getValue()
    {
        return value;
    }
}
