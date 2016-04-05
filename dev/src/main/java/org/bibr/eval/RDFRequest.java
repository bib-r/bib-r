package org.bibr.eval;

/**
 * Contains information about a single RDF file to be evaluated with another
 * @author Joffrey
 *
 */
public class RDFRequest {

	private String path;
	
	private String typeStategy;
	
	private String dataStrategy;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTypeStategy() {
		return typeStategy;
	}

	public void setTypeStategy(String typeStategy) {
		this.typeStategy = typeStategy;
	}

	public String getDataStrategy() {
		return dataStrategy;
	}

	public void setDataStrategy(String dataStrategy) {
		this.dataStrategy = dataStrategy;
	}
}
