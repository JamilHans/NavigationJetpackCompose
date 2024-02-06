package com.example.navigationjetpackcompose.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navigationjetpackcompose.components.MainButton
import com.example.navigationjetpackcompose.components.MainIconButton
import com.example.navigationjetpackcompose.components.Space
import com.example.navigationjetpackcompose.components.TitleBar
import com.example.navigationjetpackcompose.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController, id: Int, opcional: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail view") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue,
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                },
            )
        },
    ) {
        ContentDetailView(navController, id = id, opcional = opcional)
    }
}

@Composable
fun ContentDetailView(navController: NavController, id: Int, opcional: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TitleView(name = "Detail View")
        Space()
        TitleView(name = id.toString())
        Space()
        opcional?.apply {
            if (opcional !== "") {
                TitleView(name = opcional)
                Space()
            }
        }
        MainButton(name = "Return home", backColor = Color.Blue, color = Color.White) {
            navController.popBackStack()
        }
    }


}
