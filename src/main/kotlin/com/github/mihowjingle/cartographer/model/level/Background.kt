package com.github.mihowjingle.cartographer.model.level

enum class Background(val label: String, val description: String) {
    HW1_01("ez01", "Kharak"), // ez03 the same
    HW1_02("ez02", "Kharak System Outskirts"),
    HW1_04("ez04", "Great Wastelands (HW1)"),
    HW1_05("ez05", "Great Wastelands (HW1, closer to galaxy center)"),
    HW1_06("ez06", "Diamond Shoals"),
    HW1_07("ez07", "Gardens of Kadesh"),
    HW1_08("ez08", "Cathedral of Kadesh"),
    HW1_09("ez09", "Sea of Lost Souls"),
    HW1_10("ez10", "Supernova Station"),
    HW1_11("ez11", "Tenhauser Gate"),
    HW1_12("ez12", "Galactic Core"),
    HW1_13("ez13", "Karos Graveyard (HW1)"),
    HW1_14("ez14", "Bridge of Sighs"),
    HW1_15("ez15", "Chapel Perilous"),
    HW1_16("ez16", "Hiigara (HW1)"),
    HW2_01("m01", "Tanis"),
    HW2_02("m02", "Angel Moon"),
    HW2_03("m03", "Sarum"),
    HW2_04("m04", "Gehenna Outskirts"),
    HW2_05("m05", "Gehenna"),
    HW2_06("m06", "Karos Graveyard (HW2)"),
    HW2_07("m07", "Progenitor Foundry"),
    HW2_08("m08", "Dreadnaught Berth"),
    HW2_09("m09", "Counter-Attack / Lighthouse"),
    HW2_10("m10", "Great Wastelands (HW2)"), // m11 the same
    HW2_12("m12", "Thaddis Sabbah"),
    HW2_13("m13", "Balcora Gate"),
    HW2_14("m14", "Balcora"),
    HW2_15("m15", "Hiigara (HW2)");

    val dropdownLabel = "$label: $description"
    val thumbnailPath = "resources/backgrounds/$label.jpg"
}