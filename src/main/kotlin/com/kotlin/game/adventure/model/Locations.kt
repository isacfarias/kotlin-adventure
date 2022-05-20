package com.kotlin.game.adventure.model

import java.io.File

fun readLocationInfo(): Map<Int, Location> {

    val locations = mutableMapOf<Int, Location>();

    val locationsBig = ClassLoader.getSystemResource ("locations_big.txt");
    File(locationsBig.file).reader().forEachLine {
        val tokens = it.split("`");
        val location = Location(tokens[0].toInt(), tokens[1])
        locations[location.locationID] = location;
    }
    val directionsBig = ClassLoader.getSystemResource ("directions_big.txt");
    File(directionsBig.file).reader().forEachLine {
        val tokens = it.split(",");
        locations[tokens[0].toInt()]?.addExit(tokens[1], tokens[2].toInt())
    }

    return locations
}