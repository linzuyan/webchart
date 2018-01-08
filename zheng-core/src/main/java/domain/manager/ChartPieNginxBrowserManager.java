package domain.manager;

import domain.mapper.ChartPieNginxBrowserMapper;
import domain.model.ChartPieModel;
import domain.model.system.query.ChartPieQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChartPieNginxBrowserManager {
    @Autowired
    private ChartPieNginxBrowserMapper chartPieNginxBrowserdao;

    public List<ChartPieModel> querylist(ChartPieQuery query){
        return chartPieNginxBrowserdao.queryList(query);
    }
}
