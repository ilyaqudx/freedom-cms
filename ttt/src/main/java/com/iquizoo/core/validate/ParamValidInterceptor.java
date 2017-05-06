package com.iquizoo.core.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;

import com.iquizoo.core.interceptor.AbstractInterceptor;
import com.iquizoo.core.interceptor.handler.Handler;
import com.iquizoo.core.kit.Kit;
import com.iquizoo.core.kit.StrKit;

public class ParamValidInterceptor extends AbstractInterceptor{

	public ParamValidInterceptor() 
	{
		super(new Handler() 
		{
			@Override
			public boolean preCheck(HttpServletRequest request,
					HttpServletResponse response, HandlerMethod method,
					Annotation annotation) throws Exception 
			{
				MethodParameter[] parameters = method.getMethodParameters();
				for (MethodParameter param : parameters) 
				{
					ParamVerify verify = param.getParameterAnnotation(ParamVerify.class);
					if(null != verify)
					{
						Class<?> clazz = param.getParameterType();
						//Object entity  = clazz.newInstance();
						Field[] fields = clazz.getDeclaredFields();
						for (Field field : fields) 
						{
							field.setAccessible(true);
							String fieldName = field.getName();
							Class<?> fieldType = field.getType();
							Annotation[] annotations = field.getAnnotations();
							String entity = request.getParameter(fieldName);
							if(annotations.length > 0)
							{
								for (Annotation verifyAnnotation : annotations) 
								{
									Class<?> annotationType = verifyAnnotation.annotationType();
									if(annotationType == NotBlank.class)
									{
										verifyNotBlank(entity, field,fieldName, fieldType);
									}
									else if(annotationType == NumberRange.class)
									{
										verifyNumberRange(entity, field,fieldName, fieldType,verifyAnnotation);
									}
									else if(annotationType == Length.class)
									{
										verifyStringLength(entity, field,fieldName, fieldType,verifyAnnotation);
									}
									else if(annotationType == Mobile.class)
									{
										verifyMobile(entity, field, fieldName,fieldType);
									}
								}
							}
						}
					}
				}
				return true;
			}

			private void verifyMobile(String entity, Field field,
					String fieldName, Class<?> fieldType)
					throws IllegalAccessException, ParameterException {
				if(fieldType == String.class)
				{
					if(StrKit.isBlank(entity))
						throw new ParameterException(fieldName + " must not null");
					String value = entity;
					if(!Kit.isMobile(value))
						throw new ParameterException(fieldName + " must be Mobile phone format");
				}
			}

			private void verifyNotBlank(String entity, Field field,
					String fieldName, Class<?> fieldType)
					throws IllegalAccessException, ParameterException {
				if(fieldType == String.class)
				{
					if(StrKit.isBlank(entity))
						throw new ParameterException(fieldName + " must not null");
				}
			}

			private void verifyNumberRange(String entity, Field field,
					String fieldName, Class<?> fieldType,
					Annotation verifyAnnotation) throws IllegalAccessException,
					ParameterException {
				if(fieldType == int.class || fieldType == Integer.class || fieldType == long.class ||
				   fieldType == long.class || fieldType == float.class || fieldType == Float.class ||
				   fieldType == double.class || fieldType == double.class || fieldType == short.class ||
				   fieldType == Short.class || fieldType == byte.class || fieldType == Byte.class)
				{
					if(StrKit.isBlank(entity))
						throw new ParameterException(fieldName + " must not null");
					else
					{
						long value = Long.parseLong(entity);
						NumberRange numberRange = (NumberRange) verifyAnnotation;
						if(value < numberRange.min() || value > numberRange.max())
						{
							throw new ParameterException(fieldName + " must " + numberRange.min() + " <= ? <= " + numberRange.max());
						}
					}
				}
			}
			
			private void verifyStringLength(String entity, Field field,
					String fieldName, Class<?> fieldType,
					Annotation verifyAnnotation) throws IllegalAccessException,
					ParameterException {
				if(fieldType == String.class)
				{
					if(StrKit.isBlank(entity))
						throw new ParameterException(fieldName + " must not null");
					else
					{
						String value = entity;
						int valueLength = value.length();
						Length length = (Length) verifyAnnotation;
						if(valueLength < length.min() || valueLength > length.max())
						{
							throw new ParameterException(fieldName + " length must >= " + length.min() + " and <= " + length.max());
						}
					}
				}
			}
			
			@Override
			public void afterCheck(HttpServletRequest request,
					HttpServletResponse response, HandlerMethod method,
					Annotation annotation) throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public static void main(String[] args) {
		
	}
	
}
