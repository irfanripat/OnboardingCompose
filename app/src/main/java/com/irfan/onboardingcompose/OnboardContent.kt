package com.irfan.onboardingcompose

import androidx.annotation.DrawableRes

data class OnboardContent(
    val title: String,
    val subtitle: String,
    @DrawableRes val imageRes: Int
)

val onboardContents = listOf(
    OnboardContent(
        title = "Anywhere at anytimes",
        subtitle = "Stream your favorite tunes on the go at anytime with premium.",
        imageRes = R.drawable.image_1
    ),
    OnboardContent(
        title = "Listen ad free",
        subtitle = "Enjoy ad free listening and jam out to your favorites songs.",
        imageRes = R.drawable.image_2
    ),
    OnboardContent(
        title = "First month on us",
        subtitle = "Due to the current circumstances try the first month free on us",
        imageRes = R.drawable.image_3
    ),
)