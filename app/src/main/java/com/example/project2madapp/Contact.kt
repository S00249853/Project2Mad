package com.example.project2madapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ContactScreen() {
    Box(modifier = Modifier.fillMaxSize())
    {
        Column() {
            TopUi()
                NameSection("Contact")
            ContactDetails()
        }
    }
}

@Composable
fun ContactDetails(){
    Text("To report any bugs, please reach out to us here:",fontSize = 30.sp, modifier = Modifier.padding(20.dp))

    Column() {

        Text("Email: sample@gmail.com",fontSize = 30.sp, modifier = Modifier.padding(20.dp))
        Text("Phone: 0965432345",fontSize = 30.sp, modifier = Modifier.padding(20.dp))

    }


}