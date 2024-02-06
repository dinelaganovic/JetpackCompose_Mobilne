package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Scaffold
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Canvas
import androidx.compose.material.icons.filled.FlipCameraAndroid
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.ui.geometry.Offset

class MainActivity : ComponentActivity() {
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
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = null,
            tint = Color.Blue,  // Plava boja za ikonu pretrage
            modifier = Modifier.size(24.dp)
        )

        // Tekst sredina
        Box(
            modifier = Modifier
                .weight(2f)
                .background(color = Color.White)
                .padding(8.dp)
        ) {
            Text(
                text = "NOW PLAYING",
                color = Color.Blue,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        }

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
fun PinkBar(
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
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            tint = Color.Magenta,  // Plava boja za ikonu pretrage
            modifier = Modifier.size(24.dp)
        )

        // Tekst sredina
        Box(
            modifier = Modifier
                .weight(2f)
                .background(color = Color.White)
                .padding(8.dp)
        ) {
            Text(
                text = "Song Title 01",
                color = Color.Magenta,
                style = TextStyle(fontSize = 25.sp),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        }

        // Druga ikona (više opcija)
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = Color.Magenta,  // Plava boja za ikonu više opcija
            modifier = Modifier
                .size(24.dp)
        )
    }
}
@Composable
fun TextWithText(
    modifier: Modifier = Modifier,
    spaceBetween: Int = 220, // Prilagodite razmak prema potrebi
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Tekst uz levu stranu
        Text(
            text = "22:02",
            modifier = Modifier.weight(1f)
        )

        // Razmak između tekstova
        Spacer(modifier = Modifier.width(spaceBetween.dp))

        // Tekst uz desnu stranu
        Text(
            text = "22:28",
            modifier = Modifier.weight(1f)
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
                .size(280.dp)  // Povećajte veličinu slike prema potrebi
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
fun LineWithCircle(
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = 16.dp
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp) // Prilagodite visinu linije prema potrebi
            .padding(start = horizontalPadding, end = horizontalPadding)
    ) {
        val lineHeight = size.height / 2f
        val lineColor = Color.Magenta
        val circleColor = Color.Magenta
        val circleRadius = 10.dp.toPx()

        // Crtanje linije
        drawLine(
            start = Offset(0f, lineHeight),
            end = Offset(size.width, lineHeight),
            color = lineColor,
            strokeWidth = 2.dp.toPx()
        )

        // Crtanje kruga na 80% dužine linije
        val circleX = size.width * 0.8f
        drawCircle(
            color = circleColor,
            radius = circleRadius,
            center = Offset(circleX, lineHeight)
        )
    }
}



@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(6.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        AlignYourBodyElement(R.drawable.m1back, R.string.ab1m_inversions, modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
        Spacer(Modifier.height(13.dp))
        PinkBar()
        Spacer(Modifier.height(8.dp))
        TextWithText()
        LineWithCircle()
        Spacer(Modifier.height(18.dp))
        BlueRoundedTopBox()
    }
}

@Composable
fun BlueRoundedTopBox(
    modifier: Modifier = Modifier,
    height: Dp = 150.dp // Prilagodite visinu prema potrebi
) {
    Box(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .background(
                color = Color(0xFF0066CC),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(Modifier.height(10.dp))
            ThreeIconsRow(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(20.dp)) // Prilagodite razmak između redova prema potrebi
            TwoIconsWithSpacing(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}


@Composable
fun ThreeIconsRow(
    modifier: Modifier = Modifier,
    iconSize: Dp = 68.dp,
    iconSpacing: Dp = 16.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(iconSpacing),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Prva ikonica
        Icon(
            imageVector = Icons.Default.SkipPrevious,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(iconSize)
        )

        // Druga ikonica
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(iconSize)
        )

        // Treća ikonica
        Icon(
            imageVector = Icons.Default.SkipNext,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(iconSize)
        )
    }
}
@Composable
fun TwoIconsWithSpacing(
    modifier: Modifier = Modifier,
    iconSize: Dp = 25.dp, // Prilagodite veličinu ikonica prema potrebi
    spacing: Dp = 270.dp // Prilagodite razmak između ikonica prema potrebi
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconModifier = Modifier.padding(start = 8.dp)
        // Prva ikonica
        Icon(
            imageVector = Icons.Default.FlipCameraAndroid,
            contentDescription = null,
            tint = Color.White,
            modifier = iconModifier.size(iconSize)
        )

        // Druga ikonica
        Icon(
            imageVector = Icons.Default.Repeat,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(iconSize)
        )
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
fun AlignYourBodyElementPreview() {
    MyApplicationTheme {
        AlignYourBodyElement(
            text = R.string.ab1_inversions,
            drawable = R.drawable.m1back,
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
@Preview
@Composable
fun PinkPreview() {
    MyApplicationTheme {
        PinkBar()
    }
}
@Preview
@Composable
fun PinkkPreview() {
    MyApplicationTheme {
        LineWithCircle()
    }
}
@Preview
@Composable
fun TextPreview() {
    MyApplicationTheme {
        TextWithText()
    }
}
@Preview
@Composable
fun BoxxPreview() {
    MyApplicationTheme {
        BlueRoundedTopBox(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}
