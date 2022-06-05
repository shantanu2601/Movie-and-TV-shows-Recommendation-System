package net.codej.Connected;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Connected_id implements Serializable {
	
	private int movid;
	private int rel_id;
	public Connected_id(int movid, int rel_id) {
		super();
		this.movid = movid;
		this.rel_id = rel_id;
	}
	public Connected_id() {
		super();
	}


}
