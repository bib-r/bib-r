package org.bibr.eval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {
	
	private Map<String, List<String>> properties;
	
	private Map<String, String> relationships;
	
	private String type;
	
	public Entity(String type){
		properties = new HashMap<String, List<String>>();
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type.substring(type.lastIndexOf("/")+1,type.length())+" [properties=" + properties + "]";
	}

	public Map<String, List<String>> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, List<String>> properties) {
		this.properties = properties;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
