package com.baris.game;

import java.util.Scanner;

public class Player {
	Scanner scanner=new Scanner(System.in);
	private Inventory inventory;
	
	private int damage, health, money, rHealth;
	private String name, charName;
	
	public Player(String name) {
		this.name=name;
		this.inventory=new Inventory();
	}
	
	public void selectChar() {
		switch (charMenu()) {
		case 1:
			charFonk("Yasuo", 6, 18, 20);
			break;
		case 2:
			charFonk("Varus", 5, 15, 25);
			break;
		case 3:
			charFonk("Pantheon", 4, 26, 15);
			break;
		case 4:
			charFonk("Rengar", 7, 15, 20);
			break;
		case 5:
			charFonk("Illaoi", 3, 30, 25);
			break;
		default:
			charFonk("Yasuo", 6, 18, 20);
			break;
		}
		System.out.println("YOUR CHARACTER CREATED.");
		System.out.println("Character:"+getCharName()+ "    Damage:"+getDamage()+"   Health:"+getHealth()+"   Money:"+getMoney());
		
	}
	
	public int getTotalDamage() {
		return this.getDamage()+this.getInventory().getwDamage();
	}
	
	public int charMenu() {
		System.out.println("Character List: ");
		System.out.println("1- Type: Yasuo    \t Damage: 6 \t Health: 18 \t Money: 20");
		System.out.println("2- Type: Varus    \t Damage: 5 \t Health: 15 \t Money: 25");
		System.out.println("3- Type: Pantheon \t Damage: 4 \t Health: 26 \t Money: 15");
		System.out.println("4- Type: Rengar \t Damage: 7 \t Health: 15 \t Money: 20");
		System.out.println("5- Type: Illaoi \t Damage: 3 \t Health: 30 \t Money: 25");
		System.out.print("Now, please choose a character: ");
		int charID=scanner.nextInt();
		scanner.nextLine();
		while (charID<1 || charID>5) {
			System.out.print("Please choose a valid character: ");
			charID=scanner.nextInt();
			scanner.nextLine();
		}
		return charID;
	}

	public void charFonk(String charN, int dmg, int health, int money) {
		setCharName(charN);
		setDamage(dmg);
		setHealth(health);
		setMoney(money);
		setrHealth(health);
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public int getrHealth() {
		return rHealth;
	}

	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}
	
	
}
