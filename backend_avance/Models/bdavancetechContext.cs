using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Pomelo.EntityFrameworkCore.MySql.Scaffolding.Internal;

namespace backend_avance.Models;

public partial class bdavancetechContext : DbContext
{
    public bdavancetechContext()
    {
    }

    public bdavancetechContext(DbContextOptions<bdavancetechContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Categorium> Categoria { get; set; }

    public virtual DbSet<Comprobante> Comprobantes { get; set; }

    public virtual DbSet<Detalleventum> Detalleventa { get; set; }

    public virtual DbSet<Producto> Productos { get; set; }

    public virtual DbSet<Reporte> Reportes { get; set; }

    public virtual DbSet<Rol> Rols { get; set; }

    public virtual DbSet<Usuario> Usuarios { get; set; }

    public virtual DbSet<Ventum> Venta { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySql("server=192.168.0.169;database=bd_avance_tech;user=jacob;password=1234", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.0.30-mysql"));

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder
            .UseCollation("utf8mb4_0900_ai_ci")
            .HasCharSet("utf8mb4");

        modelBuilder.Entity<Categorium>(entity =>
        {
            entity.HasKey(e => e.IdCategoria).HasName("PRIMARY");

            entity.ToTable("categoria");

            entity.Property(e => e.IdCategoria)
                .ValueGeneratedNever()
                .HasColumnName("id_categoria");
            entity.Property(e => e.Descripcion)
                .HasColumnType("text")
                .HasColumnName("descripcion");
            entity.Property(e => e.Estado)
                .HasMaxLength(20)
                .HasColumnName("estado");
            entity.Property(e => e.Nombre)
                .HasMaxLength(100)
                .HasColumnName("nombre");
        });

        modelBuilder.Entity<Comprobante>(entity =>
        {
            entity.HasKey(e => e.IdComprobante).HasName("PRIMARY");

            entity.ToTable("comprobante");

            entity.HasIndex(e => e.IdCategoria, "id_categoria");

            entity.HasIndex(e => e.IdDetalleventa, "id_detalleventa");

            entity.HasIndex(e => e.IdProducto, "id_producto");

            entity.HasIndex(e => e.IdUsuario, "id_usuario");

            entity.HasIndex(e => e.IdVenta, "id_venta");

            entity.Property(e => e.IdComprobante)
                .ValueGeneratedNever()
                .HasColumnName("id_comprobante");
            entity.Property(e => e.Fecha).HasColumnName("fecha");
            entity.Property(e => e.IdCategoria).HasColumnName("id_categoria");
            entity.Property(e => e.IdDetalleventa).HasColumnName("id_detalleventa");
            entity.Property(e => e.IdProducto).HasColumnName("id_producto");
            entity.Property(e => e.IdUsuario).HasColumnName("id_usuario");
            entity.Property(e => e.IdVenta).HasColumnName("id_venta");
            entity.Property(e => e.TipoDeComprobante)
                .HasMaxLength(50)
                .HasColumnName("tipo_de_comprobante");

            entity.HasOne(d => d.IdCategoriaNavigation).WithMany(p => p.Comprobantes)
                .HasForeignKey(d => d.IdCategoria)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("comprobante_ibfk_3");

            entity.HasOne(d => d.IdDetalleventaNavigation).WithMany(p => p.Comprobantes)
                .HasForeignKey(d => d.IdDetalleventa)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("comprobante_ibfk_5");

            entity.HasOne(d => d.IdProductoNavigation).WithMany(p => p.Comprobantes)
                .HasForeignKey(d => d.IdProducto)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("comprobante_ibfk_2");

            entity.HasOne(d => d.IdUsuarioNavigation).WithMany(p => p.Comprobantes)
                .HasForeignKey(d => d.IdUsuario)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("comprobante_ibfk_4");

            entity.HasOne(d => d.IdVentaNavigation).WithMany(p => p.Comprobantes)
                .HasForeignKey(d => d.IdVenta)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("comprobante_ibfk_1");
        });

        modelBuilder.Entity<Detalleventum>(entity =>
        {
            entity.HasKey(e => e.IdDetalleventa).HasName("PRIMARY");

            entity.ToTable("detalleventa");

            entity.HasIndex(e => e.IdProducto, "id_producto");

            entity.HasIndex(e => e.IdUsuario, "id_usuario");

            entity.Property(e => e.IdDetalleventa)
                .ValueGeneratedNever()
                .HasColumnName("id_detalleventa");
            entity.Property(e => e.Cantidad).HasColumnName("cantidad");
            entity.Property(e => e.Fecha).HasColumnName("fecha");
            entity.Property(e => e.IdProducto).HasColumnName("id_producto");
            entity.Property(e => e.IdUsuario).HasColumnName("id_usuario");
            entity.Property(e => e.Total)
                .HasPrecision(10, 2)
                .HasColumnName("total");

            entity.HasOne(d => d.IdProductoNavigation).WithMany(p => p.Detalleventa)
                .HasForeignKey(d => d.IdProducto)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("detalleventa_ibfk_1");

            entity.HasOne(d => d.IdUsuarioNavigation).WithMany(p => p.Detalleventa)
                .HasForeignKey(d => d.IdUsuario)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("detalleventa_ibfk_2");
        });

        modelBuilder.Entity<Producto>(entity =>
        {
            entity.HasKey(e => e.IdProducto).HasName("PRIMARY");

            entity.ToTable("producto");

            entity.HasIndex(e => e.IdCategoria, "id_categoria");

            entity.Property(e => e.IdProducto)
                .ValueGeneratedNever()
                .HasColumnName("id_producto");
            entity.Property(e => e.Descripcion)
                .HasColumnType("text")
                .HasColumnName("descripcion");
            entity.Property(e => e.Estado)
                .HasMaxLength(20)
                .HasColumnName("estado");
            entity.Property(e => e.IdCategoria).HasColumnName("id_categoria");
            entity.Property(e => e.Imagen)
                .HasMaxLength(255)
                .HasColumnName("imagen");
            entity.Property(e => e.Nombre)
                .HasMaxLength(100)
                .HasColumnName("nombre");
            entity.Property(e => e.PrecioMax)
                .HasPrecision(10, 2)
                .HasColumnName("precio_max");
            entity.Property(e => e.PrecioMin)
                .HasPrecision(10, 2)
                .HasColumnName("precio_min");
            entity.Property(e => e.Stock).HasColumnName("stock");

            entity.HasOne(d => d.IdCategoriaNavigation).WithMany(p => p.Productos)
                .HasForeignKey(d => d.IdCategoria)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("producto_ibfk_1");
        });

        modelBuilder.Entity<Reporte>(entity =>
        {
            entity.HasKey(e => e.IdReporte).HasName("PRIMARY");

            entity.ToTable("reporte");

            entity.HasIndex(e => e.IdCategoria, "id_categoria");

            entity.HasIndex(e => e.IdComprobante, "id_comprobante");

            entity.HasIndex(e => e.IdProducto, "id_producto");

            entity.HasIndex(e => e.IdUsuario, "id_usuario");

            entity.Property(e => e.IdReporte)
                .ValueGeneratedNever()
                .HasColumnName("id_reporte");
            entity.Property(e => e.Cantidad).HasColumnName("cantidad");
            entity.Property(e => e.Fecha).HasColumnName("fecha");
            entity.Property(e => e.IdCategoria).HasColumnName("id_categoria");
            entity.Property(e => e.IdComprobante).HasColumnName("id_comprobante");
            entity.Property(e => e.IdProducto).HasColumnName("id_producto");
            entity.Property(e => e.IdUsuario).HasColumnName("id_usuario");

            entity.HasOne(d => d.IdCategoriaNavigation).WithMany(p => p.Reportes)
                .HasForeignKey(d => d.IdCategoria)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("reporte_ibfk_4");

            entity.HasOne(d => d.IdComprobanteNavigation).WithMany(p => p.Reportes)
                .HasForeignKey(d => d.IdComprobante)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("reporte_ibfk_1");

            entity.HasOne(d => d.IdProductoNavigation).WithMany(p => p.Reportes)
                .HasForeignKey(d => d.IdProducto)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("reporte_ibfk_3");

            entity.HasOne(d => d.IdUsuarioNavigation).WithMany(p => p.Reportes)
                .HasForeignKey(d => d.IdUsuario)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("reporte_ibfk_2");
        });

        modelBuilder.Entity<Rol>(entity =>
        {
            entity.HasKey(e => e.IdRol).HasName("PRIMARY");

            entity.ToTable("rol");

            entity.Property(e => e.IdRol)
                .ValueGeneratedNever()
                .HasColumnName("id_rol");
            entity.Property(e => e.TipoRol)
                .HasMaxLength(50)
                .HasColumnName("tipo_rol");
        });

        modelBuilder.Entity<Usuario>(entity =>
        {
            entity.HasKey(e => e.IdUsuario).HasName("PRIMARY");

            entity.ToTable("usuario");

            entity.HasIndex(e => e.IdRol, "id_rol");

            entity.Property(e => e.IdUsuario)
                .ValueGeneratedNever()
                .HasColumnName("id_usuario");
            entity.Property(e => e.Apellido)
                .HasMaxLength(100)
                .HasColumnName("apellido");
            entity.Property(e => e.Correo)
                .HasMaxLength(100)
                .HasColumnName("correo");
            entity.Property(e => e.Distrito)
                .HasMaxLength(100)
                .HasColumnName("distrito");
            entity.Property(e => e.IdRol).HasColumnName("id_rol");
            entity.Property(e => e.Imagen)
                .HasMaxLength(255)
                .HasColumnName("imagen");
            entity.Property(e => e.Nombre)
                .HasMaxLength(100)
                .HasColumnName("nombre");
            entity.Property(e => e.Pass)
                .HasMaxLength(255)
                .HasColumnName("pass");
            entity.Property(e => e.Telefono)
                .HasMaxLength(20)
                .HasColumnName("telefono");
            entity.Property(e => e.User)
                .HasMaxLength(50)
                .HasColumnName("user");

            entity.HasOne(d => d.IdRolNavigation).WithMany(p => p.Usuarios)
                .HasForeignKey(d => d.IdRol)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("usuario_ibfk_1");
        });

        modelBuilder.Entity<Ventum>(entity =>
        {
            entity.HasKey(e => e.IdVenta).HasName("PRIMARY");

            entity.ToTable("venta");

            entity.HasIndex(e => e.IdProducto, "id_producto");

            entity.HasIndex(e => e.IdUsuario, "id_usuario");

            entity.Property(e => e.IdVenta)
                .ValueGeneratedNever()
                .HasColumnName("id_venta");
            entity.Property(e => e.Fecha).HasColumnName("fecha");
            entity.Property(e => e.IdProducto).HasColumnName("id_producto");
            entity.Property(e => e.IdUsuario).HasColumnName("id_usuario");

            entity.HasOne(d => d.IdProductoNavigation).WithMany(p => p.Venta)
                .HasForeignKey(d => d.IdProducto)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("venta_ibfk_1");

            entity.HasOne(d => d.IdUsuarioNavigation).WithMany(p => p.Venta)
                .HasForeignKey(d => d.IdUsuario)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("venta_ibfk_2");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
