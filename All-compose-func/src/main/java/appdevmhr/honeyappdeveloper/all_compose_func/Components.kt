package appdevmhr.honeyappdeveloper.all_compose_func

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.twotone.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun editTextPassword(
    name: String,
    placeholder: String,
    label: String,
    imageVector: ImageVector = Icons.Rounded.Person,
    keyboardOptions: KeyboardType = KeyboardType.Text,
    oVC: (String) -> Unit
) {
    var visibility  by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = name,
        placeholder = { Text("Enter Your Name ") },
        onValueChange = oVC,
        label = { Text(text = label) },
        leadingIcon = { Icon(imageVector = imageVector, contentDescription = "Person") },

        keyboardOptions = KeyboardOptions(
            keyboardType = if (visibility) KeyboardType.Text else KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),

        trailingIcon = {
            Icon(
                imageVector =  if (visibility) Icons.TwoTone.Lock else Icons.Rounded.Edit,
                contentDescription = "Visibility", modifier = Modifier.clickable {
                    visibility = !visibility
                }
            )
        },
    )
}
