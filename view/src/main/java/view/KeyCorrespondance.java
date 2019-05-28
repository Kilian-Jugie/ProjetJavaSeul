package view;

import contract.GameAction;

public class KeyCorrespondance {
	private final int keyCode;
	private final GameAction action;
	
	public KeyCorrespondance(final int key, final GameAction action) {
		this.keyCode = key;
		this.action = action;
	}
	
	public final int getKeyCode() {
		return this.keyCode;
	}
	
	public final GameAction getAction() {
		return this.action;
	}
}
