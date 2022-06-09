package com.brickmate.houserepairingcompose.ui_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.brickmate.houserepairingcompose.ui.theme.AppTextStyle.bold16
import com.brickmate.houserepairingcompose.ui.theme.AppTextStyle.bold20
import com.brickmate.houserepairingcompose.ui.theme.Black
import com.brickmate.houserepairingcompose.ui.theme.Green200
import com.brickmate.houserepairingcompose.ui.theme.GreenMain

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