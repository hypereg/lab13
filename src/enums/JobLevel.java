package enums;

import java.util.NoSuchElementException;

public enum JobLevel{
    HANDLOWIEC("handlowiec"),
    DYREKTOR("dyrektor");

    private final String jobName;

    JobLevel(String job) {
        this.jobName = job;
    }

    public String getJobName() {
        return jobName;
    }

    public static JobLevel resolve(String jobName) {
        if(jobName.equalsIgnoreCase(HANDLOWIEC.getJobName())){
            return HANDLOWIEC;
        } else if (jobName.equalsIgnoreCase(DYREKTOR.getJobName())) {
            return DYREKTOR;
        }
        throw new NoSuchElementException("Job not found");
    }
}
