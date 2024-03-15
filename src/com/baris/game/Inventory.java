package com.baris.game;

public class Inventory {
	private boolean water, food, firewood, costume;
	private String wName, aName;
	private int wDamage, armor;

	public Inventory() {
		this.water=false;
		this.food=false;
		this.firewood=false;
		this.costume=false;
		this.wDamage=0;
		this.armor=0;
		this.wName=null;
	}
	
	
	public boolean isCostume() {
		return costume;
	}


	public void setCostume(boolean costume) {
		this.costume = costume;
	}


	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isFirewood() {
		return firewood;
	}

	public void setFirewood(boolean firework) {
		this.firewood = firework;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public int getwDamage() {
		return wDamage;
	}

	public void setwDamage(int wDamage) {
		this.wDamage = wDamage;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	
}
