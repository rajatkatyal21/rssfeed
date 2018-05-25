package com.rssfeed.rsstool.service;


import com.rssfeed.rsstool.dto.Channel;
import com.rssfeed.rsstool.dto.Item;
import com.rssfeed.rsstool.exception.NotFoundException;
import com.rssfeed.rsstool.logic.UnwantedWordRemover;
import com.rssfeed.rsstool.respository.ChannelRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RssService {

	private ChannelRepository channelRepository;
	private UnwantedWordRemover unwantedWordRemover;

	public Long addRssFeed(Long channelId, Item item) {
		unwantedWordRemover.removeElementsIn(item);
		Channel channel = channelRepository.findById(channelId)
				.orElseThrow(NotFoundException::new);
		channel.getItems().add(item);
		channelRepository.saveAndFlush(channel);
		return item.getId();
	}

	public Long addChannel(Channel channel) {
		return channelRepository.save(channel).getId();
	}

	public List<Channel> getAllChannel() {
		return channelRepository.findAll();
	}

	public Channel getFeedById(Long feedId) {
		return channelRepository.findById(feedId)
				.orElseThrow(NotFoundException::new);
	}

	public void deleteFeed(Long channelId, Long feedId) {
		Channel channel = channelRepository.findById(channelId)
				.orElseThrow(NotFoundException::new);
		channel.getItems().removeIf(item -> item.getId().equals(feedId));
		channelRepository.saveAndFlush(channel);
	}

	public void patchFeed(Long channelId, Long feedId, Item request) {
		Channel channel = channelRepository.findById(channelId)
				.orElseThrow(NotFoundException::new);
		channel.getItems()
				.stream()
				.filter(item -> item.getId().equals(feedId))
				.forEach(item -> item.setDescription(request.getDescription()));

		channelRepository.saveAndFlush(channel);
	}
}
