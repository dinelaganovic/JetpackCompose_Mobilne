package com.example.myapplication.viewstwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.viewstwo.ui.theme.MyApplicationTheme
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.myapplication.R


class View2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    MyApplicationTheme {
        Scaffold(
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Prva ikona (pretraga)
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            tint = Color.Blue,  // Plava boja za ikonu pretrage
            modifier = Modifier.size(24.dp)
        )

        // Sivi zaobljeni unos (input)
        BasicTextField(
            value = "",
            onValueChange = {}, // Postavite funkciju za rukovanje promenama vrednosti unutar inputa
            textStyle = LocalTextStyle.current.copy(color = Color.Black), // Boja teksta unutar inputa
            modifier = Modifier
                .weight(2f)
                .background(color = Color.Gray, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        // Druga ikona (više opcija)
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            tint = Color.Blue,  // Plava boja za ikonu više opcija
            modifier = Modifier
                .size(24.dp)
        )
    }
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(RectangleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(title),
            style = TextStyle(
                color = Color.Blue,
                fontSize = 20.sp,
            ),
            modifier = Modifier.padding(start = 16.dp)
        )

        // roze tekst ispod naslova
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "View more >",
                color = Color.Magenta,
                style = TextStyle.Default.copy(fontSize = 16.sp) // Prilagodite veličinu teksta prema potrebi
            )
        }

        content()
        Divider(
            color = Color.Gray,
            thickness = 2.dp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 9.dp) // Adjust the padding as needed
                .fillMaxWidth()
        )
    }
}


data class YourItemType(val drawable: Int, val text: Int)

val alignYourBodyData: List<YourItemType> = listOf(
    YourItemType(R.drawable.img1, R.string.ab1_inversions),
    YourItemType(R.drawable.img, R.string.ab2_inversions),
    YourItemType(R.drawable.img1, R.string.ab3_inversions),

    )
val alignYourBodyData1: List<YourItemType> = listOf(
    YourItemType(R.drawable.img, R.string.ab1_inversions),
    YourItemType(R.drawable.img1, R.string.ab2_inversions),
    YourItemType(R.drawable.img, R.string.ab3_inversions),
)
val alignYourBodyData2: List<YourItemType> = listOf(
    YourItemType(R.drawable.img1, R.string.ab1_inversions),
    YourItemType(R.drawable.img, R.string.ab2_inversions),
    YourItemType(R.drawable.img1, R.string.ab3_inversions),

    )

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(48.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

@Composable
fun AlignYourBodyRow1(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(48.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData1) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}
@Composable
fun AlignYourBodyRow2(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(48.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData2) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        Spacer(Modifier.height(60.dp))
        HomeSection(title = R.string.align_your_body1) {
            AlignYourBodyRow1()
        }
        Spacer(Modifier.height(60.dp))
        HomeSection(title = R.string.align_your_body2) {
            AlignYourBodyRow2()
        }
    }
}




@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
@Composable
fun ScreenContentPreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
    MyApplicationTheme {
        HomeSection(R.string.align_your_body) {
            AlignYourBodyRow()
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    MyApplicationTheme {
        AlignYourBodyElement(
            text = R.string.ab1_inversions,
            drawable = R.drawable.img,
            modifier = Modifier.padding(8.dp)
        )
    }
}
@Preview
@Composable
fun SearchBarPreview() {
    MyApplicationTheme {
        SearchBar()
    }
}