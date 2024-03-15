package com.baris.game;

public class ToolStore extends NoBattleLoc{


	public ToolStore(Player player) {
		super(player, "Tool Store");
	}
	
	@Override
	public boolean getLocation() {
		Menu();
		return true;
	}
	
	public void Menu() {
		System.out.println("Money: "+player.getMoney());
		System.out.println("1- Weapons");
		System.out.println("2- Armors");
		System.out.println("3- Exit");
		System.out.print("Please, select an option: ");
		int prefTool=scanner.nextInt();
		scanner.nextLine();
		int selectItemID;
		switch (prefTool) {
		case 1:
			selectItemID=weaponsMenu();
			buyWeapon(selectItemID);
			break;
		case 2:
			selectItemID=armorsMenu();
			buyArmor(selectItemID);
			break;
			
		default:
			break;
		}
	}
	
	public int weaponsMenu() {
		System.out.println("1- Pistol \t Damage: 2 \t Purchase Fee: 25");
		System.out.println("2- Sword \t Damage: 3 \t Purchase Fee: 35");
		System.out.println("3- Rifle \t Damage: 7 \t Purchase Fee: 45");
		System.out.println("4- Exit");
		System.out.print("Choose a weapon: ");
		int prefWeapon=scanner.nextInt();
		return prefWeapon;
	}
	
	public void buyWeapon(int itemID) {
		int damage=0, price=0;
		String wName=null;
		switch (itemID) {
		case 1:
			wName="Pistol";
			damage=2;
			price=25;
			break;
		case 2:
			wName="Sword";
			damage=3;
			price=35;
		case 3:
			wName="Rifle";
			damage=7;
			price=45;
		case 4:
			System.out.println("Logged out.");
			break;
		default:
			System.out.println("Invalid transaction !");
			break;
		}
		if (wName.equals(player.getInventory().getwName())) {
			System.out.println("You can not buy same weapon.");
		}
		else if (price>0) {
			if (player.getMoney()>=price) {
				player.getInventory().setwDamage(damage);
				player.getInventory().setwName(wName);
				player.setMoney(player.getMoney()-price);
				System.out.println("You are buy a weapon, ur damage before buy: "+player.getDamage()+ " New damage: "+player.getTotalDamage());
				System.out.println("Remaining Money: "+player.getMoney());
			}else {
				System.out.println("You do not have enough money to buy this.");
			}
		}
		
	}
	
	public int armorsMenu() {
		System.out.println("1- Light Armor,   Block: 1,   Purchase Fee: 15");
		System.out.println("2- Medium Armor,  Block: 3,   Purchase Fee: 25");
		System.out.println("3- Heavy Armor,   Block: 5,   Purchase Fee: 40");
		System.out.println("4- Exit");
		System.out.print("Choose a armor: ");
		int prefArmor=scanner.nextInt();
		return prefArmor;
	}
	public void buyArmor(int armorID) {
		String aName=null;
		int armor=0, price=0;
		switch (armorID) {
		case 1:
			aName="Light Armor";
			armor=1;
			price=15;
			break;
		case 2:
			aName="Medium Armor";
			armor=3;
			price=25;
			break;
		case 3:
			aName="Heavy Armor";
			armor=5;
			price=40;
			break;
		case 4:
			System.out.println("Logged out.");
			break;
		default:
			System.out.println("Invalid transaction !");
			break;
		}
		if (aName.equals(player.getInventory().getaName())) {
			System.out.println("You can not buy same armor.");
		}
		else if (price>0) {
			if (player.getMoney()>=price) {
				player.getInventory().setArmor(armor);
				player.getInventory().setaName(aName);
				player.setMoney(player.getMoney()-price);
				System.out.println("You are buy a armor, Damage blocked: "+(player.getInventory().getArmor()));
				System.out.println("Remaining money: "+player.getMoney());
			}else {
				System.out.println("You do not have enough money to buy this.");
			}
		}
	}
	
}
