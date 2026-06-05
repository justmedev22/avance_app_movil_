// usuarioModel.js

import mysql from "mysql2/promise";
import config from "../config";

const createUsuarioTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        // Verificar si la tabla 'usuario' existe
        const [rowsUsuario, fieldsUsuario] = await dbConnection.execute(`SHOW TABLES LIKE 'usuario'`);

        if (rowsUsuario.length === 0) {
            // Crear la tabla usuario si no existe
            await dbConnection.execute(`
                CREATE TABLE usuario (
                    id_usuario    INT PRIMARY KEY,            -- Clave primaria
                    user     VARCHAR(50) NOT NULL,           -- Nombre de usuario
                    pass         VARCHAR(255) NOT NULL,      -- Contraseña del usuario
                    nombre VARCHAR(100) NOT NULL,           -- Nombre del usuario
                    apellido VARCHAR(100) NOT NULL,        -- Apellido del usuario
                    correo VARCHAR(100) NOT NULL,          -- Correo electrónico
                    telefono VARCHAR(20),                  -- Teléfono
                    distrito VARCHAR(100),                 -- Distrito
                    imagen VARCHAR(255),                   -- Imagen del usuario
                    id_rol INT,                            -- Clave foránea (relaciona con la tabla rol)
                    FOREIGN KEY (id_rol) REFERENCES rol(id_rol) ON DELETE CASCADE
                );
            `);
            console.log(`Tabla 'usuario' creada exitosamente.`);
            
            // Insertar datos en la tabla usuario
            await dbConnection.execute(`
                INSERT INTO usuario (id_usuario, user, pass, nombre, apellido, correo, telefono, distrito, imagen, id_rol) VALUES
                    (1, 'adminuser', 'adminpass', 'Admin', 'User', 'admin@tech.com', '123456789', 'Lima', 'imagen_admin.jpg', 1),
                    (2, 'clientuser1', 'clientpass1', 'Client', 'User1', 'client1@tech.com', '987654321', 'Cusco', 'imagen_client1.jpg', 2),
                    (3, 'clientuser2', 'clientpass2', 'Client', 'User2', 'client2@tech.com', '987654322', 'Arequipa', 'imagen_client2.jpg', 2),
                    (4, 'clientuser3', 'clientpass3', 'Client', 'User3', 'client3@tech.com', '987654323', 'Puno', 'imagen_client3.jpg', 2),
                    (5, 'clientuser4', 'clientpass4', 'Client', 'User4', 'client4@tech.com', '987654324', 'Tacna', 'imagen_client4.jpg', 2),
                    (6, 'clientuser5', 'clientpass5', 'Client', 'User5', 'client5@tech.com', '987654325', 'Ica', 'imagen_client5.jpg', 2);
            `);
            console.log(`Datos insertados en la tabla 'usuario'.`);
        } else {
            console.log(`La tabla 'usuario' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla usuario:', error.message);
        throw error;
    }
};

export default createUsuarioTableAndData;