package com.github.mihowjingle.cartographer.model.level

private const val pathCommon = "data:sound/music/"

enum class Music(pathSuffix: String, val description: String) {
    HW1_AMBIENT_00("ambient/tutorial", "HW1 Tutorial"),
    HW1_AMBIENT_01("ambient/a01_mission1", "Kharak Ambient"),
    HW1_AMBIENT_02("ambient/a02_mission2and4", "Kharak Outskirts / Great Wastelands"),
    HW1_AMBIENT_03("ambient/a03_mission3and16", "Adagio"),
    HW1_AMBIENT_04("ambient/a04_mission5", "Great Wastelands (closer to galaxy center)"),
    HW1_AMBIENT_05("ambient/a05_mission6and12", "Diamond Shoals / Galactic Core"),
    HW1_AMBIENT_06("ambient/a06_mission7and8", "Kadesh"),
    HW1_AMBIENT_07("ambient/a07_mission9", "Sea of Lost Souls"),
    HW1_AMBIENT_08("ambient/a08_mission10", "Supernova Station"),
    HW1_AMBIENT_09("ambient/a09_mission11and15", "Tenhauser Gate / Chapel Perilous"),
    HW1_AMBIENT_10("ambient/a11_mission13", "Karos Graveyard (HW1)"),
    HW1_AMBIENT_11("ambient/a12_mission14", "Bridge of Sighs"),
    HW2_AMBIENT_01("ambient/amb_01", "Tanis"),
    HW2_AMBIENT_02("ambient/amb_02", "Angel Moon"),
    HW2_AMBIENT_03("ambient/amb_03", "Sarum"),
    HW2_AMBIENT_04("ambient/amb_04", "Gehenna Outskirts"),
    HW2_AMBIENT_05("ambient/amb_05", "Gehenna"),
    HW2_AMBIENT_06("ambient/amb_06", "Karos Graveyard (HW2)"),
    HW2_AMBIENT_07("ambient/amb_07", "Progenitor Foundry"),
    HW2_AMBIENT_08("ambient/amb_08", "Dreadnaught Berth"),
    HW2_AMBIENT_12("ambient/amb_12", "Thaddis Sabbah"),
    HW2_AMBIENT_13("ambient/amb_13", "Balcora Gate"),
    HW2_AMBIENT_14("ambient/amb_14", "Balcora"),
    STAGING_01("staging/staging_01", "Agnel Moon Transports / Original HW2 Menu"),
    STAGING_04("staging/staging_04", "Hyperspace Inhibitors"),
    STAGING_05("staging/staging_05", "Gehenna Staging"),
    STAGING_08("staging/staging_08", "Dreadnaught"),
    STAGING_11("staging/staging_11", "Bentusi! ;_;"),
    HW1_BATTLE_01("battle/b01_turanicraiderslong", "Turanic Raiders Battle"),
    HW1_BATTLE_02("battle/b03_swarmers", "Swarmers Battle"),
    HW1_BATTLE_03("battle/b04_evilempire", "Evil Empire Battle"),
    HW2_BATTLE_01("battle/battle_01", "Attack on Chimera Station / Tanis"),
    HW2_BATTLE_04("battle/battle_04", "Vaygr Battle"),
    HW2_BATTLE_04_ALT("battle/battle_04_alt", "Vaygr Battle (Alt)"),
    HW2_BATTLE_06("battle/battle_06", "Counter-Attack / Lighthouse Battle"),
    HW2_BATTLE_KEEPER("battle/battle_keeper", "The Keeper is aware!"),
    HW2_BATTLE_MOVER("battle/battle_movers", "Movers Battle"),
    HW2_BATTLE_PLANET_KILLERS("battle/battle_planetkillers", "Hiigara Planet-Killers"),
    HW2_BATTLE_SAJUUK("battle/battle_sajuuk", "Battle For Sajuuk"),
    HW2_BENTUS_ARRIVAL("battle/bentus_arrival", "Bentus Arrives (HW2, Sarum)");

    val path = pathCommon + pathSuffix
}