/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.event.map;

import com.espertech.esper.client.EventType;
import com.espertech.esper.codegen.core.CodegenContext;
import com.espertech.esper.codegen.model.expression.CodegenExpression;
import com.espertech.esper.event.BaseNestableEventUtil;
import com.espertech.esper.event.EventAdapterService;

/**
 * A getter that works on EventBean events residing within a Map as an event property.
 */
public class MapNestedEntryPropertyGetterArrayMap extends MapNestedEntryPropertyGetterBase {

    private final int index;
    private final MapEventPropertyGetter getter;

    public MapNestedEntryPropertyGetterArrayMap(String propertyMap, EventType fragmentType, EventAdapterService eventAdapterService, int index, MapEventPropertyGetter getter) {
        super(propertyMap, fragmentType, eventAdapterService);
        this.index = index;
        this.getter = getter;
    }

    public Object handleNestedValue(Object value) {
        return BaseNestableEventUtil.handleNestedValueArrayWithMap(value, index, getter);
    }

    public Object handleNestedValueFragment(Object value) {
        return BaseNestableEventUtil.handleBNNestedValueArrayWithMapFragment(value, index, getter, eventAdapterService, fragmentType);
    }

    public CodegenExpression handleNestedValueCodegen(CodegenExpression name, CodegenContext context) {
        return BaseNestableEventUtil.handleNestedValueArrayWithMapCode(index, getter, name, context, this.getClass());
    }

    public CodegenExpression handleNestedValueFragmentCodegen(CodegenExpression name, CodegenContext context) {
        return BaseNestableEventUtil.handleBNNestedValueArrayWithMapFragmentCode(index, getter, name, context, eventAdapterService, fragmentType, this.getClass());
    }
}
