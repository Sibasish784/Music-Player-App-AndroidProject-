package it.vfsfitvnm.vimusic.ui.screens.settings

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import it.vfsfitvnm.vimusic.BuildConfig
import it.vfsfitvnm.vimusic.LocalPlayerAwareWindowInsets
import it.vfsfitvnm.vimusic.ui.components.themed.Header
import it.vfsfitvnm.vimusic.ui.styling.LocalAppearance
import it.vfsfitvnm.vimusic.utils.secondary

@ExperimentalAnimationApi
@Composable
fun About() {
    val (colorPalette, typography) = LocalAppearance.current
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .background(colorPalette.background0)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                LocalPlayerAwareWindowInsets.current
                    .only(WindowInsetsSides.Vertical + WindowInsetsSides.End)
                    .asPaddingValues()
            )
    ) {
        Header(title = "About") {
            BasicText(
                text = "v${BuildConfig.VERSION_NAME} by Sibasish, Milan, Soumya",
                style = typography.s.secondary
            )
        }

        SettingsEntryGroupText(title = "SOCIAL")

        SettingsEntry(
            title = "GitHub",
            text = "View the source code",
            onClick = {
                uriHandler.openUri("https://github.com/Sibasish784/Music-Player-App-AndroidProject-")
            }
        )

        SettingsEntry(
            title = "GitHub contribution",
            text = "View the Graph",
            onClick = {
                uriHandler.openUri("https://github.com/Sibasish784/Music-Player-App-AndroidProject-/graphs/contributors")
            }
        )
        SettingsGroupSpacer()

        SettingsEntryGroupText(title = "Connect Us")

        SettingsEntry(
            title = "Sibasish Padhy",
            text = "You will be redirected to Linkedin Profile",
            onClick = {
                uriHandler.openUri("https://www.linkedin.com/in/sibasish78666/")
            }
        )
        SettingsEntry(
            title = "Milan Jana",
            text = "You will be redirected to Linkedin Profile",
            onClick = {
                uriHandler.openUri("https://www.linkedin.com/in/milan-jana-460874218/")
            }
        )

        SettingsEntry(
            title = "Soumya Ranjan Nayak ",
            text = "You will be redirected to Linkedin Profile",
            onClick = {
                uriHandler.openUri("https://www.linkedin.com/in/soumya-ranjan-nayak-4612bb206/")
            }
        )

    }
}
