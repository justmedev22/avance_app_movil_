package pe.edu.idat.app_avance.components

import pe.edu.idat.app_avance.R


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp




// inicializa la funcion en parte de detalles , detalles e imagen
data class ProductoRow(
    val nombre: String,
    val precio: String,
    @DrawableRes val imagen: Int
)



@Composable
fun ProductosLazyRow() {

    val productos = listOf( // se crea la lista para los cards
        ProductoRow(
            nombre = "Audífonos",
            precio = "S/ 89.90",
            imagen = R.drawable.lr_mouse
        ),
        ProductoRow(
            nombre = "Mouse Gamer",
            precio = "S/ 59.90",
            imagen = R.drawable.lr_audifonos
        ),
        ProductoRow(
            nombre = "Teclado",
            precio = "S/ 120.00",
            imagen = R.drawable.lr_teclado
        ),
        ProductoRow(
            nombre = "Cargador",
            precio = "S/ 35.00",
            imagen = R.drawable.lr_powerbank
        )
    )

    LazyRow(        // codigo que estructura el lazy row
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(productos) { producto ->
            TarjetaProductoRow(producto = producto)
        }
    }
}



@Composable     // esto diseña el resultado del card y lo coloca arriba
// para que se muestre el card listo en el componente del lazy row
fun TarjetaProductoRow(producto: ProductoRow) {
    Card(
        modifier = Modifier
            .width(160.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = producto.imagen),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = producto.nombre,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = producto.precio,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}