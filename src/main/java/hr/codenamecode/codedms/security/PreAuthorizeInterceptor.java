package hr.codenamecode.codedms.security;

import hr.codenamecode.codedms.data.enums.BasicPermission;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

@PreAuthorize
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class PreAuthorizeInterceptor {

    private static final Logger LOGGER = Logger.getLogger(PreAuthorizeInterceptor.class.getName());

    @AroundInvoke
    public Object checkPermission(InvocationContext ctx) throws Exception {
        PreAuthorize preAuthorize =
                ctx.getMethod().getAnnotation(PreAuthorize.class);
        String objectId = (String) ctx.getParameters()[preAuthorize.objectIdArgIndex()];
        BasicPermission basicPermission = preAuthorize.permission();
        LOGGER.log(Level.INFO, "Pre-authorizing[{0}] object {1}", new Object[]{basicPermission, objectId});

        // TODO check permission using dedicated checker service

        return ctx.proceed();
    }

}