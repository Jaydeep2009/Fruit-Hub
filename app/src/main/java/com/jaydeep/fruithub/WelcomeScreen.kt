package com.jaydeep.fruithub

import android.R.attr.fontWeight
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.util.copy

@Composable
fun WelcomeScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(modifier=modifier.fillMaxSize()
        .background(colorResource(R.color.white))
    ) {

        Box(modifier=modifier.fillMaxWidth()
            .weight(0.65f)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(R.color.orange_dark),
                        colorResource(R.color.orange_light)
                    )
                )
            ),
            contentAlignment = Alignment.Center
        ){
            Box(modifier=modifier.size(280.dp)
                .background(color = Color.White.copy(alpha = 0.1f),
                    shape = CircleShape
                ), contentAlignment = Alignment.Center)
            {
                Image(
                    painter= painterResource(R.drawable.welcome),
                    contentDescription = "Welcome Image",
                    modifier=modifier.size(200.dp)

                )
            }
        }

        Column(modifier=Modifier.fillMaxWidth()
            .weight(0.35f)
            .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {

            Column(modifier=modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                )
            {
                Text(
                    text = "Get the Freshest Fruits Salad Combo",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color= Color(0xFF272140),
                    textAlign = TextAlign.Center,
                    lineHeight = 28.sp
                )
                Spacer(modifier=modifier.height(16.dp))

                Text(
                    text="We deliver the best and freshest fruit salad in town. Order for a combo today!!!",
                    fontSize = 16.sp,
                    color= Color(0xFF7C7C8D),
                    textAlign = TextAlign.Center,
                    lineHeight = 22.sp
                )
                Spacer(modifier= modifier.height(16.dp))
                
                Button(onClick = {
                    navController.navigate("home_screen")
                },
                    modifier=modifier.fillMaxWidth()
                        .height(56.dp),
                        colors= ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.orange_dark),
                            contentColor = Color.White
                        ),
                    shape = RoundedCornerShape(16.dp)
                    ){
                    Text(text="Let's Continue",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium)


                }
            }




        }
    }//main column
}