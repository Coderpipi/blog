package site.lbw.service;

import site.lbw.entity.User;

public interface UserService {
	User findUserByUsernameAndPassword(String username, String password);

	User findUserById(Long id);
}
