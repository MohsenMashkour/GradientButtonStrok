package com.mkrdeveloper.gradientbuttonstrok

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.text.TextStyle
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
            SearchBar(
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

            }
            Text(text = "New movies", color = Color.Yellow)

            LazyHorizontalGrid(rows = GridCells.Fixed(1)) {

            }
            Text(text = "upcoming movies", color = Color.Yellow)
            LazyHorizontalGrid(rows = GridCells.Fixed(1)) {

            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {
        Log.d("screen", it)
    }
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, CircleShape)
                .background(Color.Transparent, CircleShape)
                .border(
                    BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color(0xffe45eb0),
                                Color(0xff34e3c4)
                            )
                        )
                    ),
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true
                }
        )
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}