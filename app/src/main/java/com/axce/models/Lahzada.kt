package com.axce.models

import java.io.Serializable

data class Toko(
    val id : Int = 0,
    val nama : String = "",
    val alamat: String = "",
    val no_tlp: String = ""
): Serializable

data class Item(
    val id: Int = 0,
    val nama: String = "",
    val harga: String = "",
    val id_toko: Int  = 0
)