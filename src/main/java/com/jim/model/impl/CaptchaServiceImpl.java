package com.jim.model.impl;


import com.jim.CaptchaApplication;
import com.jim.captcha.color.RandomColorFactory;
import com.jim.captcha.encoder.EncoderHelper;
import com.jim.captcha.predefined.*;
import com.jim.captcha.service.ConfigurableCaptchaService;
import com.jim.model.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Jim on 2016/5/18.
 * This class is ...
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {
    @Autowired
    private ConfigurableCaptchaService configurableCaptchaService;

    @Autowired
    private RandomColorFactory randomColorFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${captcha.directory}")
    private String path;

    private String file;

    @Override
    public String getWord() {
        return configurableCaptchaService.getCaptcha().getChallenge();
    }

    @Override
    public BufferedImage getImage() {
        return configurableCaptchaService.getCaptcha().getImage();
    }

    @Override
    public boolean validate(String word) {
        return false;
    }

    @Override
    public void generateImage() {
        randomColorFactory.setMin(new Color(10, 10, 15));
        randomColorFactory.setMax(new Color(255, 30, 10));
        configurableCaptchaService.setColorFactory(randomColorFactory);
        int counter = new Random().nextInt() % 5;

        switch (counter % 5) {
            case 0:
                configurableCaptchaService.setFilterFactory(new CurvesRippleFilterFactory(configurableCaptchaService.getColorFactory()));
                break;
            case 1:
                configurableCaptchaService.setFilterFactory(new MarbleRippleFilterFactory());
                break;
            case 2:
                configurableCaptchaService.setFilterFactory(new DoubleRippleFilterFactory());
                break;
            case 3:
                configurableCaptchaService.setFilterFactory(new WobbleRippleFilterFactory());
                break;
            case 4:
                configurableCaptchaService.setFilterFactory(new DiffuseRippleFilterFactory());
                break;
        }
        FileOutputStream fos = null;

        try {
            this.file = UUID.randomUUID().toString() + ".png";
            File tmp = new File(this.path + "/" + this.file);
            fos = new FileOutputStream(tmp);
            EncoderHelper.getChallangeAndWriteImage(configurableCaptchaService, "png", fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getFile() {
        return this.file;
    }
}
