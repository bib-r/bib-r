package org.bibr.eval;

public class Pair {
	
	private Entity e1;
	
	private Entity e2;

	public Pair(Entity e1, Entity e2) {
		super();
		this.e1 = e1;
		this.e2 = e2;
	}

	public Entity getE1() {
		return e1;
	}

	public void setE1(Entity e1) {
		this.e1 = e1;
	}

	public Entity getE2() {
		return e2;
	}

	public void setE2(Entity e2) {
		this.e2 = e2;
	}

}
