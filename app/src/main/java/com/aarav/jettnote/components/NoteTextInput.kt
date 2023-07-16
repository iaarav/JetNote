package com.aarav.jettnote.components


import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import com.aarav.jettnote.ui.theme.PurpleGrey80


@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalComposeUiApi
@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = text,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color(0xFF018BFA),
            unfocusedBorderColor = Color.Gray,
            focusedBorderColor = Color(0xFF1994F7),
            textColor = Color.Black,
            containerColor = Color.Transparent
        ),
        onValueChange = onTextChange,
        label = { Text(label) },
        maxLines = maxLine,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )

}


@Composable
fun noteButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true
) {
    Button(
        modifier= Modifier,
        onClick = onClick,
        shape = CircleShape,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = PurpleGrey80
        )
    ) {
        Text(text = text)
    }

}
