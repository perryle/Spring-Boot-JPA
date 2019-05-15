package cn.ekgc.springjpa.service;

import java.util.List;

import cn.ekgc.springjpa.entity.User;

public interface UserService {
	/**
	 * 根据电话号码查询User
	 * @param cellphone
	 * @return User
	 * @throws Exception
	 */
	public User getUserByCellphone(String cellphone)throws Exception;
	/**
	 * 保存User
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean saveUser(User user) throws Exception;
	/**
	 * 查询所有用户
	 * @return
	 * @throws Exception
	 */
	public List<User> getAllUser() throws Exception;
	/**
	 * 删除用户
	 * @param userId
	 * @throws Exception
	 */
	public void deleteUser(Long userId) throws Exception;
	/**
	 * 根据userID查询用户信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public User getUserById(Long userId) throws Exception;

}
