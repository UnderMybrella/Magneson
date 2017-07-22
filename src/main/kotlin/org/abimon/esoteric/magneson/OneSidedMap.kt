package org.abimon.esoteric.magneson

/**
 * A map that contains a reference to a parent map.
 * No new entries will be added to the parent, but references may be updated.
 * Entries also cannot be removed from the parent.
 */
class OneSidedMap<K, V>(val master: MutableMap<K, V>): MutableMap<K, V> {
    val slave = HashMap<K, V>()
    override val size: Int
        get() = master.filterKeys { !slave.containsKey(it) }.size + slave.size

    override fun containsKey(key: K): Boolean = master.containsKey(key) || slave.containsKey(key)

    override fun containsValue(value: V): Boolean = master.containsValue(value) || slave.containsValue(value)

    override fun get(key: K): V? = master[key] ?: slave[key]

    override fun isEmpty(): Boolean = master.isEmpty() && slave.isEmpty()

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = master.entries.also { it.addAll(slave.entries) }
    override val keys: MutableSet<K>
        get() = master.keys.also { it.addAll(slave.keys) }
    override val values: MutableCollection<V>
        get() = master.values.also { it.addAll(slave.values) }

    override fun clear() = slave.clear()

    override fun put(key: K, value: V): V? {
        if(master.containsKey(key))
            return master.put(key, value)
        else
            return slave.put(key, value)
    }

    override fun putAll(from: Map<out K, V>) = from.forEach { key, value -> put(key, value) }

    override fun remove(key: K): V? = slave.remove(key)
}