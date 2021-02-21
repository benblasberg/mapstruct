/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.builtin.bean;

import java.util.Optional;

public class OptionalProperty {

    // CHECKSTYLE:OFF
    public Optional<String> publicProp;
    // CHECKSTYLE:ON

    private Optional<String> prop;

    public Optional<String> getProp() {
        return prop;
    }

    public void setProp( Optional<String> prop ) {
        this.prop = prop;
    }
}
