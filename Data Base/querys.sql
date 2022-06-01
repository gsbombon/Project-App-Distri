SELECT * FROM lgh.usuarios;

/* CARGAR CABECERA DE FACTURA POR RUC E ID  */
SELECT NUMERO_CABECERA_FACTU,FECHA_CABECERA_FACTU,NOMBRE_CIU
FROM cabecera_factura cf,cliente c,ciudad ciu
WHERE c.CODIGO_CLI = cf.CODIGO_CLI AND c.CODIGO_CIU = ciu.CODIGO_CIU AND c.RUC_CLI = ? AND NUMERO_CABECERA_FACTU=?;


/* Detalle de factura por cliente buscado por su RUC */
SELECT a.NOMBRE_ART, df.CANTIDAD_DETALLE_COMPROBANTE_FACTURA, df.PRECIO__DETALLE_COMPROBANTE_FACTURA,(df.CANTIDAD_DETALLE_COMPROBANTE_FACTURA * df.PRECIO__DETALLE_COMPROBANTE_FACTURA)  AS MULTI
FROM detalle_comprobante_factura df,articulo a,cliente c,cabecera_factura cf
WHERE df.NUMERO_CABECERA_FACTU = cf.NUMERO_CABECERA_FACTU AND df.CODIGO_ART = a.CODIGO_ART AND cf.CODIGO_CLI = c.CODIGO_CLI AND c.RUC_CLI=?  AND cf.NUMERO_CABECERA_FACTU = ?;

/* Buscar facturas de un cliente  */
SELECT NUMERO_CABECERA_FACTU, FECHA_CABECERA_FACTU
FROM cabecera_factura cf, cliente c 
WHERE cf.codigo_cli = c.codigo_cli AND c.RUC_CLI=?;

/** OBTENEMOS CODIGO DETALLE FACTURA */

SELECT CODIGO_DETALLE_COMPROBANTE_FACTURA
FROM detalle_comprobante_factura df,cliente c,cabecera_factura cf
WHERE  df.NUMERO_CABECERA_FACTU = cf.NUMERO_CABECERA_FACTU AND c.CODIGO_CLI = cf.CODIGO_CLI AND c.RUC_CLI = ? AND df.NUMERO_CABECERA_FACTU=?
LIMIT 1;


/* ELIMINAR ARTICULO DE LA FACTURA */
DELETE FROM detalle_comprobante_factura WHERE CODIGO_ART=? AND NUMERO_CABECERA_FACTU = ? AND CODIGO_DETALLE_COMPROBANTE_FACTURA = ?;

/* ACTUALIZAR CANTIDAD DE ART EN FACTURA */
UPDATE detalle_comprobante_factura
SET CANTIDAD_DETALLE_COMPROBANTE_FACTURA = ?
WHERE CODIGO_ART = ? AND NUMERO_CABECERA_FACTU = ? AND CODIGO_DETALLE_COMPROBANTE_FACTURA = ?;
