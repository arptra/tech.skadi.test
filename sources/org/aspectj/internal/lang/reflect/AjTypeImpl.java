package org.aspectj.internal.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.aspectj.internal.lang.annotation.ajcDeclareEoW;
import org.aspectj.internal.lang.annotation.ajcDeclareParents;
import org.aspectj.internal.lang.annotation.ajcDeclarePrecedence;
import org.aspectj.internal.lang.annotation.ajcDeclareSoft;
import org.aspectj.internal.lang.annotation.ajcITD;
import org.aspectj.internal.lang.annotation.ajcPrivileged;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareError;
import org.aspectj.lang.annotation.DeclareWarning;
import org.aspectj.lang.reflect.Advice;
import org.aspectj.lang.reflect.AdviceKind;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.DeclareAnnotation;
import org.aspectj.lang.reflect.DeclareErrorOrWarning;
import org.aspectj.lang.reflect.DeclareParents;
import org.aspectj.lang.reflect.DeclarePrecedence;
import org.aspectj.lang.reflect.DeclareSoft;
import org.aspectj.lang.reflect.InterTypeConstructorDeclaration;
import org.aspectj.lang.reflect.InterTypeFieldDeclaration;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;
import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.aspectj.lang.reflect.NoSuchPointcutException;
import org.aspectj.lang.reflect.PerClause;
import org.aspectj.lang.reflect.PerClauseKind;
import org.aspectj.lang.reflect.Pointcut;

public class AjTypeImpl<T> implements AjType<T> {
    private static final String ajcMagic = "ajc$";
    private Advice[] advice = null;
    private Class<T> clazz;
    private Advice[] declaredAdvice = null;
    private InterTypeConstructorDeclaration[] declaredITDCons = null;
    private InterTypeFieldDeclaration[] declaredITDFields = null;
    private InterTypeMethodDeclaration[] declaredITDMethods = null;
    private Pointcut[] declaredPointcuts = null;
    private InterTypeConstructorDeclaration[] itdCons = null;
    private InterTypeFieldDeclaration[] itdFields = null;
    private InterTypeMethodDeclaration[] itdMethods = null;
    private Pointcut[] pointcuts = null;

    public AjTypeImpl(Class<T> cls) {
        this.clazz = cls;
    }

    private void addAnnotationStyleDeclareParents(List<DeclareParents> list) {
        for (Field field : this.clazz.getDeclaredFields()) {
            Class cls = org.aspectj.lang.annotation.DeclareParents.class;
            if (field.isAnnotationPresent(cls) && field.getType().isInterface()) {
                list.add(new DeclareParentsImpl(((org.aspectj.lang.annotation.DeclareParents) field.getAnnotation(cls)).value(), field.getType().getName(), false, this));
            }
        }
    }

    private void addAnnotationStyleITDFields(List<InterTypeFieldDeclaration> list, boolean z) {
    }

    private void addAnnotationStyleITDMethods(List<InterTypeMethodDeclaration> list, boolean z) {
        if (isAspect()) {
            for (Field field : this.clazz.getDeclaredFields()) {
                if (field.getType().isInterface()) {
                    Class cls = org.aspectj.lang.annotation.DeclareParents.class;
                    if (field.isAnnotationPresent(cls) && ((org.aspectj.lang.annotation.DeclareParents) field.getAnnotation(cls)).defaultImpl() != cls) {
                        for (Method method : field.getType().getDeclaredMethods()) {
                            if (Modifier.isPublic(method.getModifiers()) || !z) {
                                list.add(new InterTypeMethodDeclarationImpl(this, AjTypeSystem.getAjType(field.getType()), method, 1));
                            }
                        }
                    }
                }
            }
        }
    }

    private Advice asAdvice(Method method) {
        if (method.getAnnotations().length == 0) {
            return null;
        }
        Before before = (Before) method.getAnnotation(Before.class);
        if (before != null) {
            return new AdviceImpl(method, before.value(), AdviceKind.BEFORE);
        }
        After after = (After) method.getAnnotation(After.class);
        if (after != null) {
            return new AdviceImpl(method, after.value(), AdviceKind.AFTER);
        }
        AfterReturning afterReturning = (AfterReturning) method.getAnnotation(AfterReturning.class);
        if (afterReturning != null) {
            String pointcut = afterReturning.pointcut();
            if (pointcut.equals("")) {
                pointcut = afterReturning.value();
            }
            return new AdviceImpl(method, pointcut, AdviceKind.AFTER_RETURNING, afterReturning.returning());
        }
        AfterThrowing afterThrowing = (AfterThrowing) method.getAnnotation(AfterThrowing.class);
        if (afterThrowing != null) {
            String pointcut2 = afterThrowing.pointcut();
            if (pointcut2 == null) {
                pointcut2 = afterThrowing.value();
            }
            return new AdviceImpl(method, pointcut2, AdviceKind.AFTER_THROWING, afterThrowing.throwing());
        }
        Around around = (Around) method.getAnnotation(Around.class);
        if (around != null) {
            return new AdviceImpl(method, around.value(), AdviceKind.AROUND);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = r0.substring(r0.indexOf("$$") + 2, r0.length());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.aspectj.lang.reflect.Pointcut asPointcut(java.lang.reflect.Method r8) {
        /*
            r7 = this;
            java.lang.Class<org.aspectj.lang.annotation.Pointcut> r7 = org.aspectj.lang.annotation.Pointcut.class
            java.lang.annotation.Annotation r7 = r8.getAnnotation(r7)
            org.aspectj.lang.annotation.Pointcut r7 = (org.aspectj.lang.annotation.Pointcut) r7
            if (r7 == 0) goto L_0x004d
            java.lang.String r0 = r8.getName()
            java.lang.String r1 = "ajc$"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = "$$"
            int r1 = r0.indexOf(r1)
            int r1 = r1 + 2
            int r2 = r0.length()
            java.lang.String r0 = r0.substring(r1, r2)
            java.lang.String r1 = "$"
            int r1 = r0.indexOf(r1)
            r2 = -1
            if (r1 == r2) goto L_0x0034
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)
        L_0x0034:
            r2 = r0
            org.aspectj.internal.lang.reflect.PointcutImpl r0 = new org.aspectj.internal.lang.reflect.PointcutImpl
            java.lang.String r3 = r7.value()
            java.lang.Class r1 = r8.getDeclaringClass()
            org.aspectj.lang.reflect.AjType r5 = org.aspectj.lang.reflect.AjTypeSystem.getAjType(r1)
            java.lang.String r6 = r7.argNames()
            r1 = r0
            r4 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            return r0
        L_0x004d:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.aspectj.internal.lang.reflect.AjTypeImpl.asPointcut(java.lang.reflect.Method):org.aspectj.lang.reflect.Pointcut");
    }

    private void initAdvice() {
        Method[] methods = this.clazz.getMethods();
        ArrayList arrayList = new ArrayList();
        for (Method asAdvice : methods) {
            Advice asAdvice2 = asAdvice(asAdvice);
            if (asAdvice2 != null) {
                arrayList.add(asAdvice2);
            }
        }
        Advice[] adviceArr = new Advice[arrayList.size()];
        this.advice = adviceArr;
        arrayList.toArray(adviceArr);
    }

    private void initDeclaredAdvice() {
        Method[] declaredMethods = this.clazz.getDeclaredMethods();
        ArrayList arrayList = new ArrayList();
        for (Method asAdvice : declaredMethods) {
            Advice asAdvice2 = asAdvice(asAdvice);
            if (asAdvice2 != null) {
                arrayList.add(asAdvice2);
            }
        }
        Advice[] adviceArr = new Advice[arrayList.size()];
        this.declaredAdvice = adviceArr;
        arrayList.toArray(adviceArr);
    }

    private boolean isReallyAMethod(Method method) {
        if (method.getName().startsWith(ajcMagic)) {
            return false;
        }
        if (method.getAnnotations().length == 0) {
            return true;
        }
        return !method.isAnnotationPresent(org.aspectj.lang.annotation.Pointcut.class) && !method.isAnnotationPresent(Before.class) && !method.isAnnotationPresent(After.class) && !method.isAnnotationPresent(AfterReturning.class) && !method.isAnnotationPresent(AfterThrowing.class) && !method.isAnnotationPresent(Around.class);
    }

    private AjType<?>[] toAjTypeArray(Class<?>[] clsArr) {
        int length = clsArr.length;
        AjType<?>[] ajTypeArr = new AjType[length];
        for (int i = 0; i < length; i++) {
            ajTypeArr[i] = AjTypeSystem.getAjType(clsArr[i]);
        }
        return ajTypeArr;
    }

    private Class<?>[] toClassArray(AjType<?>[] ajTypeArr) {
        int length = ajTypeArr.length;
        Class<?>[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = ajTypeArr[i].getJavaClass();
        }
        return clsArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AjTypeImpl)) {
            return false;
        }
        return ((AjTypeImpl) obj).clazz.equals(this.clazz);
    }

    public Advice[] getAdvice(AdviceKind... adviceKindArr) {
        EnumSet<E> enumSet;
        Class<AdviceKind> cls = AdviceKind.class;
        if (adviceKindArr.length == 0) {
            enumSet = EnumSet.allOf(cls);
        } else {
            EnumSet<E> noneOf = EnumSet.noneOf(cls);
            noneOf.addAll(Arrays.asList(adviceKindArr));
            enumSet = noneOf;
        }
        return getAdvice((Set<AdviceKind>) enumSet);
    }

    public AjType<?>[] getAjTypes() {
        return toAjTypeArray(this.clazz.getClasses());
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.clazz.getAnnotation(cls);
    }

    public Annotation[] getAnnotations() {
        return this.clazz.getAnnotations();
    }

    public Constructor getConstructor(AjType<?>... ajTypeArr) throws NoSuchMethodException {
        return this.clazz.getConstructor(toClassArray(ajTypeArr));
    }

    public Constructor[] getConstructors() {
        return this.clazz.getConstructors();
    }

    public DeclareAnnotation[] getDeclareAnnotations() {
        Annotation annotation;
        ArrayList arrayList = new ArrayList();
        for (Method method : this.clazz.getDeclaredMethods()) {
            Class cls = ajcDeclareAnnotation.class;
            if (method.isAnnotationPresent(cls)) {
                ajcDeclareAnnotation ajcdeclareannotation = (ajcDeclareAnnotation) method.getAnnotation(cls);
                Annotation[] annotations = method.getAnnotations();
                int length = annotations.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        annotation = null;
                        break;
                    }
                    Annotation annotation2 = annotations[i];
                    if (annotation2.annotationType() != cls) {
                        annotation = annotation2;
                        break;
                    }
                    i++;
                }
                arrayList.add(new DeclareAnnotationImpl(this, ajcdeclareannotation.kind(), ajcdeclareannotation.pattern(), annotation, ajcdeclareannotation.annotation()));
            }
        }
        if (getSupertype().isAspect()) {
            arrayList.addAll(Arrays.asList(getSupertype().getDeclareAnnotations()));
        }
        DeclareAnnotation[] declareAnnotationArr = new DeclareAnnotation[arrayList.size()];
        arrayList.toArray(declareAnnotationArr);
        return declareAnnotationArr;
    }

    public DeclareErrorOrWarning[] getDeclareErrorOrWarnings() {
        Class cls = DeclareError.class;
        Class cls2 = DeclareWarning.class;
        ArrayList arrayList = new ArrayList();
        for (Field field : this.clazz.getDeclaredFields()) {
            try {
                if (field.isAnnotationPresent(cls2)) {
                    DeclareWarning declareWarning = (DeclareWarning) field.getAnnotation(cls2);
                    if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers())) {
                        arrayList.add(new DeclareErrorOrWarningImpl(declareWarning.value(), (String) field.get((Object) null), false, this));
                    }
                } else if (field.isAnnotationPresent(cls)) {
                    DeclareError declareError = (DeclareError) field.getAnnotation(cls);
                    if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers())) {
                        arrayList.add(new DeclareErrorOrWarningImpl(declareError.value(), (String) field.get((Object) null), true, this));
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException unused) {
            }
        }
        for (Method method : this.clazz.getDeclaredMethods()) {
            Class cls3 = ajcDeclareEoW.class;
            if (method.isAnnotationPresent(cls3)) {
                ajcDeclareEoW ajcdeclareeow = (ajcDeclareEoW) method.getAnnotation(cls3);
                arrayList.add(new DeclareErrorOrWarningImpl(ajcdeclareeow.pointcut(), ajcdeclareeow.message(), ajcdeclareeow.isError(), this));
            }
        }
        DeclareErrorOrWarning[] declareErrorOrWarningArr = new DeclareErrorOrWarning[arrayList.size()];
        arrayList.toArray(declareErrorOrWarningArr);
        return declareErrorOrWarningArr;
    }

    public DeclareParents[] getDeclareParents() {
        ArrayList arrayList = new ArrayList();
        for (Method method : this.clazz.getDeclaredMethods()) {
            Class cls = ajcDeclareParents.class;
            if (method.isAnnotationPresent(cls)) {
                ajcDeclareParents ajcdeclareparents = (ajcDeclareParents) method.getAnnotation(cls);
                arrayList.add(new DeclareParentsImpl(ajcdeclareparents.targetTypePattern(), ajcdeclareparents.parentTypes(), ajcdeclareparents.isExtends(), this));
            }
        }
        addAnnotationStyleDeclareParents(arrayList);
        if (getSupertype().isAspect()) {
            arrayList.addAll(Arrays.asList(getSupertype().getDeclareParents()));
        }
        DeclareParents[] declareParentsArr = new DeclareParents[arrayList.size()];
        arrayList.toArray(declareParentsArr);
        return declareParentsArr;
    }

    public DeclarePrecedence[] getDeclarePrecedence() {
        ArrayList arrayList = new ArrayList();
        Class<org.aspectj.lang.annotation.DeclarePrecedence> cls = org.aspectj.lang.annotation.DeclarePrecedence.class;
        if (this.clazz.isAnnotationPresent(cls)) {
            arrayList.add(new DeclarePrecedenceImpl(((org.aspectj.lang.annotation.DeclarePrecedence) this.clazz.getAnnotation(cls)).value(), this));
        }
        for (Method method : this.clazz.getDeclaredMethods()) {
            Class cls2 = ajcDeclarePrecedence.class;
            if (method.isAnnotationPresent(cls2)) {
                arrayList.add(new DeclarePrecedenceImpl(((ajcDeclarePrecedence) method.getAnnotation(cls2)).value(), this));
            }
        }
        if (getSupertype().isAspect()) {
            arrayList.addAll(Arrays.asList(getSupertype().getDeclarePrecedence()));
        }
        DeclarePrecedence[] declarePrecedenceArr = new DeclarePrecedence[arrayList.size()];
        arrayList.toArray(declarePrecedenceArr);
        return declarePrecedenceArr;
    }

    public DeclareSoft[] getDeclareSofts() {
        ArrayList arrayList = new ArrayList();
        for (Method method : this.clazz.getDeclaredMethods()) {
            Class cls = ajcDeclareSoft.class;
            if (method.isAnnotationPresent(cls)) {
                ajcDeclareSoft ajcdeclaresoft = (ajcDeclareSoft) method.getAnnotation(cls);
                arrayList.add(new DeclareSoftImpl(this, ajcdeclaresoft.pointcut(), ajcdeclaresoft.exceptionType()));
            }
        }
        if (getSupertype().isAspect()) {
            arrayList.addAll(Arrays.asList(getSupertype().getDeclareSofts()));
        }
        DeclareSoft[] declareSoftArr = new DeclareSoft[arrayList.size()];
        arrayList.toArray(declareSoftArr);
        return declareSoftArr;
    }

    public Advice[] getDeclaredAdvice(AdviceKind... adviceKindArr) {
        EnumSet<E> enumSet;
        Class<AdviceKind> cls = AdviceKind.class;
        if (adviceKindArr.length == 0) {
            enumSet = EnumSet.allOf(cls);
        } else {
            EnumSet<E> noneOf = EnumSet.noneOf(cls);
            noneOf.addAll(Arrays.asList(adviceKindArr));
            enumSet = noneOf;
        }
        return getDeclaredAdvice((Set<AdviceKind>) enumSet);
    }

    public AjType<?>[] getDeclaredAjTypes() {
        return toAjTypeArray(this.clazz.getDeclaredClasses());
    }

    public Annotation[] getDeclaredAnnotations() {
        return this.clazz.getDeclaredAnnotations();
    }

    public Constructor getDeclaredConstructor(AjType<?>... ajTypeArr) throws NoSuchMethodException {
        return this.clazz.getDeclaredConstructor(toClassArray(ajTypeArr));
    }

    public Constructor[] getDeclaredConstructors() {
        return this.clazz.getDeclaredConstructors();
    }

    public Field getDeclaredField(String str) throws NoSuchFieldException {
        Field declaredField = this.clazz.getDeclaredField(str);
        if (!declaredField.getName().startsWith(ajcMagic)) {
            return declaredField;
        }
        throw new NoSuchFieldException(str);
    }

    public Field[] getDeclaredFields() {
        Field[] declaredFields = this.clazz.getDeclaredFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (!field.getName().startsWith(ajcMagic) && !field.isAnnotationPresent(DeclareWarning.class) && !field.isAnnotationPresent(DeclareError.class)) {
                arrayList.add(field);
            }
        }
        Field[] fieldArr = new Field[arrayList.size()];
        arrayList.toArray(fieldArr);
        return fieldArr;
    }

    public InterTypeConstructorDeclaration getDeclaredITDConstructor(AjType<?> ajType, AjType<?>... ajTypeArr) throws NoSuchMethodException {
        for (InterTypeConstructorDeclaration interTypeConstructorDeclaration : getDeclaredITDConstructors()) {
            try {
                if (interTypeConstructorDeclaration.getTargetType().equals(ajType)) {
                    AjType[] parameterTypes = interTypeConstructorDeclaration.getParameterTypes();
                    if (parameterTypes.length == ajTypeArr.length) {
                        int i = 0;
                        while (i < parameterTypes.length) {
                            if (parameterTypes[i].equals(ajTypeArr[i])) {
                                i++;
                            }
                        }
                        return interTypeConstructorDeclaration;
                    }
                    continue;
                } else {
                    continue;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new NoSuchMethodException();
    }

    public InterTypeConstructorDeclaration[] getDeclaredITDConstructors() {
        if (this.declaredITDCons == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.clazz.getDeclaredMethods()) {
                if (method.getName().contains("ajc$postInterConstructor")) {
                    Class cls = ajcITD.class;
                    if (method.isAnnotationPresent(cls)) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(cls);
                        arrayList.add(new InterTypeConstructorDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), method));
                    }
                }
            }
            InterTypeConstructorDeclaration[] interTypeConstructorDeclarationArr = new InterTypeConstructorDeclaration[arrayList.size()];
            this.declaredITDCons = interTypeConstructorDeclarationArr;
            arrayList.toArray(interTypeConstructorDeclarationArr);
        }
        return this.declaredITDCons;
    }

    public InterTypeFieldDeclaration getDeclaredITDField(String str, AjType<?> ajType) throws NoSuchFieldException {
        for (InterTypeFieldDeclaration interTypeFieldDeclaration : getDeclaredITDFields()) {
            if (interTypeFieldDeclaration.getName().equals(str)) {
                try {
                    if (interTypeFieldDeclaration.getTargetType().equals(ajType)) {
                        return interTypeFieldDeclaration;
                    }
                } catch (ClassNotFoundException unused) {
                    continue;
                }
            }
        }
        throw new NoSuchFieldException(str);
    }

    public InterTypeFieldDeclaration[] getDeclaredITDFields() {
        ArrayList arrayList = new ArrayList();
        if (this.declaredITDFields == null) {
            for (Method method : this.clazz.getDeclaredMethods()) {
                Class cls = ajcITD.class;
                if (method.isAnnotationPresent(cls) && method.getName().contains("ajc$interFieldInit")) {
                    ajcITD ajcitd = (ajcITD) method.getAnnotation(cls);
                    try {
                        Method declaredMethod = this.clazz.getDeclaredMethod(method.getName().replace("FieldInit", "FieldGetDispatch"), method.getParameterTypes());
                        arrayList.add(new InterTypeFieldDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), ajcitd.name(), AjTypeSystem.getAjType(declaredMethod.getReturnType()), declaredMethod.getGenericReturnType()));
                    } catch (NoSuchMethodException unused) {
                        throw new IllegalStateException("Can't find field get dispatch method for " + method.getName());
                    }
                }
            }
            addAnnotationStyleITDFields(arrayList, false);
            InterTypeFieldDeclaration[] interTypeFieldDeclarationArr = new InterTypeFieldDeclaration[arrayList.size()];
            this.declaredITDFields = interTypeFieldDeclarationArr;
            arrayList.toArray(interTypeFieldDeclarationArr);
        }
        return this.declaredITDFields;
    }

    public InterTypeMethodDeclaration getDeclaredITDMethod(String str, AjType<?> ajType, AjType<?>... ajTypeArr) throws NoSuchMethodException {
        for (InterTypeMethodDeclaration interTypeMethodDeclaration : getDeclaredITDMethods()) {
            try {
                if (interTypeMethodDeclaration.getName().equals(str)) {
                    if (interTypeMethodDeclaration.getTargetType().equals(ajType)) {
                        AjType[] parameterTypes = interTypeMethodDeclaration.getParameterTypes();
                        if (parameterTypes.length == ajTypeArr.length) {
                            int i = 0;
                            while (i < parameterTypes.length) {
                                if (parameterTypes[i].equals(ajTypeArr[i])) {
                                    i++;
                                }
                            }
                            return interTypeMethodDeclaration;
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new NoSuchMethodException(str);
    }

    public InterTypeMethodDeclaration[] getDeclaredITDMethods() {
        if (this.declaredITDMethods == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.clazz.getDeclaredMethods()) {
                if (method.getName().contains("ajc$interMethodDispatch1$")) {
                    Class cls = ajcITD.class;
                    if (method.isAnnotationPresent(cls)) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(cls);
                        arrayList.add(new InterTypeMethodDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), ajcitd.name(), method));
                    }
                }
            }
            addAnnotationStyleITDMethods(arrayList, false);
            InterTypeMethodDeclaration[] interTypeMethodDeclarationArr = new InterTypeMethodDeclaration[arrayList.size()];
            this.declaredITDMethods = interTypeMethodDeclarationArr;
            arrayList.toArray(interTypeMethodDeclarationArr);
        }
        return this.declaredITDMethods;
    }

    public Method getDeclaredMethod(String str, AjType<?>... ajTypeArr) throws NoSuchMethodException {
        Method declaredMethod = this.clazz.getDeclaredMethod(str, toClassArray(ajTypeArr));
        if (isReallyAMethod(declaredMethod)) {
            return declaredMethod;
        }
        throw new NoSuchMethodException(str);
    }

    public Method[] getDeclaredMethods() {
        Method[] declaredMethods = this.clazz.getDeclaredMethods();
        ArrayList arrayList = new ArrayList();
        for (Method method : declaredMethods) {
            if (isReallyAMethod(method)) {
                arrayList.add(method);
            }
        }
        Method[] methodArr = new Method[arrayList.size()];
        arrayList.toArray(methodArr);
        return methodArr;
    }

    public Pointcut getDeclaredPointcut(String str) throws NoSuchPointcutException {
        for (Pointcut pointcut : getDeclaredPointcuts()) {
            if (pointcut.getName().equals(str)) {
                return pointcut;
            }
        }
        throw new NoSuchPointcutException(str);
    }

    public Pointcut[] getDeclaredPointcuts() {
        Pointcut[] pointcutArr = this.declaredPointcuts;
        if (pointcutArr != null) {
            return pointcutArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Method asPointcut : this.clazz.getDeclaredMethods()) {
            Pointcut asPointcut2 = asPointcut(asPointcut);
            if (asPointcut2 != null) {
                arrayList.add(asPointcut2);
            }
        }
        Pointcut[] pointcutArr2 = new Pointcut[arrayList.size()];
        arrayList.toArray(pointcutArr2);
        this.declaredPointcuts = pointcutArr2;
        return pointcutArr2;
    }

    public AjType<?> getDeclaringType() {
        Class<?> declaringClass = this.clazz.getDeclaringClass();
        if (declaringClass != null) {
            return new AjTypeImpl(declaringClass);
        }
        return null;
    }

    public Constructor getEnclosingConstructor() {
        return this.clazz.getEnclosingConstructor();
    }

    public Method getEnclosingMethod() {
        return this.clazz.getEnclosingMethod();
    }

    public AjType<?> getEnclosingType() {
        Class<?> enclosingClass = this.clazz.getEnclosingClass();
        if (enclosingClass != null) {
            return new AjTypeImpl(enclosingClass);
        }
        return null;
    }

    public T[] getEnumConstants() {
        return this.clazz.getEnumConstants();
    }

    public Field getField(String str) throws NoSuchFieldException {
        Field field = this.clazz.getField(str);
        if (!field.getName().startsWith(ajcMagic)) {
            return field;
        }
        throw new NoSuchFieldException(str);
    }

    public Field[] getFields() {
        Field[] fields = this.clazz.getFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : fields) {
            if (!field.getName().startsWith(ajcMagic) && !field.isAnnotationPresent(DeclareWarning.class) && !field.isAnnotationPresent(DeclareError.class)) {
                arrayList.add(field);
            }
        }
        Field[] fieldArr = new Field[arrayList.size()];
        arrayList.toArray(fieldArr);
        return fieldArr;
    }

    public Type getGenericSupertype() {
        return this.clazz.getGenericSuperclass();
    }

    public InterTypeConstructorDeclaration getITDConstructor(AjType<?> ajType, AjType<?>... ajTypeArr) throws NoSuchMethodException {
        for (InterTypeConstructorDeclaration interTypeConstructorDeclaration : getITDConstructors()) {
            try {
                if (interTypeConstructorDeclaration.getTargetType().equals(ajType)) {
                    AjType[] parameterTypes = interTypeConstructorDeclaration.getParameterTypes();
                    if (parameterTypes.length == ajTypeArr.length) {
                        int i = 0;
                        while (i < parameterTypes.length) {
                            if (parameterTypes[i].equals(ajTypeArr[i])) {
                                i++;
                            }
                        }
                        return interTypeConstructorDeclaration;
                    }
                    continue;
                } else {
                    continue;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new NoSuchMethodException();
    }

    public InterTypeConstructorDeclaration[] getITDConstructors() {
        if (this.itdCons == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.clazz.getMethods()) {
                if (method.getName().contains("ajc$postInterConstructor")) {
                    Class cls = ajcITD.class;
                    if (method.isAnnotationPresent(cls)) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(cls);
                        if (Modifier.isPublic(ajcitd.modifiers())) {
                            arrayList.add(new InterTypeConstructorDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), method));
                        }
                    }
                }
            }
            InterTypeConstructorDeclaration[] interTypeConstructorDeclarationArr = new InterTypeConstructorDeclaration[arrayList.size()];
            this.itdCons = interTypeConstructorDeclarationArr;
            arrayList.toArray(interTypeConstructorDeclarationArr);
        }
        return this.itdCons;
    }

    public InterTypeFieldDeclaration getITDField(String str, AjType<?> ajType) throws NoSuchFieldException {
        for (InterTypeFieldDeclaration interTypeFieldDeclaration : getITDFields()) {
            if (interTypeFieldDeclaration.getName().equals(str)) {
                try {
                    if (interTypeFieldDeclaration.getTargetType().equals(ajType)) {
                        return interTypeFieldDeclaration;
                    }
                } catch (ClassNotFoundException unused) {
                    continue;
                }
            }
        }
        throw new NoSuchFieldException(str);
    }

    public InterTypeFieldDeclaration[] getITDFields() {
        ArrayList arrayList = new ArrayList();
        if (this.itdFields == null) {
            for (Method method : this.clazz.getMethods()) {
                Class cls = ajcITD.class;
                if (method.isAnnotationPresent(cls)) {
                    ajcITD ajcitd = (ajcITD) method.getAnnotation(cls);
                    if (method.getName().contains("ajc$interFieldInit") && Modifier.isPublic(ajcitd.modifiers())) {
                        try {
                            Method declaredMethod = method.getDeclaringClass().getDeclaredMethod(method.getName().replace("FieldInit", "FieldGetDispatch"), method.getParameterTypes());
                            arrayList.add(new InterTypeFieldDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), ajcitd.name(), AjTypeSystem.getAjType(declaredMethod.getReturnType()), declaredMethod.getGenericReturnType()));
                        } catch (NoSuchMethodException unused) {
                            throw new IllegalStateException("Can't find field get dispatch method for " + method.getName());
                        }
                    }
                }
            }
            addAnnotationStyleITDFields(arrayList, true);
            InterTypeFieldDeclaration[] interTypeFieldDeclarationArr = new InterTypeFieldDeclaration[arrayList.size()];
            this.itdFields = interTypeFieldDeclarationArr;
            arrayList.toArray(interTypeFieldDeclarationArr);
        }
        return this.itdFields;
    }

    public InterTypeMethodDeclaration getITDMethod(String str, AjType<?> ajType, AjType<?>... ajTypeArr) throws NoSuchMethodException {
        for (InterTypeMethodDeclaration interTypeMethodDeclaration : getITDMethods()) {
            try {
                if (interTypeMethodDeclaration.getName().equals(str)) {
                    if (interTypeMethodDeclaration.getTargetType().equals(ajType)) {
                        AjType[] parameterTypes = interTypeMethodDeclaration.getParameterTypes();
                        if (parameterTypes.length == ajTypeArr.length) {
                            int i = 0;
                            while (i < parameterTypes.length) {
                                if (parameterTypes[i].equals(ajTypeArr[i])) {
                                    i++;
                                }
                            }
                            return interTypeMethodDeclaration;
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new NoSuchMethodException(str);
    }

    public InterTypeMethodDeclaration[] getITDMethods() {
        if (this.itdMethods == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.clazz.getDeclaredMethods()) {
                if (method.getName().contains("ajc$interMethod$")) {
                    Class cls = ajcITD.class;
                    if (method.isAnnotationPresent(cls)) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(cls);
                        if (Modifier.isPublic(ajcitd.modifiers())) {
                            arrayList.add(new InterTypeMethodDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), ajcitd.name(), method));
                        }
                    }
                }
            }
            addAnnotationStyleITDMethods(arrayList, true);
            InterTypeMethodDeclaration[] interTypeMethodDeclarationArr = new InterTypeMethodDeclaration[arrayList.size()];
            this.itdMethods = interTypeMethodDeclarationArr;
            arrayList.toArray(interTypeMethodDeclarationArr);
        }
        return this.itdMethods;
    }

    public AjType<?>[] getInterfaces() {
        return toAjTypeArray(this.clazz.getInterfaces());
    }

    public Class<T> getJavaClass() {
        return this.clazz;
    }

    public Method getMethod(String str, AjType<?>... ajTypeArr) throws NoSuchMethodException {
        Method method = this.clazz.getMethod(str, toClassArray(ajTypeArr));
        if (isReallyAMethod(method)) {
            return method;
        }
        throw new NoSuchMethodException(str);
    }

    public Method[] getMethods() {
        Method[] methods = this.clazz.getMethods();
        ArrayList arrayList = new ArrayList();
        for (Method method : methods) {
            if (isReallyAMethod(method)) {
                arrayList.add(method);
            }
        }
        Method[] methodArr = new Method[arrayList.size()];
        arrayList.toArray(methodArr);
        return methodArr;
    }

    public int getModifiers() {
        return this.clazz.getModifiers();
    }

    public String getName() {
        return this.clazz.getName();
    }

    public Package getPackage() {
        return this.clazz.getPackage();
    }

    public PerClause getPerClause() {
        if (!isAspect()) {
            return null;
        }
        String value = ((Aspect) this.clazz.getAnnotation(Aspect.class)).value();
        if (value.equals("")) {
            return getSupertype().isAspect() ? getSupertype().getPerClause() : new PerClauseImpl(PerClauseKind.SINGLETON);
        }
        if (value.startsWith("perthis(")) {
            return new PointcutBasedPerClauseImpl(PerClauseKind.PERTHIS, value.substring(8, value.length() - 1));
        }
        if (value.startsWith("pertarget(")) {
            return new PointcutBasedPerClauseImpl(PerClauseKind.PERTARGET, value.substring(10, value.length() - 1));
        }
        if (value.startsWith("percflow(")) {
            return new PointcutBasedPerClauseImpl(PerClauseKind.PERCFLOW, value.substring(9, value.length() - 1));
        }
        if (value.startsWith("percflowbelow(")) {
            return new PointcutBasedPerClauseImpl(PerClauseKind.PERCFLOWBELOW, value.substring(14, value.length() - 1));
        }
        if (value.startsWith("pertypewithin")) {
            return new TypePatternBasedPerClauseImpl(PerClauseKind.PERTYPEWITHIN, value.substring(14, value.length() - 1));
        }
        throw new IllegalStateException("Per-clause not recognized: " + value);
    }

    public Pointcut getPointcut(String str) throws NoSuchPointcutException {
        for (Pointcut pointcut : getPointcuts()) {
            if (pointcut.getName().equals(str)) {
                return pointcut;
            }
        }
        throw new NoSuchPointcutException(str);
    }

    public Pointcut[] getPointcuts() {
        Pointcut[] pointcutArr = this.pointcuts;
        if (pointcutArr != null) {
            return pointcutArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Method asPointcut : this.clazz.getMethods()) {
            Pointcut asPointcut2 = asPointcut(asPointcut);
            if (asPointcut2 != null) {
                arrayList.add(asPointcut2);
            }
        }
        Pointcut[] pointcutArr2 = new Pointcut[arrayList.size()];
        arrayList.toArray(pointcutArr2);
        this.pointcuts = pointcutArr2;
        return pointcutArr2;
    }

    public AjType<? super T> getSupertype() {
        Class<? super T> superclass = this.clazz.getSuperclass();
        if (superclass == null) {
            return null;
        }
        return new AjTypeImpl(superclass);
    }

    public TypeVariable<Class<T>>[] getTypeParameters() {
        return this.clazz.getTypeParameters();
    }

    public int hashCode() {
        return this.clazz.hashCode();
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.clazz.isAnnotationPresent(cls);
    }

    public boolean isArray() {
        return this.clazz.isArray();
    }

    public boolean isAspect() {
        return this.clazz.getAnnotation(Aspect.class) != null;
    }

    public boolean isEnum() {
        return this.clazz.isEnum();
    }

    public boolean isInstance(Object obj) {
        return this.clazz.isInstance(obj);
    }

    public boolean isInterface() {
        return this.clazz.isInterface();
    }

    public boolean isLocalClass() {
        return this.clazz.isLocalClass() && !isAspect();
    }

    public boolean isMemberAspect() {
        return this.clazz.isMemberClass() && isAspect();
    }

    public boolean isMemberClass() {
        return this.clazz.isMemberClass() && !isAspect();
    }

    public boolean isPrimitive() {
        return this.clazz.isPrimitive();
    }

    public boolean isPrivileged() {
        return isAspect() && this.clazz.isAnnotationPresent(ajcPrivileged.class);
    }

    public String toString() {
        return getName();
    }

    private Advice[] getAdvice(Set<AdviceKind> set) {
        if (this.advice == null) {
            initAdvice();
        }
        ArrayList arrayList = new ArrayList();
        for (Advice advice2 : this.advice) {
            if (set.contains(advice2.getKind())) {
                arrayList.add(advice2);
            }
        }
        Advice[] adviceArr = new Advice[arrayList.size()];
        arrayList.toArray(adviceArr);
        return adviceArr;
    }

    private Advice[] getDeclaredAdvice(Set<AdviceKind> set) {
        if (this.declaredAdvice == null) {
            initDeclaredAdvice();
        }
        ArrayList arrayList = new ArrayList();
        for (Advice advice2 : this.declaredAdvice) {
            if (set.contains(advice2.getKind())) {
                arrayList.add(advice2);
            }
        }
        Advice[] adviceArr = new Advice[arrayList.size()];
        arrayList.toArray(adviceArr);
        return adviceArr;
    }

    public Advice getAdvice(String str) throws NoSuchAdviceException {
        if (!str.equals("")) {
            if (this.advice == null) {
                initAdvice();
            }
            for (Advice advice2 : this.advice) {
                if (advice2.getName().equals(str)) {
                    return advice2;
                }
            }
            throw new NoSuchAdviceException(str);
        }
        throw new IllegalArgumentException("use getAdvice(AdviceType...) instead for un-named advice");
    }

    public Advice getDeclaredAdvice(String str) throws NoSuchAdviceException {
        if (!str.equals("")) {
            if (this.declaredAdvice == null) {
                initDeclaredAdvice();
            }
            for (Advice advice2 : this.declaredAdvice) {
                if (advice2.getName().equals(str)) {
                    return advice2;
                }
            }
            throw new NoSuchAdviceException(str);
        }
        throw new IllegalArgumentException("use getAdvice(AdviceType...) instead for un-named advice");
    }
}
