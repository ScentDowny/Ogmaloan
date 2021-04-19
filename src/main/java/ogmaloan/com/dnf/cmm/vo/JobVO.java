package ogmaloan.com.dnf.cmm.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobVO {
    private String jobId;
    private String jobName;
    private String jobGrowId;
    private String jobGrowName;
    private int parentJobOrder;
    private int jobGrowOrder;
    private int jobOrder;

    public void setJobInfo(String jobId, String jobGrowId, String jobName, String jobGrowName, int parentJobOrder, int jobGrowOrder, int jobOrder) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobGrowId = jobGrowId;
        this.jobGrowName = jobGrowName;
        this.parentJobOrder = parentJobOrder;
        this.jobGrowOrder = jobGrowOrder;
        this.jobOrder = jobOrder;
    }
}
