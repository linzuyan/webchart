package spi.system;

import domain.model.ChartPieModel;
import domain.model.system.query.ChartPieQuery;

import java.util.List;

public interface ChartPieSPI {
    List<ChartPieModel> queryPieChart(ChartPieQuery query);

}
