package hr.codenamecode.codedms.security;

import hr.codenamecode.codedms.data.enums.BasicPermission;
import jakarta.enterprise.util.Nonbinding;
import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.*;

@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface PreAuthorize {

    @Nonbinding
    int objectIdArgIndex() default -1;

    @Nonbinding
    BasicPermission permission() default BasicPermission.ALL;
}