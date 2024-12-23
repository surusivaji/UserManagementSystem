package org.siva.usermanagement.dao;

import java.util.List;

import org.siva.usermanagement.model.User;

public interface IUserDao {
	boolean insertUser(User user);
	List<User> displayAllUsers();
	User getUserById(int id);
	int updateUserInformation(int userid, String firstname, String lastname, String mobile, String email, String gender, String address, String password);
	int deleteUserById(int id);
}
