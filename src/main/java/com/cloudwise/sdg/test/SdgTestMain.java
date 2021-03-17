package com.cloudwise.sdg.test;

import com.cloudwise.sdg.dic.DicInitializer;
import com.cloudwise.sdg.template.TemplateAnalyzer;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class SdgTestMain {

	public static void main(String[] args) throws Exception {
		//初始化词典
		DicInitializer.init();
		File templates = new File("templates");
		if(templates.isDirectory()){
			File[] tplFiles = templates.listFiles();
			for(File tplFile: tplFiles){
				if(tplFile.isFile()){
					String tpl = FileUtils.readFileToString(tplFile);
					String tplName = tplFile.getName();
					System.out.println("======tplName: "+tplName+", begin===================");
					//创建模板分析器
					TemplateAnalyzer testTplAnalyzer = new TemplateAnalyzer(tplName, tpl);
					//分析模板 生成模拟数据
					String abc = testTplAnalyzer.analyse();
					System.out.println(abc);
					System.out.println("======tplName: "+tplName+", end==================");
					System.out.println();
				}
			}
		}
	}
}
