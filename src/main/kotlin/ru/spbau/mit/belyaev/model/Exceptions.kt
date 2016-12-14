package ru.spbau.mit.belyaev.model

// SERVER

/**
 * Exception to throw when failed to create a [Server].
 *
 * @author belaevstanislav
 */
class ServerCreateException : Exception("Failed to create a server!")

/**
 * Exception to throw when failed to create a [Server].
 *
 * @author belaevstanislav
 */
class ServerStartException : Exception("Failed to start the server!")

/**
 * Exception to throw when failed to close a [Server].
 *
 * @author belaevstanislav
 */
class ServerCloseException : Exception("Error occur while closing the server!")

// CLIENT

/**
 * Exception to throw when failed to create a [Client].
 *
 * @author belaevstanislav
 */
class ClientCreateException : Exception("Failed to create a client!")

/**
 * Exception to throw when failed to close a [Client].
 *
 * @author belaevstanislav
 */
class ClientCloseException : Exception("Error occur while closing the client!")

// CONNECTION

/**
 * Exception to throw when failed to create a [Writer].
 *
 * @author belaevstanislav
 */
class AcceptConnectionException : Exception("Failed to create a connection!")

/**
 * Exception to throw when bad i/o occur while processing a communication in [Writer].
 *
 * @author belaevstanislav
 */
class CommunicateException : Exception("Communication failed!")

/**
 * Exception to throw when failed to close a connection in [Writer].
 *
 * @author belaevstanislav
 */
class ClosingConnectionException : Exception("Error occur while closing connection!")