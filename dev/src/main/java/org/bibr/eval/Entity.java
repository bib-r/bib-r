package org.bibr.eval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {
	
	private String identifier;
	
	private Map<String, List<String>> properties;
	
	private Map<String, List<String>> relationships;
	
	private String type;
	
	public Entity(String identifier, String type){
		this.identifier = identifier;
		properties = new HashMap<String, List<String>>();
		relationships = new HashMap<String, List<String>>();
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type.substring(type.lastIndexOf("/")+1,type.length())+" "+identifier+" [properties=" + properties +" [relationships=" + relationships + "]";
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

	public Map<String, List<String>> getRelationships() {
		return relationships;
	}

	public void setRelationships(Map<String, List<String>> relationships) {
		this.relationships = relationships;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
}
