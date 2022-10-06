package com.yyw.bloom.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yyw.bloom.R
import com.yyw.bloom.ui.theme.BloomTheme

@Composable
fun WelcomePage() {
    Surface(color = MaterialTheme.colors.primary) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.light_welcome_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            WelcomeContent()
        }
    }
}

@Composable
fun WelcomeContent() {
    Column {
        Spacer(modifier = Modifier.height(72.dp))
        LeafImage()
        Spacer(modifier = Modifier.height(48.dp))
        WelcomeTitle()
        Spacer(modifier = Modifier.height(40.dp))
        WelcomeButtons()
    }
}

@Composable
fun LeafImage() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(88.dp))
        Image(
            painter = painterResource(id = R.drawable.light_welcome_illos),
            contentDescription = null,
            alignment = Alignment.TopStart,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun WelcomeTitle() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.light_logo), contentDescription = null)
        Text(
            text = "Beautiful home garden solutions",
            lineHeight = 32.sp,
            style = MaterialTheme.typography.subtitle1.merge(
                TextStyle(
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Bottom,
                        trim = LineHeightStyle.Trim.None
                    )
                )
            )
        )
    }
}


@Composable
fun WelcomeButtons() {
    Column(modifier = Modifier.padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            shape = CircleShape
        ) {
            Text(text = "Create account", style = MaterialTheme.typography.button)
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Log in", style = MaterialTheme.typography.button, color = MaterialTheme.colors.secondary)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreLeafImage() {
    BloomTheme {
        LeafImage()
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreWelcomeTitle() {
    BloomTheme {
        WelcomeTitle()
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreWelcomeButtons() {
    BloomTheme {
        WelcomeButtons()
    }
}

@Preview(device = Devices.PIXEL)
@Composable
fun PreWelcomePage() {
    BloomTheme {
        WelcomePage()
    }
}