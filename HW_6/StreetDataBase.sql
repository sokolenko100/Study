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
('Правды'),
('Кирова'),
('Ленинградская'),
('Кировоградская'),
('Героев_Сталинграда'),
('Демьяна_Бедного'),
('Рогалева'),
('Чубаря'), 
('Вакуленчука'),
('Дзержинского');
GO

SELECT * FROM Street
--------------------------
-- Add Person table
--------------------------
INSERT INTO Person (Id_Street, FirstName, LastName, Age) VALUES
(1,'Петя','Петров',23),
(1,'Настя','Бойко',22),
(1,'Юлия','Петрова',3),
(1,'Александр','Петров',6),
(2,'Роман','Романенко',13),
(2,'Настя','Романенко',33),
(3,'Фёдор','Лукьяненко',43),
(4,'Ольга','Федоренко',73),
(4,'Валерий','Федоренко',83),
(5,'Кузьма','Изматлов',28),
(5,'Ростислав','Корбан',48),
(6,'Гоша','Куценко',45),
(7,'Артур','Пирожков',33),
(8,'Екатерина','Лыжникова',31),
(9,'Руслан','Отрыжков',11),
(10,'Егор','Зеленовский',27)
GO
--------------------------
-- Add Person table
--------------------------
INSERT INTO Person (FirstName, LastName, Age) VALUES
('Борода','Бомженко',23),
('Сифон','Сифоненко',22),
('Елька','Вокзальная',13)
GO

SELECT * FROM Person

1) Вывести общее число жителей

SELECT COUNT(*) FROM Person
Go

2) Вывести средний возраст жителей

SELECT AVG(Age) FROM Person
Go

3)Вывести отсортированный по алфавиту список фамилий без повторений

SELECT DISTINCT LastName  FROM Person
ORDER BY LastName
Go

4)Вывести список фамилий, с указанием количества повторений этих фамилий в общем списке

SELECT  LastName, COUNT(*) AS Count FROM Person
WHERE LastName is not null
GROUP BY LastName
Go

5)Вывести фамилии, которые содержат в середине букву «б»  ???????????????

SELECT  LastName FROM Person
WHERE LastName like '%б%' AND LastName NOT LIKE 'б%'AND LastName NOT LIKE '%б'
Go


6) Вывести список «бомжей»

SELECT FirstName, LastName, Age FROM Person
WHERE Id_Street is NULL
Go

7) Вывести список несовершеннолетних, проживающих на проспекте Правды

SELECT FirstName, LastName, Age FROM Person
WHERE  Age<18 AND Id_Street =(SELECT Id_Street
								     FROM Street
							         WHERE Neme_Street = 'Правды');
Go

8)Вывести упорядоченный по алфавиту список всех улиц с указанием, сколько жильцов живёт на улице

SELECT Neme_Street, COUNT(LastName) AS Count FROM Street,Person
WHERE Street.Id_Street=Person.Id_Street
GROUP BY Neme_Street
ORDER BY Neme_Street
Go

9)Вывести список улиц, название которых состоит из 6-ти букв

SELECT Neme_Street FROM Street
WHERE Neme_Street LIKE '______'
Go

10)Вывести список улиц с количеством жильцов на них меньше 3

SELECT Neme_Street, COUNT(LastName) AS Count FROM Street,Person
WHERE Street.Id_Street=Person.Id_Street
GROUP BY Neme_Street
HAVING COUNT(LastName)<3
ORDER BY Neme_Street
Go
