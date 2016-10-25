package ru.spbau.mit.belyaev

import org.junit.Test
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by belaevstanislav on 25.10.16.
 */

class TestBasics {
    private val RESOURCES_PATH = Paths.get("./src/test/resources/ru/spbau/mit/belyaev")

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
    }

    @Test
    fun testEcho() {
        val shell = Shell()
        assertEquals("/bin/bash\n", shell.execute("echo \$0"))
    }

    @Test
    fun testWc() {

    }
}