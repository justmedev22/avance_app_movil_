using System;
using System.Collections.Generic;

namespace backend_avance.Models;

public partial class Ventum
{
    public int IdVenta { get; set; }

    public DateOnly Fecha { get; set; }

    public int? IdProducto { get; set; }

    public int? IdUsuario { get; set; }

    public virtual ICollection<Comprobante> Comprobantes { get; set; } = new List<Comprobante>();

    public virtual Producto? IdProductoNavigation { get; set; }

    public virtual Usuario? IdUsuarioNavigation { get; set; }
}
