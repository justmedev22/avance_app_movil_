package pe.edu.idat.app_avance.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.idat.app_avance.R

data class ProductoItem(
    val nombre: String,
    val precio: String,
    @DrawableRes val imagen: Int
)


@Composable
fun ProductosColmun() {

    val lista_producto = listOf( // se crea la lista para los cards
        ProductoItem(
            nombre = "Audífonos",
            precio = "S/ 89.90",
            imagen = R.drawable.lr_audifonos
        ),
        ProductoItem(
            nombre = "Mouse Gamer",
            precio = "S/ 59.90",
            imagen = R.drawable.lr_mouse
        ),
        ProductoItem(
            nombre = "Teclado",
            precio = "S/ 120.00",
            imagen = R.drawable.lr_teclado
        ),
        ProductoItem(
            nombre = "Cargador",
            precio = "S/ 35.00",
            imagen = R.drawable.lr_powerbank
        ),
        ProductoItem(
                nombre = "Pantalla",
        precio = "S/ 189.90",
        imagen = R.drawable.lc_pantalla
        ),
        ProductoItem(
            nombre = "Laptop",
            precio = "S/ 59.90",
            imagen = R.drawable.lc_laptop
        ),
        ProductoItem(
            nombre = "MousePad",
            precio = "S/ 120.00",
            imagen = R.drawable.lc_mousepad
        ),
        ProductoItem(
            nombre = "Camara",
            precio = "S/ 35.00",
            imagen = R.drawable.lc_camara
        )

    )

    LazyColumn (        // codigo que estructura el lazy row
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),

    ) {
        items(lista_producto) { oferta ->
            TarjetaProductoColumn(oferta = oferta)
        }
    }
}







@Composable     // esto diseña el resultado del card y lo coloca arriba
// para que se muestre el card listo en el componente del lazy row
fun TarjetaProductoColumn(oferta: ProductoItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    )
    {
        Row (
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
        )
        {
            Image(
                painter = painterResource(id = oferta.imagen),
                contentDescription = oferta.nombre,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column ( modifier = Modifier.fillMaxWidth().weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(
                    text = oferta.nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = oferta.precio,
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Button(
                onClick = {
                    /* esto compra */
                }

            ) {
                Text(text = "Comprar",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,)
            }
        }
        }

    }







