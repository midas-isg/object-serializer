package edu.pitt.isg.objectserializer;

import edu.pitt.isg.objectserializer.exceptions.SerializationException;

/**
 *
 * @author nem41
 */
public interface SerializerInterface {

	public String serializeObject(Object obj) throws SerializationException;

}
