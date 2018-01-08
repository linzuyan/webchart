package domain.model;

public class ChartPieModel {
    private long id;
    private String PieKey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPieKey() {
        return PieKey;
    }

    public void setPieKey(String pieKey) {
        PieKey = pieKey;
    }

    public long getPieValue() {
        return PieValue;
    }

    public void setPieValue(long pieValue) {
        PieValue = pieValue;
    }

    private long PieValue;


}
