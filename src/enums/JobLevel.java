package enums;

public enum JobLevel {
    HANDLOWIEC("Handlowiec"),
    DYREKTOR("Dyrektor");

    private final String jobName;

    JobLevel(String job) {
        this.jobName = job;
    }

    @Override
    public String toString() {
        return jobName;
    }
}