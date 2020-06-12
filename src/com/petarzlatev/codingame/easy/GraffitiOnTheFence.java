package com.petarzlatev.codingame.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class GraffitiOnTheFence {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int L = in.nextInt();
			int N = in.nextInt();
			boolean painted = false;
			List<Info> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int st = in.nextInt();
				int ed = in.nextInt();
				list.add(new Info(st, ed));
			}
			Collections.sort(list);
			long last = 0;
			for (Info i : list) {
				if (i == list.get(0) && i.st == 0) {
					last = i.ed;
					continue;
				}
				if (last < i.st) {
					System.out.println(last + " " + i.st);
					painted = true;
				}

				if (last < i.ed)
					last = i.ed;
				if (i == list.get(list.size() - 1) && i.ed != L) {
					painted = true;
					System.out.println(last + " " + L);
				}
			}
			if (!painted) {
				System.out.println("All painted");
			}
		}
	}
}

class Info implements Comparable<Info> {
	long st, ed;

	public Info(long st, long ed) {
		this.st = st;
		this.ed = ed;
	}

	@Override
	public int compareTo(Info info) {
		if (this.st > info.st)
			return 1;
		else if (this.st < info.st)
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "{" + "st=" + st + ", ed=" + ed + '}';
	}
}