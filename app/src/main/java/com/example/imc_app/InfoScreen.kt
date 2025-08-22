package com.example.imc_app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imc_app.ui.theme.BackGround

@Composable
fun InfoScreen() {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize().background(BackGround)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        // Title with icon
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "About this app",
                tint = Color.White,
                modifier = Modifier.size(28.dp).padding(end = 8.dp)
            )
            Text(
                text = "About this App",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Description
        Text(
            text = "This BMI - IMC (Body Mass Index - Indíce de Masa Corporal) calculator app was created as a Kotlin practice project for the Programming III course.\n\n" +
                    "It allows users to calculate their BMI, visualize categories, and better understand healthy weight ranges.",
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        // Divider (separator)
        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 24.dp)
                .fillMaxWidth(0.9f), // ocupa el 80% del ancho para que no quede de lado a lado
            thickness = 2.dp,
            color = Color.LightGray.copy(alpha = 0.6f)
        )

// About me with icon
        Column(
            modifier = Modifier.padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(verticalAlignment = Alignment.CenterVertically){


                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "About me",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )

                Text(
                    text = "About me",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "Hi! My name is Enzo Bustamante.\nI developed this app as part of my Kotlin learning path.",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Portfolio Link
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { uriHandler.openUri("https://github.com/Enzo889") }
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Portfolio",
                tint = Color(0xFF64B5F6), // light blue
                modifier = Modifier.size(24.dp).padding(end = 8.dp)
            )
            Text(
                text = "Visit my Portfolio",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF64B5F6)
            )
        }

        // GitHub Repo Link
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { uriHandler.openUri("https://github.com/your-github-repo") }
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Build,
                contentDescription = "GitHub",
                tint = Color(0xFF81C784), // green
                modifier = Modifier.size(24.dp).padding(end = 8.dp)
            )
            Text(
                text = "View Project on GitHub",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF81C784)
            )
        }
    }
}
