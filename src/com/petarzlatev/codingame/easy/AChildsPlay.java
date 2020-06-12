package com.petarzlatev.codingame.easy;

import java.util.*;

class AChildsPlay {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int w = in.nextInt();
			int h = in.nextInt();
			long n = in.nextLong();
			int angle = -270;
			List<String> map = new ArrayList<>();
			List<ThePoint> history = new ArrayList<>();
			List<ThePoint> check_history = new ArrayList<>();
			boolean repeat = false;
			ThePoint p = new ThePoint(-1, -1);

			if (in.hasNextLine()) {
				in.nextLine();
			}
			for (int i = 0; i < h; i++) {
				String line = in.nextLine();
				map.add(line);
				if (p.x == -1 && line.contains("O")) {
					p.x = line.indexOf("O");
					p.y = i;
				}
			}
			while (n > 0) {
				if (history.size() > 4 && history.size() != check_history.size()
						&& p.equals(history.get(check_history.size()))) {
					repeat = true;
				} else {
					if (repeat && history.size() == check_history.size()) {
						n %= check_history.size();
						p = history.get((int) n);
						break;
					}
					repeat = false;
				}
				if (repeat) {
					check_history.add(new ThePoint(p.x, p.y));
				} else {
					if (check_history.size() > 0) {
						history.addAll(check_history);
						check_history.clear();
					}
					history.add(new ThePoint(p.x, p.y));
				}
				if (angle == 0) {// Right
					if (p.x == w - 1) {
						break;
					}
					if (map.get(p.y).charAt(p.x + 1) == '#') {
						angle -= 90;
					}
				} else if (angle == -90) {// Down
					if (p.y == h - 1) {
						break;
					}
					if (map.get(p.y + 1).charAt(p.x) == '#') {
						angle -= 90;
					}
				} else if (angle == -180) {// Left
					if (p.x == 0) {
						break;
					}
					if (map.get(p.y).charAt(p.x - 1) == '#') {
						angle -= 90;
					}
				} else if (angle == -270) {// Top
					if (p.y == 0) {
						break;
					}
					if (map.get(p.y - 1).charAt(p.x) == '#') {
						angle -= 90;
					}
				}
				if (angle == -360) {
					angle = 0;
				}
				if (angle == 0) {
					p.x++;
				} else if (angle == -90) {
					p.y++;
				} else if (angle == -180) {
					p.x--;
				} else if (angle == -270) {
					p.y--;
				}
				n--;
			}
			System.out.println(p.x + " " + p.y);
		}
	}
}

class ThePoint {
	int x, y;

	public ThePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ThePoint) {

			ThePoint p = (ThePoint) obj;
			return p.x == this.x && p.y == this.y;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Point{" + "x=" + x + ", y=" + y + '}';
	}
}
