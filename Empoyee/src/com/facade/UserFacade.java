package com.facade;

import java.util.List;

import com.dao.UserDao;
import com.enums.Status;
import com.model.UserDetail;

public class UserFacade {

	private static UserFacade userFacade = new UserFacade();
	private UserDao userDao = UserDao.getInstance();

	public static UserFacade getInstance() {
		return userFacade;
	}

	public List<UserDetail> getUserDetail() {
		return userDao.selectUserDetail();
	}

	public Status insertUserDetail(UserDetail userDetail) {
		List<UserDetail> userDeatailList = userDao.selectUserDetail();

		for (UserDetail user : userDeatailList) {
			if (user.getEmail().equals(userDetail.getEmail())) {
				return Status.DUPLICATE;
			}
		}
		userDao.insertUserDetail(userDetail);
		return Status.INSERTED;
	}

	public Status checkUserDetail(UserDetail userDetail) {
		List<UserDetail> userDeatailList = userDao.selectUserDetail();

		for (UserDetail user : userDeatailList) {
			if (user.getEmail().equals(userDetail.getEmail()) && user.getPassword().equals(userDetail.getPassword())) {
				return Status.DUPLICATE;
			}
		}
		return Status.NOT_FOUND;
	}

	public UserDetail getUserDetailByEmail(String email) {
		return userDao.selectUserDetailByEmail(email);
	}
	
	public Status updateUserDetail(UserDetail userDetail) {
		userDao.updateUserDetail(userDetail);
		return Status.UPDATED;
	}
	
	public Status updateImage(UserDetail userDetail) {
		userDao.updateImage(userDetail);
		return Status.UPDATED;
	}
	
	public List<UserDetail> getFriendListByEmail(String email) {
		return userDao.selectFriendList(email);
	}
	

}