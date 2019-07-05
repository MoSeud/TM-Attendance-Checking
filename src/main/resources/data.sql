INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(101,'March,2019',TO_DATE('03/01/2019','MM/DD/YYYY') ,TO_DATE('03/30/2019','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(102,'April,2019',TO_DATE('04/01/2019','MM/DD/YYYY') ,TO_DATE('04/30/2019','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(103,'May,2019',TO_DATE('05/01/2019','MM/DD/YYYY') ,TO_DATE('05/30/2019','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(104,'June,2019',TO_DATE('06/01/2019','MM/DD/YYYY') ,TO_DATE('06/30/2019','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(105,'July,2019',TO_DATE('07/01/2019','MM/DD/YYYY') ,TO_DATE('07/30/2019','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(106,'August,2019',TO_DATE('08/01/2019','MM/DD/YYYY') ,TO_DATE('08/30/2019','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(107,'September,2019',TO_DATE('09/01/2019','MM/DD/YYYY') ,TO_DATE('09/30/2019','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(108,'October,2018',TO_DATE('10/01/2018','MM/DD/YYYY') ,TO_DATE('10/30/2018','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(109,'November,2018',TO_DATE('11/01/2018','MM/DD/YYYY') ,TO_DATE('11/30/2018','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(110,'December,2018',TO_DATE('12/01/2018','MM/DD/YYYY') ,TO_DATE('12/30/2018','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(111,'January,2018',TO_DATE('01/01/2018','MM/DD/YYYY') ,TO_DATE('01/30/2018','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(112,'February,2018',TO_DATE('02/01/2018','MM/DD/YYYY') ,TO_DATE('02/30/2018','MM/DD/YYYY'),22);
INSERT INTO Block (id,name, start_date, end_date, number_of_days) VALUES(113,'August,2018',TO_DATE('08/01/2018','MM/DD/YYYY') ,TO_DATE('08/30/2018','MM/DD/YYYY'),22);

INSERT INTO EVENT_TYPE(id,name,short_name,description,start_time,end_time) VALUES(101,'Morning Meditation','MM','Morning meditation is help ful',TO_DATE(' 01/01/2001 08:45 AM','MM/DD/YYYY HH:mi AM '),TO_DATE(' 01/01/2001 09:15 AM','MM/DD/YYYY HH:mi PM '));
INSERT INTO EVENT_TYPE(id,name,short_name,description,start_time,end_time) VALUES(102,'Retreat','RR','Help to get relaxed',TO_DATE(' 01/01/2001 07:30 AM','MM/DD/YYYY HH:mi AM '),TO_DATE(' 01/01/2001 09:15 PM','MM/DD/YYYY HH:mi PM '));
INSERT INTO EVENT_TYPE(id,name,short_name,description,start_time,end_time) VALUES(103,'DC Lecture','DC','extra knowledge',TO_DATE(' 01/01/2001 01:30 AM','MM/DD/YYYY HH:mi AM '),TO_DATE(' 01/01/2001 03:15 AM','MM/DD/YYYY HH:mi PM '));



INSERT INTO LOCATION(id,name,short_name,description,capacity) VALUES(101,'Dalby Hall ','DB','it is a hall  located in argiro',150);
INSERT INTO LOCATION(id,name,short_name,description,capacity) VALUES(102,'Boys Golden Dome ','BGD','it is a wide dom ',500);
INSERT INTO LOCATION(id,name,short_name,description,capacity) VALUES(103,'Girls Golden Dome ','GGD','it is a wide dom',500);


INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(101,'event for meditation',101,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(102,'event for meditation',102,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(103,'event for meditation',103,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(104,'event for meditation',104,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(105,'event for meditation',105,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(106,'event for meditation',106,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(107,'event for meditation',107,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(108,'event for meditation',108,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(109,'event for meditation',109,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(110,'event for meditation',110,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(111,'event for meditation',111,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(112,'event for meditation',112,101,101);
INSERT INTO EVENT(id,description,Block,event_type,location) VALUES(113,'event for meditation',113,101,101);

INSERT INTO PHONE(id,area,prefix,numbers) VALUES(101,'712','666','0987');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(201,'712','666','0987');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(301,'712','666','0987');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(401,'712','666','0987');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(501,'712','666','0987');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(601,'712','666','0987');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(701,'712','666','0987');
INSERT INTO PHONE(id,area,prefix,numbers) VALUES(801,'712','666','0987');

INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (101,'000-98-1234','7888',TO_DATE('2017-08-01','YYYY-MM-DD'),'Tomas','Melake','tmelake@mum.edu',101);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (102,'000-98-1235','7326',TO_DATE('2017-08-01','YYYY-MM-DD'),'Redae','Mengsteab','rmengsteab@mum.edu',201);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (103,'000-98-1236','7698',TO_DATE('2017-08-01','YYYY-MM-DD'),'Fnan','Eyasu','feyasu@mum.edu',301);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (104,'000-98-1237','7417',TO_DATE('2017-08-01','YYYY-MM-DD'),'Mohammed','Seud','mseud@mum.edu',301);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (105,'000-98-1238','7839',TO_DATE('2017-08-01','YYYY-MM-DD'),'Semhar','Isaac','sisaac@mum.edu',401);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (106,'000-98-1239','7284',TO_DATE('2017-11-01','YYYY-MM-DD'),'Kibreab ','Habte','khabte@mum.edu',501);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (107,'000-98-1230','7482',TO_DATE('2017-11-01','YYYY-MM-DD'),'Solemie ','Teshome','mberiahu@mum.edu',601);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (108,'000-98-1231','7938',TO_DATE('2017-11-01','YYYY-MM-DD'),'Mana ','Wana','mwana@mum.edu',701);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (109,'000-98-1232','7870',TO_DATE('2017-11-01','YYYY-MM-DD'),'Albert ','Gilbert','mgbernahu@mum.edu',801);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (110,'000-98-1233','7623',TO_DATE('2017-11-01','YYYY-MM-DD'),'Alex ','Morgan','amorgan@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (111,'000-98-1241','6047',TO_DATE('2017-02-01','YYYY-MM-DD'),'Alexi ','Davis','adavis@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (112,'000-98-1242','6724',TO_DATE('2017-02-01','YYYY-MM-DD'),'David ','Cameron','dcameron@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (113,'000-98-1243','7649',TO_DATE('2018-08-01','YYYY-MM-DD'),'Teresa ','May','tmay@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (114,'000-98-1244','7664',TO_DATE('2018-08-01','YYYY-MM-DD'),'Alijandro ','Valverde','avalverde@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (115,'000-98-1245','7532',TO_DATE('2018-11-01','YYYY-MM-DD'),'Alberto ','Contador','msfdgbernahu@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (116,'000-98-1246','7763',TO_DATE('2018-11-01','YYYY-MM-DD'),'Chris ','Frum','mberngfdfahu@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (117,'000-98-1247','7409',TO_DATE('2018-11-01','YYYY-MM-DD'),'Nairo ','Quintana','nquintana@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (118,'000-98-1248','7862',TO_DATE('2018-02-01','YYYY-MM-DD'),'James  ','Rodrigo','jrodrigo@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (119,'000-98-1249','7946',TO_DATE('2018-02-01','YYYY-MM-DD'),'Michael','Owen','mown@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (120,'000-98-1250','7433',TO_DATE('2018-02-01','YYYY-MM-DD'),'Leonel ','Messi','lmessi@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (121,'000-98-1251','7722',TO_DATE('2018-04-01','YYYY-MM-DD'),'Neymar ','Dasilva','ndasilva@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (122,'000-98-1252','7375',TO_DATE('2018-04-01','YYYY-MM-DD'),'Jon ','Jones','jjones@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (123,'000-98-1253','7359',TO_DATE('2018-04-01','YYYY-MM-DD'),'Anthony ','Joshua ','aj@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (124,'000-98-1254','7441',TO_DATE('2019-02-01','YYYY-MM-DD'),'Jonah ','Hill','jhill@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (125,'000-98-1255','7490',TO_DATE('2019-02-01','YYYY-MM-DD'),'Jenifer ','Lopez','jlo@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (126,'000-98-1256','7474',TO_DATE('2019-02-01','YYYY-MM-DD'),'Lindsey ','Lohan','llohan@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (127,'000-98-1257','7334',TO_DATE('2019-02-01','YYYY-MM-DD'),'Manuel ','Nuer','mnuer@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (128,'000-98-1258','7342',TO_DATE('2019-04-01','YYYY-MM-DD'),'Ariana ','Grande','agrande@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (129,'000-98-1259','7672',TO_DATE('2016-11-01','YYYY-MM-DD'),'Kyle ','Walker','kwalker@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (130,'000-98-1260','7383',TO_DATE('2016-08-01','YYYY-MM-DD'),'Kevin ','Harts','kharts@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (131,'000-98-1261','5981',TO_DATE('2016-02-01','YYYY-MM-DD'),'Ronaldinho ','Gucho','rgucho@mum.edu',null);
INSERT INTO STUDENT(id,student_id,bar_code,entry,first_name,last_name,email,phone_id) VALUES (132,'000-98-1262','8001',TO_DATE('2016-04-01','YYYY-MM-DD'),'Marta','Jonah ','mjonah@mum.edu',null);


INSERT INTO FACULTY(id,first_name,last_name,email) VALUES(101,'Rixuan','Xing','rxing@mum.edu');
INSERT INTO FACULTY(id,first_name,last_name,email) VALUES(102,'Asaad','Saad','asaad@mum.edu');
INSERT INTO FACULTY(id,first_name,last_name,email) VALUES(103,'Paul','Corraza','cruby@mum.edu');
INSERT INTO FACULTY(id,first_name,last_name,email) VALUES(104,'Bruce','Lester','blester@mum.edu');
INSERT INTO FACULTY(id,first_name,last_name,email) VALUES(105,'Renuka','Mohanraj','rmohanraj@mum.edu');
INSERT INTO FACULTY(id,first_name,last_name,email) VALUES(106,'Joe','Bruen','jbruen@mum.edu');


INSERT INTO COURSE(id,name,course_id,short_name,description) VALUES (101,'Web Application Architecture','CS-545','WAA','Spring MVC framework');
INSERT INTO COURSE(id,name,course_id,short_name,description) VALUES (102,'Modern Web Application','CS-572','MWA',' Nodejs and Angular Framework');
INSERT INTO COURSE(id,name,course_id,short_name,description) VALUES (103,'Web Application Programing','CS-472','WAP','HTML CSS JavaScript');
INSERT INTO COURSE(id,name,course_id,short_name,description) VALUES (104,'Modern Programming Practice','CS-443','MPP','Java 8 ');
INSERT INTO COURSE(id,name,course_id,short_name,description) VALUES (105,'Fundametal programming practice','CS-390','FPP','Introduction to Java');

INSERT INTO ROLE(role_id,role) VALUES (101,'ADMIN');
INSERT INTO ROLE(role_id,role) VALUES (102,'STUDENT');
INSERT INTO ROLE(role_id,role) VALUES (103,'FACULTY');
INSERT INTO USER (user_id,email,password,active) VALUES (101,'rxing@mum.edu','$2a$10$kxrclT1555lm3mt0hgY0SODvWs2cEioC1pz9ZHvTl9nVJfTvzrXc6',1);
INSERT INTO USER (user_id,email,password,active) VALUES (102,'tmelake@mum.edu','$2a$10$kxrclT1555lm3mt0hgY0SODvWs2cEioC1pz9ZHvTl9nVJfTvzrXc6',1);
INSERT INTO USER (user_id,email,password,active) VALUES (103,'blester@mum.edu','$2a$10$kxrclT1555lm3mt0hgY0SODvWs2cEioC1pz9ZHvTl9nVJfTvzrXc6',1);
INSERT INTO USER (user_id,email,password,active) VALUES (104,'asaad@mum.edu','$2a$10$kxrclT1555lm3mt0hgY0SODvWs2cEioC1pz9ZHvTl9nVJfTvzrXc6',1);
INSERt INTO USER_ROLE(user_id,role_id) VALUES (101,101);
INSERt INTO USER_ROLE(user_id,role_id) VALUES (102,102);
INSERt INTO USER_ROLE(user_id,role_id) VALUES (103,103);
INSERt INTO USER_ROLE(user_id,role_id) VALUES (104,103);


INSERT INTO SECTION (id,professor,course,Block) VALUES (101,101,102,101);
INSERT INTO SECTION (id,professor,course,Block) VALUES (102,102,101,101);
INSERT INTO SECTION (id,professor,course,Block) VALUES (103,104,103,101);
INSERT INTO SECTION (id,professor,course,Block) VALUES (104,105,104,101);
INSERT INTO SECTION (id,professor,course,Block) VALUES (105,103,105,101);


INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (101,101);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (101,102);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (101,103);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (101,104);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (101,105);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (101,106);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (102,107);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (102,108);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (102,109);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (102,110);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (102,111);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (103,112);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (103,113);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (103,114);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (103,115);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (103,116);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (103,117);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (104,118);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (104,119);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (104,120);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (104,121);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (104,122);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (105,123);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (105,124);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (105,125);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (105,126);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (105,127);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (105,128);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (104,129);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (103,130);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (102,131);
INSERT INTO STUDENT_IN_SECTION (section_id,students_id) VALUES (101,132);




