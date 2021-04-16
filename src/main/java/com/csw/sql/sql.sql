
drop table infos;
create table infos(
id int(99) primary key,
name VARCHAR(11),
age VARCHAR(11),
bir TIMESTAMP,
phone varchar(22),
qq varchar(22),
shengx VARCHAR(11),
xingz varchar(11),
beiz varchar(99),
tid int(11),
cid int(11),
xid int(11),
bid int(11)
);
select * from infos;



drop table clazz ;
create table clazz(
id int(11) auto_increment primary key not null,
name varchar(11),
tag varchar(99)
);
select * from clazz;



drop table xiaoz ;
create table xiaoz(
id int(11) auto_increment primary key not null,
name varchar(11),
nickname varchar(11),
tag varchar(99),
dd TIMESTAMP,
cid int(11)
);
select * from xiaoz;



drop table taglib ;
create table taglib(
id int(11) auto_increment primary key not null,
name varchar(11),
tag varchar(99),
dd TIMESTAMP
);
select * from taglib;

drop table tagz;
create table tagz(
id int(11) auto_increment primary key not null,
bid int(11),
iid int(11)
);

drop table city ;
create table city(
id int(11) auto_increment primary key not null,
name varchar(11),
dd TIMESTAMP
);
select * from city;

select i.id as iid,i.name as iname,i.age as iage,i.bir as ibir,i.phone as iphone
        ,i.qq as iqq,i.shengx as ishengx,i.xingz as ixingz,i.beiz as ibeiz,i.tid as itid
        ,i.cid as icid,i.bid as ibid,
        i.xid as ixid,
        x.name as xname,x.nickname as xnickname,x.id as xid,x.tag as xtag
        ,x.dd as xdd,
        c.id as cid,c.name as cname,c.tag as ctag
        from infos i,xiaoz x,clazz c,taglib b,tagz z,city t where x.id=i.xid and c.id=i.cid
        and i.bid=b.id and i.tid=t.id and z.iid=i.id and z.bid=b.id;

