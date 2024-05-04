package com.example.composefirst.ui.screen.coinScreen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefirst.domain.model.CoinsDataModel
import com.example.composefirst.ui.screen.coinScreen.component.TagItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination(navArgsDelegate = CoinsDataModel::class)
@Composable

fun CoinScreen(
    viewModel: CoinScreenViewModel,
    navigator: DestinationsNavigator,
) {
    Scaffold(
        modifier = Modifier.background(color=Color.Black),
       content =  {
           Box(modifier = Modifier
               .fillMaxSize()
               .background(color = Color.Black),
               content = {
                   if (viewModel.isLoading.value) {
                       CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                   }
                   if (viewModel.error.value.isNotBlank()) {
                       Text(
                           text = viewModel.error.value,
                           color = MaterialTheme.colorScheme.error,
                           textAlign = TextAlign.Center,
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(horizontal = 20.dp)
                               .align(Alignment.Center)
                       )
                   }

                   Column(
                       modifier = Modifier
                           .padding(16.dp)
                           .verticalScroll(state = rememberScrollState())
                   )
                   {
                       Row(
                           horizontalArrangement = Arrangement.SpaceBetween,
                           modifier = Modifier
                               .fillMaxWidth()
                       ) {
                           Text(
                               text = "1. ${viewModel.coinDetail?.name}",
                               fontSize = 16.sp,
                               fontWeight = FontWeight.Bold,
                               color = Color.White
                           )
                           Text(
                               text = if (viewModel.coinDetail?.isActive == true) "active" else "inactive",
                               color = Color.Green,
                               fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                           )
                       }

                       Spacer(modifier = Modifier.height(15.dp))
                       Text(text = "${viewModel.coinDetail?.description}", color = Color.White)
                       Spacer(modifier = Modifier.height(15.dp))
                       Text(
                           text = "Tags", fontSize = 16.sp,
                           fontWeight = FontWeight.Bold,
                           color = Color.White
                       )
                       Spacer(modifier = Modifier.height(15.dp))
                       FlowRow(
                           horizontalArrangement = Arrangement.spacedBy(12.dp),
                           verticalArrangement = Arrangement.spacedBy(10.dp),
                           content = {
                               viewModel.coinDetail?.tags?.forEach { item -> TagItem(tag = item.name) }
//
                           }
                       )
                   }
               }
           )

       }
    )
}