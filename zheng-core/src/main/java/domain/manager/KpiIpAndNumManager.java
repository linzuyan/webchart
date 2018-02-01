package domain.manager;


import domain.dto.KpiIpAndNumDto;
import domain.mapper.KpiIpAndNumMapper;
import domain.model.system.query.IpAndNumQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KpiIpAndNumManager {
    @Autowired
    private KpiIpAndNumMapper KpiIpAndNumDao;
    public List<KpiIpAndNumDto> queryPagelist(IpAndNumQuery query){
        return KpiIpAndNumDao.queryPageList(query);
       /* if (query.getDatemax()==null){return memberDao.queryPageList(query);}else{
            return memberDao.queryPageListByDate(query);
        }*/

    }


    public int queryCountPage(IpAndNumQuery  query){
            return KpiIpAndNumDao.queryCountPage(query);
    }

}
