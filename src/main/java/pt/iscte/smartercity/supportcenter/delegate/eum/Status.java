package pt.iscte.smartercity.supportcenter.delegate.eum;

public enum Status {
    ABANDONED("ABANDONED"),
    REFUND_ACCEPTED("ACCEPTED"),
    REFUND_DECLINED("DECLINED"),
    FIXED("FIXED"),
    IN_PROGRESS("IN PROGRESS");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
