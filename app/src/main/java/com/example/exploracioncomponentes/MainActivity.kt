package com.example.exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exploracioncomponentes.ui.theme.ExploracionComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExploracionComponentesTheme {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp() {
        Scaffold(
            topBar = { TopAppBar(title = { Text("Component Exploration") }) },
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
                    MyColumn()
                    Spacer(modifier = Modifier.height(16.dp))
                    MyLazyColumn()
                    Spacer(modifier = Modifier.height(16.dp))
                    MyButton()
                    Spacer(modifier = Modifier.height(16.dp))
                    MyCheckbox()
                    Spacer(modifier = Modifier.height(16.dp))
                    MySlider()
                    Spacer(modifier = Modifier.height(16.dp))
                    MySwitch()
                    Spacer(modifier = Modifier.height(16.dp))
                    MyImage()
                }
            }
        )
    }


    @Composable
    fun MyColumn() {
        Column {
            Text("This is a Column")
            Text("It stacks items vertically")
        }
    }

    @Composable
    fun MyLazyColumn() {
        LazyColumn {
            items(10) {
                Text("Item #$it")
            }
        }
    }

    @Composable
    fun MyButton() {
        Button(onClick = {}) {
            Text("Click Me")
        }
    }

    @Composable
    fun MyCheckbox() {
        var checked by remember { mutableStateOf(true) }
        Checkbox(checked = checked, onCheckedChange = { checked = it })
    }

    @Composable
    fun MySlider() {
        var sliderPosition by remember { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
    }

    @Composable
    fun MySwitch() {
        var checked by remember { mutableStateOf(true) }
        Switch(checked = checked, onCheckedChange = { checked = it })
    }

    @Composable
    fun MyImage() {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(100.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ExploracionComponentesTheme {
            MyApp()
        }
    }
}