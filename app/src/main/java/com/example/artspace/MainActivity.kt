package com.example.artspace

import android.graphics.Picture
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.artspace.data.Artwork
import com.example.artspace.data.DataSource
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface {
                    val windowSize = calculateWindowSizeClass(this)
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(
    viewModel: ArtSpaceViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val artwork by viewModel.currentArtwork.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Picture(
            artwork = artwork,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        ArtworkInfo(
            artwork = artwork,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Buttons(
            onNextClick = { viewModel.nextArtwork() },
            onPreviousClick = { viewModel.previousArtwork() },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun Picture(
    artwork: Artwork,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 8.dp,
        modifier = modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = artwork.image),
            contentDescription = stringResource(id = artwork.name),
            modifier = Modifier
                .padding(32.dp)
                .size(400.dp)


        )
    }
}

@Composable
fun ArtworkInfo(
    artwork: Artwork,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color(0xFFECEBF4),
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(id = artwork.name),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = stringResource(id = artwork.author),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "(${artwork.year})",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun Buttons(
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier
                .padding(
                    end = 8.dp,
                    bottom = 40.dp
                )
                .width(150.dp)

        ) {
            Text(text = stringResource(id = R.string.previous))
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    bottom = 40.dp
                )
                .width(150.dp)
        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp(modifier = Modifier.fillMaxSize())
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    ArtSpaceTheme {
        Buttons(
            {},
            {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkInfoPreview() {
    ArtSpaceTheme {
        ArtworkInfo(artwork = DataSource.artworks[0])
    }
}

@Preview(showBackground = true)
@Composable
fun PicturePreview() {
    ArtSpaceTheme {
        Picture(
            artwork = DataSource.artworks[0],
            modifier = Modifier.size(200.dp)
        )
    }
}