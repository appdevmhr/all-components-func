package com.example.myapplication

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

interface func {
    @Composable
    fun ProfileAPP(modifier: Modifier) {

        Surface(modifier = modifier) {
            var data = ArrayList<ProfileData>()
            for (i in 0..200) {
                data.add(
                    ProfileData(
                        "Names",
                        "This is a description of your profile. Please check more deeply to make your account spelling current $i"
                    )
                )
            }

            PrintAllData(datw = data)
        }

    }

    @Composable
    fun SurvayAnswerApp() {
        SurvayAnswer(SurvayAnswerModel(R.drawable.ic_launcher_background, "Answer"))
    }

    @Composable
    fun write(data: ProfileData) {
        Row(modifier = Modifier.padding(5.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "profile", modifier = Modifier
                    .size(40.dp)
                    .border(
                        2.dp,
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.onError
                    )
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            var isExpend by remember {
                mutableStateOf(false)
            }
            val surfaceColor by animateColorAsState(if (isExpend) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)
            Surface(shadowElevation = 1.dp) {
                Column(modifier = Modifier.clickable {
                    isExpend = !isExpend
                })
                {
                    Text(text = data.name, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(5.dp))
                    Surface(

                        color = surfaceColor, shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .padding(10.dp)
                            .animateContentSize()
                            .padding(1.dp),
                    ) {
                        SelectionContainer {
                            Text(

                                text = data.desc,
                                color = MaterialTheme.colorScheme.error,
                                maxLines = if (isExpend) Int.MAX_VALUE else 1
                            )
                        }

                    }
                }
            }


        }
    }

    @Composable
    fun PrintAllData(datw: ArrayList<ProfileData>) {
        LazyColumn {
            items(datw) {
                write(data = it)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

    }

    @Composable
    fun SurvayAnswer(answer: SurvayAnswerModel) {
        Row {
            Image(
                painter = painterResource(id = answer.image),
                contentDescription = "Image", Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = answer.text)
            RadioButton(selected = false, onClick = { /*TODO*/ })
        }
    }


    @Composable
    fun GreetingAPP(modifier: Modifier) {

        Surface(modifier = modifier) {
            SetCard()
        }
    }

    @Composable
    fun SetCard(
        names: List<GreetingModel> = listOf(
            GreetingModel("Mahmudul Hasan"),
            GreetingModel("Abdur Rahman"),
            GreetingModel("Abdur Rahman"),
            GreetingModel("Abdur Rahman"),
            GreetingModel("Abdur Rahman"),
            GreetingModel("Abdur Rahman"),
            GreetingModel("Abdur Rahman"),
            GreetingModel("Abdur Rahman"),
            GreetingModel("Abdur Rahman"),
        )
    ) {
        Surface(color = MaterialTheme.colorScheme.onPrimaryContainer) {
            Column() {
                names.forEach {

                    GreetingCard(greetingModel = it)

                }
            }
        }
    }

    @Composable
    fun GreetingCard(greetingModel: GreetingModel) {

        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = 5.dp, vertical = 4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column() {
                    Text(text = "Hello,")
                    Text(text = greetingModel.name)
                }
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Show more", color = MaterialTheme.colorScheme.surface)
                }
            }
        }

    }

    @Composable
    fun Row_Column() {
        Column(modifier = Modifier.fillMaxSize()) {
            ProfileAPP(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            )
            GreetingAPP(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .verticalScroll(rememberScrollState())
            )
        }
    }

    @Composable
    fun ColumnScope.setColumn(weight: Float, color: Color = MaterialTheme.colorScheme.primary) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(weight), color = color
        ) {

        }
    }

    @Composable
    fun LoginScreen() {
        lOGINfoRM()
    }

    @Composable
    fun expendCard() {
        var expendable by remember {
            mutableStateOf(false)
        }
        ElevatedCard(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            )
            .clickable { expendable = !expendable }) {
            Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Center) {


                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "My Title",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.weight(4f)
                    )
                    Button(onClick = { expendable = !expendable }, modifier = Modifier.weight(2f)) {
                        Image(
                            painter = if (expendable)
                                painterResource(id = R.drawable.baseline_keyboard_arrow_up_24) else painterResource(
                                id = R.drawable.baseline_keyboard_arrow_down_24
                            ), contentDescription = "ArrowKey"
                        )
                    }
                }

                if (expendable) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "this is a learge text".repeat(20))

                }
            }


        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun lOGINfoRM() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var name: MutableState<String> = remember {
                mutableStateOf("")
            }
            var password: MutableState<String> = rememberSaveable {
                mutableStateOf("")
            }
            var email: MutableState<String> = remember {
                mutableStateOf("")
            }
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                contentAlignment = Alignment.Center
            ) {

                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = "https://yt3.ggpht.com/ytc/AGIKgqODmEjME03HwtK5TOfCyYNxUZefgyDqZ2YN6ySvimlcFyamAUQ_I3EkP2nLGFGV=s88-c-k-c0x00ffffff-no-rj-mo")
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.ic_launcher_background)
                            error(R.drawable.ic_launcher_background)
                            crossfade(300)
                            transformations(CircleCropTransformation())
                        }).build(), onLoading = {
                           Log.d("TAG", "lOGINfoRM: Loading")
                    }
                )
                val painterState = painter.state
                Image(painter = painter, contentDescription = "Image")

            }
            editText(name.value, "Enter Your Name", "Name") {
                name.value = it
            }

            editText(email.value, "Enter Your Email", "Email", Icons.Rounded.Email) {
                email.value = it
            }
            editTextPassword(password.value, "Enter Your Password", "Password", Icons.Rounded.Lock) {
                password.value = it
            }

            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }

        }

    }


    @Composable
    fun editText(
        name: String,
        placeholder: String,
        label: String,
        imageVector: ImageVector = Icons.Rounded.Person,
        keyboardOptions: KeyboardType = KeyboardType.Text,
        oVC: (String) -> Unit
    ) {
        OutlinedTextField(
            value = name,
            placeholder = { Text("Enter Your Name ") },
            onValueChange = oVC,
            label = { Text(text = label) },
            leadingIcon = { Icon(imageVector = imageVector, contentDescription = "Person") },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardOptions,
                imeAction = ImeAction.Next
            ),
        )
    }

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
                    painter =  painterResource(id = if (visibility) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                    contentDescription = "Visibility", modifier = Modifier.clickable {
                        visibility = !visibility
                    }
                )
            },
        )
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun PersonLazyColumn (){
        val person = PersonRepo()
        val getalldata = person.getAllData()
        LazyColumn(){
            getalldata.forEach{ person ->
              stickyHeader {
                    Text(text = person.id.toString(),fontSize = 20.sp,fontWeight = FontWeight.Bold)
              }
                items(getalldata){
                    personCard(person = person@it)
                }

            }
        }
    }

@Composable
fun personCard(person: Person){
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.secondary)
        .padding(20.dp)
        .fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
        Text(text = person.id.toString(),fontSize = 20.sp,fontWeight = FontWeight.Bold)
        Text(text = person.firstName+" "+person.lastName,fontSize = 20.sp,fontWeight = FontWeight.Bold)
        Text(text = person.age.toString(),fontSize = 20.sp,fontWeight = FontWeight.Bold)

    }
}

}