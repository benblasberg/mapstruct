/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.internal.model.source.builtin;

import org.mapstruct.ap.internal.model.common.Parameter;
import org.mapstruct.ap.internal.model.common.Type;
import org.mapstruct.ap.internal.model.common.TypeFactory;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mapstruct.ap.internal.util.Collections.asSet;
import static org.mapstruct.ap.internal.util.Collections.first;

/**
 * {@link BuiltInMethod} for wrapping values in {@link Optional}s
 */
public class ValueToJavaOptional extends BuiltInMethod {

    private final Parameter parameter;
    private final Type returnType;
    private final Set<Type> importTypes;

    public ValueToJavaOptional(TypeFactory typeFactory) {
        Type type = typeFactory.getType(  Optional.class  );
        this.parameter = new Parameter( "element", type.getTypeParameters().get( 0 ) );
        this.returnType = type;
        this.importTypes = asSet( parameter.getType() );
    }

    @Override
    public boolean matches(List<Type> sourceTypes, Type targetType) {
        if ( sourceTypes.size() != 1 ) {
            return false;
        }

        Type sourceType = first( sourceTypes );

        Type returnType = getReturnType().resolveTypeVarToType( sourceType, getParameter().getType()  );
        if ( returnType == null ) {
            return false;
        }

        return returnType.erasure().isAssignableTo( targetType ) && returnType != sourceType;
    }

    @Override
    public boolean doTypeVarsMatch(Type sourceType, Type targetType) {
        boolean match = false;
        if ( targetType.getTypeParameters().size() == 1 ) {
            match = targetType.getTypeParameters().get( 0 ).isAssignableTo( sourceType );
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
