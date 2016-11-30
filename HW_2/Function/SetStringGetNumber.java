package Function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetStringGetNumber {
	public static boolean test(String testString) {
		Pattern p = Pattern.compile("[@]");// Почему возвращает фелз у
											// последнего теста? если строка
											// содержит @ ?
											// \\d|
											// [`#$%^&*()-+=?_}{\\]\\[:;\\|,.<>\\']
		Matcher m = p.matcher(testString);
		boolean b = m.matches();
		// return m.matches();
		return b;
	}

	public static int ShowStringNumb(String StringNumb) {
		if (test(StringNumb)) {
			throw new IllegalArgumentException();
		}
		int _numberInt = 0;
		String[] arrayStringNumb = StringNumb.toLowerCase().split(" ");
		for (int i = 0; i < arrayStringNumb.length; i++) {
			if (i == 0) {
				_numberInt += ReturnHundredValue(arrayStringNumb[i]);
			}
			_numberInt += ReturnDecadeValue(arrayStringNumb[i]);
			_numberInt += ReturnFrom11to19Value(arrayStringNumb[i]);
			_numberInt += ReturnUnitsValue(arrayStringNumb[i]);
		}
		return _numberInt;
	}

	public static int ReturnHundredValue(String Hundred) {
		int result = 0;
		switch (Hundred) {
		case "сто": {
			result = 100;
			break;
		}
		case "двести": {
			result = 200;
			break;
		}
		case "триста": {
			result = 300;
			break;
		}
		case "четыреста": {
			result = 400;
			break;
		}
		case "пятсот": {
			result = 500;
			break;
		}
		case "шестсот": {
			result = 600;
			break;
		}
		case "семьсот": {
			result = 700;
			break;
		}
		case "восемьсот": {
			result = 800;
			break;
		}
		case "девятьсот": {
			result = 900;
			break;
		}
		}
		return result;
	}

	public static int ReturnDecadeValue(String decade) {
		int result = 0;
		switch (decade) {
		case "десять": {
			result = 10;
			break;
		}
		case "двадцать": {
			result = 20;
			break;
		}
		case "тридцать": {
			result = 30;
			break;
		}
		case "сорок": {
			result = 40;
			break;
		}
		case "пятьдесят": {
			result = 50;
			break;
		}
		case "шестьдесят": {
			result = 60;
			break;
		}
		case "семьдесят": {
			result = 70;
			break;
		}
		case "восемьдесят": {
			result = 80;
			break;
		}
		case "девяносто": {
			result = 90;
			break;
		}

		}
		return result;
	}

	public static int ReturnFrom11to19Value(String from11to19) {
		int result = 0;
		switch (from11to19) {
		case "десять": {
			result = 10;
			break;
		}
		case "одиннадцать": {
			result = 11;
			break;
		}
		case "двенадцать": {
			result = 12;
			break;
		}
		case "тринадцать": {
			result = 13;
			break;
		}
		case "четырнадцать": {
			result = 14;
			break;
		}
		case "пятнадцать": {
			result = 15;
			break;
		}
		case "шестнадцать": {
			result = 16;
			break;
		}
		case "семьнадцать": {
			result = 17;
			break;
		}
		case "восемьнадцать": {
			result = 18;
			break;
		}
		case "девятнадцать": {
			result = 19;
			break;
		}

		}
		return result;
	}

	public static int ReturnUnitsValue(String unint) {
		int result = 0;
		switch (unint) {
		case "ноль": {
			result = 0;
			break;
		}
		case "oдин": {
			result = 1;
			break;
		}
		case "два": {
			result = 2;
			break;
		}
		case "три": {
			result = 3;
			break;
		}
		case "четыре": {
			result = 4;
			break;
		}
		case "пять": {
			result = 5;
			break;
		}
		case "шесть": {
			result = 6;
			break;
		}
		case "семь": {
			result = 7;
			break;
		}
		case "восемь": {
			result = 8;
			break;
		}
		case "девять": {
			result = 9;
			break;
		}
		}
		return result;
	}
}
