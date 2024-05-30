package com.haeti.capstone.presentation.main

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.haeti.capstone.presentation.main.components.AgeSlider
import com.haeti.capstone.presentation.main.components.GrayTextFieldWithTitle
import com.haeti.capstone.presentation.main.components.SegmentedButton
import com.haeti.capstone.presentation.main.components.TitleText
import com.haeti.capstone.presentation.navigation.Screen
import com.haeti.capstone.presentation.theme.BlackGray
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by mainViewModel.collectAsState()
    val context = LocalContext.current

    val sexOptions = listOf("Male", "Female")
    val drinkingOptions = listOf("Non-drinker", "Drinker")
    val smokingOptions = listOf("No Smoking", "Less than 1", "More than 1")

    Scaffold { it ->
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.White)
        ) {
            GrayTextFieldWithTitle(
                hint = "height",
                prefix = "cm",
                text = state.height ?: "",
                title = "Height",
                modifier = Modifier.padding(top = 20.dp),
                onValueChange = { height -> mainViewModel.updateHeight(height) }
            )

            GrayTextFieldWithTitle(
                hint = "weight",
                prefix = "kg",
                text = state.weight ?: "",
                title = "Weight",
                modifier = Modifier.padding(top = 20.dp),
                onValueChange = { weight -> mainViewModel.updateWeight(weight) }
            )

            GrayTextFieldWithTitle(
                hint = "waistline",
                prefix = "cm",
                text = state.waistline ?: "",
                title = "Waistline",
                modifier = Modifier.padding(top = 20.dp),
                onValueChange = { waistline -> mainViewModel.updateWaistline(waistline) }
            )

            TitleText(
                text = "Age",
                modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 8.dp)
            )

            AgeSlider(
                modifier = Modifier.padding(horizontal = 20.dp),
                age = state.age,
                onValueChange = { progress -> mainViewModel.updateAge(progress) })

            TitleText(
                text = "Sex",
                modifier = Modifier.padding(top = 16.dp, start = 20.dp)
            )

            SegmentedButton(
                onClick = { index -> mainViewModel.updateSex(index) },
                options = sexOptions
            )

            TitleText(
                text = "Drinking Status",
                modifier = Modifier.padding(top = 12.dp, start = 20.dp)
            )

            SegmentedButton(
                onClick = { index -> mainViewModel.updateDrinking(index) },
                options = drinkingOptions
            )

            TitleText(
                text = "Smoking Status",
                modifier = Modifier.padding(top = 12.dp, start = 20.dp)
            )

            SegmentedButton(
                onClick = { index -> mainViewModel.updateSmoking(index) },
                options = smokingOptions
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                text = "1 means 1 pack per day",
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 11.sp
                ),
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { mainViewModel.predict() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlackGray,
                    contentColor = Color.White,
                ),
                enabled = state.isValid
            ) {
                Text(
                    text = "View Result", style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
            }
        }
    }

    mainViewModel.collectSideEffect {
        when (it) {
            is MainSideEffect.NavigateToResult -> {
                navController.navigate(Screen.Result.createRoute(result = it.result))
            }

            is MainSideEffect.ErrorToast -> {
                Toast.makeText(context, "형식에 맞는 데이터를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun MainScreenPreview(
) {
    MainScreen(mainViewModel = hiltViewModel(), navController = rememberNavController())
}

