package com.rssfeed.rsstool.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import lombok.Data;

@Data
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "guid")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuidData {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@XmlAttribute
	private Boolean isPermalink = false;

	@XmlValue
	private String guid;

}
