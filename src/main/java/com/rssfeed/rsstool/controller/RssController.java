package com.rssfeed.rsstool.controller;


import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import com.rssfeed.rsstool.dto.Channel;
import com.rssfeed.rsstool.dto.Item;
import com.rssfeed.rsstool.dto.Rss;
import com.rssfeed.rsstool.service.RssService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/channel")
public class RssController {

	private RssService rssService;

	@GetMapping(value = "/{channelId}", produces = APPLICATION_XML_VALUE)
	@ApiOperation(value = "Getting the Channel by Channel Id")
	public Channel getRssFeedById(@PathVariable("channelId") Long channelId) {
		return rssService.getFeedById(channelId);
	}

	@PostMapping(consumes = APPLICATION_XML_VALUE, produces = APPLICATION_XML_VALUE)
	@ApiOperation(value = "Adding a new Channel")
	public Long postChannel(@RequestBody Channel channel) {
		return rssService.addChannel(channel);
	}

	@GetMapping(produces = APPLICATION_XML_VALUE)
	@ApiOperation(value = "Getting all the Channel with Feeds")
	public Rss getAllChannelWithFeed() {
		return Rss.builder()
				.channels(rssService.getAllChannel())
				.build();
	}

	@DeleteMapping(value = "/{channelId}/feeds/{feedId}", produces = APPLICATION_XML_VALUE)
	@ApiOperation(value = "Deleting a feed from FeedId and channelId")
	public void deleteFeed(@PathVariable("channelId") Long channelId, @PathVariable Long feedId) {
		rssService.deleteFeed(channelId, feedId);
	}

	@PostMapping(value = "/{channelId}/feeds", consumes = APPLICATION_XML_VALUE, produces = "application/xml;charset=UTF-8")
	@ApiOperation(value = "Adding a new Feed in a channel with the help of Channel Id")
	public Long addRssFeed(@PathVariable("channelId") Long channelId, @RequestBody Item item) {
		return rssService.addRssFeed(channelId, item);
	}

	@PatchMapping(value = "/{channelId}/feeds/{feedId}", produces = APPLICATION_XML_VALUE)
	@ApiOperation(value = "Updating the description only with the help of Channel Id and feed Id")
	public void patchFeedId(@PathVariable("channelId") Long channelId,
			@PathVariable Long feedId,
			@RequestBody Item requestedItem) {
		rssService.patchFeed(channelId, feedId, requestedItem);

	}
}
