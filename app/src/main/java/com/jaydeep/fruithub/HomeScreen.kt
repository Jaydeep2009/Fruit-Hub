package com.jaydeep.fruithub

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.ui.res.colorResource

@Composable
fun HomeScreen(navController: NavController,modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu Icon",
                tint=Color.Black,
                modifier = Modifier.size(24.dp)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(R.drawable.basket),
                    contentDescription = "Fruit Hub Logo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier=Modifier.height(4.dp))

                Text(
                    text="My Basket",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }


        }

        //Greeting Text
        Text(
            text = "Hello Jaydeep, What fruit salad combo would you like today?",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        //Searchbar

        Row(modifier = Modifier.fillMaxWidth()
            .background(color=Color(0xFFF3F1F1), shape = RoundedCornerShape(16.dp) )
            .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically){

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint=Color.Gray,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier=Modifier.width(12.dp))

            Text(
                text = "Search for fruit salad combos",
                fontSize = 14.sp,
                color = Color.Gray,
            )
            Spacer(modifier=Modifier.weight(1f) )

            Image(
                painter = painterResource(R.drawable.filter),
                contentDescription = "Filter Icon",
                modifier = Modifier.size(24.dp)
            )

        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text="Recommended Combos",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(bottom = 16.dp)) {
            items(10) { index ->
                RecommendedComboCard("Samosa","120",R.drawable.fruit_hub)
            }

        }

        Button(onClick = {
            navController.popBackStack()
        }, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.orange_dark),
                contentColor = Color.White
            )) {
            Text("Go back")

        }
    }//main column



}

@Composable
//@Preview(showSystemUi = true)
fun RecommendedComboCard(name:String, price:String, imageResId:Int) {
    Card( modifier = Modifier.width(152.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(12.dp)
            ) {

            Row(horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()){
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite Icon",
                    tint=Color.Red,
                    modifier = Modifier.size(20.dp)
                )




            }
            Image(
                painter = painterResource(imageResId),
                contentDescription = "Fruit Image",
                modifier = Modifier
                    .size(120.dp)
                    .padding(top = 8.dp)
            )
            Spacer(modifier=Modifier.height(12.dp))

            Text(
                text=name,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier=Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){

                Text(
                    text = price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add to Basket Icon",
                    tint=Color.Red,
                    modifier = Modifier.size(24.dp)
                )

            }
        }
    }
}
