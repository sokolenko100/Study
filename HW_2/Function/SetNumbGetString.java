package Function;

public class SetNumbGetString {
	private static final int _ten = 10;
	private static final int _twenty = 20;
	private static final int _hundred = 100;
	private static final int _thousand = 1000;

	public static String ShowNumbFromString(int setNumber) {
		if (setNumber < 0 || setNumber >= _thousand) {
			throw new IllegalArgumentException();
		}
		String numbString = "";
		if (setNumber < _ten) {
			numbString += " " + ReturnUnitsValue(setNumber);
		}
		if (setNumber > _ten && setNumber < _twenty) {
			numbString += " " + ReturnFrom11to19Value(setNumber);
		}
		if (setNumber > _twenty && setNumber < _hundred) {
			numbString = ShowDecadeAndUnitValue(setNumber);
		}
		if (setNumber > _hundred && setNumber < _thousand) {
			numbString = ShowHundredValue(setNumber);
		}
		return numbString;
	}

	public static String ShowDecadeAndUnitValue(int setNumber) {
		String numbString = "";
		numbString += " " + ReturnDecadeValue(setNumber / 10);
		numbString += ShowNumbFromString(setNumber % 10);
		return numbString;
	}

	public static String ShowHundredValue(int setNumber) {
		String numbString = "";
		numbString += ReturnHundredValue(setNumber / 100);
		numbString += ShowNumbFromString(setNumber % 100);
		return numbString;
	}

	public static String ReturnHundredValue(int Hundred) {
		String result = "";
		switch (Hundred) {
		case 1: {
			result = "сто";
			break;
		}
		case 2: {
			result = "двести";
			break;
		}
		case 3: {
			result = "триста";
			break;
		}
		case 4: {
			result = "четыреста";
			break;
		}
		case 5: {
			result = "пятсот";
			break;
		}
		case 6: {
			result = "шестсот";
			break;
		}
		case 7: {
			result = "семьсот";
			break;
		}
		case 8: {
			result = "восемьсот";
			break;
		}
		case 9: {
			result = "девятьсот";
			break;
		}
		}
		return result;
	}

	public static String ReturnDecadeValue(int decade) {
		String result = "";
		switch (decade) {
		case 1: {
			result = "десять";
			break;
		}
		case 2: {
			result = "двадцать";
			break;
		}
		case 3: {
			result = "тридцать";
			break;
		}
		case 4: {
			result = "сорок";
			break;
		}
		case 5: {
			result = "пятьдесят";
			break;
		}
		case 6: {
			result = "шестьдесят";
			break;
		}
		case 7: {
			result = "семьдесят";
			break;
		}
		case 8: {
			result = "восемьдесят";
			break;
		}
		case 9: {
			result = "девяносто";
			break;
		}
		}
		return result;
	}

	public static String ReturnFrom11to19Value(int from11to19) {
		String result = "";
		switch (from11to19) {
		case 10: {
			result = "десять";
			break;
		}
		case 11: {
			result = "одиннадцать";
			break;
		}
		case 12: {
			result = "двенадцать";
			break;
		}
		case 13: {
			result = "тринадцать";
			break;
		}
		case 14: {
			result = "четырнадцать";
			break;
		}
		case 15: {
			result = "пятнадцать";
			break;
		}
		case 16: {
			result = "шестнадцать";
			break;
		}
		case 17: {
			result = "семьнадцать";
			break;
		}
		case 18: {
			result = "восемьнадцать";
			break;
		}
		case 19: {
			result = "девятнадцать";
			break;
		}
		}
		return result;
	}

	public static String ReturnUnitsValue(int unint) {
		String result = "";
		switch (unint) {
		case 0: {
			result = "ноль";
			break;
		}
		case 1: {
			result = "oдин";
			break;
		}
		case 2: {
			result = "два";
			break;
		}
		case 3: {
			result = "три";
			break;
		}
		case 4: {
			result = "четыре";
			break;
		}
		case 5: {
			result = "пять";
			break;
		}
		case 6: {
			result = "шесть";
			break;
		}
		case 7: {
			result = "семь";
			break;
		}
		case 8: {
			result = "восемь";
			break;
		}
		case 9: {
			result = "девять";
			break;
		}
		}
		return result;
	}
}
