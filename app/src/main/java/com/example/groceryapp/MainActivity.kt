package com.example.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryapp.ui.theme.GroceryAppTheme

class MainActivity : ComponentActivity() {
    private val items = mapOf(
        "Fruits" to listOf(
            Item("Apple", "Sweet, healthy and delicious fruit", R.drawable.apple),
            Item("Banana", "Soft, sweet and delicious fruit", R.drawable.banana),
            Item("Cherry", "small but sweet and delicious", R.drawable.cherry),
            Item("Mango", "Very sweet and healthy", R.drawable.mango),
            Item("Grapes", "Comes in shape of bunches, sweet and healthy", R.drawable.grapes),
            Item(
                "WaterMelon",
                "Big size, red from inside and green from outside. Sweet and juicy fruit",
                R.drawable.watermellon
            )
        ),
        "Vegetables" to listOf(
            Item("Carrot", "Red color and very healthy", R.drawable.carrot),
            Item("Lettuce", "Come in shape of leaves and very healthy", R.drawable.lettuce),
            Item("Tomato", "Often red color, soft and full of Iron", R.drawable.tomato),
            Item("Onion", "Contains large amount of Vitamin C", R.drawable.onion),
            Item("Green Chilli", "Green color and healthy", R.drawable.green_chilli),
            Item("Potato", "Contain large amount of Protein and healthy", R.drawable.potato),
            Item("Eggplant", "Dark color and healthy", R.drawable.eggplant)
        ),
    )

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GroceryAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(modifier = Modifier.padding(innerPadding)) {
                        items.forEach { (header, itemsForLazyColumn) ->
                            stickyHeader {
                                Text(
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(
                                            color = colorResource(
                                                id = R.color.teal_200
                                            )
                                        )
                                        .padding(vertical = 10.dp),
                                    text = header,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            items(itemsForLazyColumn) { item ->
                                ItemCard(item)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ItemCard(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.teal_700))
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = item.image),
                contentDescription = "Image of ${item.name}",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = item.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = item.description,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroceryAppTheme {
        Greeting("Android")
    }
}