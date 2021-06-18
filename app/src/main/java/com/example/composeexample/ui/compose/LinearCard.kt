package com.example.composeexample.ui.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun TestCardLinear(name: String, descriptionText: String?, imageUrl: String) {
    val context = LocalContext.current
    Card(
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = "Hello $name!", style = MaterialTheme.typography.h4)
            Text(
                text = descriptionText.orEmpty(),
                style = TextStyle(color = Color.Blue),
                modifier = Modifier.padding(vertical = 20.dp)
            )
            Image(
                painter = rememberCoilPainter(request = imageUrl),
                contentDescription = "This is a compose image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        144.dp
                    )
                    .clickable {
                        showToast(context, name)
                    }
            )
        }
    }
}

private fun showToast(context: Context, name: String) {
    Toast
        .makeText(
            context,
            "The image for $name was clicked",
            Toast.LENGTH_SHORT
        )
        .show()
}