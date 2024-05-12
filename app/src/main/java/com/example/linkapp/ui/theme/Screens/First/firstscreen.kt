package com.example.linkapp.ui.theme.screens.First

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.linkapp.data.AuthViewModel
import com.example.linkapp.navigation.LOGIN_URL
import com.example.linkapp.navigation.SIGNUP_URL
import com.example.linkapp.ui.theme.PurpleGrey40
import com.example.linkapp.R


@Composable
fun firstscreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleGrey40),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Emergency",
            modifier = Modifier
                .size(width = 150.dp, height = 150.dp)
                .padding(top = 80.dp)
                .clip(RoundedCornerShape(size = 100.dp))
        )



        Spacer(modifier = Modifier
            .height(80.dp)
            .padding(top = 100.dp))





        Column(
            modifier = Modifier
                .padding(top = 250.dp)
        ) {
            Button(onClick = {
                navController.navigate(LOGIN_URL)
            },
                modifier = Modifier.padding(start = 100.dp)) {

                Text(text = "LOGIN",
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .size(120.dp, height = 20.dp)
                        .padding(start = 30.dp, end = 30.dp),
                    textAlign = TextAlign.Center,
                )


            }

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Spacer(modifier = Modifier.width(25.dp))

                Divider(modifier = Modifier
                    .width(150.dp)
                    .padding(top = 10.dp, end = 10.dp)
                    .height(2.dp), color = Color.Black)

                Text(text = "or")

                Divider(modifier = Modifier
                    .width(150.dp)
                    .padding(top = 10.dp, start = 10.dp)
                    .height(2.dp), color = Color.Black)

                Spacer(modifier = Modifier.width(15.dp))


            }
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate(SIGNUP_URL)
            },
                modifier = Modifier.padding(start = 100.dp)
            ) {

                Text(text = "Register",
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .size(120.dp, height = 20.dp)
                        .padding(start = 30.dp, end = 30.dp),
                    textAlign = TextAlign.Center,
                )


            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun firstscreenPreview(){
    firstscreen(navController = rememberNavController())

}
