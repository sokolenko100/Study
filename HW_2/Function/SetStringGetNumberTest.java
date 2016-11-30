package Function;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SetStringGetNumberTest {

	@Test
	public void testShowStringNumb_123() {
		int result = SetStringGetNumber.ShowStringNumb("��� �������� ���");
		assertEquals(123, result);
	}

	@Test
	public void testShowStringNumb_0() {
		int result = SetStringGetNumber.ShowStringNumb("����");
		assertEquals(0, result);
	}

	@Test
	public void testShowStringNumb_999() {
		int result = SetStringGetNumber
				.ShowStringNumb("��������� ��������� ������");
		assertEquals(999, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShowStringNumb_1000() {
		SetStringGetNumber.ShowStringNumb("�����@���� ��������� ������");
	}

}
