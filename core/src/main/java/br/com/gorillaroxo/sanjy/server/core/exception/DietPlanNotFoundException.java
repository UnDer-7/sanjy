package br.com.gorillaroxo.sanjy.server.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class DietPlanNotFoundException extends BusinessException {

    private static final ExceptionCode CODE = ExceptionCode.DIET_PLAN_NOT_FOUND;
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public DietPlanNotFoundException(final String customMessage, final Throwable originalCause) {
        super(CODE, STATUS, customMessage, originalCause);
    }

    public DietPlanNotFoundException() {
        super(CODE, STATUS);
    }

    public DietPlanNotFoundException(final Throwable originalCause) {
        super(CODE, STATUS, originalCause);
    }

    public DietPlanNotFoundException(final String customMessage) {
        super(CODE, STATUS, customMessage);
    }

    @Override
    protected LogLevel getLogLevel() {
        return LogLevel.WARN;
    }

    @Override
    protected Logger getLogger() {
        return log;
    }

}
