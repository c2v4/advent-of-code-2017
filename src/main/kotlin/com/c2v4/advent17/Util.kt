package com.c2v4.advent17


fun String.asResource() = Thread.currentThread().contextClassLoader.getResource(this).readText()
