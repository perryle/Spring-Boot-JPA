package cn.ekgc.springjpa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.ekgc.springjpa.controller.base.BaseController;
import cn.ekgc.springjpa.entity.User;
import cn.ekgc.springjpa.service.UserService;
@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource(name = "userService")
	private UserService userService;
	
	/**
	 * 获得注册页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/registory", method = RequestMethod.GET)
	public String getUserRegistoryPage() throws Exception{
		return "registory_form";
	}
	
	/**
	 * 处理注册请求
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/registory", method = RequestMethod.POST)
	public String getUserRegistory(User user) throws Exception{
		//首先判断电话号码是否存在
		if(userService.getUserByCellphone(user.getCellphone()) == null) {
			//判断填入信息是否有效
			boolean flag = user.getUsername() != null && !"".equals(user.getUsername().trim())
					&& user.getCellphone() != null && !"".equals(user.getCellphone().trim())
					&& user.getPassword() != null && !"".equals(user.getPassword().trim());
			if(flag) {
				//信息有效，可以注册
				if(userService.saveUser(user)) {
					return "redirect:list";
				}
			}
		}
		return "redirect:registory";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getUserListPage() throws Exception {
		List<User> userList = userService.getAllUser();
		return new ModelAndView("list_form","userList",userList);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(Long userId) throws Exception{
		userService.deleteUser(userId);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateUserPage(Long userId) throws Exception {
		//根据userID查找user
		User user = userService.getUserById(userId);
		return new ModelAndView("update_form","user",user);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateUser(User user) throws Exception {
		User checkUser = userService.getUserByCellphone(user.getCellphone());
		if((checkUser == null) || (checkUser!= null && checkUser.getUserId() == user.getUserId())) {
			if(userService.saveUser(user)) {
				return "redirect:list";
			}
		}
		return "redirect:update?userId="+user.getUserId();
	}
}
