package controller;

import common.JsonResult;
import linuxshell.ServerDetails;
import linuxshell.linuxshell;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MapreduceController extends BaseController{

    @RequestMapping(value = "/mapreduce/handle")
    public String mapreducehd(){
        return "/mapreduce/handle";
    }

    @ResponseBody
    @RequestMapping(value = "/mapreduce/Maphandle" ,method = {RequestMethod.POST})
    public JsonResult serverListScript(HttpServletRequest request, ServerDetails serverDetails){
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
        return jsonResult(1,"发布成功");
    }


}
