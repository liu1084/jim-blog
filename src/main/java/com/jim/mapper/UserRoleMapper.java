package com.jim.mapper;

import java.util.List;

import com.jim.model.Role;

/**
 * Created by jim.liu on 2016-06-17.
 * This class is ...
 */
public interface UserRoleMapper {
	List<Role> getRoles(long id);
    int addRole(long userId, long roleId);
    int deleteRole(long userId, long roleId);
}
