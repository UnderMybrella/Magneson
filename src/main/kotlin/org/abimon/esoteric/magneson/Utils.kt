package org.abimon.esoteric.magneson

import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.createType

val KClass<*>.type: KType
    get() = this.createType()

operator fun <T> List<T>.get(index: Int, default: T): T = if(index in (0 until size)) this[index] else default