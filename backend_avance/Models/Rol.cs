using System;
using System.Collections.Generic;

namespace backend_avance.Models;

public partial class Rol
{
    public int IdRol { get; set; }

    public string TipoRol { get; set; } = null!;

    public virtual ICollection<Usuario> Usuarios { get; set; } = new List<Usuario>();
}
