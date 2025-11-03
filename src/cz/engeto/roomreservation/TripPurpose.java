package cz.engeto.roomreservation;

public enum TripPurpose {
    BUSINESS("pracovní"), VACATION("rekreační");

    private String description;

    TripPurpose(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
