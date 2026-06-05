using System;
using System.Collections.Generic;

namespace backend_avance.Models;

public partial class Usuario
{
    public int IdUsuario { get; set; }

    public string User { get; set; } = null!;

    public string Pass { get; set; } = null!;

    public string Nombre { get; set; } = null!;

    public string Apellido { get; set; } = null!;

    public string Correo { get; set; } = null!;

    public string? Telefono { get; set; }

    public string? Distrito { get; set; }

    public string? Imagen { get; set; }

    public int? IdRol { get; set; }

    public virtual ICollection<Comprobante> Comprobantes { get; set; } = new List<Comprobante>();

    public virtual ICollection<Detalleventum> Detalleventa { get; set; } = new List<Detalleventum>();

    public virtual Rol? IdRolNavigation { get; set; }

    public virtual ICollection<Reporte> Reportes { get; set; } = new List<Reporte>();

    public virtual ICollection<Ventum> Venta { get; set; } = new List<Ventum>();
}
