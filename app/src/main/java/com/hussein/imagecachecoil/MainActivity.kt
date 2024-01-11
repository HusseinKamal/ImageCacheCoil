package com.hussein.imagecachecoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.imageLoader
import coil.memory.MemoryCache
import com.hussein.imagecachecoil.ui.theme.ImageCacheCoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = "https://i.guim.co.uk/img/media/445a67342a185182deab1b22bac5d12237ae4e9d/0_160_6000_3600/master/6000.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=89ab40ca078a7a0e55bb2d96e76aa46d"
        setContent {
            ImageCacheCoilTheme {

                Column(modifier = Modifier.fillMaxSize() , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1280f / 847f)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        imageLoader.diskCache?.clear()
                        imageLoader.memoryCache?.clear()

                       /* imageLoader.diskCache?.remove(imageUrl)
                        imageLoader.memoryCache?.remove(MemoryCache.Key(imageUrl))*/
                    }) {
                        Text(text = "Clear Cache")
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageCacheCoilTheme {
        Greeting("Android")
    }
}