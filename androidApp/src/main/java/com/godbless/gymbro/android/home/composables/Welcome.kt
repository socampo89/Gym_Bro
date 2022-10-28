package com.godbless.gymbro.android.home.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.godbless.gymbro.android.R
import com.godbless.gymbro.helpers.DateTimeUtil
import com.godbless.gymbro.user.domain.entity.User

@Composable
fun Welcome(welcomeText : String, user : User?, modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_large))
            .fillMaxSize()
    ) {
        Text(
            style = MaterialTheme.typography.subtitle2,
            text = buildString {
            append(welcomeText)
            user?.let {
                append(" ")
                append(user.firstName)
                append("!")
            }
        })
    }
}

@Preview
@Composable
fun DefaultPreview(){
    Welcome(welcomeText = "Hola",
        user = User(1, "Sergio", "Ocampo", "sergio@gmail.com", true, DateTimeUtil.now()), modifier = Modifier)
}