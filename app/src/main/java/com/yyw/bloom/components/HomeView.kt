package com.yyw.bloom.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yyw.bloom.R
import com.yyw.bloom.data.ImageItem
import com.yyw.bloom.data.gardens
import com.yyw.bloom.data.themes
import com.yyw.bloom.ui.theme.BloomTheme

@Composable
fun HomeView() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column {
            val (searchText, setSearchText) = remember {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.height(40.dp))
            SearchBar(searchText, setSearchText, "Search")
            BrowseThemes()
            GardensView()
        }
    }
}

@Composable
fun SearchBar(text: String = "", onValueChange: (String) -> Unit = {}, hintText: String = "Search") {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(text = hintText, style = MaterialTheme.typography.body1) },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        textStyle = MaterialTheme.typography.body1,
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search icon", modifier = Modifier.size(18.dp))
        }
    )
}

@Composable
fun BrowseThemes() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        BrowsTitle()
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalThemeList()
    }
}

@Composable
fun BrowsTitle() {
    Text(text = "Browse themes", style = MaterialTheme.typography.h1, modifier = Modifier.paddingFromBaseline(top = 32.dp))
}

@Composable
fun HorizontalThemeList(data: List<ImageItem> = themes) {
    LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(data) { imageItem ->
            ThemeItem(imageItem.name, imageItem.resId)
        }
    }
}

@Composable
fun ThemeItem(subtitle: String = "Desert chic", resId: Int = R.mipmap.desert_chic) {
    Card(shape = MaterialTheme.shapes.small, modifier = Modifier.size(136.dp)) {
        Column {
            Image(
                painter = painterResource(id = resId),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f),
                contentScale = ContentScale.Crop
            )
            Text(
                text = subtitle,
                modifier = Modifier
                    .weight(2f)
                    .paddingFromBaseline(top = 26.dp)
                    .padding(start = 16.dp),
                style = MaterialTheme.typography.h2
            )
        }
    }
}

@Composable
fun GardensView() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        GardenTitle()
        GardenList()
    }
}

@Composable
fun GardenTitle() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Design your home garden",
            modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 16.dp),
            style = MaterialTheme.typography.h1
        )
        Icon(imageVector = Icons.Outlined.FilterList, contentDescription = null, modifier = Modifier.size(24.dp))
    }
}

@Composable
fun GardenList(data: List<ImageItem> = gardens) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = data, key = { item -> item.id }) { item ->
            GardenItem(item)
        }
    }
}

@Composable
fun GardenItem(imageItem: ImageItem = ImageItem(0, "Monstera", R.mipmap.monstera)) {
    Row(modifier = Modifier.height(64.dp)) {
        Image(
            painter = painterResource(id = imageItem.resId),
            contentDescription = imageItem.name,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = imageItem.name,
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        text = "This is a description",
                        style = MaterialTheme.typography.body1
                    )
                }
                Checkbox(
                    checked = imageItem.selector, onCheckedChange = {}, modifier = Modifier
                        .size(24.dp)
                        .padding(top = 24.dp)
                )
            }
            Divider(modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreSearchBar() {
    BloomTheme {
        SearchBar()
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreBrowseThemes() {
    BloomTheme {
        BrowseThemes()
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreGardensView() {
    BloomTheme {
        GardensView()
    }
}

@Preview(device = Devices.PIXEL)
@Composable
fun PreHomeView() {
    BloomTheme {
        HomeView()
    }
}