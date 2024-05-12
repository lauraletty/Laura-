package com.example.linkapp.ui.theme.screens.ankle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.linkapp.R
import com.example.linkapp.ui.theme.PurpleGrey40

@Composable
fun anklescreen(navController:NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleGrey40),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.anklesprainaid),
            contentDescription ="first aid nose",
            modifier = Modifier
                .fillMaxSize()
        )

    }



}


@Composable
@Preview(showBackground = true)

fun anklescreenPreview(){
    anklescreen(navController = rememberNavController())

}