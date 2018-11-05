/*==============================================================*/
/* Table: 红包表                                        */
/*==============================================================*/
create table T_RED_PACKET (
  id                   int(12)                        not null auto_increment COMMENT '红包编号',
  user_id              int(12)                        not null COMMENT '发红包的用户id',
  amount               decimal(16,2)                  not null COMMENT '红包金额',
  send_date            timestamp                      not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发红包日期',
  total                int(12)                        not null COMMENT '红包总数', 
  unit_amount          decimal(12)                    not null COMMENT '单个红包的金额',
  stock                int(12)                        not null COMMENT '红包剩余个数',
  version              int(12) default 0              not null COMMENT '版本（为后续扩展用）',
  note                 varchar(256)                    null COMMENT '备注',
  primary key clustered (id)
);

/*==============================================================*/
/* Table: 用户抢红包表                                                */
/*==============================================================*/
create table T_USER_RED_PACKET (
  id                   int(12)                        not null auto_increment COMMENT '用户抢到的红包id',
  red_packet_id        int(12)                        not null COMMENT '红包id',
  user_id              int(12)                        not null COMMENT '抢红包用户的id',
  amount               decimal(16,2)                  not null  COMMENT '抢到的红包金额',
  grab_time            timestamp                      not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '抢红包时间',
  note                 varchar(256)                   null COMMENT '备注',
   primary key clustered (id)
);

/**
* 插入一个20万元金额，2万个小红包，每个10元的红包数据
*/
insert into T_RED_PACKET(user_id, amount, send_date, total, unit_amount, stock, note)
values(1, 200000.00, now(), 20000, 10.00, 20000,'20万元金额，2万个小红包，每个10元');
commit;