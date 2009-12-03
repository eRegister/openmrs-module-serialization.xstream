/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.serialization.xstream.converter;

import org.openmrs.ProgramWorkflow;
import org.openmrs.api.context.Context;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * Short Converter for ProgramWorkflow and its CGLib proxy. <br/>
 * While it is a property of other classes, xstream will just serialize uuid.<br />
 * While it is a sole object, xstream will serialize all attributes of it.
 */
public class ProgramWorkflowShortConverter extends BaseShortConverter {
	
	public ProgramWorkflowShortConverter(Mapper mapper, ConverterLookup converterLookup) {
	    super(mapper, converterLookup);
    }
	
	@Override
	public Object getByUUID(String uuid) {
		return Context.getProgramWorkflowService().getWorkflowByUuid(uuid);
	}

	/**
	 * This short converter can deal with both ProgramWorkflow and CGLib proxy for ProgramWorkflow. <br />
	 * Because, when "c" is a CGLib proxy of ProgramWorkflow, ProgramWorkflow.class.isAssignableFrom(c) will also
	 * return true
	 * 
	 * @see com.thoughtworks.xstream.converters.ConverterMatcher#canConvert(java.lang.Class)
	 */
	public boolean canConvert(Class c) {
		return ProgramWorkflow.class.isAssignableFrom(c);
	}

}
