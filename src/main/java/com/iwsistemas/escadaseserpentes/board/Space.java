package com.iwsistemas.escadaseserpentes.board;

public class Space {

	public enum Type {
		START_HERE, HOME, REGULAR;
	}

	private int number;
	private Type type;
	private Trasition transition;

	public Space(int number, Type type) {
		this.number = number;
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public Type getType() {
		return type;
	}
	
	public void setTransition(Trasition transition) {
		this.transition = transition;
	}
	
	public Trasition getTransition() {
		return transition;
	}

	@Override
	public String toString() {
		if(type == Type.REGULAR) {
			return String.valueOf(number);
		} else {
			return number + " (" + type + ")";
		}
	}

}
