package domain.mapper;

import domain.model.JobWeek;
import domain.model.system.query.MemberQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*这个接口是用于一张表的调用*/
public interface JobWeekMapper {
    public boolean addJobWeek(JobWeek zhoubao);
    public void updateById(JobWeek zhoubao);
    public int queryCountPagejob(MemberQuery query);
    public List<JobWeek> queryPageListjob(@Param("query") MemberQuery query);

}
