package spi.impl;

import domain.db.DynamicData;
import domain.dto.AuthPerm;
import domain.dto.MemberDto;
import domain.dto.MemberRoleDto;
import domain.manager.MemberManager;
import domain.manager.PermManager;
import domain.manager.RoleManager;
import domain.model.PageModel;
import domain.model.system.Member;
import domain.model.system.Perm;
import domain.model.system.Role;
import domain.model.system.query.MemberQuery;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spi.system.MemberSPI;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan.zheng on 2017/12/8.
 */
/*实现前面的接口：方法   方法中：利用前面定义的对象 MemberManager memberManager;来调用该对象的方法*/
/*@Service是一个注解啊，告诉spring创建一个实现类的实例啊。。。
就是不用再spring里配置bean，就是因为这个@Service*/
@Service("memberSPIService")
public class MemberSPIImpl implements MemberSPI {
    @Autowired
    private RoleManager roleManager;
    @Autowired
    private MemberManager memberManager;
    @Autowired
    private PermManager permManager;

    /**/
    @DynamicData(source = "ds2")
    public List<Member> querylist() {
        return memberManager.querylist();
    }

    @DynamicData(source = "ds2")
    public PageModel<MemberDto> queryPageList(MemberQuery query) {
        /*定义*/
        List<MemberDto> listDto=new ArrayList<MemberDto>();
        /*查询 查询的时候可以定义几条第几条 在query中即可 */

        List<Member> list= memberManager.queryPagelist(query);
        /*查询该表多少数据*/
        int count=memberManager.queryCountPage(query);
       /*要讲list 分装到 pagemodel中的model中*/
        for (Member member:list) {
            /* list中有多个member   定义一个对象 接值 了*/
            MemberDto memberDto=new  MemberDto();
            /*PropertyUtils.copyProperties(Object dest , Object orig)是org.apache.commons.beanutils包中的方法-----j
            ava对象的拷贝。在实际的开发中，一个实体类（javaBean）的属性通常比较多，get/set方法堆积也比较多，为了便于
            其他开发人员的代码阅读，PropertyUtils.copyProperties()方法可以将一个bean的属性拷贝到另一个bean中。第一个参
            数为目标bean,第二个为源bean*/
            try {
                /*对象拷贝*/
                PropertyUtils.copyProperties(memberDto,member);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
             /**/
            List<MemberRoleDto> liststr=new ArrayList<MemberRoleDto>();
            /*更具id 查询role权限*/
           /*list是可以用一个或者多个*/
            List<Role> rolelist= roleManager.queryByMemberId(member.getId());

             /* 将所查询的对象信息 将id 等传给memberRoleDto  最后add 在liststr数组下*/
            for (Role role:rolelist) {
                MemberRoleDto memberRoleDto=new MemberRoleDto();
                memberRoleDto.setId(role.getId());
                memberRoleDto.setName(role.getDisplayName());
                /**/
                liststr.add(memberRoleDto);
            }
            /*setRoles 可以承接的对象  （ List<MemberRoleDto> roles） 该roles类型为 list*/
            memberDto.setRoles(liststr);
            /*add  将其称为数组之一  */
            listDto.add(memberDto);
        }
        /*设置参数进去 MemberDto的数据类型  还有一些列表参数 */
        PageModel<MemberDto> pageModel=new PageModel<MemberDto>(listDto,query.getCurrPage(),count,query.getPageSize());
        return pageModel;
    }


    /*未写完*/




    public MemberDto queryById(Long id) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MemberDto memberDto=new MemberDto();
        Member member=memberManager.queryById(id);
        PropertyUtils.copyProperties(memberDto,member);
        //List<Role> rolelist= roleDao.queryByMemberId(id);
        List<Role> rolelist=roleManager.queryByMemberId(id);
        List<MemberRoleDto> memberRoleDtos=new ArrayList<MemberRoleDto>();
        for (Role role:rolelist) {
            MemberRoleDto memberRoleDto=new MemberRoleDto();
            memberRoleDto.setId(role.getId());
            memberRoleDto.setName(role.getDisplayName());
            memberRoleDtos.add(memberRoleDto);
        }
        memberDto.setRoles(memberRoleDtos);
        return memberDto;
    }

    public Member queryByUsername(String username) {
//        AuthMemberDto authMemberDto=new AuthMemberDto();
        //Member member= memberDao.queryByUsername(username);
        Member member= null;
        try {
            member = memberManager.queryByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if (member!=null){
//            authMemberDto.setId(member.getId());
//            authMemberDto.setPhone(member.getPhone());
//            authMemberDto.setAddress(member.getAddress());
//            authMemberDto.setImgUrl(member.getImgUrl());
//            authMemberDto.setUserName(member.getUserName());
//            authMemberDto.setPassword(member.getPassword());
//            authMemberDto.setStatus(member.getStatus());
//
//            List<Perm> perms= permDao.queryByMemberIdAndParentId(member.getId(),(long)0);
//            List<AuthPerm> authpermlist=new ArrayList<AuthPerm>();
//            for (Perm perm:perms) {
//                AuthPerm authperm=new AuthPerm();
//                authperm.setName(perm.getDisplayName());
//                authperm.setUrl(perm.getUrl());
//                List<Perm> perms2= permDao.queryByMemberIdAndParentId(member.getId(),perm.getId());
//                List<AuthPerm> authpermlist2=new ArrayList<AuthPerm>();
//                for (Perm perm2:perms2) {
//                    AuthPerm authperm2=new AuthPerm();
//                    authperm2.setName(perm2.getDisplayName());
//                    authperm2.setUrl(perm2.getUrl());
//                    authpermlist2.add(authperm2);
//                }
//                authpermlist.add(authperm);
//            }
//            authMemberDto.setRoles(authpermlist);
//        }
        return member;
    }

    public List<AuthPerm> queryAuthPerm(Long memberid) {
        /*变量 用户地址roles*/
        List<AuthPerm> authpermlist=new ArrayList<AuthPerm>();
        /*Perm  对应url与role id*/
        /*由用户id去查找所有可用的所有资源，的集合就是list《Perm》 第一层列表的*/
        List<Perm> perms= permManager.queryByMemberIdAndParentId(memberid,(long)0);
        /*定义一个perm*/
        for (Perm perm:perms) {

            AuthPerm authperm=new AuthPerm();
            authperm.setName(perm.getDisplayName());
            authperm.setUrl(perm.getUrl());
           /*perms2中两者条件都必须成立 perms2第二层列表 */
            List<Perm> perms2= permManager.queryByMemberIdAndParentId(memberid,perm.getId());
            /**/
            List<AuthPerm> authpermlist2=new ArrayList<AuthPerm>();
            /*查找完毕赋予 authpermlist*/
            for (Perm perm2:perms2) {
                AuthPerm authperm2=new AuthPerm();
                authperm2.setName(perm2.getDisplayName());
                authperm2.setUrl(perm2.getUrl());
                /**/
                authpermlist2.add(authperm2);
            }
            authperm.setRoles(authpermlist2);
            authpermlist.add(authperm);
        }
        return authpermlist;
    }

    public Member insertMember(Member member, String roleids) {
        memberManager.insertmember(member,roleids);
        return member;
    }

    public int deleteMember(Long id) {
        return memberManager.deleteMember(id);
    }

    public int updateStatus(Long memberid, Short status) {
        return memberManager.updateStatus(memberid,status);
    }
}
