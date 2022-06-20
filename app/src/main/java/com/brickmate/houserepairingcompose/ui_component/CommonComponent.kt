package com.brickmate.houserepairingcompose.ui_component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.model.offer.Offer
import com.brickmate.houserepairingcompose.screen.theme.*
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.bold16
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.bold20
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.medium12
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.medium14
import com.brickmate.houserepairingcompose.util.TimeUtil.getDayAnTimeView
import com.brickmate.houserepairingcompose.util.loadStatusOffer
import com.brickmate.houserepairingcompose.util.offerDesireDate

@Composable
fun AppOutLineTextView(
    modifier: Modifier = Modifier,
    text: String,
    placeHolder: String,
    outlineColor: Color = Color.Black,
    isShowTrailingIcon: Boolean = false,
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false
) {
    val isShowPassword by rememberSaveable { mutableStateOf(keyboardType != KeyboardType.Password) }
    val focusRequester = remember { FocusRequester() }
    Column() {
        OutlinedTextField(
            modifier = modifier.focusRequester(focusRequester),
            value = text,
            onValueChange = {
                onTextChange.invoke(it)
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (keyboardType == KeyboardType.Password && !isShowPassword) PasswordVisualTransformation() else VisualTransformation.None,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = outlineColor,
                unfocusedBorderColor = outlineColor,
                cursorColor = outlineColor,
                focusedLabelColor = Black,
                unfocusedLabelColor = Color.LightGray,

                ),
            isError = isError,
            label = { Text(placeHolder, style = bold16) },
            singleLine = true,
            textStyle = bold16,
        )
        if (isError) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }

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
fun ErrorDialog(
    message: String,
    title: String = "Something went wrong",
    onConfirmClick: () -> Unit
) {
    var openDialog by remember { mutableStateOf(true) }
    if (openDialog) {
        AlertDialog(
            onDismissRequest = {

            },
            modifier = Modifier
                .padding(28.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            title = {
                Text(text = title, style = bold16)
            },
            text = {
                Text(text = message, style = medium12)
            }, confirmButton = {
                TextButton(onClick = {

                    onConfirmClick.invoke()
                }) {
                    Text(text = "Confirm", color = GreenMain)
                }
            })
    }
}

@Composable
fun TopToolBar(modifier: Modifier = Modifier, isShowHomeBtn: Boolean = false, title: String?) {

    Box(
        modifier = modifier
            .height(60.dp)

            .fillMaxWidth()
            .background(ToolbarBackGround)
            .padding(horizontal = 10.dp)
    ) {
        Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            if (isShowHomeBtn) {
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(id = R.drawable.ic_toolbar),
                    contentDescription = ""
                )
            }

        }

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            title?.let {
                Text(text = title, style = AppTextStyle.bold24, color = GreenMain)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemOffer(modifier: Modifier = Modifier, offerItem: Offer) {

    Card(
        modifier = Modifier
            .fillMaxWidth(), border = BorderStroke(1.dp, GreenMain), shape = RoundedCornerShape(5.dp), onClick = {

        }

    ) {
        offerItem.let { offerItem ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    offerItem.fullAddress?.let {
                        Text(text = it, style = AppTextStyle.medium14, color = Black, modifier= Modifier.weight(
                            0.7f
                        ))
                    }
                    offerItem.desiredDate?.let {
                        Text(
                            text = offerDesireDate(it),
                            style = AppTextStyle.medium12,
                            color = Black,
                            textAlign =TextAlign.Right,
                            modifier = Modifier.weight(0.3f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(0.6f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "수리요청", style = AppTextStyle.bold10, color = Gray100)
                        Spacer(modifier = Modifier.width(5.dp))
                        offerItem.category?.name?.let {
                            Text(
                                text = it,
                                style = AppTextStyle.bold10,
                                color = Gray100,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(size = 4.dp))
                                    .background(Gray10)
                                    .padding(horizontal = 5.dp, vertical = 5.dp)
                            )
                        }
                    }
                    Row(Modifier.weight(0.4f), verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.weight(1f))
                        offerItem.status?.let {
                            Text(text = loadStatusOffer(it, LocalContext.current).toString())
                        }

                    }


                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(0.6f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "접수시간", style = AppTextStyle.bold10, color = Gray100)
                        Spacer(modifier = Modifier.width(5.dp))
                        offerItem.createdAt?.let {
                            Text(
                                text = getDayAnTimeView(it),
                                style = AppTextStyle.bold10,
                                color = Gray100,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(size = 4.dp))
                                    .background(Gray10)
                                    .padding(horizontal = 5.dp, vertical = 5.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(0.4f))


                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(0.6f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "접수번호", style = AppTextStyle.bold10, color = Gray100)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = offerItem.id.toString(),
                            style = AppTextStyle.bold10,
                            color = Gray100,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(size = 4.dp))
                                .background(Gray10)
                                .padding(horizontal = 5.dp, vertical = 5.dp)
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.4f))


                }
            }
        }

    }
}

@Preview
@Composable
fun PreViewErrorDialog() {
    ErrorDialog(message = "Login Fail", onConfirmClick = {})

}

@Preview
@Composable
fun PreTopToolBar() {
    TopToolBar(title = "집수리 닷컴")

}


@Preview
@Composable
fun PreItemOffer() {
    ItemOffer(offerItem = Offer(fullAddress = "제목"))

}

