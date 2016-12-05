
package edu.pitt.isg.objectserializer;


import edu.pitt.isg.objectserializer.exceptions.UnsupportedSerializationFormatException;

/**
 *
 * @author nem41
 */
public class DeserializerFactory {
	
	public static Deserializer getDeserializer(SerializationFormat format) throws UnsupportedSerializationFormatException {
		switch (format) {
			case XML:
				return new XMLDeserializer();
			default:
				throw new UnsupportedSerializationFormatException("The serialization format " + format + " is not currently supported");
		}
	}
	
}
