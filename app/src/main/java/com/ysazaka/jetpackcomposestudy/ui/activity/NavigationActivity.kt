package com.ysazaka.jetpackcomposestudy.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ysazaka.jetpackcomposestudy.R

class NavigationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowNavigationScreen()
        }
    }

}

@Composable
fun ShowNavigationScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text(text = "Click on the image") }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Spacer(modifier = Modifier.width(16.dp))

            Card {
                var expanded by remember { mutableStateOf(false) }
                Column(Modifier.clickable { expanded = !expanded }) {
                    Image(
                        painter = painterResource(R.drawable.leon),
                        contentDescription = "Test picture",
                        modifier = Modifier
                            .size(240.dp)
                            .clip(CircleShape)
                    )
                    AnimatedVisibility(expanded) {
                        Text(
                            text = "Leon",
                            style = MaterialTheme.typography.h2
                        )
                    }
                }
            }
        }
    }
}