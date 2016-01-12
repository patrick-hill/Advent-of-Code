#!/usr/bin/env groovy

def timeStart = new Date()

/*

--- Day 9: All in a Single Night ---

Every year, Santa manages to deliver all of his presents in a single night.

This year, however, he has some new locations to visit; his elves have provided him the distances between every pair of locations. He can start and end at any two (different) locations he wants, but he must visit each location exactly once. What is the shortest distance he can travel to achieve this?

For example, given the following distances:

London to Dublin = 464
London to Belfast = 518
Dublin to Belfast = 141
The possible routes are therefore:

Dublin -> London -> Belfast = 982
London -> Dublin -> Belfast = 605
London -> Belfast -> Dublin = 659
Dublin -> Belfast -> London = 659
Belfast -> Dublin -> London = 605
Belfast -> London -> Dublin = 982
The shortest of these is London -> Dublin -> Belfast = 605, and so the answer is 605 in this example.

What is the distance of the shortest route?

*/

def day = 9
def towns = [:]

def p(def str, def useHeader = true, def newLine = true) {
	def msg
	if(useHeader) {
		msg = "*\n* ${str}\n*"
	} else {
		msg = str
	}
	if(newLine) {
		println msg
	} else {
		print msg
	}
}

def findRoutes(def townName) {
	// find all routes and then pick the shortest
	if( (towns.findAll { it.visited } ).size == 0 ) {
		return 0
	} else {
		
	}
}

new File("inputs/day${day}.txt").eachLine { line ->
	// Tristram to AlphaCentauri = 118
	
	def s = line.split(' ')
	def townName = s[0]
	def destTown = s[2]
	def destTownDist = s[4].toInteger()
	
	if(! towns[townName]) {
		towns[townName] = [ adjTowns: [:] ]
		towns[townName].adjTowns[destTown] = destTownDist 
	} else {
		// add adjacent town, if it doesnt exist
		if( !towns[townName].adjTowns[destTown] ) {
			towns[townName].adjTowns[destTown] = destTownDist
		}
	}
	
	// see if townDest has route to town (reverse route)
	if (! towns[destTown]) {
		towns[destTown] = [ adjTowns: [:] ]
		towns[destTown].adjTowns[townName] = destTownDist
	} else {
		if( !towns[destTown].adjTowns[townName] ) {
			towns[destTown].adjTowns[destTown] = destTownDist
		}
	}
	
}

towns.each { key, val ->
	println "Town ${key}"
	val.adjTowns.each { town, dist ->
		println "\tAdjacent Town: ${town}    Distance is: ${dist}"
	}
}







// #####################################################
// #	END CODE BLOCK # DO NOT PUT CODE BELOW HERE    #
// #####################################################
def duration = groovy.time.TimeCategory.minus(new Date(), timeStart)
p "Script duration is: ${duration}"
