import junit.framework.TestCase.assertEquals

class dynastyStratTest {

    @org.junit.jupiter.api.Test
    internal fun test_01() {

        class dataSet(val input :Int, val bankroll: Int, ){
        }

        class test01Data {
            val test01 = listOf(
                dataSet(7,1010),
                dataSet(11,1020),
                dataSet(2,1010),
                dataSet(3,1000),
                dataSet(12,990),
            );

        }


        val work = crapsWorkSpace();
        val data = test01Data();

        for( entry in data.test01 )
        {
            work.myRandomValue = entry.input
            dynastyStrat(work)
            assertEquals(entry.bankroll, work.bankroll)
            println("current bankroll:" + work.bankroll + " dice:" + work.myRandomValue + " onNumber: " + work.onNumber + " dynastyCounter:" + work.dynastyCounter )
        }

    }
}