package com.easy.human.dao.mapper;


import com.easy.human.dao.bean.Role;

import java.util.List;

public interface RoleMapper {
        List<Role> list();

        int  add(Role Order);
        int  delete(String id);
        int update(Role Order);
        Role get(String id);


}