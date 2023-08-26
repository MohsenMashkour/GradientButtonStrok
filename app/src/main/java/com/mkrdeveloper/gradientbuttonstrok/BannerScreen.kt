package com.mkrdeveloper.gradientbuttonstrok

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BannerScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A1B1B)), verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val brush: Brush = Brush.horizontalGradient(
            listOf(
                Color(0xffe45eb0), Color(0xff34e3c4)
            )
        )
        val imageBrush =
            ShaderBrush(ImageShader(ImageBitmap.imageResource(id = R.drawable.woman)))
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
        Box(
            modifier
                .fillMaxWidth()
                .wrapContentHeight(), contentAlignment = Alignment.Center
        ) {

            Canvas(
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.TopStart),
                onDraw = {


                    drawCircle(brush = boxBrush, alpha = .3f)

                }
            )
            Canvas(
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.BottomEnd),
                onDraw = {

                    drawCircle(brush = boxBrush2, alpha = .3f)


                }
            )
            Canvas(
                modifier = Modifier.size(380.dp),
                onDraw = {
                    drawCircle(imageBrush)
                    drawCircle(brush = brush, style = Stroke(10f), center = center)

                }
            )
        }

        /*Text(
            text = "Hello Android!",
            style = TextStyle(
                brush = imageBrush,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp
            )
        )
        Spacer(modifier.height(50.dp))*/
        Text(
            text = "Watch Videos in\n\nVirtual Reality",
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Text(
            text = "Download and watch online where ever you are",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Box(
            modifier
                .align(Alignment.End), contentAlignment = Alignment.Center
        ) {

            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Canvas(
                    modifier = Modifier.size(200.dp),
                    onDraw = {


                        drawCircle(brush = boxBrush, center = center, alpha = .2f)

                    }
                )
                Canvas(
                    modifier = Modifier.size(200.dp),
                    onDraw = {

                        drawCircle(brush = boxBrush2, center = center, alpha = .2f)


                    }
                )


            }

            Button(
                onClick = { /*TODO*/ },
                modifier
                    .padding(60.dp)
                    .border(
                        BorderStroke(
                            width = 3.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xffe45eb0),
                                    Color(0xff34e3c4)
                                )
                            )
                        ),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A1B1B)
                )
            ) {
                Text(
                    text = "Get in",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraLight

                )
            }
        }

    }


}