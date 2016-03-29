package org.bibr.eval;

/**
 * Define the strategy used for representing entity identifiers. 
 * URI means that the whole RDF uri will be used. NAME mens that only the localName will be used.
 * @author Joffrey
 *
 */
public enum ID_STRATEGY {
	URI, NAME
}
