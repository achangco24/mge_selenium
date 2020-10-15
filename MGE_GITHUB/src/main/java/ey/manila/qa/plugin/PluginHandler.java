/*
 *************************************************************************************
 *                                                                
 * PROGRAM DESCRIPTION:                                           
 *           
 * Plugin Handler
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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class PluginHandler {
	private JarLoader jarLoader;
	private String[] extension = new String[] {"jar"};
	private String pluginPath = "";
	private Class<?> superClassType;
	
	private List<String> instanceClassPaths = new ArrayList<String>();
	/**Gets the class paths corresponding the valid class instances found within the Jar plugin.
	 * <br><br>
	 * Make sure to call the load method prior to getting the class paths.
	 * Otherwise, this will return an empty list.
	 * @return
	 * List<String> of the class paths corresponding the valid class instances.
	 */
	public List<String> getInstanceClassPaths() {
		return this.instanceClassPaths;
	}
	
	private List<Object> classInstances = new ArrayList<Object>();
	/**Gets the object reference for the valid class instances found within the Jar plugin.
	 * <br><br>
	 * Make sure to call the load method prior to getting the class instances.
	 * Otherwise, this will return an empty list.
	 * @return
	 * List<Object> of class instances.
	 */
	public List<Object> getClassInstances() {
		return this.classInstances;
	}
	
	/**Creates a handler object for Jar plugins using the specified class type
	 * as the reference data type in instantiating the valid class instances within the Jar.
	 * @param jarPath - directory path of the Jar
	 * @param superClassType - class type of the plugin classes to be instantiated
	 */
	public PluginHandler(String jarPath, Class<?> superClassType) {
		this.pluginPath = jarPath.trim();
		this.superClassType = superClassType;
	}
	
	/**Retrieves the class path information and object reference for the valid class instances
	 * found within the Jar file.
	 * <br><br>
	 * After calling load, class paths can be retrieved using the getInstanceClassPaths method,
	 * while class instances can be retrieved using the getClassInstances method.
	 * @param constructorClassTypes - sequential list of class types in the order in which
	 * they appear in the class constructor. Use null for non-parameterized constructor.
	 * @param constructorArguments - sequential list of constructor arguments in the order in
	 * which they appear in the class constructor. Use null for non-parameterized constructor.
	 */
	public void load(List<Class<?>> constructorClassTypes, List<Object> constructorArguments) {
		List<File> jarFiles = (List<File>) FileUtils.listFiles(new File(pluginPath), extension, false);
		try {
			for (File jarFile : jarFiles) {
				jarLoader = new JarLoader(jarFile.getAbsolutePath(), superClassType);
				List<String> classPaths = jarLoader.getPluginClassPaths();
				for (String classPath : classPaths) {
					//Add new instance if no duplicate is found
					if (!instanceClassPaths.contains(classPath)) {
						Object obj = jarLoader.instantiate(classPath, constructorClassTypes, constructorArguments);
						if (obj != null) {
							classInstances.add(obj);
							instanceClassPaths.add(classPath);
						}
					} else {
						System.out.println("Duplicate class path found");
						System.out.println("Class Path: " + classPath);
						System.out.println("Proceeding to next class path");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
