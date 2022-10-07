package com.yyw.bloom.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yyw.bloom.ui.theme.BloomTheme

@Composable
fun LoginPage() {
    Surface(
        color = MaterialTheme.colors.background, modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            LoginTitle()
            LoginInputBox()
            HintWithUnderline()
            LoginButton()
        }
    }
}

@Composable
fun LoginTitle() {
    Text(
        text = "Log in with email",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 184.dp, bottom = 16.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun LoginInputBox() {
    Column {
        val (emailText, setEmailText) = remember {
            mutableStateOf("")
        }
        val (pwdText, setPwdText) = remember {
            mutableStateOf("")
        }
        LoginTextField(emailText, setEmailText, "Email address")
        Spacer(modifier = Modifier.height(8.dp))
        LoginTextField(pwdText, setPwdText, "Password (8+ characters)")
    }
}

@Composable
fun LoginTextField(text: String, onValueChange: (String) -> Unit, hintText: String) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(text = hintText, style = MaterialTheme.typography.body1) },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        textStyle = MaterialTheme.typography.body1
    )
}

@Composable
fun HintWithUnderline() {
    Text(
        text = buildAnnotatedString {
            append("By clicking below, you agree to our ")
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append("Terms of Use")
            }
            append(" and consent to our ")
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append("Privacy Policy")
            }
            append(".")
        },
        style = MaterialTheme.typography.body2,
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 24.dp, bottom = 16.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun LoginButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth(),
        shape = CircleShape
    ) {
        Text(text = "Log in", style = MaterialTheme.typography.button)
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreLoginTitle() {
    BloomTheme {
        LoginTitle()
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreLoginInputBox() {
    BloomTheme {
        LoginInputBox()
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreHintWithUnderline() {
    BloomTheme {
        HintWithUnderline()
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreLoginButton() {
    BloomTheme {
        LoginButton()
    }
}

@Preview(device = Devices.PIXEL)
@Composable
fun PreLoginPage() {
    BloomTheme {
        LoginPage()
    }
}