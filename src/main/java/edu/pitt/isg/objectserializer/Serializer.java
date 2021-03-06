package edu.pitt.isg.objectserializer;


/**
 * @author nem41
 */
public abstract class Serializer implements SerializerInterface {

    public static final String APOLLO_NAMESPACE = "http://types.apollo.pitt.edu/v4_0";
    public static final String SERVICES_COMMON_NAMESPACE = "http://services-common.apollo.pitt.edu/v4_0/";
    public static final String LIBRARY_SERVICE_NAMESPACE = "http://library-service-types.apollo.pitt.edu/v4_0/";
    public static final String APOLLO_NAMESPACE_TNS_PREFIX = "tns";

    protected final SerializationFormat serializationFormat;

    public Serializer(SerializationFormat serializationFormat) {
        this.serializationFormat = serializationFormat;
    }

    public static String convertNamespaceFromJavaToXSD(String javaPackage) {

//		if (matcher.find()) {
        String[] packageNameSplit = javaPackage.split("\\.");
        String version = packageNameSplit[packageNameSplit.length - 1];

        StringBuilder xsdNameSpaceBuilder = new StringBuilder("http://");
        for (int i = packageNameSplit.length - 2; i >= 0; i--) {
            xsdNameSpaceBuilder.append(packageNameSplit[i].replace("_", "-")).append(".");
        }

        xsdNameSpaceBuilder.deleteCharAt(xsdNameSpaceBuilder.length() - 1);
        xsdNameSpaceBuilder.append("/").append(version).append("/");

        return xsdNameSpaceBuilder.toString();
//		} else {
//			throw new DeserializationException("Could not convert from XSD namespace to Java package. The namespace did not match the expected pattern.");
//		}
    }

}
