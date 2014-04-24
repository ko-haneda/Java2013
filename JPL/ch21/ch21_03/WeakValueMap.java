package ch21.ch21_03;

import java.lang.ref.*;
import java.util.*;

public class WeakValueMap<K, V> implements Map<K, V> {
	private Map<K, WeakReference<V>> map;

	WeakValueMap() {
		map = new HashMap<K, WeakReference<V>>();
	}

	public int size() {
		return map.size();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	//うまくいかないので自作(これは反則？？）
	public boolean containsValue(Object value) {
		Object val = new Object();
		for (Iterator<Map.Entry<K, WeakReference<V>>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<K, WeakReference<V>> entry = it.next();
			val = entry.getValue().get();
			if (val == null)		continue;
			if (val.equals(value))	return true;
		}
		return false;
	}

	public V get(Object key) {
		return map.get(key).get();
	}

	// NULLを許す仕様
	public V put(K key, V value) {
		try {
			return map.put(key, new WeakReference<V>(value)).get();
		} catch (NullPointerException e) {
			return null;
		}
	}

	public V remove(Object key) {
		return map.remove(key).get();
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	public void clear() {
		map.clear();
	}

	public Set<K> keySet() {
		return map.keySet();
	}

	public Collection<V> values() {
		Map<K, V> newMap = new HashMap<K, V>();
		for (Map.Entry<K, WeakReference<V>> entry : map.entrySet()) {
			newMap.put(entry.getKey(), entry.getValue().get());
		}
		return newMap.values();
	}

	public Set<Map.Entry<K, V>> entrySet() {
		Map<K, V> newMap = new HashMap<K, V>();
		for (Map.Entry<K, WeakReference<V>> entry : map.entrySet()) {
			newMap.put(entry.getKey(), entry.getValue().get());
		}
		return newMap.entrySet();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (Iterator<Map.Entry<K, WeakReference<V>>> it = map.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry<K, WeakReference<V>> entry = it.next();
			Object key = entry.getKey();
			Object val = entry.getValue().get();
			if (val == null)
				continue;
			sb.append(key);
			sb.append("=");
			sb.append(val);
			sb.append("　,");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("}");
		return sb.toString();
	}
}
