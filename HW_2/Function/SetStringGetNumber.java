package Function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetStringGetNumber {
	public static boolean test(String testString) {
		Pattern p = Pattern.compile("[@]");// ������ ���������� ���� �
											// ���������� �����? ���� ������
											// �������� @ ?
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
		case "���": {
			result = 100;
			break;
		}
		case "������": {
			result = 200;
			break;
		}
		case "������": {
			result = 300;
			break;
		}
		case "���������": {
			result = 400;
			break;
		}
		case "������": {
			result = 500;
			break;
		}
		case "�������": {
			result = 600;
			break;
		}
		case "�������": {
			result = 700;
			break;
		}
		case "���������": {
			result = 800;
			break;
		}
		case "���������": {
			result = 900;
			break;
		}
		}
		return result;
	}

	public static int ReturnDecadeValue(String decade) {
		int result = 0;
		switch (decade) {
		case "������": {
			result = 10;
			break;
		}
		case "��������": {
			result = 20;
			break;
		}
		case "��������": {
			result = 30;
			break;
		}
		case "�����": {
			result = 40;
			break;
		}
		case "���������": {
			result = 50;
			break;
		}
		case "����������": {
			result = 60;
			break;
		}
		case "���������": {
			result = 70;
			break;
		}
		case "�����������": {
			result = 80;
			break;
		}
		case "���������": {
			result = 90;
			break;
		}

		}
		return result;
	}

	public static int ReturnFrom11to19Value(String from11to19) {
		int result = 0;
		switch (from11to19) {
		case "������": {
			result = 10;
			break;
		}
		case "�����������": {
			result = 11;
			break;
		}
		case "����������": {
			result = 12;
			break;
		}
		case "����������": {
			result = 13;
			break;
		}
		case "������������": {
			result = 14;
			break;
		}
		case "����������": {
			result = 15;
			break;
		}
		case "�����������": {
			result = 16;
			break;
		}
		case "�����������": {
			result = 17;
			break;
		}
		case "�������������": {
			result = 18;
			break;
		}
		case "������������": {
			result = 19;
			break;
		}

		}
		return result;
	}

	public static int ReturnUnitsValue(String unint) {
		int result = 0;
		switch (unint) {
		case "����": {
			result = 0;
			break;
		}
		case "o���": {
			result = 1;
			break;
		}
		case "���": {
			result = 2;
			break;
		}
		case "���": {
			result = 3;
			break;
		}
		case "������": {
			result = 4;
			break;
		}
		case "����": {
			result = 5;
			break;
		}
		case "�����": {
			result = 6;
			break;
		}
		case "����": {
			result = 7;
			break;
		}
		case "������": {
			result = 8;
			break;
		}
		case "������": {
			result = 9;
			break;
		}
		}
		return result;
	}
}
