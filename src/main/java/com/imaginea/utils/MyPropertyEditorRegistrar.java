package com.imaginea.utils;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * PropertyEditorRegistrar which registers LongNumberPropertyEditor.
 * 
 * @author asarin
 *
 */
public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {

	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Long.class, new LongNumberPropertyEditor());
	}

}
