// categoriaModel.js

import mysql from "mysql2/promise";
import config from "../config";

const createCategoriaTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        // Verificar si la tabla 'categoria' existe
        const [rowsCategoria, fieldsCategoria] = await dbConnection.execute(`SHOW TABLES LIKE 'categoria'`);

        if (rowsCategoria.length === 0) {
            // Crear la tabla categoria si no existe
            await dbConnection.execute(`
                CREATE TABLE categoria (
                    id_categoria INT PRIMARY KEY,          -- Clave primaria
                    nombre VARCHAR(100) NOT NULL,          -- Nombre de la categoría
                    descripcion TEXT,                      -- Descripción de la categoría
                    estado VARCHAR(20) NOT NULL            -- Estado de la categoría
                );
            `);
            console.log(`Tabla 'categoria' creada exitosamente.`);
            
            // Insertar datos en la tabla categoria
            await dbConnection.execute(`
                INSERT INTO categoria (id_categoria, nombre, descripcion, estado) VALUES
                (1, 'Audífonos', 'Audífonos inalámbricos de última tecnología', 'Activo'),
                (2, 'Teclado', 'Teclado mecánico para gamers', 'Activo'),
                (3, 'Mouse', 'Mouse ergonómico para oficina', 'Activo'),
                (4, 'Monitor', 'Monitor 4K de alta resolución', 'Activo'),
                (5, 'Cargador', 'Cargador rápido para smartphones', 'Activo'),
                (6, 'Batería', 'Batería externa de 10,000mAh', 'Activo');
                `);
            console.log(`Datos insertados en la tabla 'categoria'.`);
        } else {
            console.log(`La tabla 'categoria' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla categoria:', error.message);
        throw error;
    }
};

export default createCategoriaTableAndData;