using System;
using System.Collections.Generic;

namespace backend_avance.Models;

public partial class Producto
{
    public int IdProducto { get; set; }

    public string Nombre { get; set; } = null!;

    public string? Descripcion { get; set; }

    public decimal? PrecioMin { get; set; }

    public decimal? PrecioMax { get; set; }

    public string Estado { get; set; } = null!;

    public int? Stock { get; set; }

    public string? Imagen { get; set; }

    public int? IdCategoria { get; set; }

    public virtual ICollection<Comprobante> Comprobantes { get; set; } = new List<Comprobante>();

    public virtual ICollection<Detalleventum> Detalleventa { get; set; } = new List<Detalleventum>();

    public virtual Categorium? IdCategoriaNavigation { get; set; }

    public virtual ICollection<Reporte> Reportes { get; set; } = new List<Reporte>();

    public virtual ICollection<Ventum> Venta { get; set; } = new List<Ventum>();
}
