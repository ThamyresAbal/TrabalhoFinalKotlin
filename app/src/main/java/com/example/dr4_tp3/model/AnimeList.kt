package com.example.dr4_tp3.model

class AnimeList (
    var data: List<Attributes>

) {
    class Attributes (
        var attributes: Xyz
    )
    class Xyz(
        var createdAt: String,
        var slug: String
    )
}