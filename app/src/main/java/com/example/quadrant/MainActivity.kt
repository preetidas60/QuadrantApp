package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            QuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}




@Composable
fun QuadrantScreen(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row (
            modifier = Modifier.weight(1f)
        ){
            Quadrant(
                title = stringResource(R.string.text_composable),
                description = stringResource(R.string.text_composable_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFD9C6EC),
            )

            Quadrant(
                title = stringResource(R.string.image_composable),
                description = stringResource(R.string.image_composable_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFBEA6E7),
            )
        }

        Row (
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                title = stringResource(R.string.row_composable),
                description = stringResource(R.string.row_composable_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFA588DA),
            )

            Quadrant(title = stringResource(R.string.column_composable),
                description = stringResource(R.string.column_composable_description),
                backgroundColor = Color(0xFFDACCF1),
                modifier = Modifier.weight(1f)
            )
        }
    }
}



@Composable
fun Quadrant(title : String,
             description : String,
             backgroundColor : Color,
             modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(text = description,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 12.dp, end = 12.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantTheme {
        QuadrantScreen()
    }
}