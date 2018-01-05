package domain.model;

public class JobWeek extends BaseModel {
    private Long id;
    private Long PartId;
    private String Week1;
    private String Week2;
    private String Week3;
    private String Week4;
    private String Week5;
    private String Week6;
    private String Week7;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPartId() {
        return PartId;
    }

    public void setPartId(Long partId) {
        PartId = partId;
    }

    public String getWeek1() {
        return Week1;
    }

    public void setWeek1(String week1) {
        Week1 = week1;
    }

    public String getWeek2() {
        return Week2;
    }

    public void setWeek2(String week2) {
        Week2 = week2;
    }

    public String getWeek3() {
        return Week3;
    }

    public void setWeek3(String week3) {
        Week3 = week3;
    }

    public String getWeek4() {
        return Week4;
    }

    public void setWeek4(String week4) {
        Week4 = week4;
    }

    public String getWeek5() {
        return Week5;
    }

    public void setWeek5(String week5) {
        Week5 = week5;
    }

    public String getWeek6() {
        return Week6;
    }

    public void setWeek6(String week6) {
        Week6 = week6;
    }

    public String getWeek7() {
        return Week7;
    }

    public void setWeek7(String week7) {
        Week7 = week7;
    }

    public String getWeekAll() {
        return WeekAll;
    }

    public void setWeekAll(String weekAll) {
        WeekAll = weekAll;
    }

    public String getNextPlan() {
        return NextPlan;
    }

    public void setNextPlan(String nextPlan) {
        NextPlan = nextPlan;
    }

    private String WeekAll;
    private String NextPlan;

}
