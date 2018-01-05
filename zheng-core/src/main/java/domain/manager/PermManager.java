package domain.manager;

import domain.mapper.MemberRoleMapper;
import domain.mapper.PermMapper;
import domain.mapper.RolePermMapper;
import domain.model.PageModel;
import domain.model.system.Perm;
import domain.model.system.query.PermQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import common.utility.StringUtility;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XR on 2016/8/31.
 */
/*、@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）*/
@Component
public class PermManager {
    @Autowired
    private PermMapper permMapper;
    @Autowired
    private MemberRoleMapper memberRoleDao;
    @Autowired
    private RolePermMapper rolePermDao;
    /*通过memberid或者parentid去查询permids对应的每一条所有资源   */
    public List<Perm> queryByMemberIdAndParentId(Long memberid,Long parentid){

        List<Perm> list=new ArrayList<Perm>();

        List<Long> roleids=new ArrayList<Long>();
        /*查找roleids 用户对应的权限id*/
        String rolestr= memberRoleDao.queryRolesByMemberId(memberid);
        /*字符转化*/
        roleids= StringUtility.StringToListLong(rolestr);
        /*通过查找permid*/
        List<String> permstr= rolePermDao.queryPermIdByRoleIds(roleids);

        List<Long> ids=new ArrayList<Long>();

        for (String perm:permstr) {
            ids.addAll(StringUtility.StringToListLong(perm));
        }
        list=permMapper.queryByIdsAndParentId(ids,parentid);
        return list;
    }

    public List<Perm> queryByRoleIdAndType(Long roleid,Integer type){
        String perms= rolePermDao.queryPermsByRoleId(roleid);
        List<Long> ids=StringUtility.StringToListLong(perms);
        return permMapper.queryByIdsAndType(ids,type);
    }


    /*就是通过memberid 去查找该id的权限id*/
    public List<String> queryUrlByMemberId(Long memberid){
        /**/
        List<String> strings=new ArrayList<String>();
        List<Perm> list=new ArrayList<Perm>();
        List<Long> roleids=new ArrayList<Long>();

        /*通过 memberid 查找role id*/
        String rolestr= memberRoleDao.queryRolesByMemberId(memberid);
        /*string 转化为listlong   为什么转化？？？为了可以循环，在查数据库的时候*/

        roleids= StringUtility.StringToListLong(rolestr);
        /*查找到permids（string） 由于我们输入的时候是List 所以接受也是List  返回的permstr 就是一个字符串也是由于多个字符组成*/
        List<String> permstr= rolePermDao.queryPermIdByRoleIds(roleids);

        List<Long> ids=new ArrayList<Long>();

        for (String perm:permstr) {
            /*add 是将传入的参数作为当前List中的一个Item存储，即使你传入一个List也只会另当前的List增加1个元素addAll
             是传入一个List，将此List中的所有元素加入到当前List中，也就是当前List会增加的元素个数为传入的List的大小*/
            ids.addAll(StringUtility.StringToListLong(perm));
        }
        /*ids  listlong size有多个数据*/
        return permMapper.queryUrlByListId(ids);
    }

    public List<String> queryIds(){
        List<String> list=new ArrayList<String>();
        list= permMapper.queryIds();
        return list;
    }

    public PageModel<Perm> queryPageList(PermQuery query){
        List<Perm> list= permMapper.queryPageList(query);
        int count= permMapper.queryCountPage(query);
        PageModel<Perm> permPageModel=new PageModel<Perm>(list,query.getCurrPage(),count,query.getPageSize());
        return permPageModel;
    }

    public Perm queryById(Long id){
        return permMapper.queryById(id);
    }

    public List<Perm> queryByType(List<Integer> types){
        List<Perm> list=new ArrayList<Perm>();
        list= permMapper.queryByType(types);
        return list;
    }

    public List<Perm> queryByParentId(Long id){
        return permMapper.queryByParentId(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertPerm(Perm perm){
        return permMapper.insertPerm(perm);
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateById(Perm perm){
        return permMapper.updateById(perm);
    }

    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id){
        return permMapper.deleteById(id);
    }
}
