package com.example.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeexample.ui.compose.TestCardConstraint
import com.example.composeexample.ui.compose.TestCardLinear
import com.example.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val names = listOf(
            OS(
                name = "Android",
                description = "Android is a mobile operating system based on a modified version of the Linux kernel and other open source software, designed primarily for touchscreen mobile devices such as smartphones and tablets.",
                imageUrl = "https://i.pcmag.com/imagery/reviews/06fdvkyOgcsc4kzcSqhLmxB-12.1601663115.fit_scale.size_1028x578.png"
            ),
            OS(
                name = "iOS",
                description = "iOS (formerly iPhone OS) is a mobile operating system created and developed by Apple Inc. exclusively for its hardware. It is the operating system that powers many of the company's mobile devices, including the iPhone and iPod Touch; the term also included the versions running on iPads until the name iPadOS was introduced with version 13 in 2019.",
                imageUrl = "https://i2.wp.com/allhomecinema.com/wp-content/uploads/2020/12/iOS-7-10-Emblem.jpg?resize=1320%2C611&ssl=1"
            ),
            OS(
                name = "MacOs",
                description = "macOS is a proprietary graphical operating system developed and marketed by Apple Inc. since 2001. It is the primary operating system for Apple's Mac computers.",
                imageUrl = "https://www.muycomputer.com/wp-content/uploads/2020/11/macOS-Big-Sur.jpg"
            ),
            OS(
                name = "Windows",
                description = "Microsoft Windows, commonly referred to as Windows, is a group of several proprietary graphical operating system families, all of which are developed and marketed by Microsoft.",
                imageUrl = "https://3er1viui9wo30pkxh1v2nh4w-wpengine.netdna-ssl.com/wp-content/uploads/sites/41/2015/01/Windows10_logo_1024x512-960x512.png"
            ),
            OS(
                name = "Linux",
                description = "Linux is a family of open-source Unix-like operating systems based on the Linux kernel, an operating system kernel first released on September 17, 1991, by Linus Torvalds. Linux is typically packaged in a Linux distribution.",
                imageUrl = "https://www.muylinux.com/wp-content/uploads/2021/01/Linux.jpg"
            )
        )
        setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.LightGray) {
                    TestCardList(names)
                }
            }
        }
    }
}

@Composable
fun TestCardList(operatingSystems: List<OS>) {
    LazyColumn {
        items(operatingSystems) {
            TestCardConstraint(
                name = it.name,
                descriptionText = it.description,
                imageUrl = it.imageUrl
            )
        }
    }
}

@Preview
@Composable
fun TestCardList() {
    val names = listOf(
        OS(
            name = "Android",
            description = "Android is a mobile operating system based on a modified version of the Linux kernel and other open source software, designed primarily for touchscreen mobile devices such as smartphones and tablets.",
            imageUrl = "https://i.pcmag.com/imagery/reviews/06fdvkyOgcsc4kzcSqhLmxB-12.1601663115.fit_scale.size_1028x578.png"
        ),
        OS(
            name = "iOS",
            description = "iOS (formerly iPhone OS) is a mobile operating system created and developed by Apple Inc. exclusively for its hardware. It is the operating system that powers many of the company's mobile devices, including the iPhone and iPod Touch; the term also included the versions running on iPads until the name iPadOS was introduced with version 13 in 2019.",
            imageUrl = "https://i2.wp.com/allhomecinema.com/wp-content/uploads/2020/12/iOS-7-10-Emblem.jpg?resize=1320%2C611&ssl=1"
        ),
        OS(
            name = "MacOs",
            description = "macOS is a proprietary graphical operating system developed and marketed by Apple Inc. since 2001. It is the primary operating system for Apple's Mac computers.",
            imageUrl = "https://www.muycomputer.com/wp-content/uploads/2020/11/macOS-Big-Sur.jpg"
        ),
        OS(
            name = "Windows",
            description = "Microsoft Windows, commonly referred to as Windows, is a group of several proprietary graphical operating system families, all of which are developed and marketed by Microsoft.",
            imageUrl = "https://3er1viui9wo30pkxh1v2nh4w-wpengine.netdna-ssl.com/wp-content/uploads/sites/41/2015/01/Windows10_logo_1024x512-960x512.png"
        ),
        OS(
            name = "Linux",
            description = "Linux is a family of open-source Unix-like operating systems based on the Linux kernel, an operating system kernel first released on September 17, 1991, by Linus Torvalds. Linux is typically packaged in a Linux distribution.",
            imageUrl = "https://www.muylinux.com/wp-content/uploads/2021/01/Linux.jpg"
        )
    )
    TestCardList(operatingSystems = names)
}