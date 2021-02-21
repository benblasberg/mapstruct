/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.internal.util;

/**
 * Helper holding java.util.Optional full qualified class names for conversion registration
 */
public class JavaOptionalConstants {
    public static final String JAVA_OPTIONAL_FQN = "java.util.Optional";
    private static final boolean IS_JAVA_OPTIONAL_PRESENT = ClassUtils.isPresent(
            JAVA_OPTIONAL_FQN,
            JavaOptionalConstants.class.getClassLoader()
    );

    private JavaOptionalConstants() {
    }

    /**
     * @return {@code true} if {@link java.util.Optional} is present, {@code false} otherwise
     */
    public static boolean isJavaOptionalPresent() {
        return IS_JAVA_OPTIONAL_PRESENT;
    }
}
