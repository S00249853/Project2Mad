package com.example.project2mad

import android.icu.text.CaseMap
import android.net.http.HeaderBlock
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.R
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project2madapp.ui.theme.Project2MadAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project2MadAppTheme() {



                }
            }
        }


}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.size(400.dp)) {

        Text(
        text = "Hello $name!",
        modifier = Modifier.background(Color.Red)
            .padding(16.dp)
            .background(Color.Green),
        color = Color.Blue,
        fontSize = 30.sp
    )
        Text(
            text = "Hello $name!",
            modifier = Modifier.background(Color.Red)
                .padding(16.dp)
                .background(Color.Green),
            color = Color.Blue,
            fontSize = 30.sp
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Project2MadAppTheme()  {
        HomeScreen()
    }
}