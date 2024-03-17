package com.haeti.capstone.presentation.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GrayTextFieldWithTitle(
    modifier: Modifier = Modifier,
    hint: String,
    prefix: String,
    text: String,
    title: String,
    onValueChange: (String) -> Unit = {}
) {
    Column(modifier = modifier) {
        TitleText(text = title, modifier = Modifier.padding(start = 20.dp))
        GrayTextField(
            hint = "Enter your $hint",
            prefix = prefix,
            text = text,
            onValueChange = onValueChange,
            keyboardOptions = if (title == "Waistline") {
                KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
            } else {
                KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
            }
        )
    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun GrayTextFieldWithTitlePreview(
) {
    GrayTextFieldWithTitle(hint = "Enter your height", prefix = "cm", text = "", title = "Height")
}
