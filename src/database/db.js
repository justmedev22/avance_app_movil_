import mysql from "mysql2/promise";
import config from "./../config";

import createRolTableAndData from "../model/rolModel";
import createUsuarioTableAndData from "../model/usuarioModel";
import createCategoriaTableAndData from "../model/categoriaModel";
import createProductoTableAndData from "../model/productoModel";
import createVentaTableAndData from "../model/ventaModel";
import createDetalleVentaTableAndData from "../model/detalleventaModel";
import createComprobanteTableAndData from "../model/comprobante";
import createReporteTableAndData from "../model/reporteModel";

const createDatabaseAndTableIfNotExists = async () => {
    try {        
        const connection = await mysql.createConnection({
            host: config.host,
            user: config.user,
            password: config.password
        });

        const databaseExists = await connection.execute(`SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = ?`, [config.database]);

        if (databaseExists[0].length === 0) {
            await connection.execute(`CREATE DATABASE ${config.database}`);
            console.log(`Base de datos '${config.database}' creada exitosamente.`);
        } else {
            console.log(`La base de datos '${config.database}' ya existe.`);
        }

        await connection.end();



        await createRolTableAndData();
        await createUsuarioTableAndData();
        await createCategoriaTableAndData();
        await createProductoTableAndData();
        await createVentaTableAndData();
        await createDetalleVentaTableAndData();
        await createComprobanteTableAndData();
        await createReporteTableAndData();
    

        
        
    } catch (error) {
        console.error('Error al crear o verificar la base de datos y la tabla:', error.message);
        throw error;
    }
};

createDatabaseAndTableIfNotExists();

