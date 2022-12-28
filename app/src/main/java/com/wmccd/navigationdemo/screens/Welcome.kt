package com.wmccd.navigationdemo.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wmccd.navigationdemo.NavRoutes

@Composable
fun Welcome(navHostController: NavHostController, userName: String){

    Log.d("XXX", "Welcome")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome, $userName",
                style = MaterialTheme.typography.h5
            )
            Spacer(
                modifier = Modifier.size(30.dp)
            )
            Button(
                onClick = {
                    navHostController.navigate(NavRoutes.Profile.route )
                }
            ){
                Text("Set up your profile")
            }
        }
    }
}