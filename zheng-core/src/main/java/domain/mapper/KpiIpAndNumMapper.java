package domain.mapper;

import domain.dto.KpiIpAndNumDto;
import domain.model.system.query.IpAndNumQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KpiIpAndNumMapper {

    List<KpiIpAndNumDto> queryPageList(@Param("query") IpAndNumQuery query);

    int queryCountPage(@Param("query") IpAndNumQuery query);
}
