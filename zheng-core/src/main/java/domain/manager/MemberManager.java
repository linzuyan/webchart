package domain.manager;

import domain.mapper.MemberMapper;
import domain.mapper.MemberRoleMapper;
import domain.model.system.Member;
import domain.model.system.MemberRole;
import domain.model.system.query.MemberQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by XR on 2016/8/31.
 */
/*方法类 能够调用不同表的查询语句 当前可以定义两个不同的表*/
@Component
public class MemberManager {
    @Autowired
    private MemberMapper memberDao;
    @Autowired
    private MemberRoleMapper memberRoleDao;

    public List<Member> querylist(){
        return memberDao.querylist();
    }

    public List<Member> queryPagelist(MemberQuery query){
        return memberDao.queryPageList(query);
    }

    public int queryCountPage(MemberQuery query){
        return memberDao.queryCountPage(query);
    }

    public Member queryByUsername(String username){
        return memberDao.queryByUsername(username);
    }

    public Member queryById(Long id){
        return memberDao.queryById(id);
    }

    /*声明式事务管理建立在AOP之上的。  其本质是对方法前后进行拦截， 然后在目标方法开始之前创建或者加入一个事务，在执行完目
    标方法之后根据执行情况提交或者回滚事务。声明式事务最大的优点就是不需要通过编程的方式管理事务，这样就不需要在业务逻辑
    代码中掺杂事务管理的代码，只需在配置文件中做相关的事务规则声明(或通过基于@Transactional注解的方式)，便可以将事务规则
    应用到业务逻辑中*/
    @Transactional(rollbackFor = Exception.class)
    public boolean insertmember(Member member,String ids){
        if (memberDao.insertmember(member)>0){
            MemberRole memberRole=new MemberRole();
            memberRole.setRoleIds(ids);
            memberRole.setMemberId(member.getId());
            memberRole.setCreateTime(new Date());
            memberRoleDao.insertMemberRole(memberRole);
            return true;
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    public int deleteMember(Long id){
        return memberDao.deleteMember(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateStatus(Long memberid,Short status){
        return memberDao.updateStatus(memberid,status);
    }
}
