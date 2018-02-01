package spi.impl;

import domain.dto.KpiIpAndNumDto;
import domain.manager.KpiIpAndNumManager;
import domain.model.PageModel;
import domain.model.system.query.IpAndNumQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spi.system.KipIpAndNumSPI;

import java.util.List;


@Service("KipIpAndNumSPIService")
public class KipIpAndNumSPIImpl implements KipIpAndNumSPI {
    @Autowired
    KpiIpAndNumManager kpiIpAndNumManager;

    public PageModel<KpiIpAndNumDto> queryPageList(IpAndNumQuery query) {

        int count = 6;
        try {
            count = kpiIpAndNumManager.queryCountPage(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<KpiIpAndNumDto> listDto = kpiIpAndNumManager.queryPagelist(query);

        PageModel<KpiIpAndNumDto> pageModel=new PageModel<KpiIpAndNumDto>(listDto,query.getCurrPage(),count,query.getPageSize());
        return pageModel;
    }
}
