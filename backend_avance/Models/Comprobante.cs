using System;
using System.Collections.Generic;

namespace backend_avance.Models;

public partial class Comprobante
{
    public int IdComprobante { get; set; }

    public DateOnly Fecha { get; set; }

    public int? IdVenta { get; set; }

    public string? TipoDeComprobante { get; set; }

    public int? IdProducto { get; set; }

    public int? IdCategoria { get; set; }

    public int? IdUsuario { get; set; }

    public int? IdDetalleventa { get; set; }

    public virtual Categorium? IdCategoriaNavigation { get; set; }

    public virtual Detalleventum? IdDetalleventaNavigation { get; set; }

    public virtual Producto? IdProductoNavigation { get; set; }

    public virtual Usuario? IdUsuarioNavigation { get; set; }

    public virtual Ventum? IdVentaNavigation { get; set; }

    public virtual ICollection<Reporte> Reportes { get; set; } = new List<Reporte>();
}
