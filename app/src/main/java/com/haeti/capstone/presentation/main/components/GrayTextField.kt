package com.haeti.capstone.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeti.capstone.presentation.theme.GrayField
import com.haeti.capstone.presentation.theme.HintText

@Composable
fun GrayTextField(
    modifier: Modifier = Modifier,
    hint: String,
    prefix: String,
    text: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardType: KeyboardType = KeyboardType.Number,
    onValueChange: (String) -> Unit = {}
) {
    Column(modifier = modifier.fillMaxWidth()) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = modifier.padding(top = 4.dp, start = 20.dp, end = 20.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = keyboardOptions.imeAction,
            ),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = GrayField, shape = RoundedCornerShape(12.dp))
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (text.isEmpty()) {
                        Text(
                            text = hint,
                            color = HintText,
                            fontSize = 13.sp
                        )
                    }
                    innerTextField()

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = prefix,
                        color = Color.Black,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 8.dp),
                    )
                }
            },
        )
    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun GrayTextFieldPreview() {
    GrayTextField(
        hint = "Height",
        prefix = "cm",
        text = "170"
    )
}