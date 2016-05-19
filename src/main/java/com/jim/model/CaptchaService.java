package com.jim.model;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Jim on 2016/5/18.
 * This class is ...
 */
public interface CaptchaService {
	String getWord();
	BufferedImage getImage();
	void generateImage() throws IOException;
	boolean validate(String word);
	String getFile();
}
