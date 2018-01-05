package controller;
import common.AuthUser;
import common.Constants;
import domain.model.JobWeek;
import annotation.Auth;
import common.JsonResult;
import domain.dto.RolePermDto;
import domain.model.PageModel;
import domain.model.system.Role;
import domain.model.system.query.RoleQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import domain.model.system.query.MemberQuery;

import javax.servlet.http.HttpServletRequest;
import spi.system.PermissionSPI;
import spi.system.RoleSPI;
import spi.system.JobSPI;
import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/*@SessionAttributes(value="_session_user")*/
@Controller
public class JobController extends BaseController {
    @Resource
    private JobSPI JobSPIService;

  /*  @RequestMapping(value = "/job/joblist")
    public String loglist(){

        return "/job/joblist";
    }*/

    @RequestMapping(value = "/job/log")
    public String log(){
        return "/job/log";
    }

    @ResponseBody
    @RequestMapping(value = "/job/logcommit" ,method = {RequestMethod.POST})
    public JsonResult logcommit(HttpServletRequest request, JobWeek zhoubao){

        try {
            /*if (zhoubao.getId()>0){     //编辑

                *//*iMember.updateById(member);*//*
            }else {                    //新增
                JobSPIService.addJobWeek(zhoubao);
                *//*iMember.addMember(member);*//*

            }*/
            /*将用户id给予partid*/
            AuthUser authUser=(AuthUser) request.getSession().getAttribute(Constants.SESSION_USER_KEY);
            zhoubao.setPartId(authUser.getId());
            JobSPIService.addJobWeek(zhoubao);
            return jsonResult(1,"成功");
        }catch (Exception e){
            return jsonResult(-1,"出错");
        }
    }

    /*@Auth(rule = "/job/joblist")*/
    @RequestMapping(value = "/job/joblist")
    public String index(Model model, HttpSession httpSession) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MemberQuery query=new MemberQuery();
        /* 查询这个中所有数据 并且以pagemodel所有数据展示（MemberDto）*/
        PageModel<JobWeek> list= JobSPIService.queryPageList(query);
        model.addAttribute("memberlist",list);
        model.addAttribute("user",getAuthUser(httpSession));
        return "/job/joblist";
    }


}
