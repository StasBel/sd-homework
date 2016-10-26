package ru.spbau.mit.belyaev

import org.junit.Test
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by belaevstanislav on 25.10.16.
 */

class TestBasics {
    private val RESOURCES_PATH = Paths.get("src/test/resources/ru/spbau/mit/belyaev")

    @Test
    fun testExample() {
        val shell = Shell(RESOURCES_PATH)
        assertEquals("Hello, world!\n", shell.execute("echo \"Hello, world!\""))
        shell.execute("FILE=example.txt")
        assertEquals("Some example text\n", shell.execute("cat \$FILE"))
        assertEquals("\t0\t3\t17\n", shell.execute("cat example.txt | wc"))
    }

    @Test
    fun testExit() {
        val shell = Shell()
        assertTrue(shell.execute("exit").isEmpty())
        assertTrue(shell.execute("exit exit | exit").isEmpty())
        assertEquals("321\n", shell.execute("echo 123 | exit | echo 321"))
        assertTrue(shell.execute("echo 123 | echo 321 | exit").isEmpty())
    }

    @Test
    fun testCat() {
        val shell = Shell(RESOURCES_PATH)
        assertEquals("Do in laughter securing smallest sensible no mr hastened. As perhaps proceed in in brandon of " +
                "limited unknown greatly. Distrusts fulfilled happiness unwilling as explained of difficult. " +
                "No landlord of peculiar ladyship attended if contempt ecstatic. Loud wish made on is am as " +
                "hard. Court so avoid in plate hence. Of received mr breeding concerns peculiar securing landlord. " +
                "Spot to many it four bred soon well to. Or am promotion in no departure abilities. Whatever " +
                "landlord yourself at by pleasure of children be.\n", shell.execute("cat test0.txt"))
        assertEquals("No in he real went find mr. Wandered or strictly raillery stanhill as.\n" +
                "Jennings appetite disposed me an at subjects an.\n" +
                "To no indulgence diminution so discovered mr apartments.\n" +
                "Are off under folly death wrote cause her way spite.\n" +
                "Plan upon yet way get cold spot its week.\n" +
                "Almost do am or limits hearts.\n" +
                "Resolve parties but why she shewing.\n" +
                "She sang know now how nay cold real case.\n", shell.execute("cat test1.txt"))
        assertEquals("", shell.execute("cat test2.txt"))
        assertEquals("111\n", shell.execute("cat test3.txt"))
        assertEquals("111\n\n", shell.execute("cat test4.txt"))
        assertEquals("111\n111\n\n", shell.execute("cat test3.txt test4.txt"))
    }

    @Test
    fun testEcho() {
        val shell = Shell()
        assertEquals("\n", shell.execute("echo \"\"''"))
        assertEquals("abc\n", shell.execute("echo abc"))
        assertEquals("/bin/bash\n", shell.execute("echo \$0"))
    }

    @Test
    fun testWc() {
        val shell = Shell(RESOURCES_PATH)
        assertEquals("\t0\t83\t515\n", shell.execute("wc test0.txt"))
        assertEquals("\t7\t69\t381\n", shell.execute("wc test1.txt"))
        assertEquals("\t0\t0\t0\n", shell.execute("wc test2.txt"))
        assertEquals("\t0\t1\t3\n", shell.execute("wc test3.txt"))
        assertEquals("\t2\t1\t5\n", shell.execute("wc test4.txt"))
    }

    @Test
    fun testPwd() {
        // seems to work just fine
        // val shell = Shell(RESOURCES_PATH)
        // assertEquals("/Users/belaevstanislav/IdeaProjects/sd-homework/src/test/resources/ru/spbau/mit/belyaev\n",
        //         shell.execute("pwd"))
    }

    @Test
    fun testAssign() {
        val shell = Shell()
        shell.execute("ABC=\"abra\"")
        shell.execute("CDF=cada")
        shell.execute("RTA='bra'")
        assertEquals("abracadabra\n", shell.execute("echo \$ABC\$CDF\$RTA"))
    }

    @Test
    fun testUnknown() {
        val shell = Shell()
        assertTrue(shell.execute("arch").let { s -> s == "i386\n" || s == "x86_64\n" })
    }

    @Test
    fun testQuotes() {
        val shell = Shell()
        assertEquals("/bin/bash\n", shell.execute("echo \$0"))
        assertEquals("/bin/bash\n", shell.execute("echo \"\$0\""))
        assertEquals("\$0\n", shell.execute("echo '\$0'"))
        assertEquals("\"\$0\"\n", shell.execute("echo '\"\$0\"'"))
        assertEquals("'/bin/bash'\n", shell.execute("echo \"'\$0'\""))
    }

    @Test
    fun testPipe() {
        val shell = Shell(RESOURCES_PATH)
        assertEquals("\t0\t1\t3\n", shell.execute("cat test3.txt | wc"))
        assertEquals("\t1\t3\t7\n", shell.execute("cat test3.txt | wc | wc"))
    }
}