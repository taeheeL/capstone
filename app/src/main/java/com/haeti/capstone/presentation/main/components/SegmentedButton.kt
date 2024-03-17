package com.haeti.capstone.presentation.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haeti.capstone.presentation.theme.GrayButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegmentedButton(
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit,
    options: List<String>,
) {
    var checkedItem by remember { mutableIntStateOf(0) }

    SingleChoiceSegmentedButtonRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
    ) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                selected = index == checkedItem,
                onClick = {
                    checkedItem = index
                    onClick(index)
                },
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size,
                    baseShape = RoundedCornerShape(4.dp)
                ),
                icon = ({ /* no icon */ }),
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = GrayButton
                )
            ) {
                Text(text = label)
            }

        }
    }
}