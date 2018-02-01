package domain.dto;

public class KpiIpAndNumDto extends BaseDto {
    private String kpiip;
    private Long  num;

    public String getKpiip() {
        return kpiip;
    }

    public void setKpiip(String kpiip) {
        this.kpiip = kpiip;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
