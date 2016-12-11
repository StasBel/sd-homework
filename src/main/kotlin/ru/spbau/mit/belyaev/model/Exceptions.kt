package ru.spbau.mit.belyaev.model

/**
 * @author belaevstanislav
 */

/**
 * Exception to throw when failed to create a [Server].
 */
class ServerCreateException : Exception("Failed to create a server!")

/**
 * Exception to throw when failed to close a [Server].
 */
class ClosingServerException : Exception("Error occur while closing server!")

/**
 * Exception to throw when failed to create a [ChatSocket].
 */
class AcceptConnectionException : Exception("Failed to create a connection!")

/**
 * Exception to throw when bad i/o occur while processing a communication in [ChatSocket].
 */
class CommunicateException : Exception("Communication failed!")

/**
 * Exception to throw when failed to close a connection in [ChatSocket].
 */
class ClosingConnectionException : Exception("Error occur while closing connection!")