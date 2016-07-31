package com.swagger.poc.controlller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.poc.dto.User;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
@Api(basePath="http://localhost:8080/swagger-poc",  value="getUsers",description="User api has a rich collection of operation which can we performed on the user details.")
//@RestController
@Controller
public class UserController {

	@ApiOperation(  value="/getUser/{id}")
	@RequestMapping( value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<User> getUser(@PathVariable(value = "id") Integer id) {
		System.out.println("getUser() - start");
		List<User> users = usersList(id);
		if (!CollectionUtils.isEmpty(users)) {
			System.out.println("getUser() - end");
			return new ResponseEntity<User>(users.get(0), HttpStatus.OK);
		}
		System.out.println("getUser() - end : Not Found");
		 return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
	}

	
	@RequestMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<List<User>> getUsers() {
		System.out.println("getUsers() - start");
		List<User> users = usersList(null);
		System.out.println("getUser() - end");
		 return new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);
	}

	
	
	private List<User> usersList(Integer id) {

		List<User> users = new ArrayList<User>();
		User user1 = new User(10, "Jack", "Lee", "jack.lee@gmail.com");
		User user2 = new User(11, "A", "Lee", "jack.lee@gmail.com");
		User user3 = new User(12, "B", "Lee", "jack.lee@gmail.com");
		User user4 = new User(13, "C", "Lee", "jack.lee@gmail.com");
		User user5 = new User(14, "D", "Lee", "jack.lee@gmail.com");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		// return users;

		if (StringUtils.isEmpty(id)) {
			return users;
		} else {
			for (User user : users) {
				if (id.equals(user.getId())) {
					List<User> list = new ArrayList<User>();
					list.add(user);
					return list;
				}
			}

		}
		return null;
	}

}
