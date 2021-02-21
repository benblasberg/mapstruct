/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.internal.model.source.builtin;

import org.mapstruct.ap.internal.model.common.Parameter;
import org.mapstruct.ap.internal.model.common.Type;
import org.mapstruct.ap.internal.model.common.TypeFactory;

import java.util.Optional;
import java.util.Set;

import static org.mapstruct.ap.internal.util.Collections.asSet;

/**
 * {@link BuiltInMethod} for unwrapping {@link Optional}s
 */
public class JavaOptionalToValue extends BuiltInMethod {

    private final Parameter parameter;
    private final Type returnType;
    private final Set<Type> importTypes;

    public JavaOptionalToValue(TypeFactory typeFactory) {
        Type type = typeFactory.getType(  Optional.class  );
        this.parameter = new Parameter( "value", type );
        this.returnType = type.getTypeParameters().get( 0 );
        this.importTypes = asSet( parameter.getType() );
    }

    @Override
    public boolean doTypeVarsMatch(Type sourceType, Type targetType) {
        boolean match = false;
        if ( sourceType.getTypeParameters().size() == 1 ) {
            match = sourceType.getTypeParameters().get( 0 ).isAssignableTo( targetType );
        }
        return match;
    }

    @Override
    public Parameter getParameter() {
        return parameter;
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }

    @Override
    public Set<Type> getImportTypes() {
        return importTypes;
    }

}
