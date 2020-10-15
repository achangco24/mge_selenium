/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Jar Loader
 * 
 *************************************************************************************
 *  
 * Author: EY_PHADV_Manila_Testing.GID@ey.net
 * 
 * CHANGE HISTORY:                                                
 *                                                                
 * Date:       	by:    	Reason:                     
 * YYYY-MM-DD	IN		Reason text.    
 * 
 *************************************************************************************
 */
package ey.manila.qa.plugin;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarLoader {
	private String pluginPath = "";
	private Class<?> superClassType;
	private ClassLoader loader;
	private File pluginFile;
	private JarFile pluginJar;
	
	/**Creates an instance of a custom class loader for Jar plugins 
	 * @param pluginPath - path of the Jar plugin
	 * @param superClassType - class type of the governing super class for the plugin
	 * @throws Exception
	 */
	public JarLoader(String pluginPath, Class<?> superClassType) throws Exception {
		this.pluginPath = pluginPath;
		this.superClassType = superClassType;
		
		try {
			pluginFile = new File(this.pluginPath);
			pluginJar = new JarFile(this.pluginPath);			
			this.loader = URLClassLoader.newInstance(
				new URL[] {pluginFile.toURI().toURL()},
				this.getClass().getClassLoader());
		} catch (Exception e) {
			System.out.println("Exception occured in initializing " + this.getClass().getSimpleName());
			throw e;
		}
	}
	
	/**Retrieves the classpaths of the valid subclasses
	 * as identified by the super class associated for the plugin
	 * @return
	 * String list of classpaths for the valid subclasses
	 * @throws Exception
	 */
	public List<String> getPluginClassPaths() throws Exception {
        List<String> classPaths = new ArrayList<String>();
        try {
			Enumeration<JarEntry> allEntries = pluginJar.entries();
            String name = "";
            String classPath = "";
            while (allEntries.hasMoreElements()) {
                name = ((JarEntry) allEntries.nextElement()).getName();
                if (name.endsWith(".class")) {
                	classPath = name.replace(".class", "").replace("/",  ".");
                	if (isSubclass(classPath)) {
                		classPaths.add(classPath);
                	}
                }
            }
        } catch (Exception e) {
        	System.out.println("Exception occured in extracting classpaths");
        	System.out.println("JAR File: " + pluginPath);
        	throw e;
        }
		
		return classPaths;
	}
	
	/**Creates an instance of the given classpath using the
	 * specified constructor arguments
	 * @param classPath - Equivalent classpath of the class to be instantiated
	 * @param classArgumentTypes - List of class types of the constructor arguments
	 * @param classArguments - List of object values of the constructor arguments
	 * @return
	 * Class instance of the given classpath. Null return means no instance was created.
	 * @throws Exception
	 */
	public Object instantiate(String classPath, List<Class<?>> classArgumentTypes, List<Object> classArguments) throws Exception {
		Object pluginInstance = null;
		Class<?>[] argTypes = normalizeClassArray(classArgumentTypes);
		Object[] arg = normalizeObjectArray(classArguments);
		
		try {
			//Create a class instance based on input constructor arguments
			Class<?> pluginClass = Class.forName(classPath, true, loader);
			int mod = pluginClass.getModifiers();
			if (mod != Modifier.ABSTRACT && mod != Modifier.INTERFACE) {
				Constructor<?> ctor = pluginClass.getConstructor(argTypes);
				pluginInstance = ctor.newInstance(arg);
			}
		} catch (Exception e) {
			System.out.println("Exception occured in instantiating plugin");
			throw e;
		}
		
		return pluginInstance;
	}
	
	/**Retrieves the available constructors from the specified classpath.
	 * @param classPath - Equivalent classpath
	 * @return
	 * List of constructor information
	 * @throws Exception
	 */
	public List<Constructor<?>> getConstructors(String classPath) throws Exception {
		Constructor<?>[] ctors;
		try {
			ctors = Class.forName(classPath, true, loader).getConstructors();
		} catch (Exception e) {
			System.out.println("Exception occured in retrieving constructor information");
			System.out.println("Class: " + classPath);
			throw e;
		}
		
		return Arrays.asList(ctors);
	}
	
	/**Checks if the specified classpath is a subclass of
	 * the associated super class.
	 * @param classPath - Equivalent classpath
	 * @return
	 * TRUE - classpath is a subclass <br>
	 * FALSE - classpath is not a subclass
	 */
	private boolean isSubclass(String classPath) {
		try {
			Class<?> pluginClass = Class.forName(classPath, true, loader);
			return superClassType.isAssignableFrom(pluginClass);
		} catch (Exception e) {
			System.out.println("Proceeding to next classpath");
			e.printStackTrace();
			return false;
		} catch (NoClassDefFoundError err) {
			System.out.println("Missing class definition found");
			System.out.println("Proceeding to next classpath");
			err.printStackTrace();
			return false;
		}
	}
	
	private Class<?>[] normalizeClassArray(List<Class<?>> classList) {
		if (classList == null) {
			return new Class<?>[0];
		}
		
		return (Class<?>[]) classList.toArray(new Class<?>[classList.size()]);
	}
	
	private Object[] normalizeObjectArray(List<Object> objectList) {
		if (objectList == null) {
			return new Object[0];
		}
		
		return objectList.toArray(new Object[objectList.size()]);
	}
}
