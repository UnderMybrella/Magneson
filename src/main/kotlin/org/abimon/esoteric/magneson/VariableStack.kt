package org.abimon.esoteric.magneson

import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast

class VariableStack(private val internalMap: MutableMap<KClass<*>, MutableMap<String, Any>> = HashMap()): MutableMap<KClass<*>, MutableMap<String, Any>> {
    override val entries: MutableSet<MutableMap.MutableEntry<KClass<*>, MutableMap<String, Any>>>
        get() = internalMap.entries
    override val keys: MutableSet<KClass<*>>
        get() = internalMap.keys
    override val size: Int
        get() = internalMap.size
    override val values: MutableCollection<MutableMap<String, Any>>
        get() = internalMap.values

    override fun containsKey(key: KClass<*>): Boolean = internalMap.containsKey(key)

    override fun containsValue(value: MutableMap<String, Any>): Boolean = internalMap.containsValue(value)

    override fun get(key: KClass<*>): MutableMap<String, Any>? = internalMap[key]

    override fun isEmpty(): Boolean = internalMap.isEmpty()

    override fun clear() = internalMap.clear()

    override fun put(key: KClass<*>, value: MutableMap<String, Any>): MutableMap<String, Any>? = internalMap.put(key, value)

    override fun putAll(from: Map<out KClass<*>, MutableMap<String, Any>>) = internalMap.putAll(from)

    override fun remove(key: KClass<*>): MutableMap<String, Any>? = internalMap.remove(key)

    operator fun set(key: KClass<*>, value: MutableMap<String, Any>): MutableMap<String, Any>? = internalMap.put(key, value)
    operator fun set(key: KClass<*>, value: Pair<String, Any>): Any? {
        if(!internalMap.containsKey(key))
            internalMap[key] = HashMap()
        return internalMap[key]?.put(value.first, value.second)
    }

    operator inline fun <reified T> get(key: String): T? = get(T::class)?.get(key) as? T
    operator inline fun <reified T: Any> set(key: String, value: T): T? = set(T::class, key to value) as? T

    operator fun <T: Any> get(klass: KClass<T>, key: String): T? = klass.safeCast(get(klass)?.get(key))
    operator fun <T: Any> set(klass: KClass<T>, key: String, value: T): T? = klass.safeCast(set(klass, key to value))
}