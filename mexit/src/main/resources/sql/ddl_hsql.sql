alter table EMPLOYEE drop constraint FK75C8D6AEA791D268;
drop table COMPANY if exists;
drop table EMPLOYEE if exists;

create table COMPANY (companyId integer not null, address varchar(255), city varchar(255), industry varchar(255), name varchar(255), state varchar(255), zip varchar(255), primary key (companyId));
create table EMPLOYEE (employeeId integer not null, email varchar(255), firstName varchar(255), lastName varchar(255), phone varchar(255), title varchar(255), company_companyId integer, primary key (employeeId));
alter table EMPLOYEE add constraint FK75C8D6AEA791D268 foreign key (company_companyId) references COMPANY;
