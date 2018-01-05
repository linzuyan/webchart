package spi.impl;
import domain.manager.JobWeekManager;
import domain.mapper.JobWeekMapper;
import domain.model.JobWeek;
import domain.model.PageModel;
import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spi.system.JobSPI;
import domain.model.system.query.MemberQuery;

import java.util.ArrayList;
import java.util.List;


@Service("JobSPIService")
public class JobSPIImpI implements JobSPI {
    @Autowired
    private JobWeekManager jobweekmanager;

    public boolean addJobWeek(JobWeek zhoubao){
        jobweekmanager.addJobWeek(zhoubao);
        int sex;
        sex = 0;
        sex = sex+1;
        return true;

    }
    public void updateById(JobWeek zhoubao){

    }

    public PageModel<JobWeek> queryPageList(MemberQuery query) {
        /*定义*/
        /*List<JobWeek> listDto=new ArrayList<JobWeek>();*/
        /*查询 查询的时候可以定义几条第几条 在query中即可 */
        List<JobWeek> list = null;
        try {
            list= jobweekmanager.queryPagelistjob(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*查询该表多少数据*/
        int count=jobweekmanager.queryCountPagejob(query);



        /*设置参数进去 MemberDto的数据类型  还有一些列表参数 */
        PageModel<JobWeek> pageModel=new PageModel<JobWeek>(list,query.getCurrPage(),count,query.getPageSize());
        return pageModel;
    }

}


