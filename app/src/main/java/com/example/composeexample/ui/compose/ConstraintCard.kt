@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.composeexample.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun TestCardConstraint(name: String, descriptionText: String?, imageUrl: String) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier.padding(10.dp)
    ) {
        val openDialog = remember { mutableStateOf(false) }
        ConstraintLayout(Modifier.padding(10.dp)) {
            val (title, description, image) = createRefs()
            Text(text = "Hello $name!",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.constrainAs(
                    title
                ) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

            Text(
                text = descriptionText.orEmpty(),
                style = TextStyle(color = Color.Blue),
                modifier = Modifier.constrainAs(description) {
                    top.linkTo(title.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                }
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
                        openDialog.value = true
                    }
                    .constrainAs(image) {
                        top.linkTo(description.bottom, margin = 20.dp)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            if (openDialog.value) {
                ShowDialog(onConfirm = { openDialog.value = false }, { openDialog.value = false })
            }
        }
    }
}