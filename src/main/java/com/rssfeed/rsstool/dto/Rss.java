package com.rssfeed.rsstool.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "rss")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rss {

	@XmlElementWrapper(name = "channels")
	@XmlElement(name="channel")
	private List<Channel> channels;
}
