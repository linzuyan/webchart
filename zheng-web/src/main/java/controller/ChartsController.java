package controller;


import domain.model.ChartPieModel;
import domain.model.system.query.ChartPieQuery;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spi.system.ChartPieSPI;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ChartsController extends BaseController {
    @Resource
    private ChartPieSPI chartPieSPIService;
    @RequestMapping(value = "/Charts/charts-1")
    public String chart1(Model model){
        ChartPieQuery query = new ChartPieQuery();
        List<ChartPieModel> chartList =chartPieSPIService.queryPieChart(query);
        model.addAttribute("ChartList",chartList);
        return "/Charts/charts-1";
    }

    @ResponseBody
    @RequestMapping(value = "/Charts/AjaxCharts1",method = {RequestMethod.POST})
    public List<ChartPieModel> AjaxChart1(){
        ChartPieQuery query = new ChartPieQuery();
        List<ChartPieModel> chartList =chartPieSPIService.queryPieChart(query);
        /*计算百分比*/
        /*long sizezong = 0;
        for (int i = 0;i<chartList.size();i++){
           sizezong =  sizezong + chartList.get(i).getPieValue();
        }
        for (int i = 0;i<chartList.size();i++){

        }*/

        return chartList;
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
