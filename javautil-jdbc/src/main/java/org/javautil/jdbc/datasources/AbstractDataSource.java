package org.javautil.jdbc.datasources;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.javautil.datasources.Property;
import org.javautil.security.Crypto;

/**
 * All DatasourceFactory datasources must extend this class. TODO jjs why?
 */
public abstract class AbstractDataSource implements DataSource {

	public static final String USER = "user";

	public static final String PASSWORD = "password";

	public static final String URL = "url";

	public static final String DRIVER = "driver";

	private String name;

	private final Map<String, String> properties = new TreeMap<String, String>();

	/**
	 * Called by DatasourcesFactory, purpose of this method is to ensure all
	 * required properties have been defined. An UnsupportedOperationException
	 * will be thrown if a required property is found to be missing.
	 * 
	 * todo jjs wtf? UnsupportedOperationExeption
	 */

	protected void assertRequiredProperties() {
		assertPropertyDefined(USER);
		assertPropertyDefined(PASSWORD);
		assertPropertyDefined(URL);
		assertPropertyDefined(DRIVER);
	}

	/**
	 * Sets the name of this instantiated datasource
	 * 
	 * @param name
	 */
	protected final void setName(final String name) {
		this.name = name;
	}

	protected Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * Returns the name of the instantiated datasource
	 * 
	 * @return
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Sets the property map based on the list of properties // Order of
	 * precedence
	 * 
	 * <ol>
	 * <li>Value</li>
	 * <li>System property</li>
	 * <li>Environment property</li>
	 * <li>Encrypted value</li>
	 * 
	 * todo jjs encrypted value and value should be both 1 and mutually
	 * exclusive, but this is the kind of stuff you have to deal with with maps
	 * is there an indirection from the property name to the environment name or
	 * is this an ill considered refactor artifact
	 * 
	 * @param _properties
	 */
	protected final void setProperties(final List<Property> _properties) {
		properties.clear();
		for (final Property prop : _properties) {

			final String key = prop.getKey();
			String value = prop.getValue();
			if (value == null) {
				final String propertyKey = prop.getSys();
				if (propertyKey != null) {
					value = System.getProperty(propertyKey.trim());
				}
			}
			if (value == null) {
				final String environmentKey = prop.getEnv();
				if (environmentKey != null) {
					value = System.getenv(environmentKey.trim());
				}
			}
			if (value == null) {
				final String encryptedValue = prop.getEncryptedValue();
				if (encryptedValue != null) {
					try {
						// TODO this is devoid of merit
						value = new String(Crypto.decryptFromHex(
								encryptedValue.trim(), "PA$$WORD"));
					} catch (final Exception e) {
						value = null;
						throw new RuntimeException(e);
					}
				}
			}
			properties.put(key, value);
		}
	}

	/**
	 * Returns the property value
	 * 
	 * @param key
	 * @return
	 */
	public final String getProperty(final String key) {
		return properties.get(key);
	}

	/**
	 * Asserts that the given key is defined in the property map and that it has
	 * a non-zero length.
	 * 
	 * @param key
	 */
	protected final void assertPropertyDefined(final String key) {
		final String value = getProperty(key);
		if (!key.equals("password")
				&& (value == null || value.trim().length() == 0)) {
			throw new IllegalArgumentException(getClass().getName()
					+ " requires this missing property: " + key);
		}
	}

	public void testConnection() {
		try {
			final Connection conn = getConnection();
			conn.close();
		} catch (final SQLException e) {
			e.printStackTrace();
			final StringBuilder b = new StringBuilder();
			b.append(e.getMessage());
			b.append(System.getenv("line.separator"));
			b.append(toString());
		}
	}

	/**
	 * General purpose method to do any necessary initialing before connections
	 * are retrieved.
	 * 
	 */
	protected void initialize() {

	}

	/*
	 * All methods below are by default not implemented.
	 * 
	 * They minimize the implementing class method requirements.
	 * 
	 * Implementing classes are free to override these as necessary.
	 */

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLogWriter(final PrintWriter out) throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLoginTimeout(final int seconds) throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isWrapperFor(final Class<?> iface) throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T unwrap(final Class<T> iface) throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Connection getConnection(final String arg0, final String arg1)
			throws SQLException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 * 
	 *         todo change the property map to not have the userName, password
	 *         and URL so that we don't have to dump the URL and so that we
	 *         don't have to expose everything converge back to pre-enhanced
	 *         version
	 * 
	 *         todo replace with AsString version excluding password
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		String retValue = "";

		retValue = "AbstractDataSource ( " + super.toString() + TAB + "name = "
				+ this.name + TAB + "properties = " + this.properties + TAB
				+ " )";

		return retValue;
	}
}
