package Server;

import java.util.ArrayList;

public class UserProfile 
{
	String login;
	Boolean ban = false;
	int banTyme = 0;
	ArrayList<String> newMessages = new ArrayList<>(); // ������� ��������� � Json �������
}
