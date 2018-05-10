package com.thinkgem.jeesite.modules.test.web;

import java.io.IOException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.thinkgem.jeesite.modules.qrext4j.Codectx.LogoShape;
import com.thinkgem.jeesite.modules.qrext4j.qrcode.QrcodeGenerator;
import com.thinkgem.jeesite.modules.qrext4j.qrcode.SimpleQrcodeGenerator;

/**
 * TestQrGen2
 *
 * @author Bosco.Liao
 * @since 1.3.1
 */
public class TestQrGen2 {
	
	private static String content = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private QrcodeGenerator generator = new SimpleQrcodeGenerator();

	private String localLogoPath;

	@Before
	public void init() {
		URL url = this.getClass().getClassLoader().getResource("mates/pig.png");
		//URL url = this.getClass().getClassLoader().getResource("mates/AodaCat-3.jpeg");
		this.localLogoPath = url.getFile();
	}

	@Test
	public void gen() throws IOException {
		
		generator.getQrcodeConfig().setWidth(350).setHeight(350)
		.setMasterColor("#5F9EA0")
		.setLogoBorderColor("#FFA07A")
		
		.setLogoShape(LogoShape.CIRCLE);
		generator.setLogo(localLogoPath).generate(content).toFile("D:\\qrcode-circle.png");

	}

}
