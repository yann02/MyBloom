package com.yyw.bloom.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.yyw.bloom.data.navs
import com.yyw.bloom.ui.theme.BloomTheme

@Composable
fun MainView() {
    Scaffold(bottomBar = { BottomBar() }) {
        HomeView()
    }
}

@Composable
fun BottomBar() {
    val selectedItem by remember { mutableStateOf(0) }
    BottomNavigation {
        navs.forEachIndexed { index, navItem ->
            BottomNavigationItem(selected = selectedItem == index, onClick = { /*TODO*/ }, icon = {
                Icon(imageVector = navItem.icon, contentDescription = null)
            }, label = {
                Text(
                    text = navItem.name
                )
            })
        }
    }
}

@Preview
@Composable
fun PreBottomBar() {
    BloomTheme {
        BottomBar()
    }
}

@Preview(device = Devices.PIXEL)
@Composable
fun PreMainView() {
    BloomTheme {
        MainView()
    }
}