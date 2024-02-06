package com.example.myapplication.viewsthree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.viewsthree.ui.theme.MyApplicationTheme
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

class View3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    // A surface container using the 'background' color from the theme
    DualColorBackground()
}

@Composable
fun DualColorBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
        // .background(MaterialTheme.colorScheme.White)
    ) {
        // Blue background (Top 40%)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .background(Color(0xFF0066CC))
        )

        // Red line separator
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            drawLine(
                color = Color(0xFF88E91E63), // or Color.Magenta
                start = Offset(0f, size.height * 0.4f),
                end = Offset(size.width, size.height * 0.4f),
                strokeWidth = 2.dp.toPx()

            )
            drawCircle(
                color = Color(0xFF88E91E63),
                radius = 8 * 8.dp.toPx(), // Adjust the radius as needed
                center = Offset(size.width / 2, size.height * 0.4f)
            )
            drawCircle(
                color = Color.White,
                radius = 7 * 8.dp.toPx(), // Adjust the radius as needed
                center = Offset(size.width / 2, size.height * 0.4f)
            )
        }
        // ProfileImage()
        SearchBar()

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(44.dp)
                .offset(y = -118.dp)
                .offset(x = 29.dp)
                .align(Alignment.CenterStart)
                .padding(4.dp)
        )

        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            tint = Color(0xFFFF4081),
            modifier = Modifier
                .size(134.dp)
                .offset(y = -70.dp)
                .align(Alignment.Center)
        )
        Text(
            text = "Popular Playlists",
            color = Color(0xFF0066CC),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 22.sp), // Prilagodite veličinu fonta
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(y = 20.dp)
                .padding(start = 16.dp, end = 16.dp, bottom = 1.dp)
        )


        AlignYourBodyRow()
        AlignYourBodyRoww()

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(44.dp)
                .offset(y = -200.dp)
                .offset(x = 29.dp)
                .align(Alignment.BottomStart)
                .padding(4.dp)
        )
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(44.dp)
                .offset(y = -200.dp)
                .offset(x = 240.dp)
                .align(Alignment.BottomStart)
                .padding(4.dp)
        )

    }
}
data class YourItemType(val drawable: Int, val text: Int)

val alignYourBodyData: List<YourItemType> = listOf(
    YourItemType(R.drawable.img1, R.string.ab1m3_inversions),
    YourItemType(R.drawable.img, R.string.ab2m3_inversions),

    )
val alignYourBodyDatta: List<YourItemType> = listOf(
    YourItemType(R.drawable.img, R.string.ab1_inversions),
    YourItemType(R.drawable.img1, R.string.ab2_inversions),

    )
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(68.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .offset(y = 420.dp)
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}
@Composable
fun AlignYourBodyRoww(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(68.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .offset(y = 670.dp)
    ) {
        items(alignYourBodyDatta) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
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
                .size(148.dp)
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
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(horizontal = 26.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Spacer(modifier = Modifier.height(0.dp))

        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(34.dp)
        )

        Box(
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(8.dp)
        ) {
            Text(
                text = " ROCK",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(18.dp)
            )
        }
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(34.dp)
                .align(Alignment.CenterEnd)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        DualColorBackground()
    }
}