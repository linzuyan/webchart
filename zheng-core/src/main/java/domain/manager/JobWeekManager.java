package domain.manager;
import domain.mapper.JobMapper;
/*方法类 接口类实例化来此调用方法*/
import domain.mapper.JobWeekMapper;
import domain.model.JobWeek;
import domain.model.system.query.MemberQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class JobWeekManager {
    @Autowired
    private JobWeekMapper jobweekdao;
    public boolean addJobWeek(JobWeek zhoubao){
        jobweekdao.addJobWeek(zhoubao);
        return true;
    }

    public List<JobWeek> queryPagelistjob(MemberQuery query){
        return jobweekdao.queryPageListjob(query);
    }

    public int queryCountPagejob(MemberQuery query){
        return jobweekdao.queryCountPagejob(query);
    }
}
