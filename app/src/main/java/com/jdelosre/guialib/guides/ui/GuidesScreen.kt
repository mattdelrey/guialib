package com.jdelosre.guialib.guides.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jdelosre.guialib.R
import com.jdelosre.guialib.guides.viewmodel.GuidesViewModel
import com.jdelosre.guialib.ui.theme.GuiaLibTheme

@Composable
fun GuidesScreen(
    viewModel: GuidesViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState.collectAsState()
    Column {
        Text(
            text = stringResource(id = R.string.build_name),
            style = MaterialTheme.typography.titleMedium,
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(items = uiState.value.guides, key = { guide ->
                guide.getId() ?: ""
            }) { guide ->
                GuideCard(
                    guide = guide,
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 600)
@Composable
fun GuidesScreenPreview() {
    GuiaLibTheme {
        GuidesScreen()
    }
}