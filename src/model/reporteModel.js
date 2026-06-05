// reporteModel.js

import mysql from "mysql2/promise";
import config from "../config";

const createReporteTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        // Verificar si la tabla 'reporte' existe
        const [rowsReporte, fieldsReporte] = await dbConnection.execute(`SHOW TABLES LIKE 'reporte'`);

        if (rowsReporte.length === 0) {
            // Crear la tabla reporte si no existe
            await dbConnection.execute(`
                CREATE TABLE reporte (
                    id_reporte INT PRIMARY KEY,             -- Clave primaria
                    fecha DATE NOT NULL,                    -- Fecha del reporte
                    cantidad INT,                           -- Cantidad de productos reportados
                    id_comprobante INT,                     -- Clave foránea (relaciona con la tabla comprobante)
                    id_usuario INT,                         -- Clave foránea (relaciona con la tabla usuario)
                    id_producto INT,                        -- Clave foránea (relaciona con la tabla producto)
                    id_categoria INT,                       -- Clave foránea (relaciona con la tabla categoria)
                    FOREIGN KEY (id_comprobante) REFERENCES comprobante(id_comprobante) ON DELETE CASCADE ,
                    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ,
                    FOREIGN KEY (id_producto) REFERENCES producto(id_producto) ON DELETE CASCADE ,
                    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria) ON DELETE CASCADE 
                );
            `);
            console.log(`Tabla 'reporte' creada exitosamente.`);
            
            // Insertar datos en la tabla reporte
            await dbConnection.execute(`
                INSERT INTO reporte (id_reporte, fecha, cantidad, id_comprobante, id_usuario, id_producto, id_categoria) VALUES
                    (1, '2026-05-01', 1, 1, 2, 1, 1),
                    (2, '2026-05-02', 2, 2, 3, 2, 2),
                    (3, '2026-05-03', 3, 3, 4, 3, 3),
                    (4, '2026-05-04', 1, 4, 5, 4, 4),
                    (5, '2026-05-05', 4, 5, 6, 5, 5),
                    (6, '2026-05-06', 2, 6, 2, 6, 6);
            `);
            console.log(`Datos insertados en la tabla 'reporte'.`);
        } else {
            console.log(`La tabla 'reporte' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla reporte:', error.message);
        throw error;
    }
};

export default createReporteTableAndData;