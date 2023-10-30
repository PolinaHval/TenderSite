package org.teachmeskills.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.teachmeskills.error.OrganizationAlreadyParticipating;

import javax.validation.ValidationException;

@ControllerAdvice
@Slf4j
public class ExceptionMapper {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(final Exception exception) {
        ModelAndView model = new ModelAndView();
        log.error("Unexpected Exception: ", exception);
        model.addObject("message", "Internal server error");
        model.setViewName("error");
        return model;
    }

    @ExceptionHandler(ValidationException.class)
    public ModelAndView handleException(final ValidationException exception) {
        ModelAndView model = new ModelAndView();
        log.error("Unexpected Exception: ", exception);
        model.addObject("message", "Данные введены некорректно. " +
            "За уточнением информации обратитесь к нам по телефону 80111111111");
        model.setViewName("userExists");
        return model;
    }

    @ExceptionHandler(OrganizationAlreadyParticipating.class)
    public ModelAndView handleException(final OrganizationAlreadyParticipating exception) {
        ModelAndView model = new ModelAndView();
        log.error("Unexpected Exception: ", exception);
        model.addObject("message", "Ваша организация уже принимает участие в закупке");
        model.setViewName("organizationAlreadyParticipating");
        return model;
    }
}
