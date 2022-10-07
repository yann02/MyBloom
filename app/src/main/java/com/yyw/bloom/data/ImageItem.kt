package com.yyw.bloom.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.ui.graphics.vector.ImageVector
import com.yyw.bloom.R

data class ImageItem(val id: Int, val name: String, val resId: Int, val selector: Boolean = false)
data class NavItem(val name: String, val icon: ImageVector)

val navs = listOf(
    NavItem("Home", Icons.Filled.Home),
    NavItem("Favorites", Icons.Outlined.FavoriteBorder),
    NavItem("Profile", Icons.Filled.AccountCircle),
    NavItem("Cart", Icons.Filled.ShoppingCart)
)

val themes = listOf(
    ImageItem(0, "Desert chic", R.mipmap.desert_chic),
    ImageItem(1, "Tiny terrariums", R.mipmap.tiny_terrariums),
    ImageItem(2, "Jungle vibes", R.mipmap.jungle_vibes),
    ImageItem(3, "Easy care", R.mipmap.easy_care),
    ImageItem(4, "Statements", R.mipmap.statements)
)

val gardens = listOf(
    ImageItem(0, "Monstera", R.mipmap.monstera, true),
    ImageItem(1, "Aglaonema", R.mipmap.monstera),
    ImageItem(2, "Peace lily", R.mipmap.monstera),
    ImageItem(3, "Fiddle leaf", R.mipmap.monstera),
    ImageItem(4, "Snake plant", R.mipmap.monstera),
    ImageItem(5, "Pothos", R.mipmap.monstera)
)
