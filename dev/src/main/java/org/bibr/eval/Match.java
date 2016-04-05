package org.bibr.eval;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to keep information if an entity from expertise has been matched with another entity from input collection
 * @author Joffrey
 *
 */
public class Match {

	private String entity;
	
	private Set<String> propMatched;
	
	private Boolean info = false;

	public Match(String entity) {
		super();
		this.entity = entity;
		propMatched = new HashSet<String>();
	}

	@Override
	public String toString() {
		return "Match [" + entity + ": " + info + "]";
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Boolean getInfo() {
		return info;
	}

	public void setInfo(Boolean info) {
		this.info = info;
	}

	public Set<String> getPropMatched() {
		return propMatched;
	}

	public void setPropMatched(Set<String> propMatched) {
		this.propMatched = propMatched;
	}
	
}
