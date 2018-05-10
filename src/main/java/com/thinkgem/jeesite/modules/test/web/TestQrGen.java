package com.thinkgem.jeesite.modules.test.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.thinkgem.jeesite.modules.qrext4j.qrcode.QrcodeGenerator;
import com.thinkgem.jeesite.modules.qrext4j.qrcode.QreyesFormat;
import com.thinkgem.jeesite.modules.qrext4j.qrcode.SimpleQrcodeGenerator;
import com.thinkgem.jeesite.modules.qrext4j.utils.IOUtils;

/**
 * TestQrGen2
 *
 * @author Bosco.Liao
 * @since 1.0.0
 */
public class TestQrGen {

	private static String content = "http://118.89.48.148:81/zhiban/f/core/view/1";

	private QrcodeGenerator generator = new SimpleQrcodeGenerator();

	private String localLogoPath;

	@Before
	public void init() {
		URL url = this.getClass().getClassLoader().getResource("mates/AodaCat-1.png");
		this.localLogoPath = url.getFile();
	}

	@Test
	public void testDefault() throws IOException {
		Assert.assertTrue(generator.generate(content).toFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\考拉.jpg"));
		testLocalLogo();
//		testRemoteLogo();
		testCustomConfig();
		testCustomCodeEyes();
	}

	/**
	 * 添加本地logo
	 * @throws IOException
	 */
	@Test
	public void testLocalLogo() throws IOException {
		boolean success = generator.setLogo(this.localLogoPath).generate(content).toFile("D:\\test\\local.png");
		Assert.assertTrue(success);
	}

	/**
	 * 添加在线logo
	 * @throws IOException
	 */
	/*@Test
	public void testRemoteLogo() throws IOException {
		generator.setRemoteLogo("http://www.demlution.com/site_media/media/photos/2014/11/06/3JmYoueyyxS4q4FcxcavgJ.jpg");
		Assert.assertTrue(generator.generate("https://www.apple.com/cn/").toFile("F:\\Apple_remote_logo.png"));
	}*/

	/**
	 * 自定义二维码配置
	 * @throws IOException
	 */
	@Test
	public void testCustomConfig() throws IOException {
		generator.getQrcodeConfig()
			.setBorderSize(2)
			.setPadding(10)
			.setMasterColor("#00BFFF")
			.setLogoBorderColor("#B0C4DE");
		Assert.assertTrue(generator.setLogo(this.localLogoPath).generate(content).toFile("D:\\test\\local.png"));
	}
	
	/**
	 * 自定义二维码码眼颜色
	 * @throws IOException
	 */
	@Test
	public void testCustomCodeEyes() throws IOException {
		generator.getQrcodeConfig()
			.setMasterColor("#778899")
			.setLogoBorderColor("#778899")
			.setCodeEyesPointColor("#BC8F8F")
			.setCodeEyesFormat(QreyesFormat.DR2_BORDER_R_POINT);
		Assert.assertTrue(generator.setLogo(this.localLogoPath).generate(content).toFile("D:\\test\\local.png"));
	}
	
	/**
	 * 写入输出流
	 * @throws IOException
	 */
	@Test
	public void testWriteToStream() throws IOException {
		OutputStream ous = null;
		try {
			ous = new FileOutputStream("D:\\11.png");
			Assert.assertTrue(generator.generate(content).toStream(ous));
		} finally {
			IOUtils.closeQuietly(ous);
		}
	}
	
	@Test
	public void testGetImage() throws IOException {
		BufferedImage image = generator.generate(content).getImage();
		ImageIO.write(image, "png", new File("D:\\11.png"));
	}

}
