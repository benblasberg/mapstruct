/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.builtin.bean;

import java.util.List;
import java.util.Optional;

public class OptionalListProperty {

    // CHECKSTYLE:OFF
    public List<Optional<String>> publicProp;
    // CHECKSTYLE:ON

    private List<Optional<String>> prop;

    public List<Optional<String>> getProp() {
        return prop;
    }

    public void setProp(List<Optional<String>> prop) {
        this.prop = prop;
    }
}
