package org.javautil.util;

/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Borrowed from Spring 3.x; will need to be refactored to reference:
 * org.springframework.util.LinkedCaseInsensitiveMap (when a dependency on
 * spring 3.0 is made).
 * 
 * {@link LinkedHashMap} variant that stores String keys in a case-insensitive
 * manner, for example for key-based access in a results table.
 * 
 * <p>
 * Preserves the original order as well as the original casing of keys, while
 * allowing for contains, get and remove calls with any case of key.
 * 
 * <p>
 * Does <i>not</i> support <code>null</code> keys.
 * 
 * @author Juergen Hoeller
 * @since 3.0
 */
public class LinkedCaseInsensitiveMap<V> extends LinkedHashMap<String, V> {

	private static final long serialVersionUID = 3980536589771210469L;

	private final Map<String, String> caseInsensitiveKeys;

	private final Locale locale;

	/**
	 * Create a new LinkedCaseInsensitiveMap for the default Locale.
	 * 
	 * @see java.lang.String#toLowerCase()
	 */
	public LinkedCaseInsensitiveMap() {
		this(null);
	}

	/**
	 * Create a new LinkedCaseInsensitiveMap that stores lower-case keys
	 * according to the given Locale.
	 * 
	 * @param locale
	 *            the Locale to use for lower-case conversion
	 * @see java.lang.String#toLowerCase(java.util.Locale)
	 */
	public LinkedCaseInsensitiveMap(final Locale locale) {
		super();
		this.caseInsensitiveKeys = new HashMap<String, String>();
		this.locale = (locale != null ? locale : Locale.getDefault());
	}

	/**
	 * Create a new LinkedCaseInsensitiveMap that wraps a {@link LinkedHashMap}
	 * with the given initial capacity and stores lower-case keys according to
	 * the default Locale.
	 * 
	 * @param initialCapacity
	 *            the initial capacity
	 * @see java.lang.String#toLowerCase()
	 */
	public LinkedCaseInsensitiveMap(final int initialCapacity) {
		this(initialCapacity, null);
	}

	/**
	 * Create a new LinkedCaseInsensitiveMap that wraps a {@link LinkedHashMap}
	 * with the given initial capacity and stores lower-case keys according to
	 * the given Locale.
	 * 
	 * @param initialCapacity
	 *            the initial capacity
	 * @param locale
	 *            the Locale to use for lower-case conversion
	 * @see java.lang.String#toLowerCase(java.util.Locale)
	 */
	public LinkedCaseInsensitiveMap(final int initialCapacity,
			final Locale locale) {
		super(initialCapacity);
		this.caseInsensitiveKeys = new HashMap<String, String>(initialCapacity);
		this.locale = (locale != null ? locale : Locale.getDefault());
	}

	@Override
	public V put(final String key, final V value) {
		this.caseInsensitiveKeys.put(convertKey(key), key);
		return super.put(key, value);
	}

	@Override
	public boolean containsKey(final Object key) {
		return (key instanceof String && this.caseInsensitiveKeys
				.containsKey(convertKey((String) key)));
	}

	@Override
	public V get(final Object key) {
		if (key instanceof String) {
			return super.get(this.caseInsensitiveKeys
					.get(convertKey((String) key)));
		} else {
			return null;
		}
	}

	@Override
	public V remove(final Object key) {
		if (key instanceof String) {
			return super.remove(this.caseInsensitiveKeys
					.remove(convertKey((String) key)));
		} else {
			return null;
		}
	}

	@Override
	public void clear() {
		this.caseInsensitiveKeys.clear();
		super.clear();
	}

	/**
	 * Convert the given key to a case-insensitive key.
	 * <p>
	 * The default implementation converts the key to lower-case according to
	 * this Map's Locale.
	 * 
	 * @param key
	 *            the user-specified key
	 * @return the key to use for storing
	 * @see java.lang.String#toLowerCase(java.util.Locale)
	 */
	protected String convertKey(final String key) {
		return key.toLowerCase(this.locale);
	}

}
