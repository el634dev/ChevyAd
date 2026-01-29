package com.example.chevyad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chevyad.ui.theme.ChevyAdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChevyAdTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ChevyAd(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ChevyAd(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "For Sale",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            lineHeight = 50.sp,
            modifier = modifier
        )
        Image(
            painter = painterResource(R.drawable.chevrolet_impala),
            contentDescription = "1965 Chevy Impala Wagon"
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Information",
                tint = Color.Gray,
                modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)
            )
            Text(
                text = "1965 Chevy Impala 409 Wagon",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                lineHeight = 50.sp,
                modifier = modifier
            )
        }
      BuyerSwitch()
    }
}

@Composable
fun BuyerSwitch(modifier: Modifier = Modifier) {
    var isChecked by remember { mutableStateOf(value = true) }
    val message = if (isChecked) "Sold" else "Still for Sale"

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Switch(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            }
        )
        Text(
            text = message
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChevyAdPreview() {
    ChevyAdTheme {
        ChevyAd()
    }
}