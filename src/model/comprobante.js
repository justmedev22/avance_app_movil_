// comprobanteModel.js

import mysql from "mysql2/promise";
import config from "../config";

const createComprobanteTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        // Verificar si la tabla 'comprobante' existe
        const [rowsComprobante, fieldsComprobante] = await dbConnection.execute(`SHOW TABLES LIKE 'comprobante'`);

        if (rowsComprobante.length === 0) {
            // Crear la tabla comprobante si no existe
            await dbConnection.execute(`
               CREATE TABLE comprobante (
                    id_comprobante INT PRIMARY KEY,         -- Clave primaria
                    fecha DATE NOT NULL,                    -- Fecha del comprobante
                    id_venta INT,                           -- Clave foránea (relaciona con la tabla venta)
                    tipo_de_comprobante VARCHAR(50),        -- Tipo de comprobante (Factura, Boleta, etc.)
                    id_producto INT,                        -- Clave foránea (relaciona con la tabla producto)
                    id_categoria INT,                       -- Clave foránea (relaciona con la tabla categoria)
                    id_usuario INT,                         -- Clave foránea (relaciona con la tabla usuario)
                    id_detalleventa INT,                    -- Clave foránea (relaciona con la tabla detalleventa)
                    FOREIGN KEY (id_venta) REFERENCES venta(id_venta) ON DELETE CASCADE,
                    FOREIGN KEY (id_producto) REFERENCES producto(id_producto) ON DELETE CASCADE ,
                    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria) ON DELETE CASCADE ,
                    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ,
                    FOREIGN KEY (id_detalleventa) REFERENCES detalleVenta(id_detalleventa) ON DELETE CASCADE 
                );
            `);
            console.log(`Tabla 'comprobante' creada exitosamente.`);
            
            // Insertar datos en la tabla comprobante
            await dbConnection.execute(`
                INSERT INTO comprobante (id_comprobante, fecha, id_venta, tipo_de_comprobante, id_producto, id_categoria, id_usuario, id_detalleventa) VALUES
                    (1, '2026-05-01', 1, 'Factura', 1, 1, 2, 1),
                    (2, '2026-05-02', 2, 'Boleta', 2, 2, 3, 2),
                    (3, '2026-05-03', 3, 'Factura', 3, 3, 4, 3),
                    (4, '2026-05-04', 4, 'Boleta', 4, 4, 5, 4),
                    (5, '2026-05-05', 5, 'Factura', 5, 5, 6, 5),
                    (6, '2026-05-06', 6, 'Boleta', 6, 6, 2, 6);

            `);
            console.log(`Datos insertados en la tabla 'comprobante'.`);
        } else {
            console.log(`La tabla 'comprobante' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla comprobante:', error.message);
        throw error;
    }
};

export default createComprobanteTableAndData;