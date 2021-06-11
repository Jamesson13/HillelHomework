CREATE SCHEMA IF NOT EXISTS Student;

USE Student;

CREATE TABLE Students 
(
	Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FullName VARCHAR(50) NOT NULL, 
	GroupId INT NOT NULL,
	AdmYear INT NOT NULL
);

CREATE TABLE StudyGroups 
(
	Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	GroupName VARCHAR(10) NOT NULL
);

CREATE TABLE Scores 
(
	Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	LsnId INT NOT NULL,
	StdId INT NOT NULL,
	Score INT NULL
);

CREATE TABLE Lessons 
(
	Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	LsnName VARCHAR(30) NOT NULL,
	TchId INT NOT NULL,
	Semester INT NOT NULL,
	StdYear INT NOT NULL
);

CREATE TABLE Teachers 
(
	Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FullName VARCHAR(50) NOT NULL,
	DepId INT NOT NULL
);

CREATE TABLE Departments 
(
	Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	DepName VARCHAR(30) NOT NULL,
	DepHead VARCHAR(50) NOT NULL
);

ALTER TABLE Teachers ADD 
	CONSTRAINT FK_Tch_Dep FOREIGN KEY (DepId) REFERENCES Departments (Id); 
    
ALTER TABLE Lessons ADD 
	CONSTRAINT FK_Lsn_Tch FOREIGN KEY (TchId)  REFERENCES Teachers (Id); 

ALTER TABLE Scores ADD 
	CONSTRAINT FK_Scr_Lsn FOREIGN KEY (LsnId)  REFERENCES Lessons (Id); 

ALTER TABLE Students ADD 
	CONSTRAINT FK_Std_Grp FOREIGN KEY (GroupId)  REFERENCES StudyGroups (Id); 
    
ALTER TABLE Scores ADD 
	CONSTRAINT FK_Scr_Std FOREIGN KEY (StdId)  REFERENCES Students (Id); 
