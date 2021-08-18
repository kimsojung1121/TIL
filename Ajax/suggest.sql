create table suggest(word varchar(50) primary key,
  url varchar2(100));
  
insert into suggest values('AJAX','http://www.itwill.xyz/');
insert into suggest values('AJAX ����','http://www.itwill.xyz/');
insert into suggest values('AJAX ���α׷���','http://www.itwill.xyz/');
insert into suggest values('AJA','http://www.itwill.xyz/');
insert into suggest values('�ڹ�','https://www.oracle.com/');
insert into suggest values('�ڹٱ���','http://www.itwill.xyz/');
insert into suggest values('���尡','http://www.itwill.xyz/');
insert into suggest values('����','http://www.itwill.xyz/');
insert into suggest values('Spring','https://spring.io/');
insert into suggest values('Spring Framework','https://spring.io/');
insert into suggest values('Servlet','https://www.servlets.com/');
insert into suggest values('���̹�','https://www.naver.com/');
insert into suggest values('����','https://www.daum.net/');
insert into suggest values('����','https://www.google.com/');
commit;
select * from suggest;

select rownum,temp.* from (select * from suggest where upper(word) like '%'||upper('')||'%' 
    order by word) temp where rownum<=10;










