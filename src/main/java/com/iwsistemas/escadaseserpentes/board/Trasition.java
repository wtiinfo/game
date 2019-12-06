package com.iwsistemas.escadaseserpentes.board;

public class Trasition {

	public enum Type{
		SNAKE, LADDER;
	}
	
	private Space spaceFrom;
	private Space spaceTo;
    private Type type;
    
	public Trasition(Space spaceFrom, Space spaceTo) {
		this.spaceFrom = spaceFrom;
		this.spaceTo = spaceTo;
		this.type = spaceFrom.getNumber() < spaceTo.getNumber() ? Type.LADDER : Type.SNAKE;
	}

	public Space getSpaceFrom() {
		return spaceFrom;
	}

	public Space getSpaceTo() {
		return spaceTo;
	}


	public Type getType() {
		return type;
	}

}
