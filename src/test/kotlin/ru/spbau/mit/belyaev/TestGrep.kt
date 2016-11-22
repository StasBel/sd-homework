package ru.spbau.mit.belyaev

import org.junit.Test
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by belaevstanislav on 25.10.16.
 */

class TestGrep {
    private val RESOURCES_PATH = Paths.get("src/test/resources/ru/spbau/mit/belyaev")

    @Test
    fun testSimple() {
        val shell = Shell()
        assertEquals("aaa\n", shell.execute("echo aaa | grep \"aaa\""))
        assertEquals("aaa\n", shell.execute("echo aaa | grep -i \"aAa\""))
        assertEquals("aAa\n", shell.execute("echo aAa | grep -i \"aaa\""))
        assertEquals("aaa\n", shell.execute("echo aaa | grep -w \"aaa\""))
        assertEquals("", shell.execute("echo baaab | grep -w \"aaa\""))
        assertEquals("aaa\nccc\nbbb\n", shell.execute("echo \"aaa\nccc\nbbb\" | grep -A 2 \"aaa\""))
        assertEquals("aaa\n", shell.execute("echo \"aaa\" | grep \"a*\""))
        assertEquals("aaa\n", shell.execute("echo \"aaa\" | grep \"^aaa\$\""))
        assertEquals("23812248\n", shell.execute("echo \"23812248\" | grep \"[2-4]*8\""))
    }

    @Test
    fun testUsage() {
        val shell = Shell()
        assertTrue(shell.execute("grep").let { s -> s.startsWith("usage: grep") })
    }

    @Test
    fun testCombine() {
        val shell = Shell()
        assertEquals("", shell.execute("echo aaab | grep -iw \"AAa\""))
        assertEquals("aaa b\n", shell.execute("echo \"aaa b\" | grep -iw \"AAa\""))
        assertEquals(".aaa*( b\n", shell.execute("echo \".aaa*( b\" | grep -iw \"AAa\""))
        assertEquals("aaa\n", shell.execute("echo \"ccc\naaa\nbbb\" | grep -iw \"AAa\""))
        assertEquals("aaa\nbbb\n", shell.execute("echo \"ccc\naaa\nbbb\" | grep -A 1 -iw \"AAa\""))
        assertEquals("aaa\nbbb\n", shell.execute("echo \"ccc\naaa\nbbb\" | grep -iw -A 1 \"AAa\""))
        assertEquals("...aaa*&*\nbbb\n", shell.execute("echo \"ccc\n...aaa*&*\nbbb\" | grep -i -A 1 \"AAa\""))
        assertEquals("", shell.execute("echo \"ccc\n...aaab*&*\nbbb\" | grep -iw -A 1 \"AAa\""))
        assertEquals("ccc\n", shell.execute("echo \"aaa\nbbb\nccc\nddd\" | grep -A 2 -i \"bBB\" | grep -iw \"CCc\""))
    }

    @Test
    fun testFiles() {
        val shell = Shell(RESOURCES_PATH)
        assertEquals("Plan upon yet way get cold spot its week.\n",
                shell.execute("grep -i \"PlaN UpOn yet\" test1.txt"))
        assertEquals("Plan upon yet way get cold spot its week.\n" +
                "Almost do am or limits hearts.\n" +
                "Resolve parties but why she shewing.\n",
                shell.execute("grep -i -A 2 \"PlaN UpOn yet\" test1.txt"))
        assertEquals("She sang know now how nay cold real case\n",
                shell.execute("grep -i \"She [s|p]anG know nOw [h|hh|hhh]ow nay Cold reAl case\" test1.txt"))
    }
}