package com.example.linkapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.emergencyl.ui.theme.screens.login.LoginScreen
import com.example.linkapp.ui.theme.screens.First.firstscreen
import com.example.linkapp.ui.theme.screens.call.CallScreen
import com.example.linkapp.ui.theme.screens.faint.FaintScreen
import com.example.linkapp.ui.theme.screens.chest.chestscreen
import com.example.linkapp.ui.theme.screens.home.HomeScreen
import com.example.linkapp.ui.theme.screens.dashboard.dashboardscreen
import com.example.linkapp.ui.theme.screens.ankle.anklescreen
import com.example.linkapp.ui.theme.screens.broken.brokenscreen
import com.example.linkapp.ui.theme.screens.burn.burnscreen
import com.example.linkapp.ui.theme.screens.Nosebleed.nosebleedscreen
import com.example.linkapp.ui.theme.screens.heartattack.heartattackscreen
import com.example.linkapp.ui.theme.screens.spinal.spinalscreen
import com.example.linkapp.ui.theme.screens.signup.SignupScreen
import com.example.linkapp.ui.theme.screens.splash.splashscreen



@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String =HOME_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(FIRST_URL){
            firstscreen(navController = navController)
        }
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }

        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navController = navController)
        }

        composable(DASHBOARD_URL){
            dashboardscreen(navController = navController)
        }
        composable(CALL_URL){
            CallScreen(navController=navController)
        }

        composable(NOSEBLEED_URL){
            nosebleedscreen(navController=navController)
        }

        composable(CHEST_URL){
            chestscreen(navController=navController)
        }

        composable(BROKENLIMB_URL){
            brokenscreen(navController=navController)
        }

        composable(BURN_URL){
            burnscreen(navController=navController)
        }

        composable(FAINT_URL){
            FaintScreen(navController=navController)
        }

        composable(SPINAL_URL){
            spinalscreen(navController = navController)
        }

        composable(ANKLE_URL){
            anklescreen(navController=navController)
        }

        composable(HEARTATTACK_URL){
            heartattackscreen(navController=navController)
        }

        composable(SPLASH_URL){
            splashscreen(navController=navController)
        }
    }
}