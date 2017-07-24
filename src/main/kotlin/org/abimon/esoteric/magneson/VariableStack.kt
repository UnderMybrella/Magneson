package org.abimon.esoteric.magneson

import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.safeCast

class VariableStack(private val internalMap: MutableMap<KType, MutableMap<String, Any>> = HashMap()): MutableMap<KType, MutableMap<String, Any>> {
    override val entries: MutableSet<MutableMap.MutableEntry<KType, MutableMap<String, Any>>>
        get() = internalMap.entries
    override val keys: MutableSet<KType>
        get() = internalMap.keys
    override val size: Int
        get() = internalMap.size
    override val values: MutableCollection<MutableMap<String, Any>>
        get() = internalMap.values

    override fun containsKey(key: KType): Boolean = internalMap.containsKey(key)

    override fun containsValue(value: MutableMap<String, Any>): Boolean = internalMap.containsValue(value)

    override fun get(key: KType): MutableMap<String, Any>? = internalMap[key]

    override fun isEmpty(): Boolean = internalMap.isEmpty()

    override fun clear() = internalMap.clear()

    override fun put(key: KType, value: MutableMap<String, Any>): MutableMap<String, Any>? = internalMap.put(key, value)

    override fun putAll(from: Map<out KType, MutableMap<String, Any>>) = internalMap.putAll(from)

    override fun remove(key: KType): MutableMap<String, Any>? = internalMap.remove(key)

    operator fun set(key: KType, value: MutableMap<String, Any>): MutableMap<String, Any>? = internalMap.put(key, value)
    operator fun set(key: KType, value: Pair<String, Any>): Any? {
        if(!internalMap.containsKey(key))
            internalMap[key] = HashMap()
        return internalMap[key]?.put(value.first, value.second)
    }

    operator inline fun <reified T> get(key: String): T? = get(T::class.type)?.get(key) as? T
    operator inline fun <reified T: Any> set(key: String, value: T): T? = set(T::class.type, key to value) as? T

    operator fun <T: Any> get(klass: KClass<T>): MutableMap<String, Any>? = get(klass.type)

    operator fun <T: Any> get(klass: KClass<T>, key: String): T? = klass.safeCast(get(klass.type)?.get(key))
    operator fun <T: Any> set(klass: KClass<T>, key: String, value: T): T? = klass.safeCast(set(klass.type, key to value))

    operator fun get(type: KType, key: String): Any? = get(type)?.get(key)
    operator fun <T: Any> set(type: KType, key: String, value: T): Any? = set(type, key to value)

    operator fun <T: Any> get(type: KType, klass: KClass<T>, key: String): T? = klass.safeCast(get(type)?.get(key))
    operator fun <T: Any> set(type: KType, klass: KClass<T>, key: String, value: T): Any? = klass.safeCast(set(type, key to value))
}