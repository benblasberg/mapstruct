/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.builtin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ap.test.builtin.bean.OptionalProperty;
import org.mapstruct.ap.test.builtin.bean.OtherOptionalProperty;
import org.mapstruct.ap.test.builtin.bean.StringProperty;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OptionalMapper {
    OptionalMapper INSTANCE = Mappers.getMapper( OptionalMapper.class );

    StringProperty mapString( OptionalProperty property );

    OptionalProperty map(StringProperty property );

    OtherOptionalProperty map( OptionalProperty property );
}
