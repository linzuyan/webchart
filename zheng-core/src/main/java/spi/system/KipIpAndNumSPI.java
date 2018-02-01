package spi.system;

import domain.dto.KpiIpAndNumDto;
import domain.model.PageModel;
import domain.model.system.query.IpAndNumQuery;

public interface KipIpAndNumSPI {
    PageModel<KpiIpAndNumDto> queryPageList(IpAndNumQuery query);
}
