package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by ikken on 14.02.2017.
 */
public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageTypes) throws IllegalArgumentException
    {

        if (!(imageTypes instanceof ImageTypes)) throw new IllegalArgumentException("Неизвестный тип картинки");
        switch (imageTypes) {
            case BMP:
                return new BmpReader();

            case JPG:
                return new JpgReader();

            case PNG:
                return new PngReader();

            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }

    }
}
