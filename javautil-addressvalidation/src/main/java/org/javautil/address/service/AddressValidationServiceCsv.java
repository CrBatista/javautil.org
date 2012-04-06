package org.javautil.address.service;

import java.io.File;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.javautil.address.dao.AddressValidationCsvPersister;
import org.javautil.address.service.usps.AbstractAddressValidationService;
import org.javautil.address.usps.AddressValidationException;
import org.javautil.commandline.CommandLineHandler;
import org.javautil.persistence.PersistenceException;

/**
 * <p>
 * AddressValidationJdbc class.
 * </p>
 * 
 * @author jjs
 * @version $Id: AddressValidationJdbc.java,v 1.5 2012/03/06 14:18:18 jjs Exp $
 */
public class AddressValidationServiceCsv extends
		AbstractAddressValidationService {

	/** Constant <code>revision="$Revision: 1.5 $"</code> */
	public static final String revision = "$Revision: 1.5 $";

	private AddressValidationServiceArguments arguments;

	private AddressValidationCsvPersister persister = new AddressValidationCsvPersister();

	private final Logger logger = Logger.getLogger(getClass());

	/**
	 * <p>
	 * Constructor for AddressValidationJdbc.
	 * </p>
	 */
	public AddressValidationServiceCsv() {
		logger.info("instantiated " + revision);
	}

	// TODO find old version and create subclass which implements acknowledge

	/** {@inheritDoc} */
	@Override
	protected void wrapUp() throws PersistenceException {
		logger.info(getValidator().getStatisticsMessage());
		dispose();

	}

	private void dispose() {
		getPersister().dispose();
	}

	/** {@inheritDoc} */
	@Override
	protected void conditionalCommit() throws PersistenceException {
	}

	@Override
	protected void persistChanges() throws PersistenceException {
		getPersister().update(getAddresses());
	}

	/**
	 * <p>
	 * Getter for the field <code>arguments</code>.
	 * </p>
	 * 
	 * @return the arguments
	 */
	public AddressValidationServiceArguments getArguments() {
		return arguments;
	}

	/**
	 * <p>
	 * Setter for the field <code>arguments</code>.
	 * </p>
	 * 
	 * @param arguments
	 *            the arguments to set
	 */
	public void setArguments(AddressValidationServiceArguments arguments) {
		this.arguments = arguments;
	}

	public void process() throws PersistenceException,
			AddressValidationException, SQLException {
		persister.setInputFile(new File(arguments.getInputFileName()));
		persister.setOutputFile(new File(arguments.getOutputFileName()));
		super.process(arguments);
		persister.dispose();
	}

	/**
	 * <p>
	 * main.
	 * </p>
	 * 
	 * @param args
	 *            an array of {@link java.lang.String} objects.
	 * @throws java.sql.SQLException
	 *             if any.
	 * @throws org.javautil.address.usps.AddressValidationException
	 *             if any.
	 * @throws org.javautil.persistence.PersistenceException
	 *             if any.
	 */

	@Override
	public AddressValidationCsvPersister getPersister() {
		return persister;
	}

	public void setPersister(AddressValidationCsvPersister persister) {
		this.persister = persister;
	}

	public static void main(final String args[]) throws PersistenceException,
			AddressValidationException, SQLException {

		final AddressValidationServiceJdbc as = new AddressValidationServiceJdbc();
		final AddressValidationServiceArguments arguments = new AddressValidationServiceArguments();
		final CommandLineHandler clh = new CommandLineHandler(arguments);
		clh.evaluateArguments(args);
		as.process(arguments);
	}
}