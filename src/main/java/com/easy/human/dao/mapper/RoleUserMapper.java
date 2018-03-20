package com.easy.human.dao.mapper;


import com.easy.human.dao.bean.RoleUser;
import com.easy.human.dao.bean.User;

import java.util.List;

public interface RoleUserMapper {
        List<RoleUser> list();

        int  add(RoleUser Order);
        int  delete(String id);
        int update(RoleUser Order);
        RoleUser get(String id);


}