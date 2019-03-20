package mvnweek14.mvnProjectw14.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mvnweek14.mvnProjectw14.entity.Friend;
import mvnweek14.mvnProjectw14.service.FriendsService;

@RestController
public class FriendsController {
	
	@Autowired
	FriendsService service;
	
		@RequestMapping(value ="/friends", method=RequestMethod.POST) 
	public Friend addFriend(@RequestBody Friend friend) {
			return service.createFriend(friend);
	}
		
		@RequestMapping("/friends/{id}")
		public Friend getFriend(@PathVariable Long id) {
			return service.getFriend(id);
		}
	
		@RequestMapping("/friends")
	public Iterable<Friend> getFriends() {
		return service.getFriends();
	}
		
		@RequestMapping(value="/friends/{id}", method=RequestMethod.PUT)
		public Friend updateFriend(@PathVariable Long id, @RequestBody Friend friend) {
			return service.updateFriend(id,friend);
		}
		
		@RequestMapping(value="/friend/{id}", method=RequestMethod.DELETE)
		public void deleteFriend(@PathVariable Long id) {
			service.deleteFriend(id);
		}

}
