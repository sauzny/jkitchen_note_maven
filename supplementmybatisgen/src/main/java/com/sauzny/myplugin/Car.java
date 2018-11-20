package com.sauzny.myplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;
import java.util.List;

@Mojo(name = "drive")
public class Car extends AbstractMojo {

	@Parameter(defaultValue = "all")
    private String flag;

	@Parameter
	private List<String> objectNames;
	
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        System.out.println("自己编写的maven插件 -- 开始");

        if(objectNames == null || objectNames.size() == 0 ) {
        	System.out.println("objectNames不能为空");
        }else{
            try {
            	switch (flag) {
				case "dao": MyMybatisGen.gen(objectNames, 1); break;
				case "xml": MyMybatisGen.gen(objectNames, 2); break;
				default: MyMybatisGen.gen(objectNames, 3); break;
				}
    			
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        
        System.out.println("自己编写的maven插件 -- 结束");
    }

}