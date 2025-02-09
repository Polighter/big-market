package org.example.domain.strategy.service.annotation;

import org.example.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 注解的主要用途是为类提供一个逻辑模式的标识。通过这种方式，可以在运行时通过反射获取类的逻辑模式，并根据逻辑模式进行不同的处理。
* */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogicStrategy {

    DefaultLogicFactory.LogicModel logicMode();
}
