// ventaModel.js

import mysql from "mysql2/promise";
import config from "../config";

const createVentaTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        // Verificar si la tabla 'venta' existe
        const [rowsVenta, fieldsVenta] = await dbConnection.execute(`SHOW TABLES LIKE 'venta'`);

        if (rowsVenta.length === 0) {
            // Crear la tabla venta si no existe
            await dbConnection.execute(`
                CREATE TABLE venta (
                    id_venta INT PRIMARY KEY,               -- Clave primaria
                    fecha DATE NOT NULL,                    -- Fecha de la venta
                    id_producto INT,                        -- Clave foránea (relaciona con la tabla producto)
                    id_usuario INT,                         -- Clave foránea (relaciona con la tabla usuario)
                    FOREIGN KEY (id_producto) REFERENCES producto(id_producto) ON DELETE CASCADE,
                    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE 
                );
            `);
            console.log(`Tabla 'venta' creada exitosamente.`);
            
            // Insertar datos en la tabla venta
            await dbConnection.execute(`
                INSERT INTO venta (id_venta, fecha, id_producto, id_usuario) VALUES
                    (1, '2026-05-01', 1, 2),
                    (2, '2026-05-02', 2, 3),
                    (3, '2026-05-03', 3, 4),
                    (4, '2026-05-04', 4, 5),
                    (5, '2026-05-05', 5, 6),
                    (6, '2026-05-06', 6, 2);
            `);
            console.log(`Datos insertados en la tabla 'venta'.`);
        } else {
            console.log(`La tabla 'venta' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla venta:', error.message);
        throw error;
    }
};

export default createVentaTableAndData;