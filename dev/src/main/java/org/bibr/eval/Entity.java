package org.bibr.eval;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Representation of an entity from RDF, i.e., a specific instance of a RDF class
 * @author Joffrey
 *
 */
public class Entity {
	
	private String identifier;
	
	private Map<String, List<String>> properties;
	
	private Map<String, List<String>> relationships;
	
	private Set<String> propMatched;
	
	private String type;
	
	public Entity(String identifier, String type){
		this.identifier = identifier;
		properties = new HashMap<String, List<String>>();
		relationships = new HashMap<String, List<String>>();
		propMatched = new HashSet<String>();
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

	public Set<String> getPropMatched() {
		return propMatched;
	}

	public void setPropMatched(Set<String> propMatched) {
		this.propMatched = propMatched;
	}
	
}
