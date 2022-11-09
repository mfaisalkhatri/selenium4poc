package io.github.mfaisalkhatri.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author Faisal Khatri
 * @since 11/2/2022
 **/
public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform (final ITestAnnotation annotation, final Class testClass, final Constructor testConstructor,
        final Method testMethod) {
        annotation.setRetryAnalyzer (Retry.class);
    }
}
