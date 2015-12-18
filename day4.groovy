#!/usr/bin/env groovy

/*

--- Day 4: The Ideal Stocking Stuffer ---

Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically forward-thinking little girls and boys.

To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5 hash is some
secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you must find Santa the lowest
positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.

For example:

If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes (000001dbbfa...),
and it is the lowest such number to do so.
If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes is 1048970; that is,
the MD5 hash of pqrstuv1048970 looks like 000006136ef....


--- Part Two ---

Now find one that starts with six zeroes.
*/



// import java.security.MessageDigest
key = 'ckczppom'

def generateMD5_A(String s){
    java.security.MessageDigest.getInstance("MD5").digest(s.bytes).encodeHex().toString()
}


def findTargetHash() {
	done = false
	count = 0
	hash = ''
	while(!done) {
		hash = generateMD5_A("${key}${count}")
		if (hash[0..target.length()-1] == target) {
			done = true
		} else {
			count ++		
		}
	}	
}

def printResults() {
	println "Target is: ${target}"
	println "\tHash is: ${hash}"
	println "\tFirst ${target.length()} are: ${hash[0..target.length()-1]}"
	println "\tAnswer is: ${count}"	
}

target = '00000'
findTargetHash()
printResults()

// Part 2
target = '000000'
findTargetHash()
printResults()








