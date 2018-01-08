package domain.mapper;

import domain.model.ChartPieModel;
import domain.model.system.query.ChartPieQuery;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChartPieNginxBrowserMapper {
    List<ChartPieModel> queryList(@Param("query") ChartPieQuery query);
}
