package com.haeti.capstone.presentation.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeti.capstone.presentation.theme.Slider
import com.smarttoolfactory.slider.LabelPosition
import com.smarttoolfactory.slider.MaterialSliderDefaults
import com.smarttoolfactory.slider.SliderBrushColor
import com.smarttoolfactory.slider.SliderWithLabel
import kotlin.math.roundToInt


@Composable
fun AgeSlider(
    modifier: Modifier = Modifier,
    age: Float,
    onValueChange: (Float) -> Unit
) {
    SliderWithLabel(
        modifier = modifier,
        value = age,
        valueRange = 0f..100f,
        thumbRadius = 10.dp,
        onValueChange = onValueChange,
        colors = MaterialSliderDefaults.materialColors(
            thumbColor = SliderBrushColor(color = Color.Black),
            activeTrackColor = SliderBrushColor(color = Color.Black),
            inactiveTrackColor = SliderBrushColor(color = Slider)
        ),
        labelPosition = LabelPosition.Top,
        label = {
            Box(modifier = Modifier.padding(start = 38.dp)) {
                Text(
                    text = "${age.roundToInt()}",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    )
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun AgeSliderPreview(
) {
    var age by remember { mutableFloatStateOf(1f) }
    AgeSlider(modifier = Modifier.padding(horizontal = 20.dp), age, onValueChange = { age = it })
}