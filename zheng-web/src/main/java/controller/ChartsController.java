package controller;


import domain.dto.KpiIpAndNumDto;
import domain.model.ChartPieModel;
import domain.model.PageModel;
import domain.model.system.query.ChartPieQuery;
import domain.model.system.query.IpAndNumQuery;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spi.system.ChartPieSPI;
import spi.system.KipIpAndNumSPI;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ChartsController extends BaseController {
    @Resource
    private ChartPieSPI chartPieSPIService;
    @Resource
    private KipIpAndNumSPI kipIpAndNumSPIService;
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

    @RequestMapping(value = "/Charts/nums-1")
    public String nums1(){
        return "/Charts/nums-1";
    }

    @RequestMapping(value = "Charts/querydateList")
    public String querydatelist(Model model, @RequestParam(defaultValue = "1") int currPage, @RequestParam(value = "datemin") long datemin, @RequestParam(value = "datemax") long datemax){
        IpAndNumQuery query=new IpAndNumQuery();
        query.setNummin(datemin);
        query.setNummax(datemax);
        query.setCurrPage(currPage);
        PageModel<KpiIpAndNumDto> kpiIpAndNumDtoPageModel = kipIpAndNumSPIService.queryPageList(query);
        PageModel<KpiIpAndNumDto> list= kpiIpAndNumDtoPageModel;

        model.addAttribute("memberlist",list);
        model.addAttribute("dateandlimit",query);
        return "/Charts/nums-1";
    }



}
