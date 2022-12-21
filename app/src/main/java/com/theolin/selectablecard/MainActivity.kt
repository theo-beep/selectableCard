package com.theolin.selectablecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theolin.selectablecard.ui.theme.SelectableCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            SelectableCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumnWithSelection()
                }
            }
        }
    }
}

@Composable
fun ItemView(index: Int,text :String , selected: Boolean, onClick: (Int) -> Unit){
    Text(
        text = text,
        modifier = Modifier
            .clickable {
                onClick.invoke(index)
            }
            .background(if (selected) Color.Black else Color.Red)
            .fillMaxWidth()
            .padding(12.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyColumnWithSelection(){
    var itemSelection by remember { mutableStateOf(-1) }

//    val onItemClick = { index: Int -> selectedIndex = index}
    val list = listOf("A", "B","C")

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ){
        items(list.size){ index ->
            Card(
                onClick = { itemSelection = if(itemSelection != index)  index else -1 },
                modifier = Modifier
                    .size(width = 180.dp, height = 100.dp)
                   .background(if (itemSelection == index) Color.Black else Color.Red)
            ) {
                Box(Modifier.fillMaxSize()) {
                    Text(modifier = Modifier.background(if (itemSelection == index) Color.Black else Color.Red),
                        text = list.get(index))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SelectableCardTheme {
        Greeting("Android")
    }
}