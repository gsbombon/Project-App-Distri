/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     30/05/2022 1:02:09                           */
/*==============================================================*/


drop table if exists ARTICULO;

drop table if exists CABECERA_COMPROBANTE_INVENTARIO;

drop table if exists CABECERA_FACTURA;

drop table if exists CABECERA_FACTURACION_CUENTAXCOBRAR;

drop table if exists CIUDAD;

drop table if exists CLIENTE;

drop table if exists COBRADOR;

drop table if exists DETALLE_COMPROBANTE_FACTURA;

drop table if exists DETALLE_COMPROBANTE_INVENTARIO;

drop table if exists DETALLE_PAGOS_CUENTASXCOBRAR;

drop table if exists FORMAPAGO;

drop table if exists TIPOMOVIMIENTO;

/*==============================================================*/
/* Table: ARTICULO                                              */
/*==============================================================*/
create table ARTICULO
(
   CODIGO_ART           int not null,
   NOMBRE_ART           varchar(128),
   PRECIO_ART           varchar(8),
   primary key (CODIGO_ART)
);

/*==============================================================*/
/* Table: CABECERA_COMPROBANTE_INVENTARIO                       */
/*==============================================================*/
create table CABECERA_COMPROBANTE_INVENTARIO
(
   NUMERO_CABECERA_INVEN int not null,
   FECHA_CABECERA_INVEN date,
   primary key (NUMERO_CABECERA_INVEN)
);

/*==============================================================*/
/* Table: CABECERA_FACTURA                                      */
/*==============================================================*/
create table CABECERA_FACTURA
(
   NUMERO_CABECERA_FACTU int not null,
   CODIGO_CLI           int not null,
   FECHA_CABECERA_FACTU date,
   primary key (NUMERO_CABECERA_FACTU)
);

/*==============================================================*/
/* Table: CABECERA_FACTURACION_CUENTAXCOBRAR                    */
/*==============================================================*/
create table CABECERA_FACTURACION_CUENTAXCOBRAR
(
   NUMERO_CABECERA_FACT_CXC int not null,
   CODIGO_CLI           int,
   CODIGO_COB           int not null,
   FECHA_CABECERA_FACT_CXC date,
   VALOR_CABECERA_FACT_CXC varchar(16),
   primary key (NUMERO_CABECERA_FACT_CXC)
);

/*==============================================================*/
/* Table: CIUDAD                                                */
/*==============================================================*/
create table CIUDAD
(
   CODIGO_CIU           int not null,
   NOMBRE_CIU           varchar(128),
   primary key (CODIGO_CIU)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   CODIGO_CLI           int not null,
   CODIGO_CIU           int not null,
   RUC_CLI              varchar(13),
   NOM_CLI              varchar(128),
   DIR_CLI              varchar(1258),
   primary key (CODIGO_CLI)
);

/*==============================================================*/
/* Table: COBRADOR                                              */
/*==============================================================*/
create table COBRADOR
(
   CODIGO_COB           int not null,
   NOM_COB              varchar(128),
   DIR_COB              varchar(128),
   primary key (CODIGO_COB)
);

/*==============================================================*/
/* Table: DETALLE_COMPROBANTE_FACTURA                           */
/*==============================================================*/
create table DETALLE_COMPROBANTE_FACTURA
(
   CODIGO_ART           int not null,
   NUMERO_CABECERA_FACTU int not null,
   CODIGO_DETALLE_COMPROBANTE_FACTURA int not null,
   CANTIDAD_DETALLE_COMPROBANTE_FACTURA varchar(16),
   PRECIO__DETALLE_COMPROBANTE_FACTURA varchar(16),
   primary key (CODIGO_ART, NUMERO_CABECERA_FACTU, CODIGO_DETALLE_COMPROBANTE_FACTURA)
);

/*==============================================================*/
/* Table: DETALLE_COMPROBANTE_INVENTARIO                        */
/*==============================================================*/
create table DETALLE_COMPROBANTE_INVENTARIO
(
   CODIGO_ART           int not null,
   NUMERO_CABECERA_INVEN int not null,
   CODIGO_DETALLE_COMPROBANTE_INVENTARIO int not null,
   CANTIDAD_DETALLE_COMPROBANTE_INVENTARIO varchar(16),
   PRECIO_DETALLE_COMPROBANTE_INVENTARIO varchar(16),
   primary key (CODIGO_ART, NUMERO_CABECERA_INVEN, CODIGO_DETALLE_COMPROBANTE_INVENTARIO)
);

/*==============================================================*/
/* Table: DETALLE_PAGOS_CUENTASXCOBRAR                          */
/*==============================================================*/
create table DETALLE_PAGOS_CUENTASXCOBRAR
(
   CODIGO_FP            int not null,
   NUMERO_CABECERA_FACT_CXC int not null,
   FECHA_DETALLE_PAGOS_CUENTASXCOBRAR int not null,
   VALOR_DETALLE_PAGOS_CUENTASXCOBRAR varchar(16),
   primary key (CODIGO_FP, NUMERO_CABECERA_FACT_CXC, FECHA_DETALLE_PAGOS_CUENTASXCOBRAR)
);

/*==============================================================*/
/* Table: FORMAPAGO                                             */
/*==============================================================*/
create table FORMAPAGO
(
   CODIGO_FP            int not null,
   NOM_FP               varchar(128),
   primary key (CODIGO_FP)
);

/*==============================================================*/
/* Table: TIPOMOVIMIENTO                                        */
/*==============================================================*/
create table TIPOMOVIMIENTO
(
   CODIGO_TMOV          int not null,
   NUMERO_CABECERA_INVEN int not null,
   NOMBRE_TMOV          varchar(128),
   SIGNO_TMOV           varchar(128),
   primary key (CODIGO_TMOV)
);

alter table CABECERA_FACTURA add constraint FK_TIENE foreign key (CODIGO_CLI)
      references CLIENTE (CODIGO_CLI) on delete restrict on update restrict;

alter table CABECERA_FACTURACION_CUENTAXCOBRAR add constraint FK_CABECERAFACTURA_COBRADOR foreign key (CODIGO_COB)
      references COBRADOR (CODIGO_COB) on delete restrict on update restrict;

alter table CABECERA_FACTURACION_CUENTAXCOBRAR add constraint FK_PAGA foreign key (CODIGO_CLI)
      references CLIENTE (CODIGO_CLI) on delete restrict on update restrict;

alter table CLIENTE add constraint FK_CIUDAD_CLIENTE foreign key (CODIGO_CIU)
      references CIUDAD (CODIGO_CIU) on delete restrict on update restrict;

alter table DETALLE_COMPROBANTE_FACTURA add constraint FK_DETALLE_COMPROBANTE_FACTURA foreign key (CODIGO_ART)
      references ARTICULO (CODIGO_ART) on delete restrict on update restrict;

alter table DETALLE_COMPROBANTE_FACTURA add constraint FK_DETALLE_COMPROBANTE_FACTURA2 foreign key (NUMERO_CABECERA_FACTU)
      references CABECERA_FACTURA (NUMERO_CABECERA_FACTU) on delete restrict on update restrict;

alter table DETALLE_COMPROBANTE_INVENTARIO add constraint FK_DETALLE_COMPROBANTE_INVENTARIO foreign key (CODIGO_ART)
      references ARTICULO (CODIGO_ART) on delete restrict on update restrict;

alter table DETALLE_COMPROBANTE_INVENTARIO add constraint FK_DETALLE_COMPROBANTE_INVENTARIO2 foreign key (NUMERO_CABECERA_INVEN)
      references CABECERA_COMPROBANTE_INVENTARIO (NUMERO_CABECERA_INVEN) on delete restrict on update restrict;

alter table DETALLE_PAGOS_CUENTASXCOBRAR add constraint FK_DETALLE_PAGOS_CUENTASXCOBRAR foreign key (CODIGO_FP)
      references FORMAPAGO (CODIGO_FP) on delete restrict on update restrict;

alter table DETALLE_PAGOS_CUENTASXCOBRAR add constraint FK_DETALLE_PAGOS_CUENTASXCOBRAR2 foreign key (NUMERO_CABECERA_FACT_CXC)
      references CABECERA_FACTURACION_CUENTAXCOBRAR (NUMERO_CABECERA_FACT_CXC) on delete restrict on update restrict;

alter table TIPOMOVIMIENTO add constraint FK_CABCERAINVENTARIO_TIPOMOVIMINETO foreign key (NUMERO_CABECERA_INVEN)
      references CABECERA_COMPROBANTE_INVENTARIO (NUMERO_CABECERA_INVEN) on delete restrict on update restrict;

