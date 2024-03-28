package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    UserCardList()
                }
            }
        }
    }
}
data class User(var userAvatar: Int,var userName: String,var userBio: String, var userDate: String)

@Composable
fun UserCard(user: User) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .size(width = 200.dp, height = 100.dp)
            .background(Color.White)
    ) {
        Box {
            Image(
                painter = painterResource(id = user.userAvatar),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(20.dp)
                    .clip(CircleShape)
            )
        }
        Column {
            Text(
                text = user.userName,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            )
            Text(text = user.userBio)
        }
        Text(text = user.userDate, modifier = Modifier.padding(15.dp), color = Color.Gray)
    }
}

@Composable
fun UserCardList() {
    Box {
        Column {
            val users = listOf<User>(
                User(R.drawable.useravatar1, "张坤鹏", "大师赛选手", "1 min ago"),
                User(R.drawable.useravatar2, "佟璐", "花枪王", "2 min ago"),
                User(R.drawable.useravatar3, "代勇", "大师赛选手", "3 min ago"),
                User(R.drawable.useravatar4, "杨帆", "光头选手", "4min ago"),
                User(R.drawable.useravatar5, "郑宇伯", "五百万冠军", "5min ago"),
                User(R.drawable.useravatar6, "楚秉杰", "大师赛选手", "6min ago"),
                User(R.drawable.useravatar7, "赵汝亮", "台球选手", "7min ago"),
            )
            repeat(users.size) { index ->
                UserCard(users[index])
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview(){
    MyApplicationTheme {
        UserCardList()
    }
}




