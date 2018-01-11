package controller;

import linuxshell.linuxshell;
import linuxshell.ServerDetails;
import common.JsonResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/*线上发布控制器*/
@Controller
public class ProjectOnlineController extends BaseController{

    @ResponseBody
    @RequestMapping(value = "/project/gylOnline" ,method = {RequestMethod.POST})
    public JsonResult Onlinegyl(HttpServletRequest request,ServerDetails serverDetails){

        linuxshell linux=new linuxshell("192.168.61.204","root","xiaorong","utf-8");
        String result = linux.exec("/lin_jiao/txt.sh linzuyan");

        return jsonResult(1,result);
    }

    @ResponseBody
    @RequestMapping(value = "/project/ServerListScript" ,method = {RequestMethod.POST})
    public JsonResult serverListScript(HttpServletRequest request,ServerDetails serverDetails){
        String ip = serverDetails.getIp();
        String userName = serverDetails.getUserName();
        String passwd = serverDetails.getPassWd();
        String scriptPath = serverDetails.getScriptPath();
        String parameterOne = serverDetails.getParameterOne();
        String parameterTwo = serverDetails.getParameterTwo();
        String cmds = scriptPath+" "+parameterOne;

        linuxshell linux=new linuxshell(ip,userName,passwd,"utf-8");
        String result = linux.exec(cmds);
        System.out.println("结果"+result);
        return jsonResult(1,result);
    }

    @RequestMapping(value = "/project/gyl")
    public String chart2(){
        return "/project/gyl";
    }

}
