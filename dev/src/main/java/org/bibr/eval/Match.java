package org.bibr.eval;

public class Match {

	private String entity;
	
	private Boolean info = false;

	public Match(String entity) {
		super();
		this.entity = entity;
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
	
}
