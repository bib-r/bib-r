package org.bibr.eval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {
	
	private Map<String, List<String>> properties;
	
	public Entity(){
		properties = new HashMap<String, List<String>>();
	}
	
	@Override
	public String toString() {
		return "Entity [properties=" + properties + "]";
	}

	public Map<String, List<String>> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, List<String>> properties) {
		this.properties = properties;
	}
	
}
