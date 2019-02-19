package com.equida.web.controller;

import com.equida.exception.WebException;
import com.equida.web.attribute.InputOutputAttribute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
abstract public class AbstractWebController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception exception) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(InputOutputAttribute.EXCEPTION, exception);
        modelAndView.addObject(InputOutputAttribute.URL, request.getRequestURL());
        modelAndView.setViewName("error/500");

        return modelAndView;
    }

    @ExceptionHandler(WebException.class)
    public ModelAndView handleWebException(HttpServletRequest request, WebException exception) {
        return handleException(request, exception);
    }

    protected void addError(String fieldError, String messageError, RedirectAttributes attributes) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put(fieldError, messageError);
        attributes.addFlashAttribute(InputOutputAttribute.ERROR_LIST, errorMap);
    }

    protected void bindErrors(BindingResult bindingResult, RedirectAttributes attributes) {
        Map<String, String> errors = new HashMap<>();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Iterator<FieldError> fieldErrorIterator = fieldErrors.iterator();
        while (fieldErrorIterator.hasNext()) {
            FieldError fieldError = fieldErrorIterator.next();
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        if (errors.size() > 0) {
            attributes.addFlashAttribute(InputOutputAttribute.ERROR_LIST, errors);
        }
    }
}
