// rolModel.js

import mysql from "mysql2/promise";
import config from "../config";

const createRolTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        // Verificar si la tabla 'rol' existe
        const [rowsRol, fieldsRol] = await dbConnection.execute(`SHOW TABLES LIKE 'rol'`);

        if (rowsRol.length === 0) {
            // Crear la tabla rol si no existe
            await dbConnection.execute(`
                CREATE TABLE rol (
                    id_rol INT PRIMARY KEY,            -- Clave primaria
                    tipo_rol VARCHAR(50) NOT NULL       -- Tipo de rol (admin, usuario)
                );
            `);
            console.log(`Tabla 'rol' creada exitosamente.`);
            
            // Insertar datos en la tabla rol
            await dbConnection.execute(`
                INSERT INTO rol (id_rol, tipo_rol) VALUES
                    (1, 'admin'),
                    (2, 'cliente');
            `);
            console.log(`Datos insertados en la tabla 'rol'.`);
        } else {
            console.log(`La tabla 'rol' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla rol:', error.message);
        throw error;
    }
};

export default createRolTableAndData;