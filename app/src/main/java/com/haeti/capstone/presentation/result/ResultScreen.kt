package com.haeti.capstone.presentation.result

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.haeti.capstone.R
import com.haeti.capstone.presentation.navigation.Screen
import com.haeti.capstone.presentation.theme.BlackGray

@Composable
fun ResultScreen(
    navController: NavController,
    result: Int
) {

    val resultViewModel: ResultViewModel = viewModel()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                CustomTabsIntent.Builder().build().run {
                    launchUrl(
                        context, Uri.parse(
                            context.getString(
                                R.string.national_health_portal_link
                            )
                        )
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .height(60.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(
                width = 2.dp
            ),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
            )
        ) {
            Text(
                text = "More Information", style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }

        Button(
            onClick = { navController.navigate(Screen.Home.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BlackGray,
                contentColor = Color.White,
            )
        ) {
            Text(
                text = "Go Home", style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (result == 0) {
                Image(
                    modifier = Modifier
                        .size(250.dp)
                        .padding(bottom = 10.dp),
                    painter = painterResource(id = R.drawable.img_healthy),
                    contentDescription = null,
                )

                Text(
                    text = context.getString(R.string.healthy_pharse),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 50.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(300.dp)
                        .padding(bottom = 80.dp),
                    painter = painterResource(id = R.drawable.img_danger),
                    contentDescription = null,
                )

                Text(
                    text = stringResource(R.string.danger_pharse),
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ResultScreenPreview() {
    ResultScreen(navController = rememberNavController(), result = 0)
}