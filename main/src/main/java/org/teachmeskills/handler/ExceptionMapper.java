package org.teachmeskills.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.teachmeskills.error.OrganizationAlreadyExistException;
import org.teachmeskills.error.OrganizationAlreadyParticipating;
import org.teachmeskills.error.UserAlreadyExistException;
import org.teachmeskills.error.UserNameExistException;

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

    @ExceptionHandler(OrganizationAlreadyExistException.class)
    public ModelAndView handleException(final OrganizationAlreadyExistException exception) {
        ModelAndView model = new ModelAndView();
        log.error("Unexpected Exception: ", exception);
        model.addObject("message", "Компания с таким УНП существует. Повторная регистрация невзможна");
        model.setViewName("organizationExists");
        return model;
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ModelAndView handleException(final UserAlreadyExistException exception) {
        ModelAndView model = new ModelAndView();
        log.error("Unexpected Exception: ", exception);
        model.addObject("message", "Пользователь с указанной почтой существует. Повторная регистрация невзможна");
        model.setViewName("userExists");
        return model;
    }


    @ExceptionHandler(UserNameExistException.class)
    public ModelAndView handleException(final UserNameExistException exception) {
        ModelAndView model = new ModelAndView();
        log.error("Unexpected Exception: ", exception);
        model.addObject("message", "Пользователь с таким логином существует. Повторная регистрация невзможна");
        model.setViewName("organizationExists");
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
