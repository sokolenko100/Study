CREATE DATABASE ResidentsOfStreets
GO
--------------------------
-- Create Street table
--------------------------
CREATE TABLE Street
(
  Id_Street    int    NOT NULL IDENTITY ,
  Neme_Street  char(50)   NULL,
  CONSTRAINT PK_Street  PRIMARY KEY (Id_Street)
);
GO
--------------------------
-- Create Person table
--------------------------
CREATE TABLE Person
(
  Id_Person  int    NOT NULL IDENTITY,
  Id_Street  int            NULL ,
  FirstName  char(15)       NULL,
  LastName   char(15)       NULL,
  Age        int            NULL 
  CONSTRAINT PK_Person  PRIMARY KEY (Id_Person)
  CONSTRAINT FK_Person_Street FOREIGN KEY(Id_Street) REFERENCES Street(Id_Street)
);
GO
DROP TABLE Street

--------------------------
-- ADD Street table
--------------------------
INSERT INTO Street (Neme_Street) VALUES
('������'),
('������'),
('�������������'),
('��������������'),
('������_�����������'),
('�������_�������'),
('��������'),
('������'), 
('�����������'),
('������������');
GO

SELECT * FROM Street
--------------------------
-- Add Person table
--------------------------
INSERT INTO Person (Id_Street, FirstName, LastName, Age) VALUES
(1,'����','������',23),
(1,'�����','�����',22),
(1,'����','�������',3),
(1,'���������','������',6),
(2,'�����','���������',13),
(2,'�����','���������',33),
(3,'Ը���','����������',43),
(4,'�����','���������',73),
(4,'�������','���������',83),
(5,'������','��������',28),
(5,'���������','������',48),
(6,'����','�������',45),
(7,'�����','��������',33),
(8,'���������','���������',31),
(9,'������','��������',11),
(10,'����','�����������',27)
GO
--------------------------
-- Add Person table
--------------------------
INSERT INTO Person (FirstName, LastName, Age) VALUES
('������','��������',23),
('�����','���������',22),
('�����','����������',13)
GO

SELECT * FROM Person

1) ������� ����� ����� �������

SELECT COUNT(*) FROM Person
Go

2) ������� ������� ������� �������

SELECT AVG(Age) FROM Person
Go

3)������� ��������������� �� �������� ������ ������� ��� ����������

SELECT DISTINCT LastName  FROM Person
ORDER BY LastName
Go

4)������� ������ �������, � ��������� ���������� ���������� ���� ������� � ����� ������

SELECT  LastName, COUNT(*) AS Count FROM Person
WHERE LastName is not null
GROUP BY LastName
Go

5)������� �������, ������� �������� � �������� ����� ��  ???????????????

SELECT  LastName FROM Person
WHERE LastName like '%�%' AND LastName NOT LIKE '�%'AND LastName NOT LIKE '%�'
Go


6) ������� ������ �������

SELECT FirstName, LastName, Age FROM Person
WHERE Id_Street is NULL
Go

7) ������� ������ ������������������, ����������� �� ��������� ������

SELECT FirstName, LastName, Age FROM Person
WHERE  Age<18 AND Id_Street =(SELECT Id_Street
								     FROM Street
							         WHERE Neme_Street = '������');
Go

8)������� ������������� �� �������� ������ ���� ���� � ���������, ������� ������� ���� �� �����

SELECT Neme_Street, COUNT(LastName) AS Count FROM Street,Person
WHERE Street.Id_Street=Person.Id_Street
GROUP BY Neme_Street
ORDER BY Neme_Street
Go

9)������� ������ ����, �������� ������� ������� �� 6-�� ����

SELECT Neme_Street FROM Street
WHERE Neme_Street LIKE '______'
Go

10)������� ������ ���� � ����������� ������� �� ��� ������ 3

SELECT Neme_Street, COUNT(LastName) AS Count FROM Street,Person
WHERE Street.Id_Street=Person.Id_Street
GROUP BY Neme_Street
HAVING COUNT(LastName)<3
ORDER BY Neme_Street
Go
