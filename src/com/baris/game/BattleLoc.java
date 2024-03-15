package com.baris.game;


abstract public class BattleLoc extends Location{
	protected Obstacle obstacle;
	protected String award;
	
	public BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.obstacle=obstacle;
		this.name=name;
		this.award=award;
	}

	@Override
	public boolean getLocation() {
		int obsCount=obstacle.obsCount();
		System.out.println("You are here now: "+ this.getName());
		System.out.println("Be careful! "+ obsCount+" "+ obstacle.getObsName()+ " lives here. " );
		System.out.print("<F>ight or <R>un: ");
		String selCase=scanner.nextLine();
		selCase=selCase.toUpperCase();
		if (selCase.equals("F")) {
			if (Combat(obsCount)) {
				System.out.println("You are kill ur all enemy in the "+ this.getName());
				if (this.award.equals("Food")&& player.getInventory().isFood()==false) {
					System.out.println(this.award+ " you won.");
					player.getInventory().setFood(true);
				}else if (this.award.equals("Firewood")&& player.getInventory().isFirewood()==false) {
					System.out.println(this.award+ " you won.");
					player.getInventory().setFirewood(true);
				}else if (this.award.equals("Water")&& player.getInventory().isWater()==false) {
					System.out.println(this.award+ " you won.");
					player.getInventory().setWater(true);
				}else if (this.award.equals("Costume")&& player.getInventory().isCostume()==false) {
					System.out.println(this.award+ " you won.");
					player.getInventory().setCostume(true);
				}
				return true;
			}
			if (player.getHealth()<=0) {
				System.out.println("You are died.");
				return false;
			}
		}
		return true;
	}
	public boolean Combat(int obsCount) {
		int defObsHealth=obstacle.getObsHealth();
		for (int i = 0; i < obsCount; i++) {
			playerStats();
			enemyStats();
			while (player.getHealth()>0 && obstacle.getObsHealth()>0) {
				System.out.print("<H>it or <R>un: ");
				String selCase=scanner.nextLine();
				selCase=selCase.toUpperCase();
				if (selCase.equals("H")) {
					System.out.println("You hit first !");
					obstacle.setObsHealth(obstacle.getObsHealth()-player.getTotalDamage());
					afterHit();
					if (obstacle.getObsHealth()>0) {
						System.out.println();
						System.out.println("The enemy hit you !");
						player.setHealth(player.getHealth()-(obstacle.getObsDmg()-player.getInventory().getArmor()));
						afterHit();
					}
				}else {
					return false;
				}
			}
			if (obstacle.getObsHealth()<=0 && player.getHealth()>0) {
				System.out.println("You have defeated your enemie.");
				player.setMoney(player.getMoney()+obstacle.getObsAward());
				System.out.println("Current money: "+ player.getMoney());
				obstacle.setObsHealth(defObsHealth);
			}else {
				return false;
			}
			System.out.println("--------------------------------------");
		}
		return true;
	}
	
	public void playerStats() {
		System.out.println("\n"+"Player Stats\n------------------");
		System.out.println("Health: "+player.getHealth());
		System.out.println("Damage: "+player.getTotalDamage());
		System.out.println("Money: "+player.getMoney());
		if (player.getInventory().getwDamage()>0) {
			System.out.println("Weapon: "+player.getInventory().getwName());
		}
		else if (player.getInventory().getArmor()>0) {
			System.out.println("Armor: "+player.getInventory().getaName());
		}
	}
	public void enemyStats() {
		System.out.println("\n"+obstacle.getObsName()+" Stats\n------------------");
		System.out.println("Health: "+obstacle.getObsHealth());
		System.out.println("Damage: "+obstacle.getObsDmg());
		System.out.println("Award: "+obstacle.getObsAward());
	}
	public void afterHit() {
		System.out.println("Player health: "+player.getHealth());
		System.out.println(obstacle.getObsName()+" Obstacle health: "+obstacle.getObsHealth());
		System.out.println();
	}
}
