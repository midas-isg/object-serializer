package edu.pitt.isg.objectserializer;


import edu.pitt.isg.objectserializer.exceptions.UnsupportedSerializationFormatException;

import java.util.List;

/**
 * @author nem41
 */
public class SerializerFactory {

    public static Serializer getSerializer(SerializationFormat format, List<Class> classList) throws UnsupportedSerializationFormatException {

        switch (format) {
            case XML:
                return new XMLSerializer(classList);
            case JSON:
                return new JsonSerializer(classList);
            default:
                throw new UnsupportedSerializationFormatException("The serialization format " + format + " is not currently supported");
        }

    }

}
