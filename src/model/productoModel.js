// productoModel.js

import mysql from "mysql2/promise";
import config from "../config";

const createProductoTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        // Verificar si la tabla 'producto' existe
        const [rowsProducto, fieldsProducto] = await dbConnection.execute(`SHOW TABLES LIKE 'producto'`);

        if (rowsProducto.length === 0) {
            // Crear la tabla producto si no existe
            await dbConnection.execute(`
                CREATE TABLE producto (
                    id_producto INT PRIMARY KEY,            -- Clave primaria
                    nombre VARCHAR(100) NOT NULL,           -- Nombre del producto
                    descripcion TEXT,                       -- Descripción del producto
                    precio_min DECIMAL(10, 2),              -- Precio mínimo
                    precio_max DECIMAL(10, 2),              -- Precio máximo
                    estado VARCHAR(20) NOT NULL,            -- Estado del producto
                    stock INT,                              -- Stock disponible
                    imagen VARCHAR(255),                    -- Imagen del producto
                    id_categoria INT,                       -- Clave foránea (relaciona con la tabla categoria)
                    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria) ON DELETE CASCADE 
                );

            `);
            console.log(`Tabla 'producto' creada exitosamente.`);
            
            // Insertar datos en la tabla producto
            await dbConnection.execute(`
                INSERT INTO producto (id_producto, nombre, descripcion, precio_min, precio_max, estado, stock, imagen, id_categoria) VALUES
                    (1, 'Audífono X', 'Audífono inalámbrico con cancelación de ruido', 120.00, 150.00, 'Disponible', 50, 'audifono_x.jpg', 1),
                    (2, 'Teclado Pro', 'Teclado mecánico con retroiluminación RGB', 80.00, 100.00, 'Disponible', 30, 'teclado_pro.jpg', 2),
                    (3, 'Mouse Z', 'Mouse ergonómico con 5 botones programables', 25.00, 35.00, 'Disponible', 100, 'mouse_z.jpg', 3),
                    (4, 'Monitor Ultra', 'Monitor de 27 pulgadas 4K', 350.00, 400.00, 'Disponible', 20, 'monitor_ultra.jpg', 4),
                    (5, 'Cargador Rápido', 'Cargador para dispositivos USB-C', 15.00, 20.00, 'Disponible', 200, 'cargador_rapido.jpg', 5),
                    (6, 'Batería Power', 'Batería externa de 10000mAh', 30.00, 40.00, 'Disponible', 75, 'bateria_power.jpg', 6);
            `);
            console.log(`Datos insertados en la tabla 'producto'.`);
        } else {
            console.log(`La tabla 'producto' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla producto:', error.message);
        throw error;
    }
};

export default createProductoTableAndData;