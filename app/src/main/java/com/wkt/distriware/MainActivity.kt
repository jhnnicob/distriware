package com.wkt.distriware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.wkt.distriware.ui.compose.NavGraph
import com.wkt.distriware.ui.theme.DistriwareTheme

/**
 * The main activity of the Distriware application.
 *
 * This activity serves as the entry point for the application and hosts the main UI components.
 * It extends the [ComponentActivity] class and is responsible for initializing the app's content and UI.
 *
 * ## Usage
 *
 * To use the `MainActivity`, add it to your app's manifest file and ensure it is the launch activity.
 *
 * In the `onCreate` method, the activity sets the content view using the Compose API and applies the
 * `DistriwareTheme` to style the UI. It then creates a [Surface] with the specified [Modifier] and
 * background color from the [MaterialTheme.colorScheme], and finally, it displays the app's [NavGraph].
 *
 * ```kotlin
 * class MainActivity : ComponentActivity() {
 *     override fun onCreate(savedInstanceState: Bundle?) {
 *         super.onCreate(savedInstanceState)
 *         setContent {
 *             DistriwareTheme {
 *                 Surface(
 *                     modifier = Modifier.fillMaxSize(),
 *                     color = MaterialTheme.colorScheme.background
 *                 ) {
 *                     NavGraph()
 *                 }
 *             }
 *         }
 *     }
 * }
 * ```
 *
 * ## Remarks
 *
 * - The `MainActivity` should be declared in the app's manifest file with an intent filter specifying
 *   `android.intent.action.MAIN` and `android.intent.category.LAUNCHER` to make it the launch activity.
 * - The `DistriwareTheme` is a custom theme defined in the app that provides a consistent look and feel
 *   for the UI components.
 * - The `NavGraph` is a Compose UI component responsible for managing the app's navigation and displaying
 *   the appropriate screens based on the user's interaction.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DistriwareTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavGraph()
                }
            }
        }
    }
}