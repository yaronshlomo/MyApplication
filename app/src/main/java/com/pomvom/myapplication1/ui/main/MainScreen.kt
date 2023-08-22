package com.pomvom.myapplication1.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pomvom.myapplication1.persistence.MainEntity

@Composable
fun MainScreen(uiState: UiStateModel, downloadItems: () -> Unit, itemList: List<MainEntity>) {

    ConstraintLayout(modifier = Modifier.fillMaxSize().background(Color.White)) {
        val (button, list) = createRefs()

        LazyColumn {
            items(itemList.size){ index ->
                Text(text = "Item: ${itemList.get(index).name}", modifier = Modifier, color = Color.Black)
            }
        }

        Button(onClick = { downloadItems() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent, contentColor = Color.Transparent),
            modifier = Modifier
                .width(80.dp)
                .height(20.dp)
                .constrainAs(button) { end.linkTo(parent.end, 15.dp); bottom.linkTo(parent.bottom, 20.dp); start.linkTo(parent.start) }
                .background(Color.Transparent)) {}

    }
}