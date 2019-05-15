package cn.ekgc.springjpa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.springjpa.dao.UserDao;
import cn.ekgc.springjpa.entity.User;
import cn.ekgc.springjpa.service.UserService;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	private UserDao userDao;

	/**
	 * 根据电话号码查询User
	 * @param cellphone
	 * @return User
	 * @throws Exception
	 */
	public User getUserByCellphone(String cellphone) throws Exception {
		User user = userDao.findUserByCellphone(cellphone);
		return user;
	}

	/**
	 * 保存User
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean saveUser(User user) throws Exception {
		if (userDao.save(user) != null) {
			return true;
		}
		return false;
	}

	/**
	 * 查询所有用户
	 * @return
	 * @throws Exception
	 */
	public List<User> getAllUser() throws Exception {
		
		return userDao.findAll();
	}

	/**
	 * 删除用户
	 * @param userId
	 * @throws Exception
	 */
	public void deleteUser(Long userId) throws Exception {
		userDao.deleteById(userId);
	}

	/**
	 * 根据userID查询用户信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public User getUserById(Long userId) throws Exception {
		return userDao.getOne(userId);
	}
	
}
