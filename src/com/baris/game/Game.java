package com.baris.game;

import java.util.Scanner;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Player player;
	Location location;
	
	public void Login() {
		System.out.println("Welcome to the Adventure Game !");
		System.out.print("Before starting the game please enter ur name: ");
		String playerName= scanner.nextLine();
		player = new Player(playerName);
		player.selectChar();
		Start();
	}
	
	public void Start() {
		while (true) {
			System.out.println("\nLocation List: ");
			System.out.println("1- Safe House --> This is ur safe house, there is no enemy.");
			System.out.println("2- Mid Lane --> May be Akali here. Be careful!");
			System.out.println("3- Forest --> May be KhaZix here. Be careful!");
			System.out.println("4- Bot Lane --> May be Nami here. Be careful!");
			System.out.println("5- Top Lane --> May be Garen here. Be careful!");
			System.out.println("6- Shop --> You can buy armor and weapons here.");
			System.out.print("Now, choose a place: ");
			int placeID=scanner.nextInt();
			scanner.nextLine();
			while (placeID<1 || placeID>6) {
				System.out.print("Please, choose a valid place: ");
				placeID=scanner.nextInt();
				scanner.nextLine();
			}
			switch (placeID) {
			case 1:
				location=new SafeHouse(player);
				break;
			case 2:
				location=new Mid(player);
				break;
			case 3:
				location=new Forest(player);
				break;
			case 4:
				location=new BotLane(player);
				break;
			case 5:
				location=new TopLane(player);
				break;
			case 6:
				location=new ToolStore(player);
				break;
			default:
				location=new SafeHouse(player);
				break;
			}
			if (location.getName().equals("SafeHouse")) {
				if (player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()&& player.getInventory().isCostume()) {
					System.out.println("Congratulations! You won the game.");
					break;
				}
			}
			
			if (!location.getLocation()) {
				System.out.println(" ****  GAME OVER **** ");
			}
			
		}
	}
}
