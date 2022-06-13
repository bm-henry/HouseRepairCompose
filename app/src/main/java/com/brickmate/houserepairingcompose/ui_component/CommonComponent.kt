package com.brickmate.houserepairingcompose.ui_component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.bold16
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.bold20
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.medium12
import com.brickmate.houserepairingcompose.screen.theme.Black
import com.brickmate.houserepairingcompose.screen.theme.GreenMain

@Composable
fun AppOutLineTextView(
    modifier: Modifier = Modifier,
    text: String,
    placeHolder: String,
    outlineColor: Color = Color.Black,
    isShowTrailingIcon: Boolean = false,
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val isShowPassword by rememberSaveable { mutableStateOf(keyboardType != KeyboardType.Password) }
    val customTextSelectionColors = TextSelectionColors(
        handleColor = GreenMain,
        backgroundColor = GreenMain.copy(alpha = 0.4f)
    )
    CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
        OutlinedTextField(
            modifier = modifier,
            value = text,
            onValueChange = onTextChange,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (keyboardType == KeyboardType.Password && !isShowPassword) PasswordVisualTransformation() else VisualTransformation.None,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = outlineColor,
                unfocusedBorderColor = outlineColor,
                cursorColor = outlineColor,
                focusedLabelColor = Black,
                unfocusedLabelColor = Color.LightGray,

                ),
            label = { Text(placeHolder, style = bold16) },
            singleLine = true,
            textStyle = bold16

        )
    }


}

@Composable
fun ContainButton(
    modifier: Modifier = Modifier,
    text: String,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.defaultMinSize(
            minWidth = TextFieldDefaults.MinWidth,
            minHeight = 50.dp
        ),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = GreenMain)
    ) {
        Text(text = text, style = bold20, color = Color.White)
    }
}

@Composable
fun LoadingDialog() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorDialog(message: String) {
    var openDialog by remember { mutableStateOf(true) }
    if (openDialog) {
        AlertDialog(
            onDismissRequest = { },
            modifier = Modifier
                .padding(28.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            title = {
                Text(text = "SomeThing went wrong", style = bold16)

            },
            text = {
               Text(text = message, style = medium12)
            }, confirmButton = {
                TextButton(onClick = {
                    openDialog = false
                }) {
                    Text(text = "Confirm", color = GreenMain)
                }
            })
    }
}

@Preview
@Composable
fun preViewErrorDialog() {
    ErrorDialog(message = "Helloo")
}
