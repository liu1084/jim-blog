package com.jim.mapper;

import com.jim.model.Role;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * Created by jim.liu on 2016-06-17.
 * This class is ...
 */
public interface UserRoleMapper {
	List<Role> getRoles(long id);
}
