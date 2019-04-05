package com.equida.webapp.web.controller;

import com.equida.common.exception.WebException;
import com.equida.webapp.web.attribute.InputOutputAttribute;
import com.equida.webapp.web.form.IForm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
abstract public class AbstractWebController {
	
	private Map<String, String> errorMap = new HashMap<>();
	private ArrayList<String> messages = new ArrayList<>();

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
        errorMap.put(fieldError, messageError);
        attributes.addFlashAttribute(InputOutputAttribute.ERROR_LIST, errorMap);
    }
	
	protected void addError(String messageError, ModelAndView modelAndView) {
        errorMap.put(""+errorMap.size(), messageError);
        modelAndView.addObject(InputOutputAttribute.ERROR_LIST, errorMap);
    }
	
	protected void addMessage(String message, ModelAndView modelAndView) {
        messages.add(message);
        modelAndView.addObject(InputOutputAttribute.MESSAGES_LIST, messages);
    }

    protected void bindErrors(BindingResult bindingResult, RedirectAttributes attributes) {
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Iterator<FieldError> fieldErrorIterator = fieldErrors.iterator();
        while (fieldErrorIterator.hasNext()) {
            FieldError fieldError = fieldErrorIterator.next();
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        if (errorMap.size() > 0) {
            attributes.addFlashAttribute(InputOutputAttribute.ERROR_LIST, errorMap);
        }
    }
	
	public <T> void registerForm(ModelAndView modelAndView, Model model, Class<? extends IForm<T>> formClass, T entity) {		
		if(!model.containsAttribute(InputOutputAttribute.FORM)) {
			IForm form = null;
			try {
				form = formClass.newInstance();
			} catch (InstantiationException | IllegalAccessException ex) {
				ex.printStackTrace();
				return;
			}
			
			if(entity != null) {
				form.fillFromEntity(entity);
			}
			
			modelAndView.addObject(InputOutputAttribute.FORM, form);
		} else {
			modelAndView.addObject(InputOutputAttribute.FORM, model.asMap().get(InputOutputAttribute.FORM));
		}
	}
	
	public boolean checkForError(BindingResult bindingResult, RedirectAttributes attributes, IForm form) {
		if (bindingResult.hasErrors()) {
			bindErrors(bindingResult, attributes);
			attributes.addFlashAttribute(InputOutputAttribute.FORM, form);
			
			return true;
		}
		
		return false;
	}
}
