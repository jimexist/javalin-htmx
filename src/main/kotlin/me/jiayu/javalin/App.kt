package me.jiayu.javalin

import com.github.mustachejava.DefaultMustacheFactory
import io.javalin.Javalin
import io.javalin.config.JavalinConfig
import io.javalin.rendering.template.JavalinMustache


fun main(args: Array<String>) {
    JavalinMustache.init(DefaultMustacheFactory("templates"))

    val app = Javalin.create(::configureApp)
        .get("/") { ctx -> ctx.render("index.mustache", mapOf("title" to "Hello HTMX")) }
        .get("/hello") { ctx -> ctx.result("Hello World") }

    Runtime.getRuntime().addShutdownHook(object : Thread() {
        override fun run() {
            app.stop()
        }
    })

    app.start(7070)
}

private fun configureApp(config: JavalinConfig) {
    config.staticFiles.add { staticFileConfig ->
        staticFileConfig.hostedPath = "/static"
        staticFileConfig.directory = "/static"
    }
}
