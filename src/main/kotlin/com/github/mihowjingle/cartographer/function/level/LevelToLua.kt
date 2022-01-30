package com.github.mihowjingle.cartographer.function.level

import com.github.mihowjingle.cartographer.model.level.Level
import com.github.mihowjingle.cartographer.model.objects.Entity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Level.toLua() = with(StringBuilder()) {
    appendLine("-- Created/last edited in Homeworld Cartographer on $now")
    appendLine("-- by yours truly, $author")
    appendLine()
    appendLine("function DetermChunk()")
    optionallyAppendChunk(startingPositions)
    optionallyAppendChunk(asteroids)
    optionallyAppendChunk(clouds)
    optionallyAppendChunk(dustClouds)
    optionallyAppendChunk(nebulae)
    optionallyAppendChunk(salvage)
    optionallyAppendChunk(megaliths)
    appendLine("    setWorldBoundsInner({0.00, 0.00, 0.00}, {${size.x}, ${size.z}, ${size.y}})")
    appendLine("end")
    appendLine()
    appendLine("function NonDetermChunk()")
    optionallyAppendChunk(pebbles)
    appendFog(this)
    appendLine("    setGlareIntensity($glareIntensity)")
    appendLine("    setLevelShadowColour(${shadowColor.r}, ${shadowColor.g}, ${shadowColor.b}, ${shadowColor.a})")
    appendLine("    loadBackground(\"${background.label}\")")
    appendLine("    setSensorsManagerCameraDistances(${sensorsManagerCameraDistances.min}, ${sensorsManagerCameraDistances.max})")
    appendLine("    setDefaultMusic(\"${defaultMusic.path}\")")
    appendLine("    setBattleMusic(\"${battleMusic.path}\")")
    appendLine("end")
    appendLine()
    append(playersChunk)

    toString()
}

fun Level.appendFog(sb: StringBuilder) {
    if (fog.active) {
        sb.appendLine("    fogSetActive(1)")
        sb.appendLine("    fogSetStart(${fog.start})")
        sb.appendLine("    fogSetEnd(${fog.end})")
        sb.appendLine("    fogSetColour(${fog.color.r}, ${fog.color.g}, ${fog.color.b}, ${fog.color.a})")
        sb.appendLine("    fogSetType(\"linear\")")
        sb.appendLine("    fogSetDensity(${fog.density})")
    } else {
        sb.appendLine("    fogSetActive(0)")
    }
}

private val now get() = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))

private fun StringBuilder.optionallyAppendChunk(entities: List<Entity>) {
    if (entities.isNotEmpty()) {
        appendLine(chunk(entities))
    }
}

private fun chunk(entities: Iterable<Entity>): String {
    val sb = StringBuilder("")
    for (e in entities) {
        sb.append("    " + e.toLua() + "\n")
    }
    return sb.toString()
}

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
            if (i < maxPlayers - 1) {
                s.appendLine("\n")
            }
        }
        return s.toString()
    }
