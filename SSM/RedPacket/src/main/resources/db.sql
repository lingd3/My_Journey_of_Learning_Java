/*==============================================================*/
/* Table: �����                                        */
/*==============================================================*/
create table T_RED_PACKET (
  id                   int(12)                        not null auto_increment COMMENT '������',
  user_id              int(12)                        not null COMMENT '��������û�id',
  amount               decimal(16,2)                  not null COMMENT '������',
  send_date            timestamp                      not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '���������',
  total                int(12)                        not null COMMENT '�������', 
  unit_amount          decimal(12)                    not null COMMENT '��������Ľ��',
  stock                int(12)                        not null COMMENT '���ʣ�����',
  version              int(12) default 0              not null COMMENT '�汾��Ϊ������չ�ã�',
  note                 varchar(256)                    null COMMENT '��ע',
  primary key clustered (id)
);

/*==============================================================*/
/* Table: �û��������                                                */
/*==============================================================*/
create table T_USER_RED_PACKET (
  id                   int(12)                        not null auto_increment COMMENT '�û������ĺ��id',
  red_packet_id        int(12)                        not null COMMENT '���id',
  user_id              int(12)                        not null COMMENT '������û���id',
  amount               decimal(16,2)                  not null  COMMENT '�����ĺ�����',
  grab_time            timestamp                      not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�����ʱ��',
  note                 varchar(256)                   null COMMENT '��ע',
   primary key clustered (id)
);

/**
* ����һ��20��Ԫ��2���С�����ÿ��10Ԫ�ĺ������
*/
insert into T_RED_PACKET(user_id, amount, send_date, total, unit_amount, stock, note)
values(1, 200000.00, now(), 20000, 10.00, 20000,'20��Ԫ��2���С�����ÿ��10Ԫ');
commit;