package com.athc.shell

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ShellApplication

fun main(args: Array<String>) {
  SpringApplication.run(ShellApplication::class.java, *args)
}
