package com.pack.common;

import java.util.Objects;

public class Pair<K,V> {

	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (key != null ? key.hashCode() : 0);
		hash = 31 * hash + (value != null ? value.hashCode() : 0);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return Objects.equals(key, other.key) && Objects.equals(value, other.value);
	}
}
