/* --------------Departments----------------------------------------------------------------------------------- */
insert into Departments (DepName, DepHead) values ('Product Management', 'Olivier Pedrocco');
insert into Departments (DepName, DepHead) values ('Services', 'Elyse Riepl');
insert into Departments (DepName, DepHead) values ('Sales', 'Elfrieda Gettings');
insert into Departments (DepName, DepHead) values ('Marketing', 'Clare Baldi');

/* ----------------Teachers------------------------------------------------------------------------------------ */
insert into Teachers (FullName, DepId) values ('Simone Bucham', 1);
insert into Teachers (FullName, DepId) values ('Mohandis Billiard', 2);
insert into Teachers (FullName, DepId) values ('Danny Antowski', 1);
insert into Teachers (FullName, DepId) values ('Denna Brassill', 4);
insert into Teachers (FullName, DepId) values ('Brendan Petrolli', 4);
insert into Teachers (FullName, DepId) values ('Hephzibah Adamolli', 2);
insert into Teachers (FullName, DepId) values ('Philipa Standish', 3);
insert into Teachers (FullName, DepId) values ('Elfie Keston', 4);

/* ----------------Lessons------------------------------------------------------------------------------------- */
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Finance', 5, 1, 2020);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Consumer Durables', 1, 2, 2020);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Health Care', 2, 1, 2020);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Finance', 1, 2, 2019);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Finance', 5, 1, 2020);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Technology', 2, 2, 2019);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Energy', 8, 1, 2020);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Consumer Services', 8, 2, 2019);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Technology', 5, 2, 2019);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Consumer Services', 7, 2, 2019);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Health Care', 6, 2, 2020);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Health Care', 8, 1, 2020);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Technology', 1, 1, 2020);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Energy', 2, 2, 2020);
insert into Lessons (LsnName, TchId, Semester, StdYear) values ('Finance', 8, 1, 2020);

/* --------------StudyGroups----------------------------------------------------------------------------------- */
insert into StudyGroups (GroupName) values ('GRP-101');
insert into StudyGroups (GroupName) values ('GRP-201');
insert into StudyGroups (GroupName) values ('GRP-301');

/* ----------------Students------------------------------------------------------------------------------------ */
insert into Students (FullName, GroupId, AdmYear) values ('Thomas Shingles', 1, 2016);
insert into Students (FullName, GroupId, AdmYear) values ('Veronika Marguerite', 3, 2018);
insert into Students (FullName, GroupId, AdmYear) values ('Lela Danett', 2, 2017);
insert into Students (FullName, GroupId, AdmYear) values ('Shaylah Brideoke', 3, 2018);
insert into Students (FullName, GroupId, AdmYear) values ('Thelma Shovelin', 2, 2017);
insert into Students (FullName, GroupId, AdmYear) values ('Juliet Pengelly', 1, 2016);
insert into Students (FullName, GroupId, AdmYear) values ('Joli Royds', 3, 2018);
insert into Students (FullName, GroupId, AdmYear) values ('Rinaldo Gillbard', 2, 2017);
insert into Students (FullName, GroupId, AdmYear) values ('Chantalle Milward', 2, 2017);
insert into Students (FullName, GroupId, AdmYear) values ('Isidro Mouatt', 2, 2017);
insert into Students (FullName, GroupId, AdmYear) values ('Anselma Asipenko', 1, 2016);
insert into Students (FullName, GroupId, AdmYear) values ('Lynda Gammon', 3, 2018);
insert into Students (FullName, GroupId, AdmYear) values ('Mill Laverty', 1, 2016);
insert into Students (FullName, GroupId, AdmYear) values ('Perri Taillard', 2, 2017);
insert into Students (FullName, GroupId, AdmYear) values ('Ania Langmuir', 3, 2018);
insert into Students (FullName, GroupId, AdmYear) values ('Averil Broadfield', 1, 2016);
insert into Students (FullName, GroupId, AdmYear) values ('Correna Yurinov', 2, 2017);
insert into Students (FullName, GroupId, AdmYear) values ('Sadie Easbie', 3, 2018);
insert into Students (FullName, GroupId, AdmYear) values ('Tracee Volonte', 3, 2018);
insert into Students (FullName, GroupId, AdmYear) values ('Bari Swyre', 2, 2017);

/* -----------------Scores------------------------------------------------------------------------------------- */
insert into Scores (LsnId, StdId, Score) values (9, 12, 64);
insert into Scores (LsnId, StdId, Score) values (8, 16, 77);
insert into Scores (LsnId, StdId, Score) values (12, 11, 82);
insert into Scores (LsnId, StdId, Score) values (6, 8, 72);
insert into Scores (LsnId, StdId, Score) values (5, 15, 95);
insert into Scores (LsnId, StdId, Score) values (5, 4, 83);
insert into Scores (LsnId, StdId, Score) values (10, 8, 81);
insert into Scores (LsnId, StdId, Score) values (15, 5, 95);
insert into Scores (LsnId, StdId, Score) values (6, 8, 67);
insert into Scores (LsnId, StdId, Score) values (10, 15, 76);
insert into Scores (LsnId, StdId, Score) values (2, 8, 98);
insert into Scores (LsnId, StdId, Score) values (3, 5, 100);
insert into Scores (LsnId, StdId, Score) values (12, 15, 85);
insert into Scores (LsnId, StdId, Score) values (12, 1, 93);
insert into Scores (LsnId, StdId, Score) values (1, 16, 73);
insert into Scores (LsnId, StdId, Score) values (14, 6, 79);
insert into Scores (LsnId, StdId, Score) values (2, 4, 74);
insert into Scores (LsnId, StdId, Score) values (1, 4, 82);
insert into Scores (LsnId, StdId, Score) values (14, 9, 70);
insert into Scores (LsnId, StdId, Score) values (2, 5, 96);
insert into Scores (LsnId, StdId, Score) values (6, 3, 79);
insert into Scores (LsnId, StdId, Score) values (13, 3, 82);
insert into Scores (LsnId, StdId, Score) values (2, 18, 93);
insert into Scores (LsnId, StdId, Score) values (7, 6, 98);
insert into Scores (LsnId, StdId, Score) values (9, 18, 76);
insert into Scores (LsnId, StdId, Score) values (9, 5, 83);
insert into Scores (LsnId, StdId, Score) values (14, 14, 92);
insert into Scores (LsnId, StdId, Score) values (9, 20, 83);
insert into Scores (LsnId, StdId, Score) values (11, 9, 66);
insert into Scores (LsnId, StdId, Score) values (13, 4, 61);
