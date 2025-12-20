package hr.codenamecode.codedms.http;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({ TYPE })
public @interface CmisAction {
    String value();
    
    final class CmisActionLiteral extends AnnotationLiteral<CmisAction> implements CmisAction {
        
        private final String value;
        
        public CmisActionLiteral(String value) {
            this.value = value;
        }
        
        @Override public String value() {
            return value;
        }
    }
}
