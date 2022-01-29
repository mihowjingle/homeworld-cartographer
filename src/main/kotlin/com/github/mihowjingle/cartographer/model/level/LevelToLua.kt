package com.github.mihowjingle.cartographer.model.level

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val now get() = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"))

fun Level.toLua() =
"""
-- Created/last edited in Homeworld Cartographer on $now
-- by yours truly, $author

function DetermChunk()
    >>STARTING_POSITIONS<<
    
    >>ASTEROIDS<<
    
    >>CLOUDS_NEBULAE_ETC<<
    
    setWorldBoundsInner({0.00, 0.00, 0.00}, {${volume.x}, ${volume.z}, ${volume.y}})
end

function NonDetermChunk()
    >>PEBBLES<<

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

// todo starting positions, asteroids, dust clouds, nebulae, pebbles

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
            "fogSetActive(0)"
        }
    }
