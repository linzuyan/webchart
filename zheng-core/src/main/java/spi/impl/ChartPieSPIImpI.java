package spi.impl;

import domain.manager.ChartPieNginxBrowserManager;
import domain.model.ChartPieModel;
import domain.model.system.query.ChartPieQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spi.system.ChartPieSPI;

import java.util.List;

@Service("ChartSPIService")
public class ChartPieSPIImpI implements ChartPieSPI{

    @Autowired
    private ChartPieNginxBrowserManager chartPieNginxBrowserManager;
    public List<ChartPieModel> queryPieChart(ChartPieQuery query) {
        /*List<ChartPieModel> chartList=new ArrayList<ChartPieModel>();*/
        List<ChartPieModel> chartList = null;
        try {
            chartList =  chartPieNginxBrowserManager.querylist(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chartList;
    }
}
