package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartsController extends BaseController {
    @RequestMapping(value = "/Charts/charts-1")
    public String chart1(){
        return "/Charts/charts-1";
    }


    @RequestMapping(value = "/Charts/charts-2")
    public String chart2(){
        return "/Charts/charts-2";
    }

    @RequestMapping(value = "/Charts/charts-3")
    public String chart3(){
        return "/Charts/charts-3";
    }

    @RequestMapping(value = "/Charts/charts-4")
    public String chart4(){
        return "/Charts/charts-4";
    }

    @RequestMapping(value = "/Charts/charts-5")
    public String chart5(){
        return "/Charts/charts-5";
    }

    @RequestMapping(value = "/Charts/charts-6")
    public String chart6(){
        return "/Charts/charts-6";
    }

}
