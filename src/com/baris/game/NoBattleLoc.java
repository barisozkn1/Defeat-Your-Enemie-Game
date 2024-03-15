package com.baris.game;

import java.util.Scanner;

abstract public class NoBattleLoc extends Location{
	Scanner scanner=new Scanner(System.in);
	
	public NoBattleLoc(Player player, String name) {
		super(player);
		this.name=name;
	}

	@Override
	public boolean getLocation() {
		return true;
	}
	
	
}
