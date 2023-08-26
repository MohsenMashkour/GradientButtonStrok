package com.mkrdeveloper.gradientbuttonstrok

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A1B1B)),
        contentAlignment = Alignment.Center
    ) {
        val boxBrush: Brush = Brush.radialGradient(
            listOf(
                Color(0xffe45eb0),
                Color(0xFF1A1B1B)
            )
        )
        val boxBrush2: Brush = Brush.radialGradient(
            listOf(

                Color(0xff34e3c4),
                Color(0xFF1A1B1B)
            )
        )

        Canvas(
            modifier = Modifier

                .size(600.dp)
                .align(Alignment.TopStart),
            onDraw = {
                translate(left = -400f, top = -100f) {
                    drawCircle(brush = boxBrush, alpha = .3f)
                }


            }
        )
        Canvas(
            modifier = Modifier

                .size(600.dp)
                .align(Alignment.BottomEnd),
            onDraw = {

                translate(left = 400f, top = 100f) {
                    drawCircle(brush = boxBrush2, alpha = .3f)
                }

            }
        )
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "What would you like to watch?", color = Color.White)
            Text(text = "Search here", color = Color.White)
            Text(text = "New movies", color = Color.Yellow)

            LazyHorizontalGrid(rows = GridCells.Fixed(1) ){

            }
            Text(text = "upcoming movies", color = Color.Yellow)
            LazyHorizontalGrid(rows = GridCells.Fixed(1) ){

            }
        }
    }
}