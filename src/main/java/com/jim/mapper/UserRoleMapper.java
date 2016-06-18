package com.jim.mapper;

import com.jim.model.Role;
import com.jim.model.User;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * Created by jim.liu on 2016-06-17.
 * This class is ...
 */
public interface UserRoleMapper {
	List<Role> getRoles(long id);
    int addRole(long userId, long roleId);
    int deleteRole(long userId, long roleId);
}
