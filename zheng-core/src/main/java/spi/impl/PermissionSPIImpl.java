package spi.impl;

import domain.dto.PermLevelDto;
import domain.manager.PermManager;
import domain.model.PageModel;
import domain.model.system.Perm;
import domain.model.system.query.PermQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spi.system.PermissionSPI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alan.zheng on 2017/12/8.
 */
@Service("permissionSPIService")
public class PermissionSPIImpl implements PermissionSPI {
    @Autowired
    private PermManager permManager;
    public PageModel<Perm> queryPageList(PermQuery query) {
        return permManager.queryPageList(query);
    }

    public int insertPerm(Perm perm) {
        return permManager.insertPerm(perm);
    }

    public int updatePerm(Perm perm) {
        return permManager.updateById(perm);
    }

    public int deletePerm(Long id) {
        return permManager.deleteById(id);
    }

    public Perm queryById(Long id) {
        return permManager.queryById(id);
    }

    public List<PermLevelDto> queryPermByLevel() {
        List<PermLevelDto> list=new ArrayList<PermLevelDto>();
        List<Perm> permList1= permManager.queryByParentId((long)0);
        for (Perm perm1:permList1) {
            PermLevelDto dto1=new PermLevelDto();
            dto1.setId(perm1.getId());
            dto1.setDisplayName(perm1.getDisplayName());
            List<PermLevelDto> list2=new ArrayList<PermLevelDto>();
            List<Perm> permList2= permManager.queryByParentId(perm1.getId());
            for (Perm perm2:permList2) {
                PermLevelDto dto2=new PermLevelDto();
                dto2.setId(perm2.getId());
                dto2.setDisplayName(perm2.getDisplayName());
                List<PermLevelDto> list3=new ArrayList<PermLevelDto>();
                List<Perm> permList3=permManager.queryByParentId(perm2.getId());
                for (Perm perm3:permList3) {
                    PermLevelDto dto3=new PermLevelDto();
                    dto3.setId(perm3.getId());
                    dto3.setDisplayName(perm3.getDisplayName());
                    list3.add(dto3);
                }
                dto2.setPermLevelDtos(list3);
                list2.add(dto2);
            }
            dto1.setPermLevelDtos(list2);
            list.add(dto1);
        }
        return list;
    }

    public List<Perm> queryByType(List<Integer> types) {
        return permManager.queryByType(types);
    }


    public Set<String> queryUrlsByMemberId(Long id) {
        /*HashSet() 同时也被称为集合，该容器中只能存储不重复的对象，*/
        /*HashSet实现了Set接口，它不允许集合中有重复的值，当我们提到HashSet时，第一件事情就是在将 对象存储 在HashSet之前
        ，要先确保对象重写equals()和hashCode()方法，这样才能比较对象的值是否相等，以确保set中没有储存相等的对象。如果我们
        没有重写这两个方法，将会使用这个方法的默认实现。public boolean add(Object o)方法用来在Set中添加元素，当元素值重复
        时则会立即返回false，如果成功添加的话会返回true。*/
        Set<String> stringSet =new HashSet<String>();
        /*由member id去查找urls的可访问地址库  */
        List<String> urls=permManager.queryUrlByMemberId(id);
        for (String url:urls) {
            stringSet.add(url);
        }
        /*返回的是Hash（所有可访问地址）*/
        return stringSet;
    }
}
