
package com.phearun.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phearun.model.Feed;
import com.phearun.repository.FeedRepository;

/**
 * Created by PHEARUN on 12/9/2016.
 */

@Repository
public class FeedRepositoryImpl implements FeedRepository {

	private Map<String, Feed> mFeeds = new HashMap<>();
		
	@Override
	public boolean save(Feed feed) {
		mFeeds.put(feed.getId(), feed);
		return true;
	}

	@Override
	public boolean update(Feed feed) {
		mFeeds.get(feed.getId()).setText(feed.getText());
		return true;
	}

	@Override
	public boolean remove(String id) {
		mFeeds.remove(id);
		return true;
	}

	@Override
	public Collection<Feed> findAll() {
		return mFeeds.values();
	}

	@Override
	public Feed findOne(String id) {
		return mFeeds.get(id);
	}

	@Override
	public int updateLike(String id) {
		Feed feed = mFeeds.get(id);
		feed.setLike(feed.getLike() + 1);
		return feed.getLike();
	}
	
}
