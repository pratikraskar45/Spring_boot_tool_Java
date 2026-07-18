package com.pr.enums;

public enum DoctorAvailability {

    TEN_TO_TEN_THIRTY("10:00 AM to 10:30 AM"),
    TEN_THIRTY_TO_ELEVEN("10:30 AM to 11:00 AM"),
    ELEVEN_TO_ELEVEN_THIRTY("11:00 AM to 11:30 AM"),
    ELEVEN_THIRTY_TO_TWELVE("11:30 AM to 12:00 PM"),
    TWELVE_TO_TWELVE_THIRTY("12:00 PM to 12:30 PM"),
    TWELVE_THIRTY_TO_ONE("12:30 PM to 1:00 PM"),
    FOUR_TO_FOUR_THIRTY("4:00 PM to 4:30 PM"),
    FOUR_THIRTY_TO_FIVE("4:30 PM to 5:00 PM"),
    FIVE_TO_FIVE_THIRTY("5:00 PM to 5:30 PM"),
    FIVE_THIRTY_TO_SIX("5:30 PM to 6:00 PM");

    private final String label;

    DoctorAvailability(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
