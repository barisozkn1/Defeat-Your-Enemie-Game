package com.baris.game;

public class SafeHouse extends NoBattleLoc{

	public SafeHouse(Player player) {
		super(player, "SafeHouse");
	}
	
	@Override
	public boolean getLocation() {
		player.setHealth(player.getrHealth());
		System.out.println("Your health is full again.");
		System.out.println("Now, u are in the safe house.");
		return true;
	}
	
}
