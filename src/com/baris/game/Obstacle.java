package com.baris.game;

import java.util.Random;

public class Obstacle {
	private int obsDmg, obsHealth, obsAward, maxNumber;
	private String obsName;
	
	public Obstacle(int obsDmg, int obsHealth, int obsAward, int maxNumber, String obsName) {
		this.obsDmg = obsDmg;
		this.obsHealth = obsHealth;
		this.obsAward = obsAward;
		this.maxNumber = maxNumber;
		this.obsName = obsName;
	}
	public int obsCount() {
		Random random = new Random();
		return random.nextInt(this.maxNumber)+1;
 	}

	public int getObsDmg() {
		return obsDmg;
	}

	public void setObsDmg(int obsDmg) {
		this.obsDmg = obsDmg;
	}

	public int getObsHealth() {
		return obsHealth;
	}

	public void setObsHealth(int obsHealth) {
		this.obsHealth = obsHealth;
	}

	public int getObsAward() {
		return obsAward;
	}

	public void setObsAward(int obsAward) {
		this.obsAward = obsAward;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public String getObsName() {
		return obsName;
	}

	public void setObsName(String obsName) {
		this.obsName = obsName;
	}
	
	
}
