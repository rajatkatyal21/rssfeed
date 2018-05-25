package com.rssfeed.rsstool.logic;

import static com.rssfeed.rsstool.common.Contants.COMMA;

import com.rssfeed.rsstool.dto.Item;
import com.rssfeed.rsstool.dto.UnwantedElements;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UnwantedWordRemover {


	private UnwantedElements unwantedElements;

	public void removeElementsIn(Item item) {
		item.setDescription(getStringAfterModification(item.getDescription()))
				.setTitle(getStringAfterModification(item.getTitle()));
	}

	private String getStringAfterModification(String value) {
		return Arrays.stream(unwantedElements.getElements().split(COMMA))
				.reduce(value, StringUtils::remove)
				.trim();
	}


}
