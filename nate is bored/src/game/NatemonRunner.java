package game;
//to add: enemy heals, new types
import java.util.Scanner;
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import gui.NatemonGUI;
public class NatemonRunner {
	public static ArrayList<Natemon> natemons = new ArrayList<>();
	public static ArrayList<Natemon> playerNatemons = new ArrayList<>();
	public static ArrayList<Natemon> enemyNatemons = new ArrayList<>();
	public static ArrayList<Move> moves = new ArrayList<>();
	public static ArrayList<Move> movesOnCooldown = new ArrayList<>();
	public static Natemon playerNatemon = new Natemon();
	public static Natemon enemyNatemon = new Natemon();
	public static int playerPotions = 3;
	public static int enemyPotions = 3;
	public static boolean gameOver = false;
	
	
	public static void main(String[] args) {
		
		Natemon firemon = new Natemon("firemon", "fire", 150);
		Natemon watermon = new Natemon("watermon", "water", 150);
		Natemon grassmon = new Natemon("grassmon", "grass", 150);
		
		
		Move fire1 = new Move("candle", "fire", 10, 1);
		Move fire2 = new Move("blowtorch", "fire", 25, 2);
		Move fire3 = new Move("explosion", "fire", 50, 3);
		Move water1 = new Move("lil piss", "water", 10, 1);
		Move water2 = new Move("hot shower", "water", 25, 2);
		Move water3 = new Move("3 guys pressure blast", "water", 50, 3);
		Move grass1 = new Move("leaf smack", "grass", 10, 1);
		Move grass2 = new Move("blow dirt in eyeballs", "grass", 25, 2);
		Move grass3 = new Move("bury alive", "grass", 50, 3);
		
		natemons.add(firemon);
		natemons.add(watermon);
		natemons.add(grassmon);		
		moves.add(fire1);
		moves.add(fire2);
		moves.add(fire3);
		moves.add(water1);
		moves.add(water2);
		moves.add(water3);
		moves.add(grass1);
		moves.add(grass2);
		moves.add(grass3);
		
//		//test objects
//		Natemon grassmon2 = new Natemon("grassmon2", "grass", 150);
//		Natemon grassmon3 = new Natemon("grassmon2", "grass", 150);
//		natemons.add(grassmon2);
//		natemons.add(grassmon3);
		
		
		SwingUtilities.invokeLater(() -> new NatemonGUI());
//		System.out.println("Welcome to Natemon!");
//		start();
		
	}
	
	static void start() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nWould you like to play, create, view, or edit? ");
		String x = scan.nextLine().trim().toLowerCase();
		if(x.equals("create")) {
			System.out.print("\nWould you like to create a Natemon or a move? ");
			String y = scan.nextLine().toLowerCase();
			if(y.equals("natemon")) createNatemon();
			else if(y.equals("move")) createMove();
			else {
				System.out.print("Must create a Natemon or a move!");
				start();
			}
		}
		else if(x.equals("play")) {
			String pOutput = "\nYour team: ";
			String eOutput = "Enemy team: ";
			System.out.print("\nHow Natemons per team? ");
			int y = scan.nextInt();
			for(int i = 1; i <= y; i++) {
				System.out.println("\nChoose Natemon #"+i+" or choose \"random\".");
				Natemon n = chooseNatemon();
				System.out.println("You chose "+ n.getName()+"!");
				playerNatemons.add(n);
			}
			
			for(int i = 1; i <= y; i++) {
				System.out.println("\nChoose enemy Natemon #"+i+" or choose \"random\".");
				Natemon n = chooseNatemon();
				System.out.println("Enemy chose "+ n.getName()+"!");
				enemyNatemons.add(n);
			}
			
			for(int i = 0; i < y; i++) {
				pOutput += playerNatemons.get(i).getName() +", ";
				eOutput += enemyNatemons.get(i).getName() +", ";
			}
			System.out.println(pOutput+"\n"+eOutput);
			
			
			play();
			start();
		}
		else if(x.equals("view")) {
			System.out.print("\nWould you like to view Natemons or moves? ");
			String y = scan.nextLine().trim().toLowerCase();
			if(y.equals("natemons")) {
				viewNatemons();
				start();
			}
			else if(y.equals("moves")) {
				viewMoves();
				start();
			}
			else {
				System.out.println("Must view Natemons or moves!");
				start();
			}
		}
		else if(x.equals("edit")) {
			System.out.print("\nWould you like to edit a Natemon or a move? ");
			String y = scan.nextLine().toLowerCase().trim();
			if(y.equals("natemon")) {
				editNatemon();
				start();
			}else if(y.equals("move")) {
				editMove();
				start();
			}else {
				System.out.println("Must edit a Natemon or a move!");
				start();
			}
		}
		else start();
		scan.close();
	}
	
	static String showTeam(ArrayList<Natemon> team) {
		String output = "";
		for(int i = 0; i < team.size(); i++) {
			if(team.get(i).isAlive() && !playerNatemon.getName().equals(team.get(i).getName())) {
				output += team.get(i).toString()+ "\n\n";
			}
			
		}
		return output;
 	}
		
	static void editNatemon() {
		Scanner scan = new Scanner(System.in);
		Natemon edit = new Natemon();
		System.out.println("\nChoose a Natemon to edit!");
		viewNatemons();
		System.out.print("Choice: ");
		String x = scan.nextLine().trim();
		for(int i = 0; i < natemons.size(); i++) {
			if(x.equals(natemons.get(i).getName())) edit = natemons.get(i);
		}
		if(edit.getName().equals("Little Natemon")) {
			System.out.print("Natemon not found.");
			editNatemon();
		}
		
		System.out.print("\nWould you like to edit "+edit.getName()+"'s name, type, or health? ");
		String y = scan.nextLine().toLowerCase().trim();
		
		if(y.equals("name")) {
			System.out.print("Enter name: ");
			String name = scan.nextLine();
			if(name.equals(edit.getName())) {
				System.out.println("Can't enter the same name...");
				editNatemon();
			}else {
				System.out.println(edit.getName() +"'s name has been changed to "+name+"!");
				edit.setName(name);
			}
		}else if (y.equals("type")) {
			System.out.print("Enter type: ");
			String type = scan.nextLine().toLowerCase().trim();
			if(type.equals("fire") || type.equals("water") || type.equals("grass")) {
				if(edit.getType().equals(type)) {
					System.out.println(edit.getName()+" is already a "+type+" type!");
					editNatemon();
				}else {
					System.out.println(edit.getName() +"'s type has been changed to "+type+"!");
					edit.setType(type);
				}
			}else {
				System.out.println("Invalid type.");
				editNatemon();
			}
			
		}else if(y.equals("health")) {
			System.out.print("Enter health: ");
			int hp = scan.nextInt();
			if(hp == edit.getHp()) {
				System.out.println("Can't enter the same health...");
				editNatemon();
			}else {
				System.out.println(edit.getName()+"'s health has been chaned to "+hp+"!");
				edit.setHp(hp);
			}
		}else {
			System.out.println("Invalid input");
			editNatemon();
		}
			
	}
	
	static void editMove() {
		Scanner scan = new Scanner(System.in);
		Move edit = new Move();
		System.out.println("\nChoose a move to edit!");
		viewMoves();
		System.out.print("Choice: ");
		String x = scan.nextLine().trim();
		for(int i = 0; i < moves.size(); i++) {
			if(x.equals(moves.get(i).getName())) edit = moves.get(i);
		}
		if(edit.getName().equals("no move")) {
			System.out.print("Move not found.");
			editMove();
		}
		
		System.out.print("\nWould you like to edit "+edit.getName()+"'s name, type, or damage? ");
		String y = scan.nextLine().toLowerCase().trim();
		
		if(y.equals("name")) {
			System.out.print("Enter name: ");
			String name = scan.nextLine();
			if(name.equals(edit.getName())) {
				System.out.println("Can't enter the same name...");
				editMove();
			}else {
				System.out.println(edit.getName() +"'s name has been changed to "+name+"!");
				edit.setName(name);
			}
		}else if (y.equals("type")) {
			System.out.print("Enter type: ");
			String type = scan.nextLine().toLowerCase().trim();
			if(type.equals("fire") || type.equals("water") || type.equals("grass")) {
				if(edit.getType().equals(type)) {
					System.out.println(edit.getName()+" is already a "+type+" type!");
					editMove();
				}else {
					System.out.println(edit.getName() +"'s type has been changed to "+type+"!");
					edit.setType(type);
				}
			}else {
				System.out.println("Invalid type.");
				editMove();
			}
			
		}else if(y.equals("damage")) {
			System.out.print("Enter damage: ");
			int hp = scan.nextInt();
			if(hp == edit.getDamage()) {
				System.out.println("Can't enter the same damage...");
				editMove();
			}else {
				System.out.println(edit.getName()+"'s damage has been changed to "+hp+"!");
				edit.setDamage(hp);
			}
		}else {
			System.out.println("Invalid input");
			editMove();
		}
		
	}
	
	static void play() {
		playerNatemon = playerNatemons.get(0);
		enemyNatemon = enemyNatemons.get(0);
		while(!gameOver) {
			Scanner scan = new Scanner(System.in);
			showHealths(playerNatemon, enemyNatemon);
			System.out.print("\nWould you like to attack, heal, or switch your Natemon? ");
			String x = scan.nextLine().toLowerCase().trim();
			if(x.equals("attack")) {
				Move playerMove = moveSelect();
				attack(playerMove, playerNatemon, enemyNatemon);
				movesOnCooldown.add(playerMove);
			}else if(x.equals("heal")) {
				if(playerPotions == 0) {
					System.out.println("You have no potions left!");
					Move playerMove = moveSelect();
					movesOnCooldown.add(playerMove);
					attack(playerMove, playerNatemon, enemyNatemon);
				}else {
					playerNatemon.setHp(playerNatemon.getHp() + 25);
					playerPotions--;
					System.out.println("You healed "+playerNatemon.getName()+"! You now have "+playerPotions+" potions left!");
				}
			}else if(x.equals("switch")) {
				switchNatemon();
				
			}else {
				System.out.println("Invalid input.");
				continue;
			}
			
			
			showHealths(playerNatemon, enemyNatemon);
			
			if(natemonDefeated(enemyNatemon)) {
				if(teamDefeated(enemyNatemons)) {
					System.out.println("Congratulations! Your team defeated the enemy team!");
					gameOver = true;
					return;
				}else {
					System.out.println("Your "+playerNatemon.getName()+" defeated the "+enemyNatemon.getName()+"!");
					while(enemyNatemon.isAlive() == false) {
						enemyNatemon = randomNatemon(enemyNatemons);
					}
					System.out.println("Enemy chose "+enemyNatemon.getName()+"!");
				}
				
				
			}
			
			Move enemyMove = randomMove(enemyNatemon);
			attack(enemyMove, enemyNatemon, playerNatemon);
			
			if(natemonDefeated(playerNatemon)) {
				if(teamDefeated(playerNatemons)) {
					System.out.println("Oh no! Your team was defeated!");
					gameOver = true;
					return;
				}else {
					System.out.println("Oh no! Your "+playerNatemon.getName()+" was defeated by the "+enemyNatemon.getName()+"!");
				switchNatemon();
				}
				
				
			}
			
			for(int i = 0; i < movesOnCooldown.size(); i++) {
				movesOnCooldown.get(i).setCd(movesOnCooldown.get(i).getCooldown()-1);
				if(movesOnCooldown.get(i).getCooldown() == 0) {
					movesOnCooldown.get(i).setCd(movesOnCooldown.get(i).getMax());
					movesOnCooldown.remove(i);
				}
			}
			
		}
		
	}

	static boolean teamDefeated(ArrayList<Natemon> team) {
		boolean allDead = true;
		for(int i = 0; i < team.size(); i++) {
			if(team.get(i).isAlive()) {
				allDead = false;
				break;
			}
			
		}
		
		return allDead;
	}
	
	static void switchNatemon() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a natemon to switch to!");
		System.out.println("\n"+showTeam(playerNatemons)); 
		System.out.print("Choice: ");
		String n = scan.nextLine();
		
		for(int i = 0; i < playerNatemons.size(); i++) {
			if(n.equals(playerNatemons.get(i).getName()) && !n.equals(playerNatemon.getName())) {
				System.out.println("You chose "+n+"!");
				playerNatemon = playerNatemons.get(i);
			}
		}
	}
		
	static boolean natemonDefeated(Natemon natemon) {
		if(natemon.getHp() <= 0) return true;
		else return false;
	}
	
	static Move moveSelect() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nSelect a move to use!");
		viewMoves(playerNatemon);
		Move move = new Move();
		System.out.print("Choice: ");
		String ch = scan.nextLine();
		
		
		for(int i = 0; i < moves.size(); i++) {
			if(ch.equals(moves.get(i).getName())) move = moves.get(i);
		}
		
		if(move.getName().equals("no move") ) {
			System.out.println("Move entered was not found.");
		}else if(move.getCooldown() != move.getMax()) {
			System.out.println(move.getName() + " is on cooldown for "+move.getCooldown()+" turns!");
			move = new Move();
		}
		else {
			System.out.println("You chose "+move.getName()+"!");
		}
		return move;
		
	}
	 
	static Move randomMove(Natemon natemon) {
		ArrayList<Move> typeMoves = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < moves.size(); i++) {
			if(natemon.getType().equals(moves.get(i).getType())) typeMoves.add(moves.get(i));
		}
		
		int x = rand.nextInt(typeMoves.size());
		return typeMoves.get(x);
	}
	
	static void attack(Move m, Natemon attacker, Natemon defender) {
		System.out.println("\n"+attacker.getName() +" attacked "+defender.getName()+" with "+ m.getName()+"!");
		if((attacker.getType().equals("water") && defender.getType().equals("fire")) || (attacker.getType().equals("fire") && defender.getType().equals("grass")) || (attacker.getType().equals("grass") && defender.getType().equals("water"))) {
			//super effective
			defender.setHp(defender.getHp() - (2*m.getDamage()));
			System.out.println("Super effective! Double damage!");
		}else if((attacker.getType().equals("fire") && defender.getType().equals("water")) || (attacker.getType().equals("grass") && defender.getType().equals("fire")) || (attacker.getType().equals("water") && defender.getType().equals("grass"))) {
			//not very effective
			defender.setHp((int) (defender.getHp() - (0.5*m.getDamage())));
			System.out.println("Not very effective. Half damage.");
		}else {
			//normal attack
			defender.setHp(defender.getHp() - (m.getDamage()));
		}
		 System.out.println();
	 }
	
	static void showHealths(Natemon n1, Natemon n2) {
		System.out.println("\n"+n1.getName()+"'s Health: "+n1.getHp());
		System.out.println(n2.getName()+"'s Health: "+n2.getHp());
	}
	
	static Natemon chooseNatemon() {
		Scanner scan = new Scanner(System.in);
		
		viewNatemons();
		String choice = "";
		System.out.print("Choice: ");
		choice = scan.nextLine();
		
		if(choice.equals("random")) {
			Natemon r = randomNatemon();
			Natemon n = new Natemon(r.getName(), r.getType(), r.getHp());
			return n;
		}else {
			for(int i = 0; i < natemons.size(); i++) {
				if(choice.equals(natemons.get(i).getName())) {
					Natemon r = natemons.get(i);
					Natemon n = new Natemon(r.getName(), r.getType(), r.getHp());
					return n;
				}
			}
		}
		
		
		System.out.println("Natemon entered was not found.");
		play();
		return null;
	}
	
	static Natemon randomNatemon() {
		Random rand = new Random();
		int x = rand.nextInt(natemons.size());
		return natemons.get(x);
	}
	
	static Natemon randomNatemon(ArrayList<Natemon> team) {
		Random rand = new Random();
		int x = rand.nextInt(team.size());
		return team.get(x);
	}
	
	static void createNatemon() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nCreate a Natemon");
		System.out.print("Enter name: ");
		String name = scan.nextLine().trim();
		System.out.print("Enter health: ");
		int hp = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter type (fire, water, grass): ");
		String type = scan.nextLine().trim();
		Natemon n = new Natemon(name, type, hp);
		System.out.println(n.getName() +" was created!");
		natemons.add(n);
		start();
		scan.close();
	}
	
	static void createMove() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nCreate a move");
		System.out.print("Enter name: ");
		String moveName = scan.nextLine().trim();
		System.out.print("Enter damage: ");
		int damage = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter type (fire, water, grass): ");
		String moveType = scan.nextLine().trim();
		System.out.println("Enter cooldown: ");
		int cd = scan.nextInt();
		Move move = new Move(moveName, moveType, damage, cd);
		System.out.println(move.getName() + " was created!");
		moves.add(move);
		start();
		scan.close();
	}
	
	static void viewNatemons() {
		String output = "\n";
		for(int i = 0; i < natemons.size(); i++) {
			output += natemons.get(i).toString();
			output += "\n\n";
		}
		System.out.println(output);
	}
	
	static void viewMoves() {
		String output = "\n";
		for(int i = 0; i < moves.size(); i++) {
			output += moves.get(i).moveDescription() + "\nCooldown: "+ moves.get(i).getMax();
			output += "\n\n";
		}
		System.out.println(output);
	}

	static void viewMoves(Natemon natemon) {
		String output = "\n";
		for(int i = 0; i < moves.size(); i++) {
			if(moves.get(i).getType().equals(natemon.getType())) {
				output += moves.get(i).moveDescription();
				if(moves.get(i).getCooldown() == moves.get(i).getMax()){
					output += "\nMove ready to use!\n\n";
				}else {
					output += "\nMove ready to use in "+moves.get(i).getCooldown()+" moves!\n\n";
				}
			}
			
		}
		System.out.println(output);
	}
}
