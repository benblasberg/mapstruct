<#--

    Copyright MapStruct Authors.

    Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0

-->
<#-- @ftlvariable name="" type="org.mapstruct.ap.internal.model.SupportingMappingMethod" -->
private <T> T ${name}( <@includeModel object=findType("Optional") raw=true/><T> optional ) {
    if ( optional == null ) {
        return null;
    }

    return optional.orElse( null );
}
