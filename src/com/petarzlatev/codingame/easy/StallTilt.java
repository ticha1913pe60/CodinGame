package com.petarzlatev.codingame.easy;

import java.util.*;

class Motorcycle {
	char name;
	Integer speed;

	Motorcycle(char name, Integer speed) {
		this.name = name;
		this.speed = speed;
	}
}

class Motorcycles {
	List<Motorcycle> motorcycles;

	Motorcycles() {
		this.motorcycles = new ArrayList<Motorcycle>();
	}

	void sortSpeed() {
		List<Motorcycle> sorted = new ArrayList<Motorcycle>();

		for (int idx = 0; idx < this.motorcycles.size(); idx += 1) {
			Motorcycle mot = this.motorcycles.get(idx);
			boolean insered = false;
			for (int index = 0; index < sorted.size(); index += 1) {
				if (mot.speed > sorted.get(index).speed) {
					sorted.add(index, mot);
					insered = true;
					break;
				}
			}
			if (!insered) {
				sorted.add(mot);
			}
		}

		this.motorcycles = sorted;
	}

	void turn(int max_speed) {
		List<Motorcycle> standing = new ArrayList<Motorcycle>();
		List<Motorcycle> fallen = new ArrayList<Motorcycle>();

		for (int idx = 0; idx < this.motorcycles.size(); idx += 1) {
			Motorcycle mot = this.motorcycles.get(idx);
			if (mot.speed > max_speed) {
				fallen.add(mot);
			} else {
				standing.add(mot);
			}
		}

		standing.addAll(fallen);
		this.motorcycles = standing;
	}
}

class StallTilt {
	static int max_speed(int turn) {
		return (int) Math.sqrt(Math.tan(Math.toRadians(60)) * (turn * 9.81));
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int v = in.nextInt();

		Motorcycles motorcycles = new Motorcycles();

		for (int i = 0; i < n; i++) {
			int speed = in.nextInt();
			motorcycles.motorcycles.add(new Motorcycle((char) (i + 97), speed));
		}

		motorcycles.sortSpeed();
		int max_speed = Integer.MAX_VALUE;
		for (int i = 0; i < v; i++) {
			int bends = in.nextInt();

			int turnSpeed = max_speed(bends);
			max_speed = Math.min(max_speed, turnSpeed);

			motorcycles.turn(turnSpeed);
		}

		System.out.println(max_speed);
		System.out.println("y");
		for (int idx = 0; idx < motorcycles.motorcycles.size(); idx += 1) {
			System.out.println(motorcycles.motorcycles.get(idx).name);
		}
	}
}