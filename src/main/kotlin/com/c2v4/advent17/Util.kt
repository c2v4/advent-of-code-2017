package com.c2v4.advent17


fun String.asResource() = Dummy().javaClass.classLoader.getResource(this).readText()

class Dummy{}
