package spi.system;
import domain.model.JobWeek;
import domain.model.PageModel;
import domain.model.system.query.MemberQuery;


public interface JobSPI {
    public boolean addJobWeek(JobWeek zhoubao);
    public void updateById(JobWeek zhoubao);
    /*public void deleteById(long id);*/
    PageModel<JobWeek> queryPageList(MemberQuery query);

}
