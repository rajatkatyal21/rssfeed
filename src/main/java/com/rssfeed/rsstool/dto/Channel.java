package com.rssfeed.rsstool.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "channel")
public class Channel {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@XmlElement
	private String title;

	@XmlElement
	private String link;

	@XmlElement
	private String description;

	@XmlElement
	private String lastBuildDate;

	@XmlElement
	private String docs;
	@XmlElement
	private String generator;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@XmlElementWrapper(name = "items")
	@XmlElement(name="item")
	private List<Item> items;

}
