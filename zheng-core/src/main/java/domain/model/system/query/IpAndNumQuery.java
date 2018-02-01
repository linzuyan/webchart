package domain.model.system.query;

import domain.model.QueryPageModel;

public class IpAndNumQuery extends QueryPageModel {
    private long nummin;
    private long nummax;

    public long getNummin() {
        return nummin;
    }

    public void setNummin(long nummin) {
        this.nummin = nummin;
    }

    public long getNummax() {
        return nummax;
    }

    public void setNummax(long nummax) {
        this.nummax = nummax;
    }
}
