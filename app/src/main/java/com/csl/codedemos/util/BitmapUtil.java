package com.csl.codedemos.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * android bitmap util
 */
public class BitmapUtil {

    public static void recycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public static void recycleImageViewBitmap(ImageView imageView) {
        if (imageView == null) return;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null && drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    public static Bitmap getWidthBitmap(String path, int width) throws Exception {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 仅获得尺寸信息
        BitmapFactory.decodeFile(path, options);
        options.inSampleSize = options.outWidth / width; // 当<1的时候默认会设置为1
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;

        // 生成bitmap
        FileInputStream fis = new FileInputStream(path);
        return BitmapFactory.decodeFileDescriptor(fis.getFD(), null, options);
    }

    public static void setImageViewWidthBitmap(String imgPath, ImageView imageView) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imgPath, options);
        options.inSampleSize = Math.min(options.outWidth / imageView.getWidth(), options.outHeight/ imageView.getWidth());
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;

        FileInputStream fis = new FileInputStream(imgPath);
        imageView.setImageBitmap(BitmapFactory.decodeFileDescriptor(fis.getFD(), null, options));
    }

    public static BitmapDrawable getBitmapDrawableRes(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        InputStream is = context.getResources().openRawResource(resId);
        Bitmap bitmap = BitmapFactory.decodeStream(is, null, opt);
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static Bitmap getRotatedImg(String path) {
        int angle = getBitmapRotation(path);
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        try {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    private static int getBitmapRotation(String filePath) {
        int rotation = 0;
        switch (getExifOrientation(filePath)) {
            case ExifInterface.ORIENTATION_ROTATE_180:
                rotation = 180;
                break;
            case ExifInterface.ORIENTATION_ROTATE_90:
                rotation = 90;
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                rotation = 270;
                break;
        }
        return rotation;
    }
    private static int getExifOrientation(String filePath) {
        ExifInterface exif;
        int orientation = 0;
        try {
            exif = new ExifInterface(filePath);
            orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orientation;
    }

    /**
     * @param maxSize unit kb
     */
    public static boolean compressSizeToFile(Bitmap bitmap, int maxSize, File outFile) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int quality = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        while (baos.toByteArray().length / 1024.0 > maxSize) {
            if (quality < 30) {
                break;
            }
            quality -= 20;
            baos.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            fileOutputStream.write(baos.toByteArray());
            fileOutputStream.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean compress(Bitmap bitmap, File outFile) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 35, baos);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            fileOutputStream.write(baos.toByteArray());
            fileOutputStream.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
