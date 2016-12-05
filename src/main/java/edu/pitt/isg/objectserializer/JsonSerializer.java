/*
 * Copyright 2015 nem41.
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
package edu.pitt.isg.objectserializer;


import edu.pitt.isg.objectserializer.exceptions.SerializationException;

import java.util.List;

/**
 * @author nem41
 */
public class JsonSerializer extends Serializer {

    private final List<Class> classList;

    public JsonSerializer(List<Class> classList) {
        super(SerializationFormat.JSON);
        this.classList = classList;
    }

    public String serializeObject(Object obj) throws SerializationException {
        JsonUtils jsonUtils = new JsonUtils(classList);
        return jsonUtils.getJSONString(obj);
    }

}
