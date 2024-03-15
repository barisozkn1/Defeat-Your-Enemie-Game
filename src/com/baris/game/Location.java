package com.baris.game;

import java.util.Scanner;

abstract public class Location {
	Scanner scanner=new Scanner(System.in);
	protected Player player;
	protected String name;
	
	public Location(Player player) {
		this.player=player;
	}
	
	abstract public boolean getLocation();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
