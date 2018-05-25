package com.rssfeed.rsstool.respository;

import com.rssfeed.rsstool.dto.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
