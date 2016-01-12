#!/usr/bin/env groovy

def timeStart = new Date()



/*



*/

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




// #####################################################
// #	END CODE BLOCK # DO NOT PUT CODE BELOW HERE    #
// #####################################################
def duration = groovy.time.TimeCategory.minus(new Date(), timeStart)
p "Script duration is: ${duration}"
