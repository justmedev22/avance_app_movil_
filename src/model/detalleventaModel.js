// detalleVentaModel.js

import mysql from "mysql2/promise";
import config from "../config";

const createDetalleVentaTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        // Verificar si la tabla 'detalleVenta' existe
        const [rowsDetalleVenta, fieldsDetalleVenta] = await dbConnection.execute(`SHOW TABLES LIKE 'detalleVenta'`);

        if (rowsDetalleVenta.length === 0) {
            // Crear la tabla detalleVenta si no existe
            await dbConnection.execute(`
                CREATE TABLE detalleVenta (
                    id_detalleventa INT PRIMARY KEY,         -- Clave primaria
                    fecha DATE NOT NULL,                     -- Fecha del detalle de la venta
                    id_producto INT,                         -- Clave foránea (relaciona con la tabla producto)
                    id_usuario INT,                          -- Clave foránea (relaciona con la tabla usuario)
                    cantidad INT NOT NULL,                   -- Cantidad de producto vendido
                    total DECIMAL(10, 2),                    -- Total de la venta
                    FOREIGN KEY (id_producto) REFERENCES producto(id_producto) ON DELETE CASCADE,
                    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE
                );
            `);
            console.log(`Tabla 'detalleVenta' creada exitosamente.`);
            
            // Insertar datos en la tabla detalleVenta
            await dbConnection.execute(`
                INSERT INTO detalleVenta (id_detalleventa, fecha, id_producto, id_usuario, cantidad, total) VALUES
                    (1, '2026-05-01', 1, 2, 1, 120.00),
                    (2, '2026-05-02', 2, 3, 2, 160.00),
                    (3, '2026-05-03', 3, 4, 3, 75.00),
                    (4, '2026-05-04', 4, 5, 1, 350.00),
                    (5, '2026-05-05', 5, 6, 4, 60.00),
                    (6, '2026-05-06', 6, 2, 2, 60.00);
            `);
            console.log(`Datos insertados en la tabla 'detalleVenta'.`);
        } else {
            console.log(`La tabla 'detalleVenta' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla detalleVenta:', error.message);
        throw error;
    }
};

export default createDetalleVentaTableAndData;