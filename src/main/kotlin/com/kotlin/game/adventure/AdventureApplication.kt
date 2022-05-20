package com.kotlin.game.adventure

import com.kotlin.game.adventure.model.Location
import com.kotlin.game.adventure.model.readLocationInfo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdventureApplication

fun main(args: Array<String>) {

	runApplication<AdventureApplication>(*args)

	val locations = readLocationInfo()
	var loc = 64

	while (true) {
		val location = locations[loc] ?: Location(0,
			                          "Sorry, something went wrong, so the game will terminate")

		println(location.description)
		if (location.locationID == 0) {
			break
		}

		println("Available exits are: ")
		location.exits.keys.forEach {
			print("$it, ")
		}

		val direction = readLine()?.uppercase() ?: "z"
		if (location.exits.containsKey(direction)) {
			loc = location.exits[direction]!!
		} else {
			print("You can't go in that direction")
		}
	}
}
