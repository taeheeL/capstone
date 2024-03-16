package com.haeti.capstone.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GrayTextFieldWithTitle(
    modifier: Modifier = Modifier,
    hint: String,
    prefix: String,
    text: String,
    title: String,
) {
    Column(modifier = modifier) {
        TitleText(text = title, modifier = Modifier.padding(start = 20.dp))
        GrayTextField(hint = "Enter your $hint", prefix = prefix, text = text)
    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun GrayTextFieldWithTitlePreview(
) {
    GrayTextFieldWithTitle(hint = "Enter your height", prefix = "cm", text = "", title = "Height")
}
