using System;
using System.Collections.Generic;

namespace backend_avance.Models;

public partial class Reporte
{
    public int IdReporte { get; set; }

    public DateOnly Fecha { get; set; }

    public int? Cantidad { get; set; }

    public int? IdComprobante { get; set; }

    public int? IdUsuario { get; set; }

    public int? IdProducto { get; set; }

    public int? IdCategoria { get; set; }

    public virtual Categorium? IdCategoriaNavigation { get; set; }

    public virtual Comprobante? IdComprobanteNavigation { get; set; }

    public virtual Producto? IdProductoNavigation { get; set; }

    public virtual Usuario? IdUsuarioNavigation { get; set; }
}
