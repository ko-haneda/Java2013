package ch16.ex16_09;

import java.lang.reflect.*;

public class ex16_09 {

	public static void main(String[] args) {
		String class_name = "java.lang.Integer";
		try {
			Class<?> cls = Class.forName(class_name);
			System.out.println("class " + cls.getSimpleName() + " {");
			System.out.println(toStringField(cls));
			System.out.println(toStringConstructor(cls));
			System.out.println(toStringMethod(cls));
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//field
	public static String toStringField(Class<?> cls){
		Field[] fields = cls.getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		for(Field f : fields){
			sb.append("\t");
			int m = f.getModifiers();
			if(Modifier.isPublic(m))	sb.append("public ");
			if(Modifier.isProtected(m))	sb.append("protected ");
			if(Modifier.isPrivate(m))	sb.append("private ");
	
			if(Modifier.isStatic(m))	sb.append("static ");
			if(Modifier.isFinal(m))		sb.append("final ");
			sb.append(f.getType().getSimpleName() + " ");
			sb.append(f.getName());
			try {
				sb.append(" = " + f.get(cls));
			} catch (IllegalArgumentException | IllegalAccessException e) {
			}
			sb.append(";\n");
		}
		return sb.toString();
	}
	
	//constructor
	public static String toStringConstructor(Class<?> cls){
		Constructor<?>[] cons = cls.getConstructors();
		StringBuffer sb = new StringBuffer();
		for(Constructor<?> c: cons){
			sb.append("\t");
			int m = c.getModifiers();
			if(Modifier.isPublic(m))	sb.append("public ");
			if(Modifier.isProtected(m))	sb.append("protected ");
			if(Modifier.isPrivate(m))	sb.append("private ");
	
			if(Modifier.isStatic(m))	sb.append("static ");
			if(Modifier.isFinal(m))		sb.append("final ");
			sb.append(c.getDeclaringClass().getSimpleName());
			Class<?> []cl = c.getParameterTypes();
			sb.append("(");
			int i = 0;
			for(Class<?> cla: cl){
				if(i++ != 0)	sb.append(" ,");
				sb.append(cla.getSimpleName());
			}
			sb.append(")");
			//例外追加
			if(c.getExceptionTypes().length > 0){
				sb.append(" throws ");
				for (Type t : c.getExceptionTypes()) {
					sb.append(((Class<?>) t).getSimpleName() + ",");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append(";\n");
		}
		return sb.toString();
	}
	
	//method
	public static String toStringMethod(Class<?> cls){
		Method[] methods = cls.getMethods();
		StringBuffer sb = new StringBuffer();
		for(Method me : methods){
			sb.append("\t");
			int m = me.getModifiers();
			if(Modifier.isPublic(m))	sb.append("public ");
			if(Modifier.isProtected(m))	sb.append("protected ");
			if(Modifier.isPrivate(m))	sb.append("private ");
	
			if(Modifier.isStatic(m))	sb.append("static ");
			if(Modifier.isFinal(m))		sb.append("final ");
			sb.append(me.getReturnType().getSimpleName() + " ");
			sb.append(me.getName());
			Class<?> []cl = me.getParameterTypes();
			sb.append("(");
			int i = 0;
			for(Class<?> cla: cl){
				if(i++ != 0)	sb.append(" ,");
				sb.append(cla.getSimpleName());
			}
			sb.append(")");
			//例外追加
			if(me.getExceptionTypes().length > 0){
				sb.append(" throws ");
				for (Type t : me.getExceptionTypes()) {
					sb.append(((Class<?>) t).getSimpleName() + ",");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append(";\n");
		}
		return sb.toString();
	}
}