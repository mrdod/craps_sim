import kotlin.random.Random

enum class State {
    START,
    ON
}

enum class FieldState {
    BET1X,
    BET2X,
    BET3X,
    BET6X,
    BET5X,
    BET10X,
    BET7X,
    BET14X,
    BET10XEND
}

class OnNum(val myNumber: Int) {
    var state = State.START;

}

fun main() {
    // var state = State.START;
    // var bankroll = 1000;
    // var myBet = 10;
    // var onNumber: Int? = null;

    // var onNumPass = OnNum(-2);
    // var onNumCome = OnNum(-1);
    // var onNum04 = OnNum(4);
    // var onNum05 = OnNum(5);
    // var onNum06 = OnNum(6);
    // var onNum08 = OnNum(8);
    // var onNum09 = OnNum(9);
    // var onNum10 = OnNum(10);

    // val onNumList = listOf(onNumPass, onNumCome, onNum04, onNum05, onNum06, onNum08, onNum09, onNum10)

    // var rollNumber = 0;

    // var bucket_02 = 0;
    // var bucket_03 = 0;
    // var bucket_04 = 0;
    // var bucket_05 = 0;
    // var bucket_06 = 0;
    // var bucket_07 = 0;
    // var bucket_08 = 0;
    // var bucket_09 = 0;
    // var bucket_10 = 0;
    // var bucket_11 = 0;
    // var bucket_12 = 0;

    // val mybets: MutableList<Int> = mutableListOf()


    // while (true) {
    //     val di01: Int = Random.nextInt(1, 7)
    //     val di02: Int = Random.nextInt(1, 7)

    //     val myRandomValue = di01 + di02

    //     when (myRandomValue) {
    //         2 -> bucket_02++
    //         3 -> bucket_03++
    //         4 -> bucket_04++
    //         5 -> bucket_05++
    //         6 -> bucket_06++
    //         7 -> bucket_07++
    //         8 -> bucket_08++
    //         9 -> bucket_09++
    //         10 -> bucket_10++
    //         11 -> bucket_11++
    //         12 -> bucket_12++
    //     }



    //     if (rollNumber++ > 100) break;


    //     when (state) {
    //         State.START -> {
    //             if (myRandomValue == 7 || myRandomValue == 11) {
    //                 bankroll += myBet
    //             } else if (myRandomValue == 2 || myRandomValue == 12) {
    //                 bankroll -= myBet
    //             } else {
    //                 onNumber = myRandomValue
    //                 state = State.ON
    //             }
    //         }

    //         State.ON -> {
    //             if (myRandomValue == onNumber) {
    //                 // Win!
    //                 bankroll += myBet;
    //                 state = State.START
    //             } else if (myRandomValue == 7) {
    //                 // Loss!
    //                 bankroll -= myBet;
    //                 state = State.START
    //             }
    //         }
    //     }

    //     //print("num:$myRandomValue state:$state, ")
    // }
    // println()
    // println("distribution:")
    // println("02: $bucket_02")
    // println("03: $bucket_03")
    // println("04: $bucket_04")
    // println("05: $bucket_05")
    // println("06: $bucket_06")
    // println("07: $bucket_07")
    // println("08: $bucket_08")
    // println("09: $bucket_09")
    // println("10: $bucket_10")
    // println("11: $bucket_11")
    // println("12: $bucket_12")

    // println("my bank roll ended up being: $bankroll")

    //singleRollBets()
    dynastyStratStart()
    //onePassOneCome()
    //ironCross()
    //dontPass()
    //come68()
}

fun singleRollBets() {
    for (x in 1..150) {

        var prevMyRandomValue = 0;
        var state = State.START;
        var bankroll = 1000;
        val numOfRolls = 300;
        var myBet = 10;
        val oddsBet = 10;
        var onNumber: Int? = null;

        var onNumPass = OnNum(-2);
        var onNumCome = OnNum(-1);
        var onNum04 = OnNum(4);
        var onNum05 = OnNum(5);
        var onNum06 = OnNum(6);
        var onNum08 = OnNum(8);
        var onNum09 = OnNum(9);
        var onNum10 = OnNum(10);

        val onNumList = listOf(onNumPass, onNumCome, onNum04, onNum05, onNum06, onNum08, onNum09, onNum10)

        var rollNumber = 0;

        var bucket_02 = 0;
        var bucket_03 = 0;
        var bucket_04 = 0;
        var bucket_05 = 0;
        var bucket_06 = 0;
        var bucket_07 = 0;
        var bucket_08 = 0;
        var bucket_09 = 0;
        var bucket_10 = 0;
        var bucket_11 = 0;
        var bucket_12 = 0;

        val mybets: MutableList<Int> = mutableListOf()


        while (true) {
            val di01: Int = Random.nextInt(1, 7)
            val di02: Int = Random.nextInt(1, 7)

            val myRandomValue = di01 + di02

            when (myRandomValue) {
                2 -> bucket_02++
                3 -> bucket_03++
                4 -> bucket_04++
                5 -> bucket_05++
                6 -> bucket_06++
                7 -> bucket_07++
                8 -> bucket_08++
                9 -> bucket_09++
                10 -> bucket_10++
                11 -> bucket_11++
                12 -> bucket_12++
            }



            if (rollNumber++ > numOfRolls) break;

            // // Single Roll Bets
            // if (myRandomValue == 2 || myRandomValue == 12) {
            //     bankroll += (30 * myBet)
            //     bankroll -= (myBet * 3)
            // } else if (myRandomValue == 3 || myRandomValue == 11) {
            //     bankroll += (15 * myBet)
            //     bankroll -= (myBet * 3)
            // } else {
            //     bankroll -= (myBet * 4)
            // }

            when (state) {

                State.START -> {
                    if (myRandomValue == 7 || myRandomValue == 11) {
                        bankroll += myBet
                    } else if (myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12) {
                        bankroll -= myBet
                    } else {
                        onNumber = myRandomValue
                        state = State.ON
                    }
                }

                State.ON -> {

                    if ((myRandomValue == 6 && onNumber == 8) || (myRandomValue == 8 && onNumber == 6)) {
                        bankroll += (myBet * 7) / 6;
                    }

                    if (myRandomValue == onNumber) {
                        // Win!
                        bankroll += myBet;

                        // odds
                        // if(onNumber == 6 || onNumber == 8)
                        //   bankroll += calcOddsBet(myRandomValue, oddsBet)

                        state = State.START
                    } else if (myRandomValue == 7) {
                        // Loss!
                        bankroll -= myBet;

                        if (onNumber == 6 || onNumber == 8)
                        // 6/8 place
                            bankroll -= myBet;

                        // odds
                        // if(onNumber == 6 || onNumber== 8)
                        //   bankroll -= oddsBet;

                        state = State.START
                    }
                }
            }
            prevMyRandomValue = myRandomValue

            //print("num:$myRandomValue state:$state, ")
        }
        // println()
        // println("distribution:")
        // println("02: $bucket_02")
        // println("03: $bucket_03")
        // println("04: $bucket_04")
        // println("05: $bucket_05")
        // println("06: $bucket_06")
        // println("07: $bucket_07")
        // println("08: $bucket_08")
        // println("09: $bucket_09")
        // println("10: $bucket_10")
        // println("11: $bucket_11")
        // println("12: $bucket_12")

        //println("my bank roll ended up being: $$bankroll after $numOfRolls rolls @$$myBet per bet")
        println(bankroll)
    }
}

fun calcOddsBet(inputVal: Int, oddsBet: Int): Int {
    var retVal = 0;

    when (inputVal) {
        4, 10 -> retVal = oddsBet * 2
        5, 9 -> retVal = (oddsBet * 3) / 2
        6, 8 -> retVal = (oddsBet * 6) / 5
    }

    return retVal
}

class crapsWorkSpace {
    var bucket_02 = 0;
    var bucket_03 = 0;
    var bucket_04 = 0;
    var bucket_05 = 0;
    var bucket_06 = 0;
    var bucket_07 = 0;
    var bucket_08 = 0;
    var bucket_09 = 0;
    var bucket_10 = 0;
    var bucket_11 = 0;
    var bucket_12 = 0;

    var prevMyRandomValue = 0;
    var state = State.START;
    var bankroll = 1000;
    val numOfRolls = 300;
    var myBet = 10;
    val oddsBet = 10;
    var onNumber: Int? = null;
    var dynastyCounter = 0
    val dynastyCounterLimit = 1
    val passLineOnly = 0
    var onNumPass = OnNum(-2);
    var onNumCome = OnNum(-1);
    var onNum04 = OnNum(4);
    var onNum05 = OnNum(5);
    var onNum06 = OnNum(6);
    var onNum08 = OnNum(8);
    var onNum09 = OnNum(9);
    var onNum10 = OnNum(10);
    val onNumList = listOf(onNum04, onNum05, onNum06, onNum08, onNum09, onNum10)
    var myRandomValue = 0
    var rollNumber = 0;
}

fun dynastyStratStart() {


    var work = crapsWorkSpace()

    for (x in 1..300) {
        val di01: Int = Random.nextInt(1, 7)
        val di02: Int = Random.nextInt(1, 7)

        work.myRandomValue = di01 + di02

        when (work.myRandomValue) {
            2 -> work.bucket_02++
            3 -> work.bucket_03++
            4 -> work.bucket_04++
            5 -> work.bucket_05++
            6 -> work.bucket_06++
            7 -> work.bucket_07++
            8 -> work.bucket_08++
            9 -> work.bucket_09++
            10 -> work.bucket_10++
            11 -> work.bucket_11++
            12 -> work.bucket_12++
        }

        if (work.rollNumber++ > work.numOfRolls) break;

        dynastyStrat(work)
    }
}
fun dynastyStrat(work: crapsWorkSpace) {

    when (work.state) {

        State.START -> {
            if (work.myRandomValue == 7 || work.myRandomValue == 11) {
                work.bankroll += work.myBet
            } else if (work.myRandomValue == 2 || work.myRandomValue == 3 || work.myRandomValue == 12) {
                work.bankroll -= work.myBet
            } else {
                work.onNumber = work.myRandomValue
                work.state = State.ON
            }

            if (work.myRandomValue == 7) {
                for (num in work.onNumList) {
                    if (num.state == State.ON) {
                        // Loss
                        work.bankroll -= work.myBet
                        num.state = State.START
                    }
                }

                work.dynastyCounter = 0
            }
        }

        State.ON -> {
            if (work.myRandomValue == work.onNumber) {
                // Win!
                work.bankroll += work.myBet;

                work.state = State.START

                // if not a winner, and still room for dynasty, add move come
                if (work.dynastyCounter < work.dynastyCounterLimit) {
                    for (num in work.onNumList) {
                        if (num.myNumber == work.myRandomValue) {
                            num.state = State.ON
                            work.dynastyCounter++
                        }
                    }
                }

            } else if (work.myRandomValue == 7) {
                // Loss!
                work.bankroll -= work.myBet;
                work.onNumber = null;

                // come bet wins though
                if (work.dynastyCounter < work.dynastyCounterLimit) {
                    work.bankroll += work.myBet
                }

                work.state = State.START

                for (num in work.onNumList) {
                    if (num.state == State.ON) {
                        // Loss
                        work.bankroll -= work.myBet
                        num.state = State.START
                        work.dynastyCounter = 0
                    }
                }

            } else if ((work.myRandomValue == 2 || work.myRandomValue == 3 || work.myRandomValue == 12) && (work.dynastyCounter == 0 && work.passLineOnly == 0)) {
                //come box loses on craps
                work.bankroll -= work.myBet
            } else if (work.passLineOnly == 0) {
                if (work.myRandomValue == 11) {
                    // 11 only pays out if we have chips on the pass line
                    if(work.dynastyCounter < work.dynastyCounterLimit)
                    {
                        work.bankroll += work.myBet;
                    }
                } else {
                    // walk list for winner check for winner
                    for (num in work.onNumList) {
                        if (num.myNumber == work.myRandomValue && num.state == State.ON) {
                            num.state = State.START
                            work.dynastyCounter--;
                            work.bankroll += work.myBet
                        }
                    }

                    // if not a winner, and still room for dynasty, add move come
                    if (work.dynastyCounter < work.dynastyCounterLimit) {
                        for (num in work.onNumList) {
                            if (num.myNumber == work.myRandomValue) {
                                num.state = State.ON
                                work.dynastyCounter++
                            }
                        }

                    }
                }
            }
        }
    }
    work.prevMyRandomValue = work.myRandomValue

    //print("num:$myRandomValue state:$state, ")

    //println("current bankroll:$bankroll dice:$myRandomValue onnumber:$onNumber dynastyCounter:$dynastyCounter")

    //println("my bank roll ended up being: $$bankroll after $numOfRolls rolls @$$myBet per bet")
    println(work.bankroll)

    // println()
    // println("distribution:")
    // println("02: $bucket_02")
    // println("03: $bucket_03")
    // println("04: $bucket_04")
    // println("05: $bucket_05")
    // println("06: $bucket_06")
    // println("07: $bucket_07")
    // println("08: $bucket_08")
    // println("09: $bucket_09")
    // println("10: $bucket_10")
    // println("11: $bucket_11")
    // println("12: $bucket_12")
}

fun onePassOneCome() {
    var bucket_02 = 0;
    var bucket_03 = 0;
    var bucket_04 = 0;
    var bucket_05 = 0;
    var bucket_06 = 0;
    var bucket_07 = 0;
    var bucket_08 = 0;
    var bucket_09 = 0;
    var bucket_10 = 0;
    var bucket_11 = 0;
    var bucket_12 = 0;


    for (x in 1..100) {

        var state = State.START;
        var bankroll = 1000;
        val numOfRolls = 300;
        var myBet = 10;
        var comeVal :Int?= null;
        var onRollNum = 0;
        var onNumber: Int? = null;
        var dynastyCounter = 0
        var onNum04 = OnNum(4);
        var onNum05 = OnNum(5);
        var onNum06 = OnNum(6);
        var onNum08 = OnNum(8);
        var onNum09 = OnNum(9);
        var onNum10 = OnNum(10);

        val onNumList = listOf(onNum04, onNum05, onNum06, onNum08, onNum09, onNum10)

        var rollNumber = 0;



        while (true) {
            val di01: Int = Random.nextInt(1, 7)
            val di02: Int = Random.nextInt(1, 7)

            val myRandomValue = di01 + di02

            when (myRandomValue) {
                2 -> bucket_02++
                3 -> bucket_03++
                4 -> bucket_04++
                5 -> bucket_05++
                6 -> bucket_06++
                7 -> bucket_07++
                8 -> bucket_08++
                9 -> bucket_09++
                10 -> bucket_10++
                11 -> bucket_11++
                12 -> bucket_12++
            }



            if (rollNumber++ > numOfRolls) break;


            when (state) {

                State.START -> {
                    if (myRandomValue == 7 || myRandomValue == 11) {
                        bankroll += myBet
                    } else if (myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12) {
                        bankroll -= myBet
                    } else {
                        onNumber = myRandomValue
                        state = State.ON

                        if (comeVal == null) {
                            onRollNum = 0
                        }
                    }

                    if (myRandomValue == 7) {
                        for (num in onNumList) {
                            if (num.state == State.ON) {
                                // Loss
                                bankroll -= myBet
                                num.state = State.START
                            }
                        }
                    }
                }

                State.ON -> {

                    if (myRandomValue == onNumber) {
                        // Win!
                        bankroll += myBet;

                        state = State.START
                    } else if (myRandomValue == 7) {
                        // Loss!
                        bankroll -= myBet;

                        // Come bet
                        if (onRollNum == 0) {
                            bankroll += myBet
                        } else {
                            bankroll -= myBet
                        }
                        comeVal= null;

                        state = State.START
                    } else if (onRollNum == 0 && (myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12)) {
                        // Did one come try, got craps
                        bankroll -= myBet
                    } else if (onRollNum == 0 && myRandomValue == 11) {
                        bankroll += myBet
                    } else if (onRollNum > 0 &&  comeVal== myRandomValue) {
                        // we have a winner
                        bankroll += myBet
                        comeVal= null
                    } else if (onRollNum == 0) {
                        comeVal = myRandomValue
                    }

                    onRollNum++
                }
            }
            //print("num:$myRandomValue state:$state, ")
            //println("current bankroll:$bankroll dice:$myRandomValue onnumber:$onNumber onRollNum:$onRollNum comeVal:$comeVal")
        }
        println("$x final bankroll:$bankroll")
    }


// println()
// println("distribution:")
// println("02: $bucket_02")
// println("03: $bucket_03")
// println("04: $bucket_04")
// println("05: $bucket_05")
// println("06: $bucket_06")
// println("07: $bucket_07")
// println("08: $bucket_08")
// println("09: $bucket_09")
// println("10: $bucket_10")
// println("11: $bucket_11")
// println("12: $bucket_12")

    println()
}

fun ironCross() {
    var bucket_02 = 0;
    var bucket_03 = 0;
    var bucket_04 = 0;
    var bucket_05 = 0;
    var bucket_06 = 0;
    var bucket_07 = 0;
    var bucket_08 = 0;
    var bucket_09 = 0;
    var bucket_10 = 0;
    var bucket_11 = 0;
    var bucket_12 = 0;


    for (x in 1..150) {

        var state = State.START;
        var bankroll = 1000;
        val numOfRolls = 300;
        var myBet = 10;
        var comeVal :Int?= null;
        var onRollNum = 0;
        var onNumber: Int? = null;
        var dynastyCounter = 0
        var onNum04 = OnNum(4);
        var onNum05 = OnNum(5);
        var onNum06 = OnNum(6);
        var onNum08 = OnNum(8);
        var onNum09 = OnNum(9);
        var onNum10 = OnNum(10);
        var hitCounter = 0;

        val onNumList = listOf(onNum04, onNum05, onNum06, onNum08, onNum09, onNum10)

        var rollNumber = 0;



        while (true) {
            val di01: Int = Random.nextInt(1, 7)
            val di02: Int = Random.nextInt(1, 7)

            val myRandomValue = di01 + di02

            when (myRandomValue) {
                2 -> bucket_02++
                3 -> bucket_03++
                4 -> bucket_04++
                5 -> bucket_05++
                6 -> bucket_06++
                7 -> bucket_07++
                8 -> bucket_08++
                9 -> bucket_09++
                10 -> bucket_10++
                11 -> bucket_11++
                12 -> bucket_12++
            }



            if (rollNumber++ > numOfRolls) break;


            when (state) {

                State.START -> {
                    if (myRandomValue == 7 || myRandomValue == 11) {
                        bankroll += myBet
                    } else if (myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12) {
                        bankroll -= myBet
                    } else {
                        onNumber = myRandomValue
                        state = State.ON
                        hitCounter = 0
                    }
                }

                State.ON -> {
                    if (hitCounter < 2 ) {
                        when (myRandomValue) {
                            2, 12 -> {
                                //pay field
                                bankroll += myBet * 2
                                hitCounter++
                            }

                            3, 4, 5, 9, 10, 11 -> {
                                bankroll += myBet
                                hitCounter++
                            }

                            5,6,8 -> {
                                bankroll += myBet
                                hitCounter++
                            }

                            7 -> {
                                if (onNumber == 5 || onNumber == 6 || onNumber == 8) {
                                    bankroll -= myBet * 7
                                } else {
                                    bankroll -= myBet * 8
                                }

                                state = State.START
                            }

                        }
                    }
                    else if(myRandomValue == 7){
                        if (onNumber == 5 || onNumber == 6 || onNumber == 8) {
                            bankroll -= myBet * 2
                        } else {
                            bankroll -= myBet
                        }

                        state = State.START

                    }
                }
            }
            //print("num:$myRandomValue state:$state, ")
            //println("current bankroll:$bankroll dice:$myRandomValue onnumber:$onNumber hitcounter:$hitCounter")

        }

        println(bankroll)
    }


// println()
// println("distribution:")
// println("02: $bucket_02")
// println("03: $bucket_03")
// println("04: $bucket_04")
// println("05: $bucket_05")
// println("06: $bucket_06")
// println("07: $bucket_07")
// println("08: $bucket_08")
// println("09: $bucket_09")
// println("10: $bucket_10")
// println("11: $bucket_11")
// println("12: $bucket_12")

    println()
}




fun dontPass() {
    var bucket_02 = 0;
    var bucket_03 = 0;
    var bucket_04 = 0;
    var bucket_05 = 0;
    var bucket_06 = 0;
    var bucket_07 = 0;
    var bucket_08 = 0;
    var bucket_09 = 0;
    var bucket_10 = 0;
    var bucket_11 = 0;
    var bucket_12 = 0;


    for (x in 1..150) {

        var state = State.START;
        var bankroll = 1000;
        val numOfRolls = 300;
        var myBet = 10;
        var comeVal :Int?= null;
        var onRollNum = 0;
        var onNumber: Int? = null;
        var dynastyCounter = 0
        var comeCounter = 0
        var dontComeCounter = 0
        var onNum04 = OnNum(4);
        var onNum05 = OnNum(5);
        var onNum06 = OnNum(6);
        var onNum08 = OnNum(8);
        var onNum09 = OnNum(9);
        var onNum10 = OnNum(10);
        var onDontNum04 = OnNum(4);
        var onDontNum05 = OnNum(5);
        var onDontNum06 = OnNum(6);
        var onDontNum08 = OnNum(8);
        var onDontNum09 = OnNum(9);
        var onDontNum10 = OnNum(10);
        var hitCounter = 0;

        val onComeNumList = listOf(onNum04, onNum05, onNum06, onNum08, onNum09, onNum10)
        val onDontComeNumList = listOf(onDontNum04, onDontNum05, onDontNum06, onDontNum08, onDontNum09, onDontNum10)

        var rollNumber = 0;



        while (true) {
            val di01: Int = Random.nextInt(1, 7)
            val di02: Int = Random.nextInt(1, 7)

            val myRandomValue = di01 + di02

            when (myRandomValue) {
                2 -> bucket_02++
                3 -> bucket_03++
                4 -> bucket_04++
                5 -> bucket_05++
                6 -> bucket_06++
                7 -> bucket_07++
                8 -> bucket_08++
                9 -> bucket_09++
                10 -> bucket_10++
                11 -> bucket_11++
                12 -> bucket_12++
            }



            if (rollNumber++ > numOfRolls) break;


            when (state) {

                State.START -> {
                    if (myRandomValue == 7 || myRandomValue == 11) {
                        bankroll -= myBet
                    } else if (myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12) {
                        bankroll += myBet
                    } else {
                        onNumber = myRandomValue
                        state = State.ON
                        hitCounter = 0
                    }
                }

                State.ON -> {
                    if(myRandomValue == onNumber) {
                        bankroll -= myBet
                        state = State.START
                    } else if (myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12) {
                        // Do nothing
                    } else if (myRandomValue == 7){
                        // win
                        bankroll +=myBet
                        state = State.START
                    }

                    if(comeCounter < 2){
                        when( myRandomValue){
                            7,11 ->
                                bankroll+=myBet
                            2,3,12 ->
                                bankroll -= myBet
                        }
                    } else if(dontComeCounter < 1){
                        when( myRandomValue){
                            7,11 ->
                                bankroll-=myBet
                            2,3,12 ->
                                bankroll += myBet
                        }
                    }


                    // Process Come bets
                    for (num in onComeNumList) {
                        if (num.myNumber == myRandomValue) {
                            if(num.state == State.START && comeCounter < 2){
                                num.state = State.ON
                                comeCounter++
                            } else {
                                // number was already on, pay out
                                bankroll += myBet
                                num.state = State.START
                                comeCounter--
                            }
                        }
                    }

                    // Process dome come
                    for (num in onDontComeNumList) {
                        if (num.myNumber == myRandomValue) {
                            if(num.state == State.START && dontComeCounter < 1){
                                num.state = State.ON
                                dontComeCounter++
                            } else {
                                // number was already on, pay out
                                bankroll += myBet
                                num.state = State.START
                                dontComeCounter--
                            }
                        }
                    }

                }
            }
            //print("num:$myRandomValue state:$state, ")
            println("current bankroll:$bankroll dice:$myRandomValue onnumber:$onNumber hitcounter:$hitCounter")

        }

        println(bankroll)
    }


// println()
// println("distribution:")
// println("02: $bucket_02")
// println("03: $bucket_03")
// println("04: $bucket_04")
// println("05: $bucket_05")
// println("06: $bucket_06")
// println("07: $bucket_07")
// println("08: $bucket_08")
// println("09: $bucket_09")
// println("10: $bucket_10")
// println("11: $bucket_11")
// println("12: $bucket_12")

    println()
}

fun come68() {
    var bucket_02 = 0;
    var bucket_03 = 0;
    var bucket_04 = 0;
    var bucket_05 = 0;
    var bucket_06 = 0;
    var bucket_07 = 0;
    var bucket_08 = 0;
    var bucket_09 = 0;
    var bucket_10 = 0;
    var bucket_11 = 0;
    var bucket_12 = 0;


    for (x in 1..1) {

        var prevMyRandomValue = 0;
        var state = State.START;
        var bankroll = 1000;
        val numOfRolls = 300;
        var myBet = 10;
        val oddsBet = 10;
        var onNumber: Int? = null;
        var dynastyCounter = 0
        val dynastyCounterLimit = 6
        val passLineOnly = 0
        var onNumPass = OnNum(-2);
        var onNumCome = OnNum(-1);
        var onNum04 = OnNum(4);
        var onNum05 = OnNum(5);
        var onNum06 = OnNum(6);
        var onNum08 = OnNum(8);
        var onNum09 = OnNum(9);
        var onNum10 = OnNum(10);

        val onNumList = listOf(onNum04, onNum05, onNum06, onNum08, onNum09, onNum10)

        var rollNumber = 0;



        while (true) {
            val di01: Int = Random.nextInt(1, 7)
            val di02: Int = Random.nextInt(1, 7)

            val myRandomValue = di01 + di02

            when (myRandomValue) {
                2 -> bucket_02++
                3 -> bucket_03++
                4 -> bucket_04++
                5 -> bucket_05++
                6 -> bucket_06++
                7 -> bucket_07++
                8 -> bucket_08++
                9 -> bucket_09++
                10 -> bucket_10++
                11 -> bucket_11++
                12 -> bucket_12++
            }



            if (rollNumber++ > numOfRolls) break;


            when (state) {

                State.START -> {
                    if (myRandomValue == 7 || myRandomValue == 11) {
                        bankroll += myBet
                    } else if (myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12) {
                        bankroll -= myBet
                    } else {
                        onNumber = myRandomValue
                        state = State.ON
                    }

                    if (myRandomValue == 7) {
                        for (num in onNumList) {
                            if (num.state == State.ON) {
                                // Loss
                                bankroll -= myBet
                                num.state = State.START
                            }
                        }

                        dynastyCounter = 0
                    }
                }

                State.ON -> {
                    if (myRandomValue == onNumber) {
                        // Win!
                        bankroll += myBet;

                        state = State.START
                    } else if (myRandomValue == 7) {
                        // Loss!
                        bankroll -= myBet;
                        onNumber = null;

                        // come bet wins though
                        if (dynastyCounter < dynastyCounterLimit) {
                            bankroll += myBet
                        }

                        state = State.START

                        for (num in onNumList) {
                            if (num.state == State.ON) {
                                // Loss
                                bankroll -= myBet
                                num.state = State.START
                                dynastyCounter = 0
                            }
                        }

                    } else if ((myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12) && (dynastyCounter == 0 && passLineOnly == 0)) {
                        //come box loses on craps
                        bankroll -= myBet
                    } else if (passLineOnly == 0) {
                        var winnerFlag = false;
                        // walk list for winner check for winner
                        for (num in onNumList) {
                            if (num.myNumber == myRandomValue && num.state == State.ON) {
                                num.state = State.START
                                dynastyCounter--;
                                bankroll += myBet
                                winnerFlag = true;
                            }
                        }

                        // if not a winner, and still room for dynasty, add move come
                        if (!winnerFlag && dynastyCounter < dynastyCounterLimit) {
                            for (num in onNumList) {
                                if (num.myNumber == myRandomValue) {
                                    num.state = State.ON
                                    dynastyCounter++
                                }
                            }

                        }
                    }
                }
            }
            prevMyRandomValue = myRandomValue

            //print("num:$myRandomValue state:$state, ")

            println("current bankroll:$bankroll dice:$myRandomValue onnumber:$onNumber dynastyCounter:$dynastyCounter")
        }

        //println("my bank roll ended up being: $$bankroll after $numOfRolls rolls @$$myBet per bet")
        //println(bankroll)
    }

    // println()
    // println("distribution:")
    // println("02: $bucket_02")
    // println("03: $bucket_03")
    // println("04: $bucket_04")
    // println("05: $bucket_05")
    // println("06: $bucket_06")
    // println("07: $bucket_07")
    // println("08: $bucket_08")
    // println("09: $bucket_09")
    // println("10: $bucket_10")
    // println("11: $bucket_11")
    // println("12: $bucket_12")

    println()
}


fun field() {
    var bucket_02 = 0;
    var bucket_03 = 0;
    var bucket_04 = 0;
    var bucket_05 = 0;
    var bucket_06 = 0;
    var bucket_07 = 0;
    var bucket_08 = 0;
    var bucket_09 = 0;
    var bucket_10 = 0;
    var bucket_11 = 0;
    var bucket_12 = 0;


    for (x in 1..1) {

        var prevMyRandomValue = 0;
        var state = FieldState.BET1X
        var bankroll = 1000;
        val numOfRolls = 300;
        var myBet = 10;
        val oddsBet = 10;
        var onNumber: Int? = null;
        var dynastyCounter = 0
        val dynastyCounterLimit = 6
        val passLineOnly = 0
        var onNumPass = OnNum(-2);
        var onNumCome = OnNum(-1);
        var onNum04 = OnNum(4);
        var onNum05 = OnNum(5);
        var onNum06 = OnNum(6);
        var onNum08 = OnNum(8);
        var onNum09 = OnNum(9);
        var onNum10 = OnNum(10);

        val onNumList = listOf(onNum04, onNum05, onNum06, onNum08, onNum09, onNum10)

        var rollNumber = 0;



        while (true) {
            val di01: Int = Random.nextInt(1, 7)
            val di02: Int = Random.nextInt(1, 7)

            val myRandomValue = di01 + di02

            when (myRandomValue) {
                2 -> bucket_02++
                3 -> bucket_03++
                4 -> bucket_04++
                5 -> bucket_05++
                6 -> bucket_06++
                7 -> bucket_07++
                8 -> bucket_08++
                9 -> bucket_09++
                10 -> bucket_10++
                11 -> bucket_11++
                12 -> bucket_12++
            }

            // enum class FieldState {
            //     BET1X,
            //     BET2X,
            //     BET3X,
            //     BET6X,
            //     BET5X,
            //     BET10X,
            //     BET7X,
            //     BET14X,
            //     BET10XEND
            // }


            if (rollNumber++ > numOfRolls) break;

            // when(state){
            //     FieldState.BET1X ->
            //         when(myRandomValue){
            //             2,12 ->
            //
            //         }
            // }


             // when (state) {

             //     State.START -> {
             //         if (myRandomValue == 7 || myRandomValue == 11) {
             //             bankroll += myBet
             //         } else if (myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12) {
             //             bankroll -= myBet
             //         } else {
             //             onNumber = myRandomValue
             //             state = State.ON
             //         }

             //         if (myRandomValue == 7) {
             //             for (num in onNumList) {
             //                 if (num.state == State.ON) {
             //                     // Loss
             //                     bankroll -= myBet
             //                     num.state = State.START
             //                 }
             //             }

             //             dynastyCounter = 0
             //         }
             //     }

             //     State.ON -> {
             //         if (myRandomValue == onNumber) {
             //             // Win!
             //             bankroll += myBet;

             //             state = State.START
             //         } else if (myRandomValue == 7) {
             //             // Loss!
             //             bankroll -= myBet;
             //             onNumber = null;

             //             // come bet wins though
             //             if (dynastyCounter < dynastyCounterLimit) {
             //                 bankroll += myBet
             //             }

             //             state = State.START

             //             for (num in onNumList) {
             //                 if (num.state == State.ON) {
             //                     // Loss
             //                     bankroll -= myBet
             //                     num.state = State.START
             //                     dynastyCounter = 0
             //                 }
             //             }

             //         } else if ((myRandomValue == 2 || myRandomValue == 3 || myRandomValue == 12) && (dynastyCounter == 0 && passLineOnly == 0)) {
             //             //come box loses on craps
             //             bankroll -= myBet
             //         } else if (passLineOnly == 0) {
             //             var winnerFlag = false;
             //             // walk list for winner check for winner
             //             for (num in onNumList) {
             //                 if (num.myNumber == myRandomValue && num.state == State.ON) {
             //                     num.state = State.START
             //                     dynastyCounter--;
             //                     bankroll += myBet
             //                     winnerFlag = true;
             //                 }
             //             }

             //             // if not a winner, and still room for dynasty, add move come
             //             if (!winnerFlag && dynastyCounter < dynastyCounterLimit) {
             //                 for (num in onNumList) {
             //                     if (num.myNumber == myRandomValue) {
             //                         num.state = State.ON
             //                         dynastyCounter++
             //                     }
             //                 }

             //             }
             //         }
             //     }
             // }
            prevMyRandomValue = myRandomValue

            //print("num:$myRandomValue state:$state, ")

            println("current bankroll:$bankroll dice:$myRandomValue onnumber:$onNumber dynastyCounter:$dynastyCounter")
        }

        //println("my bank roll ended up being: $$bankroll after $numOfRolls rolls @$$myBet per bet")
        //println(bankroll)
    }

    // println()
    // println("distribution:")
    // println("02: $bucket_02")
    // println("03: $bucket_03")
    // println("04: $bucket_04")
    // println("05: $bucket_05")
    // println("06: $bucket_06")
    // println("07: $bucket_07")
    // println("08: $bucket_08")
    // println("09: $bucket_09")
    // println("10: $bucket_10")
    // println("11: $bucket_11")
    // println("12: $bucket_12")

    println()
}