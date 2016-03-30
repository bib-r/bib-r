package org.bibr.eval;

/**
 * Define the strategy used for defining the type of an entity. 
 * ID means that the type of entity is contained in the uri. PROPERTY means that the type is defined in a property of the entity.
 * @author Joffrey
 *
 */
public enum TYPE_STRATEGY {
	
	ID, PROPERTY, ATTRIBUTE

}
