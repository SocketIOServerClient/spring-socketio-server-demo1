
package com.phearun.controller.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phearun.model.Feed;
import com.phearun.service.FeedService;

/**
 * Created by PHEARUN on 12/9/2016.
 */

@RestController
@RequestMapping("/api/v1/feed")
public class FeedController {

	@Autowired
	private FeedService feedService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Feed feed) {
		String message = "Feed save failed!";
		if (feedService.save(feed)) {
			message = "Feed save successfully!";
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Feed>> findAll() {
		Collection<Feed> feeds = feedService.findAll();
		return new ResponseEntity<Collection<Feed>>(feeds, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Feed> findOne(@PathVariable("id") String id) {
		Feed feed = feedService.findOne(id);
		return new ResponseEntity<Feed>(feed, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("id") String id) {
		String message = "Feed remove failed!";
		if (feedService.remove(id)) {
			message = "Feed remove successfully!";
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestBody Feed feed) {
		String message = "Feed update failed!";
		if (feedService.update(feed)) {
			message = "Feed update successfully!";
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<String> update(@PathVariable("id") String id) {
		int like = feedService.updateLike(id);
		String message = "Current like " + like;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
