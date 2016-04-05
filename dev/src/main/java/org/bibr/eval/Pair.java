package org.bibr.eval;

public class Pair {
	
	private Entity col;
	
	private Entity exp;

	public Pair(Entity col, Entity exp) {
		super();
		this.col = col;
		this.exp = exp;
	}
	
	

	@Override
	public String toString() {
		return "Pair [col=" + col + ", exp=" + exp + "]";
	}



	public Entity getCol() {
		return col;
	}

	public void setCol(Entity col) {
		this.col = col;
	}

	public Entity getExp() {
		return exp;
	}

	public void setExp(Entity exp) {
		this.exp = exp;
	}

}
