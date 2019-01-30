package com.visualpath.user.repository;

import java.util.List;

import com.visualpath.user.User;

public interface UserCRUDRepositoryCustom {
	List<User> findUserbyAddressAndName(String name, String address);

}
