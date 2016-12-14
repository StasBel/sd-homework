package ru.spbau.mit.belyaev

import org.junit.Test
import ru.spbau.mit.belyaev.message.Proto
import ru.spbau.mit.belyaev.model.ChatListener
import ru.spbau.mit.belyaev.model.Model
import ru.spbau.mit.belyaev.model.Writer
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionService
import java.util.concurrent.ExecutorCompletionService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals

/**
 * @author belaevstanislav
 */
class ModelTest {
    companion object {
        private val TEST_UI_1 = Proto.UserInfo.newBuilder()
                .setName("Stas")
                .build()
        private val TEST_UI_2 = Proto.UserInfo.newBuilder()
                .setName("Misha")
                .build()
        private val TEST_MSG_1 = Proto.TextMessage.newBuilder()
                .setTime(1481379743L)
                .setText("It's working!!!")
                .build()
        private val TEST_MSG_2 = Proto.TextMessage.newBuilder()
                .setTime(1481379829L)
                .setText("No, it's not!!!")
                .build()
        private val TEST_TYPING = Proto.Typing.newBuilder().build()

        private val model = Model()
        private val threadPool = Executors.newCachedThreadPool()
    }

    private class TestChatListener : ChatListener {
        private val userInfoCount = AtomicInteger(0)
        private val lastUserInfo: CompletionService<Proto.UserInfo>
                = ExecutorCompletionService<Proto.UserInfo>(threadPool)

        fun getUserInfoCount(): Int = userInfoCount.get()

        fun getLastUserInfo(): Proto.UserInfo = lastUserInfo.take().get()

        private val textMessageCount = AtomicInteger(0)
        private val lastTextMessage: CompletionService<Proto.TextMessage>
                = ExecutorCompletionService<Proto.TextMessage>(threadPool)

        fun getTextMessageCount(): Int = textMessageCount.get()

        fun getLastTextMessage(): Proto.TextMessage = lastTextMessage.take().get()

        private val typingCount = AtomicInteger(0)
        private val lastTyping: CompletionService<Proto.Typing>
                = ExecutorCompletionService<Proto.Typing>(threadPool)

        fun getTypingCount(): Int = typingCount.get()

        fun getLastTyping(): Proto.Typing = lastTyping.take().get()

        private val onErrorCount = AtomicInteger(0)

        fun getOnErrorCount(): Int = onErrorCount.get()

        private val onCloseCount = AtomicInteger(0)

        fun getOnCloseCount(): Int = onCloseCount.get()

        override fun onUserInfo(userInfo: Proto.UserInfo) {
            userInfoCount.incrementAndGet()
            lastUserInfo.submit { userInfo }
        }

        override fun onMessage(textMessage: Proto.TextMessage) {
            textMessageCount.incrementAndGet()
            lastTextMessage.submit { textMessage }
        }

        override fun onTyping(typing: Proto.Typing) {
            typingCount.incrementAndGet()
            lastTyping.submit { typing }
        }

        override fun onError() {
            onErrorCount.incrementAndGet()
        }

        override fun onClose() {
            onCloseCount.incrementAndGet()
        }
    }

    @Test
    fun test() {
        val serverTestChatListener = TestChatListener()
        val clientTestChatListener = TestChatListener()

        val server = model.createServer(2223)
        val serverWriterFuture: CompletableFuture<Writer> = CompletableFuture()

        threadPool.submit {
            server.start(serverTestChatListener)
            val serverWriter = server.accept()
            serverWriterFuture.complete(serverWriter)

            serverWriter.sendTextMessage(TEST_MSG_1)
            assertEquals(TEST_MSG_1, clientTestChatListener.getLastTextMessage(), "Comparing test message's")

            serverWriter.notifyTyping(TEST_TYPING)
            assertEquals(TEST_TYPING, clientTestChatListener.getLastTyping(), "Comparing typing's")

            serverWriter.sendUserInfo(TEST_UI_2)
            assertEquals(TEST_UI_2, clientTestChatListener.getLastUserInfo(), "Comparing user info's")

            // wait
            while (true) {
            }
        }

        val client = model.createClient("localhost", 2223)
        val clientWriter = client.connect(clientTestChatListener)

        clientWriter.sendUserInfo(TEST_UI_1)
        assertEquals(TEST_UI_1, serverTestChatListener.getLastUserInfo(), "Comparing user info's")

        clientWriter.notifyTyping(TEST_TYPING)
        assertEquals(TEST_TYPING, serverTestChatListener.getLastTyping(), "Comparing typing's")

        clientWriter.sendTextMessage(TEST_MSG_2)
        assertEquals(TEST_MSG_2, serverTestChatListener.getLastTextMessage(), "Comparing test message's")

        // wait
        while (serverTestChatListener.getUserInfoCount() != 1
                || clientTestChatListener.getTextMessageCount() != 1) {
        }

        clientWriter.close()
        client.close()
        serverWriterFuture.get().close()
        server.close()

        assertEquals(0, serverTestChatListener.getOnErrorCount() + clientTestChatListener.getOnErrorCount(),
                "No errors check")

        assertEquals(3, serverTestChatListener.getTextMessageCount() +
                serverTestChatListener.getUserInfoCount()
                + serverTestChatListener.getTypingCount(), "Number of op's in server")

        assertEquals(3, clientTestChatListener.getTextMessageCount() +
                clientTestChatListener.getUserInfoCount()
                + clientTestChatListener.getTypingCount(), "Number of op's in client")
    }
}