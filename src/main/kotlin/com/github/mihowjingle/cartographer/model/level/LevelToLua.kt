package com.github.mihowjingle.cartographer.model.level

import com.github.mihowjingle.cartographer.model.objects.Entity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val now get() = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"))

fun Level.toLua() =
"""
-- Created/last edited in Homeworld Cartographer on $now
-- by yours truly, $author

function DetermChunk()
$startingPositionsChunk

$asteroidsChunk

$cloudsChunk

$dustCloudsChunk

$nebulaeChunk

$salvageChunk

$megalithChunk

    setWorldBoundsInner({0.00, 0.00, 0.00}, {${volume.x}, ${volume.z}, ${volume.y}})
end

function NonDetermChunk()
$pebblesChunk

$fogChunk

    setGlareIntensity($glareIntensity)

    setLevelShadowColour(${shadowColor.r}, ${shadowColor.g}, ${shadowColor.b}, ${shadowColor.a})

    loadBackground("${background.label}")

    setSensorsManagerCameraDistances(${sensorsManagerCameraDistances.min}, ${sensorsManagerCameraDistances.max})

    setDefaultMusic("${defaultMusic.path}")
    setBattleMusic("${battleMusic.path}")
end

$playersChunk
"""

// todo investigate: clouds vs dust clouds vs nebulae

private fun chunk(entities: Iterable<Entity>): String {
    val sb = StringBuilder("")
    for (e in entities) {
        sb.append("    " + e.toLua() + "\n")
    }
    return sb.toString()
}

private val Level.startingPositionsChunk: String
    get() = chunk(startingPositions)

private val Level.asteroidsChunk: String
    get() = chunk(asteroids)

private val Level.pebblesChunk: String
    get() = chunk(pebbles)

private val Level.cloudsChunk: String
    get() = chunk(clouds)

private val Level.dustCloudsChunk: String
    get() = chunk(dustClouds)

private val Level.nebulaeChunk: String
    get() = chunk(nebulae)

private val Level.salvageChunk: String
    get() = chunk(salvage)

private val Level.megalithChunk: String
    get() = chunk(megaliths)

private fun playerChunk(index: Int): String {
    return """
        player[$index] = {
            id = $index,
            name = "",
            resources = 0,
            raceName = "Hiigaran",
            startPos = 1
        }
        
        
        """.trimIndent()
}

private val Level.playersChunk: String
    get() {
        val s = StringBuilder("maxPlayers = $maxPlayers\n\nplayer = {}\n\n")
        for (i in 0 until maxPlayers) {
            s.append(playerChunk(i))
        }
        return s.toString()
    }

private val Level.fogChunk: String
    get() {
        return if (fog.active) {
            """
                fogSetActive(1)
            	fogSetStart(${fog.start})
            	fogSetEnd(${fog.end})
            	fogSetColour(${fog.color.r}, ${fog.color.g}, ${fog.color.b}, ${fog.color.a})
            	fogSetType("linear")
            	fogSetDensity(${fog.density})
            """.replaceIndent("    ")
        } else {
            "    fogSetActive(0)"
        }
    }
