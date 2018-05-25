package com.rssfeed.rsstool.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElementRef;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	private String title;
	private String link;
	private String description;
	private String pubDate;
	@XmlElementRef(name = "guid")
	@OneToOne(cascade = CascadeType.ALL)
	private GuidData guidData;

	@OneToOne(cascade = CascadeType.ALL)
	@XmlElementRef(name = "enclosure")
	private Enclosure enclosure;
}
