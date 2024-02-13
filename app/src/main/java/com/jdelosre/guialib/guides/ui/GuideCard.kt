package com.jdelosre.guialib.guides.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jdelosre.guialib.network.entities.Guide
import com.jdelosre.guialib.ui.theme.GuiaLibTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuideCard(
    guide: Guide?,
) {
    OutlinedCard(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary
        ),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = guide?.name ?: "",
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = guide?.startDate ?: "",
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = guide?.endDate ?: "",
                style = MaterialTheme.typography.titleMedium,
            )
            if(guide?.venue?.city != null) {
                Text(
                    text = guide.venue.city,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            if(guide?.venue?.state != null) {
                Text(
                    text = guide.venue.state,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            // TODO ideally use a third party lib to show actual icons here
            if(guide?.iconUrl != null) {
                Text(
                    text = guide.iconUrl,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            if(guide?.url != null) {
                Text(
                    text = guide.url,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuideCardPreview() {
    GuiaLibTheme {
        GuideCard(Guide(name="Guide Name"))
    }
}