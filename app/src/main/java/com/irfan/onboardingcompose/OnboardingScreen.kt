package com.irfan.onboardingcompose

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.irfan.onboardingcompose.ui.theme.Blue
import com.irfan.onboardingcompose.ui.theme.Grey30
import com.irfan.onboardingcompose.ui.theme.Typography
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()
    val currentState = pagerState.currentPage
    val contents = onboardContents
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

        HorizontalPager(
            count = contents.size,
            modifier = Modifier.weight(1f),
            state = pagerState,
        ) { page ->
            OnboardPage(content = contents[page], position = page)
        }

        SliderIndicator(
            pageSize = contents.size,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(vertical = 16.dp),
            selectedPage = pagerState.targetPage
        )

        Button(
            onClick = {
                coroutineScope.launch {
                    if (currentState < contents.lastIndex) {
                        pagerState.animateScrollToPage(currentState + 1, 0f)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .padding(bottom = 48.dp)
                .height(58.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Blue),
            elevation = ButtonDefaults.elevation(1.dp, 4.dp, 0.dp),
        ) {
            val buttonText = stringResource(if (pagerState.targetPage != contents.lastIndex) R.string.action_continue else R.string.action_start)
            Crossfade(targetState = buttonText, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.button,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}

@Composable
fun SliderIndicator(modifier: Modifier = Modifier, pageSize: Int, selectedPage: Int) {
    Row(
        modifier = modifier.padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        (0 until pageSize).forEach { position ->
            val width by animateDpAsState(if (position == selectedPage) 16.dp else 8.dp)
            Box(
                modifier = Modifier
                    .height(8.dp)
                    .width(width)
                    .clip(CircleShape)
                    .background(if (position == selectedPage) Blue else Grey30)
            )
        }
    }
}

@Composable
fun OnboardPage(modifier: Modifier = Modifier, content: OnboardContent, position: Int) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        with(content) {
            Image(
                painter = painterResource(id = imageRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomEndPercent = if (position == onboardContents.lastIndex) 25 else 0,
                            bottomStartPercent = if (position == 0) 25 else 0
                        )
                    )
                    .background(Blue)
                    .padding(horizontal = 72.dp)
                    .weight(1f)
                    .align(CenterHorizontally),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                alignment = Center
            )

            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .padding(horizontal = 48.dp),
                textAlign = TextAlign.Center,
                style = Typography.h1
            )

            Text(
                text = subtitle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp)
                    .padding(top = 20.dp),
                textAlign = TextAlign.Center,
                style = Typography.body1,
                lineHeight = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardPagePreview() {
    OnboardPage(content = onboardContents[0], position = 0)
}