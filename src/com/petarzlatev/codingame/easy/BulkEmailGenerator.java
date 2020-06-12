package com.petarzlatev.codingame.easy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BulkEmailGenerator {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = Integer.parseInt(scanner.nextLine());

			String[] emailTemplateLines = new String[N];

			for (int i = 0; i < N; i++) {
				emailTemplateLines[i] = scanner.nextLine();
			}

			String emailTemplate = String.join("\n", emailTemplateLines);

			Pattern regexPattern = Pattern.compile("\\([^)]*\\)");
			Matcher regexMatcher = regexPattern.matcher(emailTemplate);

			int choicesCounter = -1;
			String email = "";
			int emailTemplateIndex = 0;

			while (regexMatcher.find()) {
				choicesCounter++;

				email += emailTemplate.substring(emailTemplateIndex, regexMatcher.start());
				emailTemplateIndex = regexMatcher.end();

				String[] choices = emailTemplate.substring(regexMatcher.start() + 1, regexMatcher.end() - 1).split("\\|",
						-1);
				email += choices[choicesCounter % choices.length];
			}

			email += emailTemplate.substring(emailTemplateIndex);

			System.out.println(email);
		}
	}
}