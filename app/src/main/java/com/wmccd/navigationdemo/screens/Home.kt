package com.wmccd.navigationdemo.screens
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wmccd.navigationdemo.NavRoutes


@Composable
fun Home(navHostController: NavHostController){

    Log.d("XXX", "Home")
    var userName by remember { mutableStateOf("") }
    val onUserNameChange = { text: String ->
        userName = text
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           CustomTextField(
               title = "Enter Your Name",
               textState = userName,
               onTextChange = onUserNameChange
           )
            Spacer(
                modifier = Modifier.size(30.dp)
            )
            Button(
                onClick = {
                    navHostController.navigate(NavRoutes.Welcome.route + "/$userName")
                }
            ){
                Text("Register")
            }
        }
    }
}

@Composable
fun CustomTextField(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        value = textState,
        onValueChange = onTextChange,
        singleLine = true,
        label = { Text(title) },
        modifier = Modifier.padding(10.dp),
        textStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
    )

}

