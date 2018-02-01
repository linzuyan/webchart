package domain.model.system.query;

import domain.model.QueryPageModel;

/**
 * Created by alan.zheng on 2017/1/19.
 */
public class MemberQuery extends QueryPageModel {
    private String datemin;
    private String datemax;

    public String getDatemin() {
        return datemin;
    }

    public void setDatemin(String datemin) {
        this.datemin = datemin;
    }

    public String getDatemax() {
        return datemax;
    }

    public void setDatemax(String datemax) {
        this.datemax = datemax;
    }
}
