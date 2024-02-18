package com

import com.tvmazedatabase.InitDatabase
import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import org.jboss.logging.Logger

@QuarkusMain
object Main {

    private val logger = Logger.getLogger(InitDatabase::class.simpleName)

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info("Starting application")
        Quarkus.run(BookMain::class.java, *args)
    }

    class BookMain : QuarkusApplication {
        @Throws(Exception::class)
        override fun run(vararg args: String): Int {
            logger.info("Main class is running...")
            Quarkus.waitForExit()
            return 0
        }
    }
}