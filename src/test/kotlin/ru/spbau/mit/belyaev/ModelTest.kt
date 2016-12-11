package ru.spbau.mit.belyaev

import org.junit.Test
import ru.spbau.mit.belyaev.message.Proto
import ru.spbau.mit.belyaev.model.CommunicateException
import ru.spbau.mit.belyaev.model.Model
import java.util.concurrent.Executors
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * @author belaevstanislav
 */
class ModelTest {


    companion object {
        private val model = Model()
        private val TEST_MSG_1 = Proto.Message.newBuilder()
                .setTime(1481379743L)
                .setName("Stas")
                .setText("It's working!!!")
                .build()
        private val TEST_MSG_2 = Proto.Message.newBuilder()
                .setTime(1481379829L)
                .setName("Misha")
                .setText("No, it's not!!!")
                .build()
        private val threadPool = Executors.newCachedThreadPool()
    }

    @Test(expected = CommunicateException::class)
    fun test() {
        val future = threadPool.submit {
            val server = model.createServer(2222)
            val chatSocket = server.accept()
            chatSocket.sendMessage(TEST_MSG_1)
            assertTrue(chatSocket.isOpen(), "Checking if connection still open")
            assertTrue(TEST_MSG_2 == chatSocket.getMessage(), "Comparing messages")

            chatSocket.close()
            server.close()

            assertFalse(chatSocket.isOpen(), "Checking if connection breaks")
        }

        val client = model.createClient("localhost", 2222)
        val message = client.getMessage()
        assertTrue(client.isOpen(), "Checking if connection still open")
        assertTrue(TEST_MSG_1 == message, "Comparing messages")
        client.sendMessage(TEST_MSG_2)

        future.get()
        client.close()

        client.sendMessage(TEST_MSG_1)
    }
}