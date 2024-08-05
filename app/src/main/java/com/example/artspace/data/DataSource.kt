package com.example.artspace.data

import com.example.artspace.R

object DataSource {
    val artworks = listOf(
        Artwork(
            name = R.string.mono_lisa,
            author = R.string.leonardo_da_vinci,
            image = R.drawable.mona_lisa,
            year = 1517,
            location = R.string.louvre_museum,
        ),
        Artwork(
            name = R.string.guernica,
            author = R.string.pablo_picasso,
            image = R.drawable.guernica,
            year = 1937,
            location = R.string.museum_reina_sofia,
        ),
        Artwork(
            name = R.string.the_creation_of_adam,
            author = R.string.michelangelo_buonarroti,
            image = R.drawable.the_creation_of_adam,
            year = 1512,
            location = R.string.sistine_chapels_ceiling,
        ),
        Artwork(
            name = R.string.the_starry_night,
            author = R.string.vincent_van_gogh,
            image = R.drawable.the_starry_night,
            year = 1889,
            location = R.string.museum_of_modern_art,
        ),
        Artwork(
            name = R.string.the_scream,
            author = R.string.edvard_munch,
            image = R.drawable.the_scream,
            year = 1983,
            location = R.string.national_gallery,
        ),
    )
}