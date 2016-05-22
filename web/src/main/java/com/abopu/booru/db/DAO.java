package com.abopu.booru.db;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Sarah Skanes
 * @created April 17, 2016.
 */
public class DAO {
	
	private static final Collection<String> TAGS;
	static {
		TAGS = Arrays.asList("foo", "bar");
	}
	
	public static Collection<String> getAllTags() {
		return TAGS;
	}
}
