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
			result = "���";
			break;
		}
		case 2: {
			result = "������";
			break;
		}
		case 3: {
			result = "������";
			break;
		}
		case 4: {
			result = "���������";
			break;
		}
		case 5: {
			result = "������";
			break;
		}
		case 6: {
			result = "�������";
			break;
		}
		case 7: {
			result = "�������";
			break;
		}
		case 8: {
			result = "���������";
			break;
		}
		case 9: {
			result = "���������";
			break;
		}
		}
		return result;
	}

	public static String ReturnDecadeValue(int decade) {
		String result = "";
		switch (decade) {
		case 1: {
			result = "������";
			break;
		}
		case 2: {
			result = "��������";
			break;
		}
		case 3: {
			result = "��������";
			break;
		}
		case 4: {
			result = "�����";
			break;
		}
		case 5: {
			result = "���������";
			break;
		}
		case 6: {
			result = "����������";
			break;
		}
		case 7: {
			result = "���������";
			break;
		}
		case 8: {
			result = "�����������";
			break;
		}
		case 9: {
			result = "���������";
			break;
		}
		}
		return result;
	}

	public static String ReturnFrom11to19Value(int from11to19) {
		String result = "";
		switch (from11to19) {
		case 10: {
			result = "������";
			break;
		}
		case 11: {
			result = "�����������";
			break;
		}
		case 12: {
			result = "����������";
			break;
		}
		case 13: {
			result = "����������";
			break;
		}
		case 14: {
			result = "������������";
			break;
		}
		case 15: {
			result = "����������";
			break;
		}
		case 16: {
			result = "�����������";
			break;
		}
		case 17: {
			result = "�����������";
			break;
		}
		case 18: {
			result = "�������������";
			break;
		}
		case 19: {
			result = "������������";
			break;
		}
		}
		return result;
	}

	public static String ReturnUnitsValue(int unint) {
		String result = "";
		switch (unint) {
		case 0: {
			result = "����";
			break;
		}
		case 1: {
			result = "o���";
			break;
		}
		case 2: {
			result = "���";
			break;
		}
		case 3: {
			result = "���";
			break;
		}
		case 4: {
			result = "������";
			break;
		}
		case 5: {
			result = "����";
			break;
		}
		case 6: {
			result = "�����";
			break;
		}
		case 7: {
			result = "����";
			break;
		}
		case 8: {
			result = "������";
			break;
		}
		case 9: {
			result = "������";
			break;
		}
		}
		return result;
	}
}
